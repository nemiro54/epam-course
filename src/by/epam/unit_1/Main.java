package by.epam.unit_1;

import java.math.BigInteger;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        task19(151312.91928848, 50.155217748711);
    }
    // Task01: Найдите значение функции: z = ((a - 3) * b / 2) + c

    static double task01(double a, double b, double c) {
        return (a - 3) * b / 2 + c;
    }

    /* Task02: Вычислите значение выражения по формуле (все переменные принимают действительные значения):
    (b + √(b^2 + 4ac) / 2a - a^3 * c - b^(-2)
     */

    static double task02(double a, double b, double c) {
        return ((b + Math.sqrt(Math.pow(b, 2) + 4 * a * c)) / (2 * a) - Math.pow(a, 3) * c - Math.pow(b, -2));
    }

    /* Task03: Вычислить значение выражения по формуле (все переменные принимают действительные значения):
    (sin x + cos y) / (cos x - sin y) * tg xy
     */

    static double task03(double x, double y) {
        double radX = Math.toRadians(x);
        double radY = Math.toRadians(y);

        return ((Math.sin(radX) + Math.cos(radY)) / Math.cos(radX) - Math.sin(radY)) * Math.tan(radX * radY);
    }

    /* Task04: Дано действительное число R вида nnn.ddd (три цифровых разряда в целой и дробной частях).
    Поменять местами дробную и целую части числа и вывести полученное значение числа
     */

    static void task04(double number) {
        double reverseNumber = (number * 1000) % 1000 + (int) number / 1000.0;
        System.out.println(reverseNumber);
    }

    /* Task05: Дано натуральное число Т, которое представляет длительность прошедшего времени в секундах.
    Вывести данное значение длительности в часах, минутах и секундах в следующей форме:
    HHч MMмин SSс
     */

    static void task05(int secondValue) {
        int hours = secondValue / 3600;
        int tmp = secondValue - hours * 3600;
        int minutes = tmp / 60;
        int seconds = tmp - minutes * 60;

        System.out.println(String.format("%dч %dмин %dс", hours, minutes, seconds));
    }

    /* Task06: Для данной области составить линейную программу, которая печатает true, если точка с координатами (x, y)
    принадлежит закрашенной области, и false - в противном случае.
     */

    static void task06(int x, int y) {
        boolean isFlag = false;

        if ((x >= -4 && x <= 4 && y >= -3 && y <= 0) || (x >= -2 && x <= 2 && y >= 0 & y <= 4)) {
            isFlag = true;
        }
        System.out.println(isFlag);
    }

    /* Task07: Даны два угла треугольника (в градусах). Определить, существует ли такой треугольник, и если да,
    то будет ли он прямоугольным.
     */

    static void task07(int a, int b) {
        if (a + b == 90) {
            System.out.println("This is a right triangle!");
        } else if (a + b < 180) {
            System.out.println("This is a triangle!");
        } else {
            System.out.println("This isn't a triangle!");
        }
    }

    // Task08: Найти max{min(a, b), min(c, d)}.

    static void task08(double a, double b, double c, double d) {
        double max = Math.max(Math.min(a, b), Math.min(c, d));
    }

    // Task09: Даны три точки A(x1, y1), B(x2, y2), C(x3, y3). Определить, будут ли они расположены на одной прямой.

    static void task09(int x1, int y1, int x2, int y2, int x3, int y3) {
        if ((x1 - x3) * (y2 - y3) == (x2 - x3) * (y1 - y3)) {
            System.out.println("Points lie on one straight line");
        } else {
            System.out.println("Points don't lie on one straight line");
        }
    }

    /* Task10: Заданы размеры A, B прямоугольного отверстия и размеры x, y, z кирпича.
    Определить пройдет ли кирпич через отверстие.
     */

    static void task10(int A, int B, int x, int y, int z) {
        if (x <= A && y <= B || y <= A && x <= B ||
                x <= A && z <= B || z <= A && x <= B ||
                z <= A && y <= B || y <= A && z <= B) {
            System.out.println("Will pass");
        } else {
            System.out.println("Will not pass");
        }
    }

    // Task11: Вычислить значение функции.

    static void task11(double x) {
        double result;

        if (x <= 3) {
            result = Math.pow(x, 2) - 3 * x + 9;
        } else {
            result = 1 / (Math.pow(x, 3) + 6);
        }
        System.out.println(result);
    }

    /* Task12: Напишите программу, где пользователь вводит любое целое положительное число, а программа
    суммирует все числа от 1 до введенного пользователем числа.
     */

    static void task12() {
        Scanner scanner = new Scanner(System.in);
        int number;
        int result = 0;

        while (true) {
            System.out.println("Enter a positive number");
            number = scanner.nextInt();

            if (number <= 0) {
                System.out.print("Error! ");
            } else {
                break;
            }
        }

        for (int i = 0; i <= number; i++) {
            result += i;
        }

        System.out.println(String.format("Sum is: %d", result));
    }

    //Task13: Вычислить значение функции y = {x, x > 2; y = -x, x <=2} на отрезке [a, b] с шагом h.

    static void task13(double a, double b, double h) {
        double y;

        for (double x = a; x <= b; x += h) {
            if (x > 2) {
                y = x;
            } else {
                y = -x;
            }
        }
    }

    // Task14: Найти сумму квадратов первых ста чисел

    static void task14() {
        int result = 0;

        for (int i = 0; i <= 100; i++) {
            result += Math.pow(i, 2);
        }
    }

    // Task15: Составить программу нахождения произведения квадратов первых двухсот чисел

    static void task15() {
        BigInteger result = BigInteger.valueOf(1);

        for (int i = 1; i <= 200; i++) {
            result = result.multiply(BigInteger.valueOf((long) Math.pow(i, 2)));
        }
    }

    /* Task16: Даны числовой ряд и некоторое число е. Найти сумму тех членов ряда, модуль которых больше или равен
    заданному е. Общий член ряда имеет вид: a = 1 / 2^n + 1 / 3^n
     */

    static void task16(double e, double n) { // n - первый член ряда
        double sum = 0;

        while (Math.abs(1 / Math.pow(2, n) + 1 / Math.pow(3, n)) >= e) {
            sum += Math.abs(1 / Math.pow(2, n) + 1 / Math.pow(3, n));
            n++;
        }
    }

    // Task17: Вывести на экран соответствие между символами и их численными обозначениями в памяти компьютера

    static void task17() {
        for (int i = 0; i < 256; i++) {
            char c = (char) i;
            System.out.println(i + ": " + c);
        }
    }

    /* Task18: Для каждого натурального числа в промежутке от m до n вывести все делители, кроме единицы и самого числа.
    m и n вводятся с клавиатуры.
     */

    static void task18() {
        int m, n;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter m: ");
        m = scanner.nextInt();
        System.out.print("Enter n: ");
        n = scanner.nextInt();

        if (m < 1) {
            m = 1;
        }

        for (int i = m; i < n + 1; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    list.add(j);
                }
            }
            if (list.isEmpty()) {
                System.out.println(i + ": ");
            } else {
                System.out.println(i + ": " + list);
            }
        }
    }

    // Task19: Даны два числа. Определить цифры входящие в запись как первого так и второго числа.

    static void task19(double a, double b) {
        String aStr = Double.toString(a);
        String bStr = Double.toString(b);
        HashSet<Character> set = new HashSet<>();

        for (int i = 0; i < aStr.length(); i++) {
            for (int j = 0; j < bStr.length(); j++) {
                if (aStr.charAt(i) == bStr.charAt(j) && aStr.charAt(i) != '.') {
                    set.add(aStr.charAt(i));
                }
            }
        }
        System.out.println(set);
    }
}
