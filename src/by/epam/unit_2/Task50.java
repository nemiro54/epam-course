package by.epam.unit_2;

/*
task50: Написать программу, определяющую сумму n - значных чисел, содержащих только нечетные цифры. Определить также
сколько четных цифр в найденной сумме. Для решения использовать декомпозицию
 */

public class Task50 extends Task49 {
    public static void main(String[] args) {
        System.out.println("sum = " + getSumOfOddNumbers(2));
        System.out.println(countEvenNumbers(getSumOfOddNumbers(2)));
    }

    static int countEvenNumbers(int num) {
        int count = 0;
        int[] numToArray = getNumbers(num);

        for (int element : numToArray) {
            if (isEvenNumber(element)) {
                count++;
            }
        }
        return count;
    }

    static int getSumOfOddNumbers(int n) {
        int sum = 0;
        int[] numbers = getArrayOfNumbers(n);

        for (int element : numbers) {
            if (isConsistOnlyOddNumbers(getNumbers(element))) {
                sum += element;
            }
        }
        return sum;
    }

    static boolean isConsistOnlyOddNumbers(int[] num) {
        for (int i : num) {
            if (isEvenNumber(i)) {
                return false;
            }
        }
        return true;
    }

    static boolean isEvenNumber(int num) {
        return num % 2 == 0;
    }
}
