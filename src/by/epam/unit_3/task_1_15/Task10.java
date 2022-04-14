package by.epam.unit_3.task_1_15;

/*
task10: Подсчитать сколько раз среди заданной строки встречается буква 'a'.
 */

import java.util.stream.IntStream;

public class Task10 {
    public static void main(String[] args) {
    }

    static int countA(String str) {
        return (int) str.chars().filter(x -> x == 'a').count();
    }
}
