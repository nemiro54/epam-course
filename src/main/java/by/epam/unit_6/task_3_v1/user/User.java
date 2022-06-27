package by.epam.unit_6.task_3_v1.user;

import by.epam.unit_6.task_1.cryptographer.Password;
import jakarta.xml.bind.annotation.XmlType;

@XmlType(propOrder = {"login", "password", "userRole"})
public class User {
    private String login;
    private String password;
    private UserRole userRole;

    public User() {
    }

    public User(String login, String password, UserRole userRole) {
        this.login = login;
        this.password = password;
        this.userRole = userRole;
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
        return "User{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", userRole=" + userRole +
                '}';
    }
}
