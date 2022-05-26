package by.epam.unit_2;

/*
task44: Дано натуральное число N. Написать метод (методы) для формирования массива, элементами которого являются
цифры числа N
 */

import java.math.BigInteger;
import java.util.Arrays;

public class Task44 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(numberToArray(2115645586)));
    }

    static int[] numberToArray(int n) {
        char[] chars = Integer.toString(n).toCharArray();
        int[] array = new int[chars.length];

        for (int i = 0; i < chars.length; i++) {
            array[i] = Character.getNumericValue(chars[i]);
        }
        return array;
    }
}
