package by.epam.unit_2;

/*
task36: Написать метод (методы) для нахождения НОД четырех натуральных чисел
 */

public class Task36 {
    public static void main(String[] args) {
        System.out.println(greaterCommonDivisor(24, 180, 44, 36));
    }

    static int greaterCommonDivisor(int a, int b, int c, int d) {
        int firstGcd = gcd(a, b);
        int secondGcd = gcd(firstGcd, c);
        int resGcd = gcd(secondGcd, d);

        return resGcd;
    }

    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }
}
