package by.epam.unit_2;

public class Main {
    public static void main(String[] args) {
    }

    // Проверка простых чисел:

    static boolean isPrimeNumber(int number) {
        if (number < 2) {
            return false;
        } else {
            for (int i = 2; i < number; i++) {
                if (number % i == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    // task01: В массив A[N] занесены натуральные числа. Найти сумму тех элементов, которые кратны данному K.

    static int task01(int[] A, int K) {
        int count = 0;

        for (int i = 0; i < A.length; i++) {
            if(A[i] % K == 0) {
                count += A[i];
            }
        }
        return count;
    }

    /* task02: Дана последовательность действительных чисел a1, a2, ..., an. Заменить все ее члены, большие данного Z,
    этим числом. Подсчитать количество замен.
     */

    static int task02(double[] numbers, double Z) {
        int countReplacement = 0;

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] < Z) {
                numbers[i] = Z;
                countReplacement++;
            }
        }
        return countReplacement;
    }

    /* task03: Дан массив действительных чисел, размерность которого N. Подсчитать, сколько в нем отрицательных, положительных
    и нулевых элементов.
     */

    static void task03(double[] array) {
        int countPositiveNumber = 0;
        int countNegativeNumber = 0;
        int countZeroNumber = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] > 0) {
                countPositiveNumber++;
            } else if (array[i] < 0) {
                countNegativeNumber++;
            } else {
                countZeroNumber++;
            }
        }
    }

    // task04: Даны действительные числа a1, a2, ..., an. Поменять местами наибольший и наименьший элементы.

    static void task04(double[] array) {
        int iMax = 0;
        int iMin = 0;
        double max = array[0];
        double min = array[0];

        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
                iMax = i;
            } else if (array[i] < min) {
                min = array[i];
                iMin = i;
            }
        }
        array[iMin] = max;
        array[iMax] = min;
    }

    // task05: Даны целые числа а1, а2,..., an. Вывести на печать только те числа, для которых ai > i.

    static void task05(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] > i) {
                System.out.println(array[i]);
            }
        }
    }

    /* task06: Задана последовательность N вещественных чисел. Вычислить сумму чисел, порядковые номера которых
    являются простыми числами.
     */

    static double task06(double[] numbers) {
        double countPrimeNumbers = 0;

        for (int i = 0; i < numbers.length; i++) {
            if (isPrimeNumber(i)) {
                countPrimeNumbers += numbers[i];
            }
        }
        return countPrimeNumbers;
    }
}