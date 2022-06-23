package by.epam.unit_6.task_3_v1.server;

import by.epam.unit_6.task_3_v1.archive.Case;
import by.epam.unit_6.task_3_v1.user.User;
import by.epam.unit_6.task_3_v1.xml.XmlReader;
import by.epam.unit_6.task_3_v1.xml.XmlWriter;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

public class Server {
    private static final String USER_DATABASE_PATH = "src/main/java/by/epam/unit_6/task_3_v1/user/userDatabase.xml";
    private static final String ARCHIVE_PATH = "src/main/java/by/epam/unit_6/task_3_v1/archive/archive.xml";
    private static List<User> users;
    private static List<Case> archive;

    public static void main(String[] args) {
        try {
            users = readUserDatabase();
            archive = readArchive();

            startServer();
        } finally {
            writeUserDatabase(users);
            writeArchive(archive);
        }
    }

    private static void startServer() {
        try (ServerSocket serverSocket = new ServerSocket(8000)) {
            while (true) {
                try (Socket socket = serverSocket.accept();
                     BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                     BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
                    String request = reader.readLine();
                    String response = handler(request);

                    writer.write(response);
                    writer.newLine();
                    writer.flush();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
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
                case 1 -> response = viewArchive();
                default -> response = "INCORRECT REQUEST";
            }
            return response;
        } catch (ArrayIndexOutOfBoundsException | InputMismatchException e) {
            throw new RuntimeException(e);
        }
    }

    private static String isUserExist(String login, String password) {
        for (User user : users) {
            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                return "YES" + ";" + user.getUserRole().toString();
            }
        }
        return "NO";
    }

    private static String viewArchive() {
        StringBuilder stringBuilder = new StringBuilder();

        for (Case aCase : archive) {
            stringBuilder.append(aCase).append("\n");
        }
        return stringBuilder.toString();
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
