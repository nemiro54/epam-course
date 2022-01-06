package by.epam.unit_2;

import java.util.*;

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

    // Метод перестановки чисел местами

    static int[] swap(int[] array, int a, int b) {
        int tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;

        return array;
    }

    // task01: В массив A[N] занесены натуральные числа. Найти сумму тех элементов, которые кратны данному K.

    static int task01(int[] A, int K) {
        int count = 0;

        for (int element : A) {
            if (element % K == 0) {
                count += element;
            }
        }
        return count;
    }

    /*
    task02: Дана последовательность действительных чисел a1, a2, ..., an. Заменить все ее члены, большие данного Z,
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

    /*
    task03: Дан массив действительных чисел, размерность которого N. Подсчитать, сколько в нем отрицательных, положительных
    и нулевых элементов.
     */

    static void task03(double[] array) {
        int countPositiveNumber = 0;
        int countNegativeNumber = 0;
        int countZeroNumber = 0;

        for (double element : array) {
            if (element > 0) {
                countPositiveNumber++;
            } else if (element < 0) {
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

    /*
    task06: Задана последовательность N вещественных чисел. Вычислить сумму чисел, порядковые номера которых
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

    /*
    task08: Дана последовательность целых чисел a1, a2, ..., an. Образовать новую последовательность, выбросив
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

    /*
    task09: В массиве целых чисел с количеством элементов n определить наиболее часто встречающееся число.
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

    /*
    task10: Дан целочисленный массив с количеством элементов n. Сжать массив, выбросив из него каждый второй
    элемент (освободившиеся элементы заполнить нулями). Примечание. Дополнительный массив не использовать.
     */

    static int[] task10(int[] array) {
        for (int i = 0; i < array.length / 2; i++) {
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

    /*
    task17: Сформировать квадратную матрицу порядка N по правилу: A[I, J] = sin((I^2 - J^2) / N) и подсчитать
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

    /*
    task18: В числовой матрице поменять местами два столбца, т.е. все элементы одного столбца посавить на соответствующие
    им позиции другого, а его элементы второго переместить в первый. Номера столбцов вводит пользователь с клавиатуры.
     */
    static void task18(int[][] matrix) {
        Scanner scanner = new Scanner(System.in);
        int firstColumn = scanner.nextInt();
        int secondColumn = scanner.nextInt();

        for (int i = 0; i < matrix.length; i++) {
            int tmp = matrix[i][firstColumn - 1];
            matrix[i][firstColumn - 1] = matrix[i][secondColumn - 1];
            matrix[i][secondColumn - 1] = tmp;
        }
    }

    /*
    task19: Задана матрица неотрицательных чисел. Посчитать сумму элементов в каждом столбце. Определить, какой столбец
    содержит максимальную сумму.
     */

    static int task19(int[][] matrix) {
        int sum = 0;
        int column = 0;

        for (int i = 0; i < matrix[0].length; i++) {
            int count =0;
            for (int j = 0; j < matrix.length; j++) {
                count += matrix[j][i];
            }
            if (count > sum) {
                sum = count;
                column = i;
            }
        }
        return column;
    }

    // task20: Найти положительные элементы главной диагонали квадратной матрицы

    static ArrayList<Integer> task20(int[][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][i] > 0) {
                list.add(matrix[i][i]);
            }
        }
        return list;
    }

    /*
    task21: Матрицу 10х20 заполнить случайными числами от 0 до 15. Вывести на экран саму матрицу и номера строк,
    в которых число 5 встречается три и более раз.
     */

    static void task21(int [][] matrix) {
        HashSet<Integer> numbersOfString = new HashSet<>();
        int tmpCount;

        for (int i = 0; i < matrix.length; i++) {
            tmpCount = 0;
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = (int) (Math.random() * 16);
                if (matrix[i][j] == 5) {
                    tmpCount++;
                }
                if (tmpCount >= 3) {
                    numbersOfString.add(i);
                }
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println("Numbers of strings: " + numbersOfString);
    }

    // task22: Отсортировать строки матрицы по возрастанию и убыванию элементов

    static int[][] task22(int[][] matrix) {
        int tmp;
        boolean isSorted = false;

        // сортировка по возрастанию
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length - 1; j++) {
                    if (matrix[i][j] > matrix[i][j + 1]) {
                        isSorted = false;

                        tmp = matrix[i][j];
                        matrix[i][j] = matrix[i][j + 1];
                        matrix[i][j + 1] = tmp;
                    }
                }
            }
        }

        // сортировка по убыванию
        isSorted = false;

        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length - 1; j++) {
                    if (matrix[i][j] < matrix[i][j + 1]) {
                        isSorted = false;

                        tmp = matrix[i][j];
                        matrix[i][j] = matrix[i][j + 1];
                        matrix[i][j + 1] = tmp;
                    }
                }
            }
        }
        return matrix;
    }

    // task23: Отсортировать столбцы матрицы по возрастанию и убыванию элементов

    static int[][] task23(int[][] matrix) {
        int tmp;
        boolean isSorted = false;

        // сортировка по возрастанию
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < matrix[0].length; i++) {
                for (int j = 0; j < matrix.length - 1; j++) {
                    if (matrix[j][i] > matrix[j + 1][i]) {
                        isSorted = false;

                        tmp = matrix[j][i];
                        matrix[j][i] = matrix[j + 1][i];
                        matrix[j + 1][i] = tmp;
                    }
                }
            }
        }

        // сортировка по убыванию
        isSorted = false;

        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < matrix[0].length; i++) {
                for (int j = 0; j < matrix.length - 1; j++) {
                    if (matrix[j][i] < matrix[j + 1][i]) {
                        isSorted = false;

                        tmp = matrix[j][i];
                        matrix[j][i] = matrix[j + 1][i];
                        matrix[j + 1][i] = tmp;
                    }
                }
            }
        }
        return matrix;
    }

    /*
    task24: Сформировать случайную матрицу m * n, состоящую из нулей и единиц, причем в каждом столбце число
    единиц равно номеру столбца
     */

    static int[][] task24(int m, int n) {
        int count; // счетчик единиц
        int[][] matrix = new int[m][n];
        Random random = new Random();

        for (int j = 0; j < matrix[0].length; j++) {
            count = 0;
            while (count != j) {
                int i = random.nextInt(matrix.length); // случайный индекс строки
                if (matrix[i][j] == 0) {
                    matrix[i][j] = 1;
                    count++;
                }
            }
        }
        return matrix;
    }

    // task25: Найти наибольший элемент матрицы и заменить все нечетные элементы на него

    static int[][] task25(int[][] matrix) {
        int max = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                max = Math.max(max, matrix[i][j]);
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j += 2) {
                matrix[i][j] = max;
            }
        }
        return matrix;
    }

    /*
    task26: Магическим квадратом порядка n называется квадратная матрица размера n * n, составленная из чисел
    1, 2, 3, ..., n^2 так, что суммы по каждому столбцу, каждой строке и каждой из двух большиих диагоналей равны между
    собой. Построить такой квадрат.
     */

    static int[][] task26(int n) {
        int str =  0;
        int column = n / 2;
        int[][] magicSquare = new int[n][n];

        for (int i = 1; i <= Math.pow(n, 2); i++) {
            magicSquare[str][column] = i;
            if (i % n == 0) {
                str++;
            } else {
                str--;
                column++;
                if (str == -1) {
                    str = n - 1;
                }
                if (column == n) {
                    column = 0;
                }
            }
        }
        return magicSquare;
    }

    /*
    task27: Заданы два одномерных массива с различным количеством элементов и натуральное число k. Объединить их
    в один массив, включив второй массив между k - ым и (k + 1) - м элементами первого, при этом не исользуя
    дополнительный массив.
     */

    static int[] task27(int[] firstArray, int[] secondArray, int k) {
        int[] resultArray = new int[firstArray.length + secondArray.length];

        System.arraycopy(firstArray, 0, resultArray, 0, firstArray.length);
        System.arraycopy(firstArray, k, resultArray, resultArray.length - firstArray.length + k, firstArray.length - k);
        System.arraycopy(secondArray, 0, resultArray, k, secondArray.length);

        return resultArray;
    }

    /*
    task28: Даны две последовательности a1 <= a2 <= ... <= an и b1 <= b2 <= ... bm. Образовать из них новую
    последовательность чисел так, чтобы она тоже была неубывающей. Дополнительный массив не использовать
     */

    static int[] task28(int[] firstArray, int[] secondArray) {
        int[] resultArray = new int[firstArray.length + secondArray.length];

        System.arraycopy(firstArray, 0, resultArray, 0, firstArray.length);
        System.arraycopy(secondArray, 0, resultArray, firstArray.length, secondArray.length);
        Arrays.sort(resultArray);

        return resultArray;
    }

    /*
    task29: Написать алгоритм сортировки выбором по убыванию. В массиве, начиная с первого, выбирается наибольший
    элемент и ставится на первое место, а первый - на место наибольшего. Затем, начиная со второго, процедура повторяется
     */

    static int[] task29(int[] array) {
        int tmp;

        for (int i = 0; i < array.length - 1; i++) {
            int max = i;
            for (int j = max + 1; j < array.length; j++) {
                if (array[j] > array[max]) {
                    max = j;
                }
            }
            tmp = array[max];
            array[max] = array[i];
            array[i] = tmp;
        }
        return array;
    }

    /*
    task30: Написать алгоритм сортировки обменами по возрастанию. Для этого сравниваются два соседних числа ai и ai+1.
    Если ai > ai+1, то делается перестановка. Так продолжается до тех пор. пока все элементы не станут расположены в
    порядке возрастания. Подсчитать количество перестановок
     */

    static int[] task30(int[] array) {
        int tmp;
        int countPermutations = 0;
        boolean isSorted = false;

        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    isSorted = false;
                    tmp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = tmp;
                    countPermutations++;
                }
            }
        }
        return array;
    }

    /*
    task31: Написать алгоритм сортировки вставками по возрастанию. Берется следующее число ai+1 и вставляется
    в последовательность так, чтобы новая последовательность была тоже возрастающей. Процесс производится до тех пор,
    пока все элементы от i + 1 до n не будут перебраны. Место помещения очередного элемента в отсортированную часть
    производить с помощью двоичного поиска. Двоичный поиск оформить в виде отдельной функции.
     */

    // Метод для целочисленных значений

    static int binarySearch(int[] sortedArray, int key, int low, int high) {
        int mid;
        if (low == high) {
            return low;
        }
        mid = low + (high - low) / 2;

        if (key > sortedArray[mid]) {
            return binarySearch(sortedArray, key, mid + 1, high);
        } else if (key < sortedArray[mid]) {
            return binarySearch(sortedArray, key, low, mid);
        } else {
            return mid;
        }
    }

    // Метод для значений с плавающей точкой

    static int binarySearch(double[] sortedArray, double key, int low, int high) {
        int mid;
        if (low == high) {
            return low;
        }
        mid = low + (high - low) / 2;

        if (key > sortedArray[mid]) {
            return binarySearch(sortedArray, key, mid + 1, high);
        } else if (key < sortedArray[mid]) {
            return binarySearch(sortedArray, key, low, mid);
        } else {
            return mid;
        }
    }

    static int[] task31(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int element = binarySearch(array, array[i], 0, i);
            if (element < i) {
                int tmp = array[i];
                for (int j = i - 1; j >= element; j--) {
                    array[j + 1] = array[j];
                }
                array[element] = tmp;
            }
        }
        return array;
    }

    /*
    task32: Сортировка Шелла. Дан массив n действительных чисел. Требуется упорядочить его по возрастанию.
    Сравниваются два соседних элемента. Если ai <= ai+1, то продвигаютяся на один элемент вперед. Если ai > ai+1,
    то производится перестановка и сдигаются на один элемент назад.
     */

    static int[] task32(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                swap(array, i, i + 1);
                i -= 2;
            }
            if (i < 0) {
                i++;
            }
        }
        return array;
    }

    // sortingShell: Реализация сортировки Шелла, по определению из интернет-источников

    static int[] sortingShell(int[] array) {
        for (int step = array.length / 2; step > 0; step /= 2) {
            for (int i = step; i < array.length; i++) {
                for (int j = i - step; j >= 0 && array[j] > array[j + step]; j -= step) {
                    swap(array, j, j + step);
                }
            }
        }
        return array;
    }

    /*
    task33: Пусть даны две неубывающие последовательности действительных чисел a1 <= a2 <= ... <= an и b1 <= b2 <=
    <= ... <= bm. Требуется указать те места, на которые нужно вставлять элементы последовательности b1 <= b2 <= ... <=
    <= bm в первую последовательность, так чтобы новая последовательность оставалась возрастающей.
     */

    static ArrayList<Integer> task33(double[] firstSequence, double[] secondSequence) {
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < secondSequence.length; i++) {
            int index = binarySearch(firstSequence, secondSequence[i], 0, firstSequence.length);
            list.add(index);
        }
        return list;
    }
}