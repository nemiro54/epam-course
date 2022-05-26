package by.epam.unit_2;

/*
task49: Найти все натуальные n-значные числа, цифры в которых образуют строго возрастающую последовательность
(например, 1234, 5789). Для решения задачи использовать декомпозицию
 */

import java.util.ArrayList;
import java.util.List;

public class Task49 {
    public static void main(String[] args) {
        List<Integer> list = getPositiveSequenceOfNumbers(4);
        list.forEach(System.out::println);
    }

    static List<Integer> getPositiveSequenceOfNumbers(int n) {
        List<Integer> positiveSequenceOfNumbers = new ArrayList<>();
        int[] allNumbers = getArrayOfNumbers(n);

        for (int i : allNumbers) {
            if (isPositiveSequence(getNumbers(i))) {
                positiveSequenceOfNumbers.add(i);
            }
        }
        return positiveSequenceOfNumbers;
    }

    static boolean isPositiveSequence(int[] num) {
        for (int i = 0; i < num.length - 1; i++) {
            if (num[i] >= num[i + 1]) {
                return false;
            }
        }
        return true;
    }

    static int[] getArrayOfNumbers(int n) {
        int min = (int) Math.pow(10, n - 1);
        int max = (int) Math.pow(10, n);
        int[] numbers = new int[max - min];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = min;
            min++;
        }
        return numbers;
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
