package by.epam.unit_6.task_3;

/*
unit_6.task_3: Создайте клиент-серверное приложение "Архив".

Общие требования к заданию:
- В архиве хранятся Дела (например, студентов). Архив находится на сервере.
- Клиент, в зависимости от прав, может запросить дело на просмотр, внести в него изменения, или создать новое дело.

Требования к коду лабораторной работы:
- Для реализации сетевого соединения используйте сокеты.
- Формат хранения данных на сервере - xml-файлы.
 */

import by.epam.unit_6.task_3.server.archive.Case;
import by.epam.unit_6.task_3.server.xml.XmlReader;
import by.epam.unit_6.task_3.server.xml.XmlWriter;
import by.epam.unit_6.task_3.user.User;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
    }
}

