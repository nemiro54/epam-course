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

import by.epam.unit_6.task_1.books_catalog.author.Author;
import by.epam.unit_6.task_1.books_catalog.books.Book;
import by.epam.unit_6.task_1.books_catalog.books.EBook;
import by.epam.unit_6.task_1.books_catalog.publisher.Publisher;
import by.epam.unit_6.task_1.mail_sender.EMailSender;
import by.epam.unit_6.task_1.users.Role;
import by.epam.unit_6.task_1.users.User;
import by.epam.unit_6.task_1.users.UserUtil;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
    }
}
