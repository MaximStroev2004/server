import stroev.Phone;

import java.io.*;

public class Client {
    public static void main(String[] args) {
        try (Phone phone = new  Phone("188.170.87.120", 8000)) {
            System.out.println("Connected to server");

            String request = "Visaginas";
            System.out.println("Request:" + request);
            phone.writeLine(request);

            String response = phone.readLine();
            System.out.println("Responce:" + response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


