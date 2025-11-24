// EchoClient.java
import java.io.*;
import java.net.*;

public class EchoClient {
    public static void main(String[] args) {
        String host = "98.89.7.161";
        int port = 8080;

        try (Socket socket = new Socket(host, port)) {
            System.out.println("[CLIENT] Connected to server.");

            BufferedReader console =
                new BufferedReader(new InputStreamReader(System.in));

            BufferedReader in =
                new BufferedReader(new InputStreamReader(socket.getInputStream()));

            PrintWriter out =
                new PrintWriter(socket.getOutputStream(), true);

            String message;

            while (true) {
                System.out.print("Enter message (or 'quit'): ");
                message = console.readLine();

                if (message.equalsIgnoreCase("quit")) {
                    break;
                }

                out.println(message);
                String echo = in.readLine();
                System.out.println("[CLIENT] Echoed from server: " + echo);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

