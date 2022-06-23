package by.epam.unit_6.task_3.user;

import by.epam.unit_6.task_1.cryptographer.Password;
import by.epam.unit_6.task_3.archive.Archive;
import by.epam.unit_6.task_3.archive.Case;

import java.util.List;

public class User {
    private static Archive archive;
    private String login;
    private String password;
    private UserRole userRole;

    public User(String login, String password, UserRole userRole) {
        this.login = login;
        setPassword(password);
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

    public static void setArchive(Archive archive) {
        User.archive = archive;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = Password.getSaltedHash(password);
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    @Override
    public String toString() {
        return String.format("%s, %s", login, (isTutor()) ? "Tutor" : "Student");
    }
}
