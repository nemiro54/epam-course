package by.epam.unit_6.task_1.books_catalog.books;

import by.epam.unit_6.task_1.books_catalog.publisher.Publisher;
import by.epam.unit_6.task_1.books_catalog.author.Author;

import java.net.URL;

public class EBook extends Book {
    private URL url;

    public EBook(String title, Author author, Publisher publisher, int publishingYear, URL url) {
        super(title, author, publisher, publishingYear);
        this.url = url;
    }

    public URL getUrl() {
        return url;
    }

    public void setUrl(URL url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + getTitle() + '\'' +
                ", author=" + getAuthor() +
                ", publisher=" + getPublisher() +
                ", publishingYear=" + getPublishingYear() +
                ", url=" + url +
                '}';
    }
}
