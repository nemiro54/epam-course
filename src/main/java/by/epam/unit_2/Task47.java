package by.epam.unit_2;

/*
task47: Два простых числа называются "близнецами", если они отличаются друг от друга на 2 (напрмиер, 41 и 43).
Найти и распечатать все пары "близнецов" из отрезка [n, 2n], где n - заданное натуральное число больше 2. Для решения
задачи использовать декомпозицию
 */

public class Task47 {
    public static void main(String[] args) {
        getTwinsOfPrimeNumbers(50);
    }

    static void getTwinsOfPrimeNumbers(int n) {
        for (int i = n; i <= 2 * n; i++) {
             if (Main.isPrimeNumber(i) && Main.isPrimeNumber(i + 2)) {
                 System.out.printf("A pair of twins: %d, %d%n", i, i + 2);
             }
        }
    }
}
