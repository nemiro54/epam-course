package by.epam.unit_4.task_9;

import java.util.Arrays;
import java.util.stream.Collectors;

public class AggregationBook {
    private Book[] books;

    public AggregationBook(Book[] books) {
        this.books = books;
    }

    public void filterByAuthor(String author) {
        Arrays.stream(books)
                .filter(x -> x.getAuthor().toLowerCase().contains(author.toLowerCase()))
                .forEach(System.out::println);
    }

    public void filterByPublisher(String publisher) {
        Arrays.stream(books)
                .filter(x -> x.getPublisher().toLowerCase().contains(publisher.toLowerCase()))
                .forEach(System.out::println);
    }

    public void filterByYear(int year) {
        Arrays.stream(books)
                .filter(x -> x.getYear() > year)
                .forEach(System.out::println);
    }

    public Book[] getBooks() {
        return books;
    }

    public void setBooks(Book[] books) {
        this.books = books;
    }
}
