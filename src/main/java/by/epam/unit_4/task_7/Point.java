package by.epam.unit_4.task_7;

public class Point {
    private final double x;
    private final double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    // метод вычисления расстояния между точками
    public double sideLength(Point point) {
        return Math.sqrt(Math.pow(point.getX() - x, 2) + Math.pow(point.getY() - y, 2));
    }

    @Override
    public String toString() {
        return String.format("X: %.2f; Y: %.2f", x, y);
    }
}
