package by.epam.unit_6.task_3.user;

import java.util.Scanner;

public class User {
    private String name;
    private UserRole userRole;

    public User(String name, UserRole userRole) {
        this.name = name;
        this.userRole = userRole;
    }

    public static void login() {
        System.out.print("Enter your login: ");

        while (true) {
            String login = new Scanner(System.in).nextLine();

            switch (login) {
                case "tutor" -> {
                    showTutorMenu();
                    return;
                }
                case "student" -> {
                    showStudentMenu();
                    return;
                }
                default -> System.out.print("Incorrect login! Try again: ");
            }
        }
    }

    private static void showTutorMenu() {
        System.out.println("""
                Choose action:
                1. Show case;
                2. Change case;
                3. Add new case;
                4. Exit.
                """);

        int choose = choicePosition(1, 4);

        switch (choose) {
            case 1 -> printCase();
            case 2 -> changeCase();
            case 3 -> addNewCase();
        }
    }

    private static void showStudentMenu() {
    }

    private static void changeCase() {
    }

    private static void addNewCase() {
    }

    private static void printCase() {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }
}
