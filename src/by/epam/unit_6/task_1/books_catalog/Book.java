package by.epam.unit_6.task_1.books_catalog;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;

public class Book {
    private String title;
    private Author author;
    private Publisher publisher;
    private int publishingYear;
    private URL url;
    private final String booksFilePath = "src/by/epam/unit_6/task_1/books_catalog/booksCatalog";

    public Book(String title, Author author, Publisher publisher, int publishingYear) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.publishingYear = publishingYear;
        writeBook();
    }

    public Book(String title, Author author, Publisher publisher, int publishingYear, URL url) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.publishingYear = publishingYear;
        this.url = url;
        writeEBook();
    }

    //    write book to txt file

    protected void writeBook() {
        String stringBook = String.format("&title=%s&author=%s&publisher=%s&year=%d&",
                getTitle(), getAuthor(), getPublisher(), getPublishingYear());
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(booksFilePath, true))) {
            writer.write(stringBook + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeEBook() {
        String stringBook = String.format("&title=%s&author=%s&publisher=%s&year=%d&url=%s&",
                getTitle(), getAuthor(), getPublisher(), getPublishingYear(), getUrl());
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(getBooksFilePath(), true))) {
            writer.write(stringBook + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
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

    public URL getUrl() {
        return url;
    }

    public void setUrl(URL url) {
        this.url = url;
    }

    public String getBooksFilePath() {
        return booksFilePath;
    }

    @Override
    public String toString() {
        return String.format("Book - '%s', author - %s, publishing year - %d.",
                getTitle(), getAuthor(), getPublishingYear());
    }
}
