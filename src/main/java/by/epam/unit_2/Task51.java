package by.epam.unit_2;

/*
task51: Из заданного числа вычли сумму его цифр. Из результата вновь вычли сумму его цифр и т.д. Сколько таких действий
нужно произвести, чтобы получился ноль? Для решения испльзовать декомпозицию
 */

public class Task51 extends Task49 {
    public static void main(String[] args) {
        System.out.println(subtraction(20));
    }

    static int subtraction(int num) {
        int count = 0;
        int sumNumbers;

        while (true) {
            sumNumbers = sumNumbers(getNumbers(num));
            int tmp = num - sumNumbers;

            if (tmp > 0) {
                num = tmp;
                count++;
            } else {
                break;
            }
        }
        return count + 1;
    }

    static int sumNumbers(int[] number) {
        int sum = 0;

        for (int i : number) {
            sum += i;
        }
        return sum;
    }
}
