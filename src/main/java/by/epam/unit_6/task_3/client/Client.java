package by.epam.unit_6.task_3.client;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try (Socket socket = new Socket("127.0.0.1", 8000);
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
             BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("enter: ");
            String request = scanner.nextLine();

            writer.write(request);
            writer.newLine();
            writer.flush();

            String response = reader.readLine();
            System.out.println(response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
