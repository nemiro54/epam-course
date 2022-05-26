package by.epam.unit_3.task_1_15;

/*
task12: Вводится строка. Требуется удалить из нее повторяющееся символы и все пробелы.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task12 {
    public static void main(String[] args) {
        System.out.println(removeDuplicateCharacters());
    }

    static String removeDuplicateCharacters() {
        String str;

        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            str = reader.readLine().replace(" ", "");

            return str.chars()
                    .distinct()
                    .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                    .toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
