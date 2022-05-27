package by.epam.unit_6.task_1.users;

import by.epam.unit_6.task_1.books_catalog.author.Author;
import by.epam.unit_6.task_1.books_catalog.books.Book;
import by.epam.unit_6.task_1.books_catalog.books.EBook;
import by.epam.unit_6.task_1.books_catalog.publisher.Publisher;
import by.epam.unit_6.task_1.mail_sender.EMailSender;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class UserUtil {
    static void addBook(User user, Book book, String pathCatalog) {
        if (user.getRole() == Role.ADMIN) {
            writeBook(book, pathCatalog);

            String subjectMail = "New book added to catalog";
            String textMail = "We have added a new book to our catalog";

            EMailSender eMailSender = new EMailSender(getUsersEMails(), user.getEMail());
            eMailSender.sendEMails(subjectMail, textMail);
        } else {
            System.out.println("You cannot modify a directory!");
        }
    }

    static void addEBook(User user, EBook eBook, String pathCatalog) {
        if (user.getRole() == Role.ADMIN) {
            writeEBook(eBook, pathCatalog);

            String subjectMail = "New book added to catalog";
            String textMail = "We have added a new book to our catalog";

            EMailSender eMailSender = new EMailSender(getUsersEMails(), user.getEMail());
            eMailSender.sendEMails(subjectMail, textMail);
        } else {
            System.out.println("You cannot modify a directory!");
        }
    }

    static void deleteBook(User user, Book book, String pathCatalog) {
        if (user.getRole() == Role.ADMIN) {
            String tmpSourceFile = "src/tmpFile";

            try (BufferedReader reader = new BufferedReader(new FileReader(pathCatalog));
                 BufferedWriter writer = new BufferedWriter(new FileWriter(tmpSourceFile))) {
                String line;

                while (reader.ready()) {
                    line = reader.readLine();
                    if (!line.contains(book.getTitle())) {
                        writer.write(line + "\r\n");
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                Files.delete(Paths.get(pathCatalog));
                Files.copy(Paths.get(tmpSourceFile), Paths.get(pathCatalog));
                Files.delete(Paths.get(tmpSourceFile));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("You cannot modify a directory!");
        }
    }

    static void suggestBook(User user, Book book) {
        if (user.getRole() == Role.USER) {
            String subjectMail = "New book";
            String textMail = "Please add this book to the catalog.\n" + book;

            EMailSender eMailSender = new EMailSender(getAdminEMails(), user.getEMail());
            eMailSender.sendEMails(subjectMail, textMail);
        }
    }

    static void viewBookCatalog(String pathCatalog) {
        List<String> books = readBooks(pathCatalog);
        browseCatalog(books);
    }

    static void searchBook(String title, String pathCatalog) {
        List<String> allBooks = readBooks(pathCatalog);
        List<String> booksByTitle = allBooks.stream()
                .filter(x -> x.toLowerCase().contains(title.toLowerCase()))
                .toList();
        browseCatalog(booksByTitle);
    }

    static void searchBook(Author author, String pathCatalog) {
        List<String> allBooks = readBooks(pathCatalog);
        List<String> booksByAuthor = allBooks.stream()
                .filter(x -> x.contains(author.getFirstName() + " " + author.getLastName()))
                .toList();
        browseCatalog(booksByAuthor);
    }

    static void searchBook(Publisher publisher, String pathCatalog) {
        List<String> allBooks = readBooks(pathCatalog);
        List<String> booksByAuthor = allBooks.stream()
                .filter(x -> x.contains(publisher.getName()))
                .toList();
        browseCatalog(booksByAuthor);
    }

    static void searchBook(Integer year, String pathCatalog) {
        List<String> allBooks = readBooks(pathCatalog);
        List<String> booksByAuthor = allBooks.stream()
                .filter(x -> x.contains(year.toString()))
                .toList();
        browseCatalog(booksByAuthor);
    }

    static void writeUser(User user) {
        String stringUser = String.format("&nickName=%s&eMail=%s&password=%s&role=%s&",
                user.getNickName(), user.getEMail(), user.getPassword(), user.getRole());
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(User.getUsersFilePath(), true))) {
            writer.write(stringUser + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeBook(Book book, String pathCatalog) {
        String stringBook = String.format("%s, %s, %s, %d",
                book.getTitle(), book.getAuthor(), book.getPublisher(), book.getPublishingYear());

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(pathCatalog, true))) {
            writer.write(stringBook + "\r\n");
            System.out.println("Book added successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeEBook(EBook eBook, String pathCatalog) {
        String stringBook = String.format("%s, %s, %s, %d, %s",
                eBook.getTitle(), eBook.getAuthor(), eBook.getPublisher(), eBook.getPublishingYear(), eBook.getUrl());
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(pathCatalog, true))) {
            writer.write(stringBook + "\r\n");
            System.out.println("Book added successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void browseCatalog(List<String> catalog) {
        Scanner scanner = new Scanner(System.in);
        String choice;
        int position = 0;

        while (true) {
            for (int i = position; i < Integer.min(catalog.size(), position + 5); i++) {
                System.out.println(catalog.get(i));
            }

            System.out.println("Enter choice: 1 - next page, 2 - previous page, 3 - exit");
            choice = scanner.nextLine();

            if (choice.equals("1") || choice.equalsIgnoreCase("next")) {
                if (position + 5 < catalog.size()) {
                    position += 5;
                }
            } else if (choice.equals("2") || choice.equalsIgnoreCase("back")) {
                if (position - 5 >= 0) {
                    position -= 5;
                }
            } else return;
        }
    }

    private static List<String> readUsers(String userFilePath) {
        List<String> users = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(userFilePath))) {
            while (reader.ready()) {
                users.add(reader.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return users;
    }

    private static List<String> readBooks(String pathCatalog) {
        List<String> books = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(pathCatalog))) {
            while (reader.ready()) {
                books.add(reader.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return books;
    }

    private static List<String> getUsersEMails() {
        List<String> eMails = new ArrayList<>();
        Pattern pattern = Pattern.compile("(([a-z0-9_-]+\\.)*[a-z0-9_-]+@[a-z0-9_-]+(\\.[a-z0-9_-]+)*\\.[a-z]{2,6})");
        Matcher matcher;

        try (BufferedReader reader = new BufferedReader(new FileReader(User.getUsersFilePath()))) {
            String line;
            while (reader.ready()) {
                line = reader.readLine();
                matcher = pattern.matcher(line);
                if (line.contains("role=USER")) {
                    while (matcher.find()) {
                        eMails.add(matcher.group());
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return eMails;
    }

    private static List<String> getAdminEMails() {
        List<String> eMails = new ArrayList<>();
        Pattern pattern = Pattern.compile("(([a-z0-9_-]+\\.)*[a-z0-9_-]+@[a-z0-9_-]+(\\.[a-z0-9_-]+)*\\.[a-z]{2,6})");
        Matcher matcher;

        try (BufferedReader reader = new BufferedReader(new FileReader(User.getUsersFilePath()))) {
            String line;
            while (reader.ready()) {
                line = reader.readLine();
                matcher = pattern.matcher(line);
                if (line.contains("role=ADMIN")) {
                    while (matcher.find()) {
                        eMails.add(matcher.group());
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return eMails;
    }
}
