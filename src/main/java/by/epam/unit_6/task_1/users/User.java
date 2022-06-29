package by.epam.unit_6.task_1.users;

import by.epam.unit_6.task_1.books_catalog.author.Author;
import by.epam.unit_6.task_1.books_catalog.books.Book;
import by.epam.unit_6.task_1.books_catalog.books.EBook;
import by.epam.unit_6.task_1.books_catalog.publisher.Publisher;
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
    private final static String USERS_FILE_PATH = "src/main/java/by/epam/unit_6/task_1/users/users";
    private final static String BOOKS_PATH_CATALOG = Book.getBooksFilePath();

    public User(String nickName, String eMail, String password, Role role) {
        setNickName(nickName);
        setEMail(eMail);
        setPassword(password);
        this.role = role;
    }

    public void addUser() {
        UserUtil.writeUser(this);
    }

    public void addBook(Book book) {
        UserUtil.addBook(this, book, BOOKS_PATH_CATALOG);
    }

    public void addBook(EBook eBook) {
        UserUtil.addBook(this, eBook, BOOKS_PATH_CATALOG);
    }

    public void deleteBook(Book book) {
        UserUtil.deleteBook(this, book, BOOKS_PATH_CATALOG);
    }

    public void suggestBook(Book book) {
        UserUtil.suggestBook(this, book);
    }

    public void viewCatalog() {
        UserUtil.viewBookCatalog(BOOKS_PATH_CATALOG);
    }

    public void searchBook(String title) {
        UserUtil.searchBook(title, BOOKS_PATH_CATALOG);
    }

    public void searchBook(Author author) {
        UserUtil.searchBook(author, BOOKS_PATH_CATALOG);
    }

    public void searchBook(Publisher publisher) {
        UserUtil.searchBook(publisher, BOOKS_PATH_CATALOG);
    }

    public void searchBook(Integer year) {
        UserUtil.searchBook(year, BOOKS_PATH_CATALOG);
    }

    private boolean checkNickName(String nickName) {
        Pattern pattern = Pattern.compile("^[a-z0-9_-]{3,16}$");
        Matcher matcher = pattern.matcher(nickName);
        return matcher.matches();
    }

    private boolean checkEMail(String eMail) {
        Pattern pattern = Pattern.compile("^([a-z0-9_-]+\\.)*[a-z0-9_-]+@[a-z0-9_-]+(\\.[a-z0-9_-]+)*\\.[a-z]{2,6}$");
        Matcher matcher = pattern.matcher(eMail);
        return matcher.matches();
    }

    private boolean checkPassword(String password) {
        Pattern pattern = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])[0-9a-zA-Z]{8,16}$");
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }

    private boolean isNickNameUsed(String nickName) {
        Pattern pattern = Pattern.compile("&nickName=" + nickName + "&");
        Matcher matcher;
        try (BufferedReader reader = new BufferedReader(new FileReader(USERS_FILE_PATH))) {
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

    private boolean isEMailUsed(String eMail) {
        Pattern pattern = Pattern.compile("&eMail=" + eMail + "&");
        Matcher matcher;
        try (BufferedReader reader = new BufferedReader(new FileReader(USERS_FILE_PATH))) {
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

    public static String getUsersFilePath() {
        return USERS_FILE_PATH;
    }

    @Override
    public String toString() {
        return String.format("%s, %s", getNickName(), getEMail());
    }
}
