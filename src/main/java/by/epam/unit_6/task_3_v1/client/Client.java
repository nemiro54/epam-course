package by.epam.unit_6.task_3_v1.client;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        connectToServer();
    }

    private static void connectToServer() {
        try (Socket socket = new Socket("127.0.0.1", 8000);
             BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))
        ) {
            while (socket.isConnected())
                menu(reader, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void menu(BufferedReader reader, BufferedWriter writer) throws IOException {
        String[] arrLogin = logIn(reader, writer).split(";");

        while (true) {
            if (arrLogin[0].equals("YES")) {
                if (arrLogin[1].equals("TUTOR")) {
                    String response = showTutorMenu(reader, writer);
                    System.out.println(response);
                }
            } else {
                System.out.println("Wrong login or password");
                break;
            }
        }
    }

    private static String showTutorMenu(BufferedReader reader, BufferedWriter writer) throws IOException {
        System.out.println("""
                Enter action number:
                1 - View archive.
                2 - Change case in the archive.
                3 - Add a new case to the archive.
                4 - Add a new User""");

        int choice = choosePosition(1, 4);

        return switch (choice) {
            case 1 -> viewArchive(reader, writer);
            case 2 -> changeCase(reader, writer);
            default -> "Something was wrong";
        };
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

    private static String viewArchive(BufferedReader reader, BufferedWriter writer) throws IOException {
        String request = 1 + ";";
        sendRequest(writer, request);

        StringBuilder response = new StringBuilder();

        while (reader.ready()) {
            response.append(reader.readLine()).append("\n");
        }

        return response.toString();
    }

    private static String changeCase(BufferedReader reader, BufferedWriter writer) throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter student name: ");
        String oldName = scanner.nextLine();

        System.out.print("Enter new name: ");
        String name = scanner.nextLine();
        System.out.print("Enter new faculty: ");
        String faculty = scanner.nextLine();
        System.out.print("Enter new course: ");
        String course = scanner.nextLine();

        String request = String.format("%d;%s;%s;%s;%s;", 2, oldName, name, faculty, course);
        sendRequest(writer, request);

        String response = reader.readLine();
        return response;
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
