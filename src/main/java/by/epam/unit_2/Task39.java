package by.epam.unit_2;

/*
task39: Составить программу, которая в массиве A[N] находит второе по величине число (вывести на печать число, которое
меньше максимального элемента массива, но больше всех других элементов)
 */

import java.util.Arrays;

public class Task39 {
    public static void main(String[] args) {
        beforeMax(new int[]{1, 4, 1, 2, 4, 2, 3, 73, 4, 8, 54, 98, 98, 2, 13, 122});
    }

    static void beforeMax(int [] a) {
        int beforeMax= a[0];
        int max;

        Arrays.sort(a);
        max = a[a.length -1];

        for (int i = a.length - 1; i > 0; i--) {
            if (a[i] < max && a[i] != max) {
                beforeMax = a[i];
                break;
            }
        }
        System.out.println(beforeMax);
    }
}