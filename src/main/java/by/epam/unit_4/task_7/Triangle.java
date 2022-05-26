package by.epam.unit_4.task_7;

import static java.lang.Math.*;

public class Triangle {
    private Point pointA;
    private Point pointB;
    private Point pointC;

    private double sideA;
    private double sideB;
    private double sideC;

    private Triangle(Point pointA, Point pointB, Point pointC) throws IncorrectTriangleException {
        checkPoints(pointA, pointB, pointC);

        this.pointA = pointA;
        this.pointB = pointB;
        this.pointC = pointC;
    }

    // метод создания объекта "треугольник"
    public static Triangle create(Point pointA, Point pointB, Point pointC) throws IncorrectTriangleException {
        return new Triangle(pointA, pointB, pointC);
    }

    // проверка возможности существования треугольника
    private void checkPoints(Point pointA, Point pointB, Point pointC) throws IncorrectTriangleException {
        if (pointA == null || pointB == null || pointC == null) {
            throw new IncorrectTriangleException("Point not may be null");
        }

        sideA = pointA.sideLength(pointB);
        sideB = pointB.sideLength(pointC);
        sideC = pointA.sideLength(pointC);

        if ((sideA + sideB) <= sideC || (sideB + sideC) <= sideA || (sideA + sideC) <= sideB) {
            throw new IncorrectTriangleException("Incorrect triangle points");
        }
    }

    public double calcArea() {
        double halfPerimeter = (sideA + sideB + sideC) / 2;
        return sqrt(halfPerimeter * (halfPerimeter - sideA) * (halfPerimeter - sideB) * (halfPerimeter - sideC));
    }

    public double calcPerimeter() {
        return sideA + sideB + sideC;
    }

    public Point calcMedian(){
        double medianX = (pointA.getX() + pointB.getX() + pointC.getX()) / 3;
        double medianY = (pointA.getY() + pointB.getY() + pointC.getY()) / 3;

        return new Point(medianX, medianY);
    }

    @Override
    public String toString() {
        return String.format("Triangle sides: a - %.2f; b - %.2f; c - %.2f;", sideA, sideB, sideC);
    }
}
