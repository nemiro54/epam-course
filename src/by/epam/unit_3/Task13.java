package by.epam.unit_3;

/*
task13: Вводится строка слов, разделенных пробелом. Найти самое длинное слово и вывести его на экран.
Случай, когда самых длинных слов может быть несколько, не обрабатывать.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Task13 {
    public static void main(String[] args) {
        printLongestWord();

    }

    static void printLongestWord() {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] words;

            words = reader.readLine().split(" ");

            Arrays.sort(words, Comparator.comparing(String::length, Comparator.reverseOrder()));

            if (words[0].length() > words[1].length()) {
                System.out.println(words[0]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}