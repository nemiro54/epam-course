package by.epam.unit_1;

public class Main {

    public static void main(String[] args) {
        task01();
        task02();
        task03();
    }

    // найдите значение функции: z = ((a - 3) * b / 2) + c
    public static void task01() {
        double a = 2;
        double b = -8;
        double c = 12.4;

        double result = (a - 3) * b / 2 + c;
        System.out.println(String.format("The result task01 is: %f", result));
    }

    // вычислите значение выражения по формуле (все переменные принимают действительные значения):
    // (b + √(b^2 + 4ac) / 2a - a^3 * c - b^(-2)
    public static void task02() {
        double a = 4;
        double b = -5.4;
        double c = 10;

        double result = ((b + Math.sqrt(Math.pow(b, 2) + 4 * a * c)) / (2 * a) - Math.pow(a, 3) * c - Math.pow(b, -2));
        System.out.println(String.format("The result task02 is: %f", result));
    }

    // вычислить значение выражения по формуле (все переменные принимают действительные значения):
    // (sin x + cos y) / (cos x - sin y) * tg xy
    public static void task03() {
        double radX = Math.toRadians(30);
        double radY = Math.toRadians(60);

        double result = ((Math.sin(radX) + Math.cos(radY)) / Math.cos(radX) - Math.sin(radY)) * Math.tan(radX * radY);
        System.out.println(String.format("The result task03 is: %f", result));
    }
}
