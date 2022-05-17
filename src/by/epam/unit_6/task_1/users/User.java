package by.epam.unit_6.task_1.users;

import by.epam.unit_6.task_1.cryptographer.Password;

import java.io.*;

public class User {
    private String nickName;
    private String eMail;
    private String login;
    private String password;
    private Role role;

    public User(String nickName, String eMail, String login, String password, Role role) {
        this.nickName = nickName;
        this.eMail = eMail;
        this.login = login;
        this.password = Password.getSaltedHash(password);
        this.role = role;
    }

    public void writeUser(String filePath) {
        String stringObj = String.format("nickName=%s&eMail=%s&login=%s&password=%s&role=%s",
                getNickName(), geteMail(), getLogin(), getPassword(), getRole());
        try (BufferedWriter bos = new BufferedWriter(new FileWriter(filePath, true))) {
            bos.write(stringObj + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return String.format("%s, %s", nickName, eMail);
    }
}
