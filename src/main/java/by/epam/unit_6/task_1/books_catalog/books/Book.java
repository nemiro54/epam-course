package by.epam.unit_6.task_1.books_catalog.books;

import by.epam.unit_6.task_1.books_catalog.publisher.Publisher;
import by.epam.unit_6.task_1.books_catalog.author.Author;

public class Book {
    private String title;
    private Author author;
    private Publisher publisher;
    private int publishingYear;
    private final static String booksFilePath = "src/main/java/by/epam/unit_6/task_1/books_catalog/booksCatalog";

    public Book(String title, Author author, Publisher publisher, int publishingYear) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.publishingYear = publishingYear;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public int getPublishingYear() {
        return publishingYear;
    }

    public void setPublishingYear(int publishingYear) {
        this.publishingYear = publishingYear;
    }

    public static String getBooksFilePath() {
        return booksFilePath;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author=" + author +
                ", publisher=" + publisher +
                ", publishingYear=" + publishingYear +
                '}';
    }
}
