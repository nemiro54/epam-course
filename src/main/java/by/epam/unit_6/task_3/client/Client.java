package by.epam.unit_6.task_3.client;

import by.epam.unit_6.task_3.user.User;
import by.epam.unit_6.task_3.user.UserRole;

import java.io.*;
import java.net.Socket;
import java.util.*;

public class Client {
    public static void main(String[] args) {
        User tutor = new User("tutor", UserRole.TUTOR);
        User student = new User("student", UserRole.STUDENT);
        List<User> users = new ArrayList<>(2) {{
            add(tutor);
            add(student);
        }};

        boolean isConnected;
        do {
            isConnected = connectToServer();
        } while (isConnected);
    }

    private static boolean connectToServer() {
        String request = new Scanner(System.in).nextLine();

        if (request.equals("exit")) {
            return false;
        }
        try (Socket socket = new Socket("127.0.0.1", 8000);
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
             BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            writer.write(request);
            writer.newLine();
            writer.flush();

            String response = reader.readLine();
            System.out.println(response);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}