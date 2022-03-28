package by.epam.unit_3;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
task1: Дан массив названий переменных в camelCase. Преобразовать названия в snake_Case.
 */

public class Task1 {
    public static void main(String[] args) {
    }

    static void converter(String[] strings) {
        Pattern pattern = Pattern.compile("\\B[A-Z]");
        for (int i = 0; i < strings.length; i++) {
            Matcher matcher = pattern.matcher(strings[i]);
            StringBuilder sb = new StringBuilder();
            while (matcher.find()) {
                matcher.appendReplacement(sb, "_$0");
            }
            matcher.appendTail(sb);
            strings[i] = sb.toString().toLowerCase();
        }
        System.out.println(Arrays.toString(strings));
    }
}
