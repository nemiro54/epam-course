package by.epam.unit_2;

/*
task46: Даны натуральные числа K и N. Написать метод (методы) формирования массива А, элементами которого являются
числа, сумма цифр которых равна K и которые не больше N
 */

import java.util.Arrays;

public class Task46 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(createArray(9, 100)));
    }

    public static int[] numberToArray(int num) {
        char[] charArr = Integer.toString(num).toCharArray();
        int[] array = new int[charArr.length];

        for (int i = 0; i < charArr.length; i++) {
            array[i] = Character.getNumericValue(charArr[i]);
        }
        return array;
    }

    public static int sumOfNumber(int[] array) {
        int sum = 0;

        for (int i : array) {
            sum += i;
        }
        return sum;
    }

    public static int arrayLength(int k, int n) {
        int length = 0;

        for (int i = 0; i <= n; i++) {
            if (sumOfNumber(numberToArray(i)) == k) {
                length++;
            }
        }
        return length;
    }

    public static int[] createArray(int k, int n) {
        int num = 0;
        int[] array = new int[arrayLength(k, n)];

        for (int i = 0; i <= n; i++) {
            if (sumOfNumber(numberToArray(i)) == k) {
                array[num] = i;
                num++;
            }
        }
        return array;
    }
}