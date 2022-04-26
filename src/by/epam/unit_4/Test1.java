package by.epam.unit_4;

/*
task1: Создайте класс Test1 с двумя переменными. Добавьте метод вывода на экран и методы изменения этих переменных.
Добавьте метод, который находит сумму значений этих переменных и метод, который находит наибольшее значение
из этих двух переменных.
 */

public class Test1 {
    private int first;
    private int second;

    public void printFirst() {
        System.out.println(first);
    }

    public void printSecond() {
        System.out.println(second);
    }

    public void setFirst(int i) {
        first = i;
    }

    public void setSecond(int i) {
        second = i;
    }

    public int sum() {
        return first + second;
    }

    public int max() {
        return Math.max(first, second);
    }
}
