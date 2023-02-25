import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static <reader> void main(String[] args) {

        try (ServerSocket server = new ServerSocket(8000))
        {
            System.out.println("Server started!");

            while (true)
                 try (
                      Socket socket = server.accept();
                    BufferedWriter writer =
                            new BufferedWriter(
                                    new OutputStreamWriter(
                                            socket.getOutputStream()));
                    BufferedReader reader  =
                    new BufferedReader(
                            new InputStreamReader(
                                    socket.getInputStream()));
            ) {
                String request = reader.readLine();
                System.out.println("Request:  " + request) ;
                String response ="HELLO FROM SERVER" + request.length();
                System.out.println("Response: "+ response);
                writer.newLine();
                writer.flush();
            } catch (NullPointerException e) {
                     e.printStackTrace();
                 }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

