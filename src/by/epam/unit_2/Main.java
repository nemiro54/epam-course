package by.epam.unit_2;

import java.util.Arrays;

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

    // task07: Даны действительные числа a1, a1, ...an. Найти max(a1 + a2n, a2 + a2n-1, ..., an + an+1).

    static double task07(double[] numbers) {
        double max = numbers[0] + numbers[numbers.length - 1];

        for (int i = 0; i < numbers.length / 2; i++) {
            max = Math.max(max, (numbers[i] + numbers[numbers.length - i - 1]));
        }
        return max;
    }

    /* task08: Дана последовательность целых чисел a1, a2, ..., an. Образовать новую последовательность, выбросив
    из исходной те члены, которые равны min(a1, a2, ..., an).
     */

    static int[] task08(int[] numbers) {
        int min = numbers[0];
        int countMin = 0; // кол-во элементов == min

        for (int element : numbers) {
            min = Math.min(min, element);
        }
        for (int element : numbers) {
            if (element == min) {
                countMin++;
            }
        }

        int[] newNumbers = new int[numbers.length - countMin];
        int indexNewArray = 0;

        for (int element : numbers) {
            if (element != min) {
                newNumbers[indexNewArray++] = element;
            }
        }
        return newNumbers;
    }

    /* task09: В массиве целых чисел с количеством элементов n определить наиболее часто встречающееся число.
    Если таких чисел несколько, то определить наименьшее из них.
     */

    static int task09(int[] array) {
        int resultNumber = array[0]; // возвращаемое значение
        int[] popularNumbers = new int[array.length];

        for (int i = 0; i < array.length; i++) { //  проверка на количество повторений чисел
            for (int j = 0; j < array.length; j++) {
                if (array[i] == array[j]) {
                    popularNumbers[i]++;
                }
            }
        }

        int mostPopularNumber = popularNumbers[0]; // наиболее часто встречающееся число
        for (int i = 0; i < popularNumbers.length; i++) {
            if (popularNumbers[i] > mostPopularNumber) {
                mostPopularNumber = popularNumbers[i];
                resultNumber = array[i];
            }
            if ((mostPopularNumber == popularNumbers[i]) && (array[i] < resultNumber)) {
                resultNumber = array[i];
            }
        }
        return resultNumber;
    }

    /* task10: Дан целочисленный массив с количеством элементов n. Сжать массив, выбросив из него каждый второй
    элемент (освободившиеся элементы заполнить нулями). Примечание. Дополнительный массив не использовать.
     */

    static int[] task10(int[] array) {
        for (int i = 0; i < array.length / 2; i ++) {
            array[i] = array[i * 2];
        }
        Arrays.fill(array, array.length / 2, array.length - 1, 0);
        return array;
    }

    // task11: Дана матрица. Вывести на экран все нечетные столбцы, у которых первый элемент больше последнего.

    static void task11(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j += 2) {
                if (matrix[0][j] > matrix[matrix.length - 1][j]) {
                    System.out.print(matrix[i][j] + "\t");
                }
            }
            System.out.println();
        }
    }

    // task12: Дана квадратная матрица. Вывести на экран элементы, стоящие на диагонали.

    static void task12(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(matrix[i][i]);
        }
    }

    // task13: Дана матрица. Вывести k-ю строку и p-й столбец матрицы.

    static void task13(int[][] matrix, int k, int p) {
        for (int i = 0; i < matrix[k - 1].length; i++) {
            System.out.print(matrix[k - 1][i] + "\t");
        }
        System.out.println();
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(matrix[i][p - 1]);
        }
    }

    // task14: Сформировать квадратную матрицу порядка n по заданному образцу (n - четное).

    static int[][] task14(int n) {
        int[][] matrix = new int[n][n];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (i % 2 == 0) {
                    matrix[i][j] = j + 1;
                } else {
                    matrix[i][j] = n - j;
                }
            }
        }
        return matrix;
    }

    // task15: Сформировать квадратную матрицу порядка n по заданному образцу (n - четное).

    static int[][] task15(int n) {
        int[][] matrix = new int[n][n];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length - i; j++) {
                matrix[i][j] = i + 1;
            }
        }
        return matrix;
    }

    // task16: Сформировать квадратную матрицу порядка n по заданному образцу (n - четное).

    static int[][] task16(int n) {
        int[][] matrix = new int[n][n];

        for (int i = 0; i < matrix.length / 2; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (j >= i && j < (n - i)) {
                    matrix[i][j] = 1;
                    matrix[n - i - 1][j] = 1;
                }
            }
        }
        return matrix;
    }

    /* task17: Сформировать квадратную матрицу порядка N по правилу: A[I, J] = sin((I^2 - J^2) / N) и подсчитать
    количество положительных элементов в ней.
     */

    static int task17(int n) {
        double[][] matrix = new double[n][n];
        int countPositiveNumber = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[i][j] = Math.sin((Math.pow(i, 2) - Math.pow(j, 2)) / n);
                if (matrix[i][j] > 0) {
                    countPositiveNumber++;
                }
            }
        }
        return countPositiveNumber;
    }
}