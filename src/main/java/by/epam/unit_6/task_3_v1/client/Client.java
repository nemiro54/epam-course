package by.epam.unit_6.task_3_v1.client;

import by.epam.unit_6.task_1.cryptographer.Password;

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
            while (socket.isConnected()) {
                menu(reader, writer);
            }
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    private static void menu(BufferedReader reader, BufferedWriter writer) throws IOException {
        String[] arrLogin = logIn(reader, writer).split(";");

        while (true) {
            if (arrLogin[0].equals("YES")) {
                switch (arrLogin[1]) {
                    case "TUTOR" -> {
                        String response = showTutorMenu(reader, writer);
                        System.out.println(response);
                        if (response.equals("exit")) {
                            return;
                        }
                    }
                    case "STUDENT" -> {
                        String response = showStudentMenu(reader, writer);
                        System.out.println(response);
                        if (response.equals("exit")) {
                            return;
                        }
                    }
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
                1 - View student  case.
                2 - Change case in the archive.
                3 - Add a new case to the archive.
                4 - Add a new User.
                5 - Log out.""");

        int choice = choosePosition(1, 5);

        return switch (choice) {
            case 1 -> viewCase(reader, writer);
            case 2 -> changeCase(reader, writer);
            case 3 -> addANewCaseToTheArchive(reader, writer);
            case 4 -> addANewUser(reader, writer);
            case 5 -> "exit";
            default -> "Something was wrong!";
        };
    }

    private static String showStudentMenu(BufferedReader reader, BufferedWriter writer) throws IOException {
        System.out.println("""
                Enter action number:
                1 - View student case.
                2 - Log out.""");

        int choice = choosePosition(1, 2);

        return switch (choice) {
            case 1 -> viewCase(reader, writer);
            case 2 -> "exit";
            default -> "Something was wrong!";
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

        return reader.readLine();
    }

    private static String viewCase(BufferedReader reader, BufferedWriter writer) throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter student name: ");
        String studentName = scanner.nextLine();
        String request = 1 + ";" + studentName + ";";
        sendRequest(writer, request);

        return reader.readLine();
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

        return reader.readLine();
    }

    private static String addANewCaseToTheArchive(BufferedReader reader, BufferedWriter writer) throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        System.out.print("Enter faculty: ");
        String faculty = scanner.nextLine();
        System.out.print("Enter course: ");
        String course = scanner.nextLine();

        String request = String.format("%d;%s;%s;%s;", 3, name, faculty, course);
        sendRequest(writer, request);

        return reader.readLine();
    }

    private static String addANewUser(BufferedReader reader, BufferedWriter writer) throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter login: ");
        String login = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = Password.getSaltedHash(scanner.nextLine());
        System.out.print("Enter UserRole: ");
        String userRole = getUserRole(scanner.nextLine());

        String request = String.format("%d;%s;%s;%s;", 4, login, password, userRole);
        sendRequest(writer, request);

        return reader.readLine();
    }

    private static void sendRequest(BufferedWriter writer, String request) throws IOException {
        writer.write(request);
        writer.newLine();
        writer.flush();
    }

    private static String getUserRole(String role) {
        if (role.equalsIgnoreCase("tutor")) {
            return "tutor";
        } else if (role.equalsIgnoreCase("student")) {
            return "student";
        } else {
            System.out.println("Incorrect UserRole. Try again: ");
            return getUserRole(new Scanner(System.in).nextLine());
        }
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
