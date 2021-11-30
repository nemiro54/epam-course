package by.epam.unit_1;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Main {

    public static void main(String[] args) {
    }

    // Task01: Найдите значение функции: z = ((a - 3) * b / 2) + c

    public static double task01(double a, double b, double c) {
        return (a - 3) * b / 2 + c;
    }

    /* Task02: Вычислите значение выражения по формуле (все переменные принимают действительные значения):
       (b + √(b^2 + 4ac) / 2a - a^3 * c - b^(-2) */

    public static double task02(double a, double b, double c) {
        return ((b + Math.sqrt(Math.pow(b, 2) + 4 * a * c)) / (2 * a) - Math.pow(a, 3) * c - Math.pow(b, -2));
    }

    /* Task03: Вычислить значение выражения по формуле (все переменные принимают действительные значения):
       (sin x + cos y) / (cos x - sin y) * tg xy */

    public static double task03(double x, double y) {
        double radX = Math.toRadians(x);
        double radY = Math.toRadians(y);

        return ((Math.sin(radX) + Math.cos(radY)) / Math.cos(radX) - Math.sin(radY)) * Math.tan(radX * radY);
    }

    /* Task04: Дано действительное число R вида nnn.ddd (три цифровых разряда в целой и дробной частях).
       Поменять местами дробную и целую части числа и вывести полученное значение числа */

    public static void task04(double number) {
        double reverseNumber = (number * 1000) % 1000 + (int) number / 1000.0;
        System.out.println(reverseNumber);
    }

    /* Task05: Дано натуральное число Т, которое представляет длительность прошедшего времени в секундах.
       Вывести данное значение длительности в часах, минутах и секундах в следующей форме:
       HHч MMмин SSс */

    public static void task05(int secondValue) {
        int hours = secondValue / 3600;
        int tmp = secondValue - hours * 3600;
        int minutes = tmp / 60;
        int seconds = tmp - minutes * 60;

        System.out.println(String.format("%dч %dмин %dс", hours, minutes, seconds));
    }
}
