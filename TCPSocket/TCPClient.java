package TCPSocket;
import java.io.*;
import java.net.*;

class TCPClient {
    public static void main(String[] args) {
        try {
            // Create a socket connection to the server
            Socket socket = new Socket("localhost", 1234);

            // Create input and output streams for the socket
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // Send a message to the server
            out.println("Hello, server!");

            // Receive a response from the server
            String response = in.readLine();
            System.out.println("Server response: " + response);

            // Close the socket and streams
            in.close();
            out.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
