package by.epam.unit_2;

/*
task43: Даны числа X, Y, Z, T - длины сторон четырехугольника. Написать метод (методы) вычисления его площади, если
угол между сторонами длиной X и Y - прямой
 */

public class Task43 {
    public static void main(String[] args) {
        System.out.println(quadrangleArea(4, 4, 4, 4));
    }

    static double quadrangleArea(double x, double y, double z, double t) {
        double firstTriangleArea;
        double secondTriangleArea;
        double resArea;
        double halfPerimeter;
        double hypotenuse;

        hypotenuse = hypotenuse(x, y);
        halfPerimeter = (z + t + hypotenuse) / 2;
        firstTriangleArea = x * y / 2;
        secondTriangleArea = Math.sqrt(halfPerimeter * (halfPerimeter - z) * (halfPerimeter - t) * (halfPerimeter - hypotenuse));
        resArea = firstTriangleArea + secondTriangleArea;

        return resArea;
    }

    static double hypotenuse(double sideA, double sideB) {
        return Math.sqrt(Math.pow(sideA, 2) + Math.pow(sideB, 2));
    }
}
