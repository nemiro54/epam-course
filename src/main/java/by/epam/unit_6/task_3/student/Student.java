package by.epam.unit_6.task_3.student;

public class Student {
    public static final int TRAINING_PERIOD = 4;

    private String name;
    private String faculty;
    private int course;
    private int yearOfEnrolling;
    private StudentStatus studentStatus;

    public Student() {
    }

    public Student(String name, String faculty, int course, int yearOfEnrolling) {
        setName(name);
        setFaculty(faculty);
        setCourse(course);
        setYearOfEnrolling(yearOfEnrolling);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null && !name.isEmpty()) {
            this.name = name;
        }
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        if (course >= 1 && course <= TRAINING_PERIOD) {
            this.course = course;
        }
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        if (faculty != null && !faculty.isEmpty()) {
            this.faculty = faculty;
        }
    }

    public int getYearOfEnrolling() {
        return yearOfEnrolling;
    }

    public void setYearOfEnrolling(int yearOfEnrolling) {
        this.yearOfEnrolling = yearOfEnrolling;
    }

    public StudentStatus getStudentStatus() {
        return studentStatus;
    }

    public void setStudentStatus(StudentStatus studentStatus) {
        this.studentStatus = studentStatus;
    }

    public boolean incrementCourse() {
        if (course <= TRAINING_PERIOD - 1) {
            course++;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return String.format("%15s %15s %7s %9s %10s",
                name, faculty, course, yearOfEnrolling, studentStatus.toString());
    }
}
