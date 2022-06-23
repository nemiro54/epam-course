package by.epam.unit_6.task_3_v1.archive;

import jakarta.xml.bind.annotation.XmlType;

@XmlType(propOrder = {"studentName", "faculty", "course"})
public class Case {
    private String studentName;
    private String faculty;
    private int course;

    public Case() {
    }

    public Case(String studentName, String faculty, int course) {
        this.studentName = studentName;
        this.faculty = faculty;
        this.course = course;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Case{" +
                "studentName='" + studentName + '\'' +
                ", faculty='" + faculty + '\'' +
                ", course=" + course +
                '}';
    }
}
