package by.epam.unit_2;

/*
task34: Даны дроби (pi, qi - натуральные). Составить программу, которая приводит эти дроби к общему знаменателю
и упорядочивает их в порядке возрастания
 */

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Task34 {
    public static void main(String[] args) {
        List<Fraction> fractions = new ArrayList<>(){{
            add(new Fraction(2, 8));
            add(new Fraction(3, 6));
            add(new Fraction(3));
            add(new Fraction(5, -10));
            add(new Fraction(11, 18));
            add(new Fraction(9, 2));
        }};

        for (Fraction fraction : fractions) {
            System.out.printf("%d/%d; ", fraction.getNumerator(), fraction.getDenominator());
        }

        System.out.println();

        for (Fraction fraction : Fraction.sortFraction(fractions)) {
            System.out.printf("%d/%d; ", fraction.getNumerator(), fraction.getDenominator());
        }
    }
}

class Fraction {
    private final int numerator;
    private final int denominator;

    public Fraction(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Denominator cannot be zero");
        }
        if (denominator < 0) {
            numerator *= -1;
            denominator *= -1;
        }
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public Fraction(int numerator) {
        this.numerator = numerator;
        this.denominator = 1;
    }

    public int getNumerator() {
        return this.numerator;
    }

    public int getDenominator() {
        return this.denominator;
    }

    public static List<Fraction> sortFraction(List<Fraction> fractions) {
        int lcmOfFractions;
        int numerator;
        int denominator;
        int factor;
        List<Fraction> resFractions = new ArrayList();

        lcmOfFractions = LeastCommonMultiply.lcmOfSeveralNumbers(fractions);

        for (Fraction fraction : fractions) {
            factor = lcmOfFractions / fraction.getDenominator();
            numerator = fraction.getNumerator() * factor;
            denominator = fraction.getDenominator() * factor;
            resFractions.add(new Fraction(numerator, denominator));
        }

        resFractions.sort((Comparator.comparingInt(Fraction::getNumerator)));

        return resFractions;
    }
}

class GreaterCommonDivisor {
    // НОД двух чисел
    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}

class LeastCommonMultiply {
    // НОК двух чисел
    public static int lcm(int a, int b) {
        return a / GreaterCommonDivisor.gcd(a, b) * b;
    }

    // НОК 3-х и более чисел
    public static int lcmOfSeveralNumbers(List<Fraction> fractions) {
        int result = 0;
        List<Integer> lcmList = new ArrayList<>();

        int firstLcm = lcm(fractions.get(0).getDenominator(), fractions.get(1).getDenominator());
        lcmList.add(firstLcm);

        for (int i = 0; i < fractions.size() - 1; i++) {
            lcmList.add(lcm(lcmList.get(i), fractions.get(i + 1).getDenominator()));
        }

        for (int i = 0; i < lcmList.size() - 1; i++) {
            result = Math.max(lcmList.get(i), lcmList.get(i + 1));
        }
        return result;
    }
}