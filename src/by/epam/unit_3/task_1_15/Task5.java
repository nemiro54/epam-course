package by.epam.unit_3.task_1_15;

/*
task5: Удалить в строке все лишние пробелы, то есть серии подряд идущих пробелов заменить на одиночные пробелы.
Крайние пробелы в строке удалить.
 */

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task5 {
    public static void main(String[] args) {
    }

    static String replaceSpace(String str) {
        return str.replaceAll("\s+", " ").trim();
    }
}
