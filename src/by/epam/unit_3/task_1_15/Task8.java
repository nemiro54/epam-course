package by.epam.unit_3.task_1_15;

/*
task8: Проверить, является ли заданное слово палиндромом.
 */

public class Task8 {
    public static void main(String[] args) {

    }

    static boolean isPalindrome(String word) {
        return word.equalsIgnoreCase(new StringBuilder(word).reverse().toString());
    }
}
