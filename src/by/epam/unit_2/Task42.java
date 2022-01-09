package by.epam.unit_2;

/*
task42: Задан массив D. Составить метод (методы) для вычисления суммы трех последовательно расположенных элементов
массива с номерами от k до m
 */

public class Task42 {
    public static void main(String[] args) {
        System.out.println(sumElements(new int[]{4, 2, 5, 21, 11, 22}, 0));
    }

    static int sumElements(int[] array, int k) {
        int sum = 0;
        if (k + 3 > array.length || array.length < 3) {
            throw new ArrayIndexOutOfBoundsException("One or more elements out of bounds of the array");
        }

        for (int i = k; i < k + 3; i++) {
            sum += array[i];
        }
        return sum;
    }
}
