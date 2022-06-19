package by.epam.unit_6.task_3.server.archive;

import by.epam.unit_6.task_3.server.Student.Student;
import by.epam.unit_6.task_3.server.Student.StudentStatus;

import java.util.Calendar;

public class Case {
    private Student student;
    private static int counter = 0;
    private final int numOfCase = ++counter;
    private final Calendar dateOfCreating = Calendar.getInstance();

    public Case(String name, String faculty, int course, int yearOfEnrolling) {
        student = new Student(name, faculty, course, yearOfEnrolling);
        if (course > Student.TRAINING_PERIOD) {
            student.setStudentStatus(StudentStatus.GRADUATED);
        }
    }

    public void changeFaculty(String faculty) {
        if (student.getStudentStatus() == StudentStatus.ENROLLED) {
            student.setFaculty(faculty);
        } else {
            System.out.println("This student is graduated or expelled!");
        }
    }

    public boolean incrementCourse() {
        if (student.getStudentStatus() == StudentStatus.ENROLLED) {
            if (!student.incrementCourse()) {
                student.setStudentStatus(StudentStatus.GRADUATED);
                return false;
            } else {
                return true;
            }
        } else {
            System.out.println("This student is graduated or expelled! ");
            return false;
        }
    }

    public void changeCourse(int course) {
        if (student.getStudentStatus() == StudentStatus.ENROLLED) {
            student.setCourse(course);
        } else {
            System.out.println("This student is graduated or expelled!");
        }
    }

    public String getName() {
        return student.getName();
    }

    public String getFaculty() {
        return student.getFaculty();
    }

    public int getNumOfCase() {
        return numOfCase;
    }

    public int getCourse() {
        return student.getCourse();
    }

    public int getYearOfEnrolling() {
        return student.getYearOfEnrolling();
    }

    public StudentStatus getStudentStatus() {
        return student.getStudentStatus();
    }

    public void deduct() {
        if (student.getStudentStatus() == StudentStatus.ENROLLED) {
            student.setStudentStatus(StudentStatus.DEDUCTED);
        } else {
            System.out.println("This student is graduated or expelled!");
        }
    }

    public void graduate() {
        if (student.getStudentStatus() == StudentStatus.ENROLLED) {
            student.setStudentStatus(StudentStatus.GRADUATED);
        } else {
            System.out.println("This student is graduated or expelled!");
        }
    }

    public void enroll() {
        if (student.getStudentStatus() != StudentStatus.ENROLLED) {
            student.setStudentStatus(StudentStatus.ENROLLED);
        } else {
            System.out.println("This student is already enrolled!");
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Created ").append(dateOfCreating.getTime()).append("\n");
        stringBuilder.append("Matter #").append(student.getName()).append("\n");
        stringBuilder.append("Faculty - ").append(student.getFaculty()).append("\n");
        if (student.getStudentStatus() == StudentStatus.ENROLLED) {
            stringBuilder.append("Course - ").append(student.getCourse()).append("\n");
        }
        stringBuilder.append("Year of enrollment - ").append(student.getYearOfEnrolling()).append("\n");
        stringBuilder.append("Status - ").append(student.getStudentStatus()).append("\n");

        return stringBuilder.toString();
    }
}
