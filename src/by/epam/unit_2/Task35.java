package by.epam.unit_2;

/*
task35: Написать метод (методы) для нахождения НОД и НОК двух натуральных чисел.
 */

public class Task35 {
    public static void main(String[] args) {
    }

    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }

    public static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }
}
