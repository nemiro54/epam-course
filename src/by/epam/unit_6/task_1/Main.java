package by.epam.unit_6.task_1;

/*
unit_6.task_1: Создать консольное приложение "Учет книг в домашней библиотеке".

Общие требования к заданию:

- Система учитывает книги как в электронном, так и в бумажном варианте.
- Существующие роли: пользователь, администратор.
- Пользователь может просматривать книги в каталоге книг, осуществлять поиск книг в каталоге.
- Администратор может модифицировать каталог.
- * При добавлении описания книги в каталог оповещение о ней рассылается на e-mail всем пользователям.
- * При просмотре каталога желательно реализовать постраничный просмотр.
- * Пользователь может предложить добавить книгу в библиотеку, переслав ее администратору на e-mail.
- Каталог книг хранится в текстовом файле.
- Данные аутентификации пользователей хранятся в текстовом файле. Пароль не хранится в открытом виде.
 */

/*
1. сделать каталог книг - done
2. методы каталога
3. методы пользователей
4. Mail API
 */

import by.epam.unit_6.task_1.books_catalog.author.Author;
import by.epam.unit_6.task_1.books_catalog.books.Book;
import by.epam.unit_6.task_1.books_catalog.publisher.Publisher;
import by.epam.unit_6.task_1.users.Role;
import by.epam.unit_6.task_1.users.User;

import java.net.MalformedURLException;
import java.net.URL;

public class Main {
    public static void main(String[] args) throws MalformedURLException {
        Author tolstoy = new Author("Leo", "Tolstoy");
        Author pushkin = new Author("Alexsandr", "Pushkin");
        Author dostoevskiy = new Author("Fedor", "Dostoevskiy");
        Author lermontov = new Author("Mihail", "Lermonov");
        Author kolas = new Author("Yakub", "Kolas");

        Publisher publisherNauka = new Publisher("Nauka");

        URL url = new URL("https://google.com");

        Book warAndPeace = new Book("War and Peace", tolstoy, publisherNauka, 1867);
        Book evgeniyOnegin = new Book("Evgeniy Onegin", pushkin, publisherNauka, 1823, url);
        Book nakazanie = new Book("Преступление и наказание", dostoevskiy, publisherNauka, 1820);
        Book mziri = new Book("Мцири", lermontov, publisherNauka, 1863, url);
        Book kalasiPadSyarpom = new Book("Каласы пад сярпом тваим", kolas, publisherNauka, 1925);

//        User admin = new User("admin", "admin@gmail.com", "qweRTY123", Role.ADMIN);
//        admin.viewBookCatalog();
    }
}
