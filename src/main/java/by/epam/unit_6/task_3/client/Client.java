package by.epam.unit_6.task_3.client;

import by.epam.unit_6.task_3.user.User;
import by.epam.unit_6.task_3.user.UserRole;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        User tutor = new User("tutor", UserRole.TUTOR);
        User student = new User("student", UserRole.STUDENT);
        List<User> users = new ArrayList<>(2) {{
            add(tutor);
            add(student);
        }};

        UserRole userRole = login();

        boolean isConnected;
        do {
            isConnected = connectToServer(userRole);
        } while (isConnected);
    }

    private static boolean connectToServer(UserRole userRole) {
        String request = "";
        int action;

        if (userRole == UserRole.TUTOR) {
            action = tutorMenu();
            switch (action) {
                case 1 -> request = "show case;" + enterFullName();
                case 2 -> request = "change case;" + enterFullName();
                case 3 -> request = "add new case;";
                case 4 -> request = "exit";
            }
        } else if (userRole == UserRole.STUDENT) {
            action = studentMenu();
            switch (action) {
                case 1 -> request = "show case;" + enterFullName();
                case 2 -> request = "exit";
            }
        } else {
            System.out.println("You are not login!");
        }

        if (request.equals("exit")) {
            return false;
        }

        try (Socket socket = new Socket("127.0.0.1", 8000);
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
             BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            write(writer, request);

            String response;

            while ((response = reader.readLine()).length() != 0) {
                System.out.println(response);
            }

            System.out.println(response);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    private static int tutorMenu() {
        System.out.println("""
                Choose action (enter a number):
                1. Show case;
                2. Change case;
                3. Add new case;
                4. Exit.""");

        return choicePosition(1, 4);
    }

    private static int studentMenu() {
        System.out.println("""
                Choose action (enter a number):
                1. Show case;
                2. Exit.""");

        return choicePosition(1, 2);
    }

    private static String changeCase() {
        System.out.println("""
                Choose what to change(enter a number):
                1. First name;
                2. Last name;
                3. Email;
                4. Faculty;
                5. Course""");

        int choose = choicePosition(1, 5);

        return switch (choose) {
            case 1 -> enterFirstName();
            case 2 -> enterLastName();
            case 3 -> enterEmail();
            case 4 -> enterFaculty();
            case 5 -> enterCourse();
            default -> "";
        };
    }

    private static String enterFullName() {
        System.out.print("Enter first name: ");
        String firstName = new Scanner(System.in).nextLine();
        if (firstName.length() == 0) {
            firstName = "";
        }

        System.out.print("Enter last name: ");
        String lastName = new Scanner(System.in).nextLine();
        if (lastName.length() == 0) {
            lastName = "";
        }

        return firstName + ";" + lastName + ";";
    }

    private static String enterFirstName() {
        System.out.print("Enter first name: ");
        String firstName = new Scanner(System.in).nextLine();
        if (firstName.length() == 0) {
            firstName = "";
        }

        return firstName + ";";
    }

    private static String enterLastName() {
        System.out.print("Enter last name: ");
        String lastName = new Scanner(System.in).nextLine();
        if (lastName.length() == 0) {
            lastName = "";
        }

        return lastName + ";";
    }

    private static String enterEmail() {
        System.out.print("Enter email: ");
        String email = new Scanner(System.in).nextLine();
        if (email.length() == 0) {
            email = "";
        }

        return email + ";";
    }

    private static String enterFaculty() {
        System.out.print("Enter faculty: ");
        String faculty = new Scanner(System.in).nextLine();
        if (faculty.length() == 0) {
            faculty = "";
        }

        return faculty + ";";
    }

    private static String enterCourse() {
        System.out.print("Enter course: ");
        String course = new Scanner(System.in).nextLine();
        if (course.length() == 0) {
            course = "";
        }

        return course + ";";
    }

    private static UserRole login() {
        System.out.print("Enter your login: ");

        while (true) {
            String login = new Scanner(System.in).nextLine();

            switch (login) {
                case "tutor" -> {
                    return UserRole.TUTOR;
                }
                case "student" -> {
                    return UserRole.STUDENT;
                }
                default -> System.out.print("Incorrect login! Try again: ");
            }
        }
    }

    private static void write(BufferedWriter writer, String request) {
        try {
            writer.write(request);
            writer.newLine();
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int choicePosition(int min, int max) {
        Scanner scanner = new Scanner(System.in);
        int res = scanner.nextInt();

        if (res < min || res > max) {
            System.out.println("Invalid input! Try again: ");
            return choicePosition(min, max);
        } else {
            return res;
        }
    }
}