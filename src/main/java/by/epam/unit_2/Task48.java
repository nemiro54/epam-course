package by.epam.unit_2;

/*
task48: Натуральное число, в записи которого n цифр, называется числом Армстронга, если сумма его цифр, возведенная в
степень n, равна самому числу. Найти все числа Армстронга от 1 до k. Для решения задачи использовать декомпозицию
 */

import java.util.ArrayList;
import java.util.List;

public class Task48 {
    public static void main(String[] args) {
    }

    static List<Integer> getArmstrongNumbers(int k) {
        List<Integer> list = new ArrayList<>();

        for (int i = 1; i <= k; i++) {
            if (isArmstrongNumber(i)) {
                list.add(i);
            }
        }
        return list;
    }

    static boolean isArmstrongNumber(int num) {
        return sumOfDegrees(getNumbers(num)) == num;
    }

    static int sumOfDegrees(int[] number) {
        int sum = 0;
        for (int i : number) {
            sum += Math.pow(i, number.length);
        }
        return sum;
    }

    static int[] getNumbers(int num) {
        char[] chars = Integer.toString(num).toCharArray();
        int[] numberToArray = new int[chars.length];

        for (int i = 0; i < chars.length; i++) {
            numberToArray[i] = Character.getNumericValue(chars[i]);
        }
        return numberToArray;
    }
}