package by.epam.unit_6.task_3_v1.server;

import by.epam.unit_6.task_1.cryptographer.Password;
import by.epam.unit_6.task_3_v1.archive.Case;
import by.epam.unit_6.task_3_v1.user.User;
import by.epam.unit_6.task_3_v1.user.UserRole;
import by.epam.unit_6.task_3_v1.xml.XmlReader;
import by.epam.unit_6.task_3_v1.xml.XmlWriter;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.InputMismatchException;
import java.util.List;

public class Server {
    private static final String USER_DATABASE_PATH = "src/main/java/by/epam/unit_6/task_3_v1/user/userDatabase.xml";
    private static final String ARCHIVE_PATH = "src/main/java/by/epam/unit_6/task_3_v1/archive/archive.xml";

    private static List<User> users;
    private static List<Case> cases;

    public static void main(String[] args) {
        try {
            users = readUserDatabase();
            cases = readArchive();

            startServer();
        } finally {
            writeUserDatabase(users);
            writeArchive(cases);
        }
    }

    private static void startServer() {
        try (ServerSocket serverSocket = new ServerSocket(8000)) {
            while (true) {
                try (Socket socket = serverSocket.accept();
                     BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                     BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
                    while (socket.isConnected()) {
                        String request = reader.readLine();
                        String response = handler(request);

                        sendRequest(writer, response);
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    private static String handler(String req) {
        String[] request = req.split(";");

        for (int i = 0; i < request.length; i++) {
            request[i] = request[i].trim();
        }

        String response;

        try {
            int choose = Integer.parseInt(request[0]);

            switch (choose) {
                case 0 -> response = isUserExist(request[1], request[2]);
                case 1 -> response = viewCase(request[1]);
                case 2 -> response = changeArchive(request[1], request[2], request[3], request[4]);
                case 3 -> response = addANewCaseToTheArchive(request[1], request[2], request[3]);
                case 4 -> response = addANewUser(request[1], request[2], request[3]);
                default -> response = "INCORRECT REQUEST";
            }
            return response;
        } catch (ArrayIndexOutOfBoundsException | InputMismatchException e) {
            throw new RuntimeException(e);
        }
    }

    private static String isUserExist(String login, String password) {
        return users.stream()
                .filter(user -> user.getLogin().equals(login)
                        && Password.checkPassword(password, user.getPassword()))
                .findFirst()
                .map(user -> "YES" + ";" + user.getUserRole().toString())
                .orElse("NO");
    }

    private static boolean isCaseExist(String name) {
        return cases.stream().anyMatch(aCase -> aCase.getStudentName().equalsIgnoreCase(name));
    }

    private static String viewCase(String studentName) {
        if (cases.size() > 0) {
            return cases.stream().filter(x -> x.getStudentName().equalsIgnoreCase(studentName)).toList().toString();
        } else {
            return "Archive is empty!";
        }
    }

    private static String changeArchive(String oldName, String name, String faculty, String course) {
        for (Case aCase : cases) {
            if (isCaseExist(oldName)) {
                aCase.setStudentName(name);
                aCase.setFaculty(faculty);
                aCase.setCourse(Integer.parseInt(course));
                return "Data updated successfully";
            }
        }
        return "Student not found";
    }

    private static String addANewCaseToTheArchive(String name, String faculty, String course) {
        try {
            cases.add(new Case(name, faculty, Integer.parseInt(course)));
            return "New case added successfully";
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    private static String addANewUser(String name, String password, String userRole) {
        UserRole role = userRole.equalsIgnoreCase("tutor") ? UserRole.TUTOR : UserRole.STUDENT;

        try {
            users.add(new User(name, password, role));
            return "New user added successfully";
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    private static void sendRequest(BufferedWriter writer, String response) throws IOException {
        writer.write(response);
        writer.newLine();
        writer.flush();
    }

    private static List<User> readUserDatabase() {
        return new XmlReader().readUserDatabaseXml(Server.USER_DATABASE_PATH);
    }

    private static void writeUserDatabase(List<User> users) {
        new XmlWriter().writeUserDatabaseXml(users, Server.USER_DATABASE_PATH);
    }

    private static List<Case> readArchive() {
        return new XmlReader().readArchiveXml(Server.ARCHIVE_PATH);
    }

    private static void writeArchive(List<Case> cases) {
        new XmlWriter().writeArchiveXml(cases, Server.ARCHIVE_PATH);
    }
}
