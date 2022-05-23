package by.epam.unit_6.task_1.users;

import by.epam.unit_6.task_1.cryptographer.Password;

import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class User {
    private String nickName;
    private String eMail;
    private String password;
    private Role role;
    private final String usersFilePath = "src/by/epam/unit_6/task_1/users/users";

    public User(String nickName, String eMail, String password, Role role) {
        setNickName(nickName);
        setEMail(eMail);
        setPassword(password);
        this.role = role;
        writeUser();
    }

    //    write user to txt file

    private void writeUser() {
        String stringUser = String.format("&nickName=%s&eMail=%s&password=%s&role=%s&",
                getNickName(), getEMail(), getPassword(), getRole());
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(usersFilePath, true))) {
            writer.write(stringUser + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //    check nickname for uniqueness

    private boolean checkNickName(String nickName) {
        Pattern pattern = Pattern.compile("^[a-z0-9_-]{3,16}$");
        Matcher matcher = pattern.matcher(nickName);
        return matcher.matches();
    }

    //    check e-mail for uniqueness

    private boolean checkEMail(String eMail) {
        Pattern pattern = Pattern.compile("^([a-z0-9_-]+\\.)*[a-z0-9_-]+@[a-z0-9_-]+(\\.[a-z0-9_-]+)*\\.[a-z]{2,6}$");
        Matcher matcher = pattern.matcher(eMail);
        return matcher.matches();
    }

    //    check password for validity

    private boolean checkPassword(String password) {
        Pattern pattern = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])[0-9a-zA-Z]{8,16}$");
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }

    //    check nickname for use in

    private boolean isNickNameUsed(String nickName) {
        Pattern pattern = Pattern.compile("&nickName=" + nickName + "&");
        Matcher matcher;

        try (BufferedReader reader = new BufferedReader(new FileReader(usersFilePath))) {
            while (reader.ready()) {
                matcher = pattern.matcher(reader.readLine());

                if (matcher.find()) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    //    check e-mail for use in

    private boolean isEMailUsed(String eMail) {
        Pattern pattern = Pattern.compile("&eMail=" + eMail + "&");
        Matcher matcher;

        try (BufferedReader reader = new BufferedReader(new FileReader(usersFilePath))) {
            while (reader.ready()) {
                matcher = pattern.matcher(reader.readLine());

                if (matcher.find()) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        Scanner scanner = new Scanner(System.in);

        if (!checkNickName(nickName)) {
            System.out.printf("Nickname '%s' is incorrect. Nickname must be between 3 and 16 characters and can " +
                    "contain only letters of the Latin alphabet and special characters '-', '_'!\n", nickName);
            System.out.print("Enter another nickname: ");

            setNickName(scanner.nextLine());
        } else {
            if (isNickNameUsed(nickName)) {
                System.out.printf("Nickname '%s' is already in use!\n", nickName);
                System.out.print("Enter another nickname: ");

                setNickName(scanner.nextLine());
            } else {
                this.nickName = nickName;
            }
        }
    }

    public String getEMail() {
        return eMail;
    }

    public void setEMail(String eMail) {
        Scanner scanner = new Scanner(System.in);

        if (!checkEMail(eMail)) {
            System.out.printf("E-mail '%s' is incorrect!\n", eMail);
            System.out.print("Enter another e-mail: ");

            setEMail(scanner.nextLine());
        } else {
            if (isEMailUsed(eMail)) {
                System.out.printf("E-mail '%s' is already in use!\n", eMail);
                System.out.print("Enter another e-mail: ");

                setEMail(scanner.nextLine());
            } else {
                this.eMail = eMail;
            }
        }
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        Scanner scanner = new Scanner(System.in);

        if (!checkPassword(password)) {
            System.out.println("Password is incorrect! Password must be between 8 and 16 characters, " +
                    "contain at least 1 number, a lowercase Latin letter and an uppercase Latin letter.");
            System.out.print("Enter another password: ");

            setPassword(scanner.nextLine());
        } else {
            this.password = Password.getSaltedHash(password);
        }
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return String.format("%s, %s", getNickName(), getEMail());
    }
}
