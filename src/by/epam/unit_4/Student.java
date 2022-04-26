package by.epam.unit_4;

/*
task3: Создайте класс с именем Student, содержащий поля: фамилия и инициалы, номер группы, успеваемость (массив из пяти
элементов). Создайте массив из десяти элементов этого типа. Добавьте возможность вывода фамилий и номеров групп студентов,
имеющих оценки, равные только 9 и 10.
 */

import java.util.Arrays;

public class Student {
    String fullName;
    int groupNumber;
    int[] grades = new int[5];

    public Student() {}

    public Student(String fullName, int groupNumber, int[] grades) {
        this.fullName = fullName;
        this.groupNumber = groupNumber;
        this.grades = grades;
    }

    public static void main(String[] args) {
        Student[] students = new Student[10];

        students[0] = new Student("Artemov I.A.", 2, new int[]{7, 9, 9, 6 ,8});
        students[1] = new Student("Shishkin I.I", 1, new int[]{9, 9, 10, 10, 9});
        students[2] = new Student("Pen U.M.", 1, new int[]{9, 10, 9, 9, 10});
        students[3] = new Student("Aivazovsky I.K.", 1, new int[]{10, 10, 9, 9, 9});
        students[4] = new Student("Ivanov I.A.", 3, new int[]{7, 5, 10, 7, 9});
        students[5] = new Student("Grigoriev M.A.", 3, new int[]{4, 9, 7, 6 ,8});
        students[6] = new Student("Sidorov P.G.", 3, new int[]{9, 8, 10, 10, 9});
        students[7] = new Student("Andreev K.V.", 2, new int[]{9, 7, 9, 9, 10});
        students[8] = new Student("Martynov I.K.", 2, new int[]{7, 8, 9, 9, 9});
        students[9] = new Student("Ivanov I.A.", 3, new int[]{7, 5, 10, 7, 9});

        printStudent(students);
    }

    private static void printStudent(Student[] students) {
        for (Student student : students) {
            int[] grades = student.grades;

            if (Arrays.stream(grades).allMatch(x -> x > 8)) {
                System.out.println(student);
            }
        }
    }

    @Override
    public String toString() {
        return this.fullName + ", " + this.groupNumber + " группа";
    }
}
