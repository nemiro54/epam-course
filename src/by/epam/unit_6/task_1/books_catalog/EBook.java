package by.epam.unit_6.task_1.books_catalog;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;

public class EBook extends Book {
    private URL url;

    public EBook(String title, Author author, Publisher publisher, int publishingYear, URL url) {
        super(title, author, publisher, publishingYear, url);
        this.url = url;
//        writeBook();
    }

    //    write e-book to txt file

    @Override
    protected void writeBook() {
        String stringBook = String.format("&title=%s&author=%s&publisher=%s&year=%d&url=%s&",
                getTitle(), getAuthor(), getPublisher(), getPublishingYear(), getUrl());
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(getBooksFilePath(), true))) {
            writer.write(stringBook + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public URL getUrl() {
        return url;
    }

    public void setUrl(URL url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
