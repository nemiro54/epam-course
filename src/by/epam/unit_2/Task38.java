package by.epam.unit_2;

/*
task38: На плоскости заданы своими координатами n точек. Написать метод (методы), определяющие, между какими из пар
точек самое большое расстояние. Координаты точек занести в массив
 */

import java.util.ArrayList;
import java.util.Arrays;

public class Task38 {
    public static void main(String[] args) {
        int[][] resCoordinates = maxDistance(new ArrayList<>(){{
            add(new Point(1, 4));
            add(new Point(5, 0));
            add(new Point(2, 2));
            add(new Point(14, 2));
        }});

        for (int[] coordinates : resCoordinates) {
            System.out.println(Arrays.toString(coordinates));
        }
    }

    static double findDistance(Point point1, Point point2) {
        return Math.sqrt(Math.pow(point2.getX() - point1.getX(), 2) + Math.pow(point2.getY() - point1.getY(), 2));
    }

    static int[][] maxDistance(ArrayList<Point> points) {
        double maxDistance = 0;
        double thisDistance;
        ArrayList<Point> pairPoints = new ArrayList<>(2);

        for (int i = 0; i < points.size() - 1; i++) {
            for (int j = 1; j < points.size(); j++) {
                thisDistance = findDistance(points.get(i), points.get(j));
                if (thisDistance > maxDistance) {
                    maxDistance = thisDistance;
                    pairPoints.clear();
                    pairPoints.add(points.get(i));
                    pairPoints.add(points.get(j));
                }
            }
        }
        int[][] resCoordinates = new int[2][2];
        resCoordinates[0][0] = pairPoints.get(0).getX();
        resCoordinates[0][1] = pairPoints.get(0).getY();
        resCoordinates[1][0] = pairPoints.get(1).getX();
        resCoordinates[1][1] = pairPoints.get(1).getY();

        return resCoordinates;
    }
}

class Point {
    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}