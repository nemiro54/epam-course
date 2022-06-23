package by.epam.unit_6.task_3_v1.client;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
//        boolean isConnected;
//
//        do {
//            isConnected = connectToServer();
//        } while (isConnected);
        connectToServer();
    }

    private static void connectToServer() {
        try (Socket socket = new Socket("127.0.0.1", 8000);
             BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))
        ) {
            menu(reader, writer);
//            return true;
        } catch (IOException e) {
            e.printStackTrace();
//            return false;
        }
    }

    private static void menu(BufferedReader reader, BufferedWriter writer) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String request;

        String[] isLogin = logIn(reader, writer).split(";");

        while (true) {
            if (isLogin[0].equals("YES")) {
                if (isLogin[1].equals("TUTOR")) {
                    String response = showTutorMenu(reader, writer);
                    System.out.println(response);
                }
            }
        }
    }

    private static String logIn(BufferedReader reader, BufferedWriter writer) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your login: ");
        String login = scanner.nextLine();
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        String request = 0 + ";" + login + ";" + password + ";";
        sendRequest(writer, request);

        String response = reader.readLine();
        return response;
    }

    private static String showTutorMenu(BufferedReader reader, BufferedWriter writer) throws IOException {
        System.out.println("""
                Enter action number:
                1 - View archive.
                2 - Change case in the archive.
                3 - Add a new case to the archive.
                4 - Add a new User""");

        int choice = choosePosition(1, 4);

        if (choice == 1) {
            return viewArchive(reader, writer);
        } else {
            return "Something was wrong";
        }
    }

    private static String viewArchive(BufferedReader reader, BufferedWriter writer) throws IOException {
        String request = 1 + ";";
        sendRequest(writer, request);

        StringBuilder response = new StringBuilder();
        while (!reader.readLine().equals("")) {
            response.append(reader.readLine());
        }
        return response.toString();
    }

    private static void sendRequest(BufferedWriter writer, String request) throws IOException {
        writer.write(request);
        writer.newLine();
        writer.flush();
    }

    private static int choosePosition(int min, int max) {
        Scanner scanner = new Scanner(System.in);
        int res = scanner.nextInt();

        if (res < min || res > max) {
            System.out.println("Invalid input! Try again: ");
            return choosePosition(min, max);
        } else {
            return res;
        }
    }
}
