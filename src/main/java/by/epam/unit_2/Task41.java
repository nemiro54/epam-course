package by.epam.unit_2;

/*
task41: Написать метод (методы) для вычисления суммы факториалов всех нечетных чисел от 1 до 9
 */

public class Task41 {
    public static void main(String[] args) {
        System.out.println(sumFactorials());
    }

    static int sumFactorials() {
        int sum = 0;
        for (int i = 1; i <= 9; i += 2) {
            sum = sum + factorial(i);
        }
        return sum;
    }

    static int factorial(int n) {
        if (n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }
}
