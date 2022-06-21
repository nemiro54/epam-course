package by.epam.unit_6.task_3.user;

import by.epam.unit_6.task_3.archive.Archive;
import by.epam.unit_6.task_3.archive.Case;

import java.util.List;

public class User {
    private static Archive archive;
    private String name;
    private UserRole userRole;

    public User(String name, UserRole userRole) {
        this.name = name;
        this.userRole = userRole;
    }

    public void addCase(Case aCase) {
        archive.addDeed(aCase);
    }

    public void addCase(String name, String faculty, int course, int yearOfEnrolling) {
        archive.addCase(name, faculty, course, yearOfEnrolling);
    }

    public void removeCase(Case aCase) {
        archive.removeCase(aCase);
    }

    public void removeCase(int numOfDeed) {
        archive.removeCase(numOfDeed);
    }

    public void removeIfNotEnrolled() {
        archive.removeIfNotEnrolled();
    }

    public boolean chooseCase(int numOfDeed) {
        return archive.chooseCase(numOfDeed);
    }

    public void changeFaculty(String faculty) {
        archive.changeFaculty(faculty);
    }

    public boolean incrementCourse() {
        return archive.incrementCourse();
    }

    public void changeCourse(int course) {
        archive.changeCourse(course);
    }

    public List<Case> findCaseByCourse(int course) {
        return archive.findCaseByCourse(course);
    }

    public List<Case> findCaseByFaculty(String faculty) {
        return archive.findCaseByFaculty(faculty);
    }

    public List<Case> findCaseByYear(int year) {
        return archive.findCaseByYear(year);
    }

    public boolean isTutor() {
        return userRole == UserRole.TUTOR;
    }

    public Archive getArchive() {
        return archive;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    @Override
    public String toString() {
        return String.format("%s, %s", name, (isTutor()) ? "Tutor" : "Student");
    }
}
