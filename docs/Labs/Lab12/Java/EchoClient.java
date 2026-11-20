// EchoClient.java
// TCP echo client: connects to the server, sends messages you type,
// and shows the server's acknowledgement and echo.
import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class EchoClient {
    static final String HOST = "YOUR.AWS.PUBLIC.IP"; // Replace with your AWS instance's public IP
    static final int PORT = 8080;                    // Must match the PORT the server is listening on

    static final DateTimeFormatter TIME = DateTimeFormatter.ofPattern("HH:mm:ss");
    static volatile boolean finished = false; // true once we exit normally

    /** Print a timestamped log line. */
    static void log(String msg) {
        System.out.println("[" + LocalTime.now().format(TIME) + "] [CLIENT] " + msg);
    }

    /** IP of the network interface this system uses to reach the internet.
     *  connect() on a UDP socket picks a route but sends no packets. */
    static String getPrivateIp() {
        try (DatagramSocket s = new DatagramSocket()) {
            s.connect(InetAddress.getByName("8.8.8.8"), 80);
            return s.getLocalAddress().getHostAddress();
        } catch (IOException e) {
            return "unavailable";
        }
    }

    /** Ask an outside service which IP our traffic appears to come from. */
    static String getPublicIp() {
        try {
            URLConnection conn = URI.create("https://checkip.amazonaws.com").toURL().openConnection();
            conn.setConnectTimeout(3000);
            conn.setReadTimeout(3000);
            try (BufferedReader r = new BufferedReader(
                    new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8))) {
                return r.readLine().trim();
            }
        } catch (IOException e) {
            return "unavailable";
        }
    }

    /** True if text looks like an IPv4 address such as 3.91.24.157 */
    static boolean isIpAddress(String text) {
        String[] parts = text.split("\\.", -1);
        if (parts.length != 4) return false;
        for (String p : parts) {
            if (!p.matches("\\d{1,3}") || Integer.parseInt(p) > 255) return false;
        }
        return true;
    }

    /** Connect to the server. Returns a socket, or null after printing
     *  a hint about what to fix. */
    static Socket connect() {
        if (!isIpAddress(HOST)) {
            log("ERROR: HOST is set to '" + HOST + "', which is not an IP address.");
            log("FIX: edit HOST in EchoClient.java to your AWS instance's public IP (e.g. 3.91.24.157), then recompile.");
            return null;
        }

        log("Connecting to " + HOST + ":" + PORT + "...");
        Socket socket = new Socket();
        try {
            socket.connect(new InetSocketAddress(HOST, PORT), 5000); // Give up after 5 seconds
            return socket;
        } catch (ConnectException e) {
            log("ERROR: " + HOST + " answered, but nothing is listening on port " + PORT + ".");
            log("FIX: start EchoServer on your instance, and check that PORT matches in both files.");
        } catch (SocketTimeoutException e) {
            log("ERROR: no answer from " + HOST + ":" + PORT + " after 5 seconds.");
            log("FIX: check that...");
            log("  - your Security Group has an inbound rule allowing TCP port " + PORT + " from your IP");
            log("  - HOST is your instance's *public* IP (it changes if the instance is stopped and started)");
            log("  - your instance is running");
        } catch (IOException e) {
            log("ERROR: could not connect: " + e.getMessage());
            log("FIX: check that this system is connected to the internet.");
        }
        try { socket.close(); } catch (IOException ignored) { }
        return null;
    }

    /** Send messages to the server and print each acknowledgement. */
    static void chat(Socket socket) throws IOException {
        String localIp = socket.getLocalAddress().getHostAddress();
        int localPort = socket.getLocalPort();
        String serverIp = socket.getInetAddress().getHostAddress();
        int serverPort = socket.getPort();

        log("Connected to server " + serverIp + ":" + serverPort);
        // The OS picks a temporary (ephemeral) port for the client when it connects
        log("OS opened local port " + localPort + " for this connection");
        // A socket is identified by 4 values: local IP:port <-> remote IP:port
        log("Socket: " + localIp + ":" + localPort + " <-> " + serverIp + ":" + serverPort);

        socket.setSoTimeout(10000); // Wait at most 10 seconds for each reply

        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader in = new BufferedReader(
                new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
        OutputStream out = socket.getOutputStream();

        // Each message is one line of text ending in "\n".
        // TCP is a stream of bytes, so the newline marks where a message ends.
        while (true) {
            System.out.print("Enter message (or 'quit'): ");
            String message = console.readLine();
            if (message == null) { // Ctrl+D
                System.out.println();
                break;
            }
            if (message.equalsIgnoreCase("quit")) {
                break;
            }
            if (message.isEmpty()) {
                continue;
            }

            byte[] data = (message + "\n").getBytes(StandardCharsets.UTF_8);
            long start = System.nanoTime();
            out.write(data);
            out.flush();
            log("Sent " + data.length + " bytes");

            String reply;
            try {
                reply = in.readLine();
            } catch (SocketTimeoutException e) {
                log("ERROR: server did not reply within 10 seconds. Is EchoServer still running?");
                break;
            }
            double rttMs = (System.nanoTime() - start) / 1_000_000.0;

            if (reply == null) {
                log("Server closed the connection. Is EchoServer still running?");
                break;
            }

            // Reply format: ACK <bytes> <your ip> <your port> <message>
            String[] parts = reply.split(" ", 5);
            String acked = parts[1], seenIp = parts[2], seenPort = parts[3];
            String echo = parts.length > 4 ? parts[4] : "";
            int replyBytes = reply.getBytes(StandardCharsets.UTF_8).length + 1; // +1 for "\n"

            log(String.format("Received %d bytes in %.1f ms", replyBytes, rttMs));
            log("Server on port " + serverPort + " acknowledged " + acked + " bytes");
            log("Echo: '" + echo + "'");
            log("You see yourself as  " + localIp + ":" + localPort);
            log("Server sees you as   " + seenIp + ":" + seenPort);
        }
    }

    public static void main(String[] args) {
        // Runs when the program is stopped with Ctrl+C
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            if (!finished) {
                System.out.println();
                log("Interrupted. Goodbye!");
            }
        }));

        log("Starting up...");
        log("Private IP: " + getPrivateIp());
        log("Public IP:  " + getPublicIp());

        Socket socket = connect();
        if (socket != null) {
            try (Socket s = socket) {
                chat(s);
            } catch (IOException e) {
                log("Connection to server was lost. Is EchoServer still running?");
            }
            log("Disconnected. Goodbye!");
        }
        finished = true;
    }
}
