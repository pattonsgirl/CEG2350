// EchoServer.java
// TCP echo server: listens on PORT, accepts one client at a time,
// and echoes every message back with an acknowledgement.
import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class EchoServer {
    static final int PORT = 8080; // Port to listen on (non-privileged ports are > 1023)

    static final DateTimeFormatter TIME = DateTimeFormatter.ofPattern("HH:mm:ss");
    static volatile boolean failed = false; // true if we stop because of an error

    /** Print a timestamped log line. */
    static void log(String msg) {
        System.out.println("[" + LocalTime.now().format(TIME) + "] [SERVER] " + msg);
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

    /** Echo messages from one connected client until it disconnects. */
    static void handleClient(Socket clientSocket) throws IOException {
        String clientIp = clientSocket.getInetAddress().getHostAddress();
        int clientPort = clientSocket.getPort();
        String localIp = clientSocket.getLocalAddress().getHostAddress();
        int localPort = clientSocket.getLocalPort();

        log("Client connected from " + clientIp + ":" + clientPort);
        // A socket is identified by 4 values: local IP:port <-> remote IP:port
        log("Socket: " + localIp + ":" + localPort + " <-> " + clientIp + ":" + clientPort);

        // Each message is one line of text ending in "\n".
        // TCP is a stream of bytes, so the newline marks where a message ends.
        try (Socket s = clientSocket;
             BufferedReader in = new BufferedReader(
                     new InputStreamReader(s.getInputStream(), StandardCharsets.UTF_8));
             OutputStream out = s.getOutputStream()) {

            String message;
            while ((message = in.readLine()) != null) {
                int received = message.getBytes(StandardCharsets.UTF_8).length + 1; // +1 for "\n"
                log("Received " + received + " bytes from " + clientIp + ":" + clientPort + ": '" + message + "'");

                // Acknowledge + echo. Include the IP and port we saw the client
                // connect from so it can compare against what it thinks it is.
                byte[] reply = ("ACK " + received + " " + clientIp + " " + clientPort + " " + message + "\n")
                        .getBytes(StandardCharsets.UTF_8);
                out.write(reply);
                out.flush();
                log("Echoed " + reply.length + " bytes back to " + clientIp + ":" + clientPort);
            }
        }
        log("Client " + clientIp + ":" + clientPort + " disconnected");
    }

    public static void main(String[] args) {
        // Runs when the program is stopped with Ctrl+C
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            if (!failed) {
                System.out.println();
                log("Shutting down. Goodbye!");
            }
        }));

        log("Starting up...");
        log("Private IP: " + getPrivateIp());
        log("Public IP:  " + getPublicIp());

        try (ServerSocket serverSocket = new ServerSocket()) {
            // Allow restarting the server right away instead of waiting for the
            // OS to release the port ("Address already in use")
            serverSocket.setReuseAddress(true);
            try {
                serverSocket.bind(new InetSocketAddress(PORT)); // all network interfaces
            } catch (BindException e) {
                if (String.valueOf(e.getMessage()).contains("Permission denied")) {
                    log("ERROR: not allowed to use port " + PORT + ". Ports below 1024 need root - pick a port above 1023.");
                } else {
                    log("ERROR: cannot listen on port " + PORT + ": " + e.getMessage());
                    log("Is another server already running? Check with: ss -tlnp | grep " + PORT);
                }
                failed = true;
                System.exit(1);
            }

            log("Listening on 0.0.0.0:" + PORT + " (TCP) - press Ctrl+C to stop");

            // Serve clients one after another, forever
            while (true) {
                Socket clientSocket = serverSocket.accept();
                try {
                    handleClient(clientSocket);
                } catch (IOException e) {
                    log("Client " + clientSocket.getInetAddress().getHostAddress() + ":"
                            + clientSocket.getPort() + " dropped the connection");
                }
                log("Waiting for next client...");
            }
        } catch (IOException e) {
            log("ERROR: " + e.getMessage());
            failed = true;
        }
    }
}
