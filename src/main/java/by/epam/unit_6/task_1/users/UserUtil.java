package by.epam.unit_6.task_1.users;

import by.epam.unit_6.task_1.books_catalog.books.Book;
import by.epam.unit_6.task_1.books_catalog.books.EBook;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class UserUtil {

    static void addBookToCatalog(User user, Book book, String pathCatalog) {
        if (user.getRole() == Role.ADMIN) {
            writeBookToCatalog(book, pathCatalog);
        } else {
            System.out.println("You cannot modify a directory!");
        }
    }

    static void addEBookToCatalog(User user, EBook eBook, String pathCatalog) {
        if (user.getRole() == Role.ADMIN) {
            writeEBookToCatalog(eBook, pathCatalog);
        } else {
            System.out.println("You cannot modify a directory!");
        }
    }

    static void deleteBookFromCatalog(User user, Book book, String pathCatalog) {
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

    static void viewBookCatalog(String pathCatalog) {
        List<String> books = readBooksFromCatalog(pathCatalog);
        browseCatalog(books);
    }

    static void searchByTitle(String title, String pathCatalog) {
        List<String> allBooks = readBooksFromCatalog(pathCatalog);
        List<String> booksByTitle = allBooks.stream().filter(x -> x.toLowerCase().contains(title.toLowerCase())).toList();
        browseCatalog(booksByTitle);
    }

    static void searchByAuthor(String author, String pathCatalog) {
        List<String> allBooks = readBooksFromCatalog(pathCatalog);
        List<String> booksByAuthor = allBooks.stream().filter(x -> x.toLowerCase().contains(author.toLowerCase())).toList();
        browseCatalog(booksByAuthor);
    }

    static void searchByPublisher(String publisher, String pathCatalog) {
        List<String> allBooks = readBooksFromCatalog(pathCatalog);
        List<String> booksByAuthor = allBooks.stream().filter(x -> x.toLowerCase().contains(publisher.toLowerCase())).toList();
        browseCatalog(booksByAuthor);
    }

    static void searchByYear(Integer year, String pathCatalog) {
        List<String> allBooks = readBooksFromCatalog(pathCatalog);
        List<String> booksByAuthor = allBooks.stream().filter(x -> x.contains(year.toString())).toList();
        browseCatalog(booksByAuthor);
    }

    private static void writeBookToCatalog(Book book, String pathCatalog) {
        String stringBook = String.format("%s, %s, %s, %d",
                book.getTitle(), book.getAuthor(), book.getPublisher(), book.getPublishingYear());

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(pathCatalog, true))) {
            writer.write(stringBook + "\n");
            System.out.println("Book added successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeEBookToCatalog(EBook eBook, String pathCatalog) {
        String stringBook = String.format("%s, %s, %s, %d, %s",
                eBook.getTitle(), eBook.getAuthor(), eBook.getPublisher(), eBook.getPublishingYear(), eBook.getUrl());
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(pathCatalog, true))) {
            writer.write(stringBook + "\n");
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

    private static List<String> readBooksFromCatalog(String pathCatalog) {
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
}
