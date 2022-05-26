package by.epam.unit_2;

/*
task37: Вычислить площадь правильного шестиугольника со стороной а, используя метод вычисления площади теугольника
 */

public class Task37 {
    public static void main(String[] args) {
        System.out.println(hexagonArea(3));
    }

    static double hexagonArea(int side) {
        return equilateralTriangleArea(side) * 6;
    }

    static double equilateralTriangleArea(int side) {
        return Math.pow(side, 2) * Math.sqrt(3) / 4;
    }
}
