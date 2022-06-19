package by.epam.unit_6.task_3.user;

public class User {
    private String name;
    private UserRole userRole;

    public User(String name, UserRole userRole) {
        this.name = name;
        this.userRole = userRole;
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
}
