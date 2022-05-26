package by.epam.unit_2;

/*
task40: Написать метод (методы), проверяющий, являются ли данные три числа взаимно простыми
 */

public class Task40 {
    public static void main(String[] args) {
        System.out.println(isThreePrimeNumbers(16, 4, 8));
        System.out.println(isThreePrimeNumbers(11, 18, 93));
    }

    static boolean isThreePrimeNumbers(int a, int b, int c) {
        boolean isPrime = false;
        int firstGcd = gcd(a, b);
        int resGcd = gcd(firstGcd, c);

        if (resGcd == 1) {
            isPrime = true;
        }
        return isPrime;
    }

    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }
}