package by.epam.unit_2;

/*
task45: Написать метод (методы), определяющий, в каком из данных двух чисел больше цифр
 */

public class Task45 {
    public static void main(String[] args) {
        System.out.println(moreNumbers(12451, 28576));
    }

    static int moreNumbers(int a, int b) {
        char[] number1 = Integer.toString(a).toCharArray();
        char[] number2 = Integer.toString(b).toCharArray();
        int resultNumber;

        resultNumber = number1.length > number2.length ? a : b;

        return resultNumber;
    }
}
