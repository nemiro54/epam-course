package by.epam.unit_4.task_4;

/*
task4: Создайте класс Train, содержащий поля: название пункта назначения, номер поезда, время отправления.
Создайте данные в массив из пяти элементов типа Train, добавьте возможность сортировки элементов массива по
номерам поездов. Добавьте возможность вывода информации о поезде, номер которого введен пользователем.
Добавьте возможность сортировки массива по пункту назначения, причем поезда с одинаковыми пунктами назначения
должны быть упорядочены по времени отправления.
 */

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH-mm");
        Train[] trains = new Train[]{
                new Train("Moscow", 722, simpleDateFormat.parse("11-20")),
                new Train("Saint-Petersburg", 250, simpleDateFormat.parse("03-20")),
                new Train("Adler", 302, simpleDateFormat.parse("15-18")),
                new Train("Kaliningrad", 360, simpleDateFormat.parse("19-00")),
                new Train("Brest", 653, simpleDateFormat.parse("06-15")),
                new Train("Brest", 654, simpleDateFormat.parse("05-00"))
        };
    }
}
