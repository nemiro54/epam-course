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
1. сделать каталог книг
2. методы каталога
3. методы пользователей
4. Mail API
 */

import by.epam.unit_6.task_1.books_catalog.Author;
import by.epam.unit_6.task_1.books_catalog.Book;
import by.epam.unit_6.task_1.books_catalog.EBook;
import by.epam.unit_6.task_1.books_catalog.Publisher;
import by.epam.unit_6.task_1.users.Role;
import by.epam.unit_6.task_1.users.User;

import java.net.MalformedURLException;
import java.net.URL;

public class Main {
    public static void main(String[] args) throws MalformedURLException {
        Author authorTolstoy = new Author("Leo", "Tolstoy");
        Publisher publisherNauka = new Publisher("Nauka");
        URL url = new URL("https://google.com");
        EBook warAndPeace = new EBook("Parents and children", authorTolstoy, publisherNauka, 2018, url);
    }
}
