package by.epam.unit_3.task_1_15;

/*
task14: Посчитать количество строчных (маленьких) и прописных (больших) букв во введенной строке.
Учитывать только английские буквы.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task14 {
    public static void main(String[] args) {
        System.out.println(countLetters());
    }

    static String countLetters() {
        int capitalLetters;
        int smallLetters;
        String str;

        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            str = bufferedReader.readLine();

            capitalLetters = countCapitalLetters(str);

            smallLetters = countSmallLetters(str);

            return String.format("Строчных букв: %d \nПрописных букв: %d", smallLetters, capitalLetters);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    static int countCapitalLetters(String str) {
        return (int) str.chars()
                .filter(Character::isUpperCase)
                .count();
    }

    static int countSmallLetters(String str) {
        return (int) str.chars()
                .filter(Character::isLowerCase)
                .count();
    }
}
