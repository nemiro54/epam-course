package by.epam.unit_6.task_3.server.archive;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlType;

@XmlType(propOrder = {"firstName", "lastName", "email", "faculty", "course"})
public class Case {
    private String firstName;
    private String lastName;
    private String email;
    private String faculty;
    private int course;

    public Case() {
    }

    public Case(String firstName, String lastName, String email, String faculty, int course) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.faculty = faculty;
        this.course = course;
    }

    @XmlAttribute
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @XmlAttribute
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", faculty='" + faculty + '\'' +
                ", course=" + course +
                '}';
    }
}
