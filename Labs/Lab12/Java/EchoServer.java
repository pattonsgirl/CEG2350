// EchoServer.java
import java.io.*;
import java.net.*;

public class EchoServer {
    public static void main(String[] args) {
        int port = 8080;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("[SERVER] Listening on port " + port);

            Socket clientSocket = serverSocket.accept();
            System.out.println("[SERVER] Connected to " + clientSocket.getInetAddress());

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream())
            );
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            String message;
            while ((message = in.readLine()) != null) {
                System.out.println("[SERVER] Received: " + message);
                out.println(message); // Echo back
            }

            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

