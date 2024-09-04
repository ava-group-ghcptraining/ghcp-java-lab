package TCPSocket;
import java.io.*;
import java.net.*;


class TCPServer {
    public static void main(String[] args) {
        try {
            // Create a server socket
            ServerSocket serverSocket = new ServerSocket(1234);

            System.out.println("Server started. Waiting for client connections...");

            // Accept client connections
            Socket clientSocket = serverSocket.accept();

            System.out.println("Client connected: " + clientSocket.getInetAddress().getHostAddress());

            // Create input and output streams for the client socket
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            // Read data from the client and send a response
            String message = in.readLine();
            System.out.println("Received message from client: " + message);

            String response = "Hello from the server!";
            out.println(response);
            System.out.println("Sent response to client: " + response);

            // Close the streams and sockets
            in.close();
            out.close();
            clientSocket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
