package by.epam.unit_6.task_3.server;

import by.epam.unit_6.task_3.server.archive.Case;
import by.epam.unit_6.task_3.server.xml.XmlReader;
import by.epam.unit_6.task_3.user.User;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {
    private static final String ARCHIVE_PATH = "src/main/java/by/epam/unit_6/task_3/server/archive/cases.xml";
    private static List<Case> cases = new ArrayList<>();

    public static void main(String[] args) {
        cases = new XmlReader().readXml(ARCHIVE_PATH);

        startServer();
    }

    private static void startServer() {
        try (ServerSocket serverSocket = new ServerSocket(8000)) {
            while (true) {
                try (Socket socket = serverSocket.accept();
                     BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                     BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
                    String request = reader.readLine();
                    String response = new StringBuffer(request).reverse().toString();

                    writer.write(response);
                    writer.newLine();
                    writer.flush();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Case> getCases() {
        return cases;
    }

    public static void setCases(List<Case> users) {
        Server.cases = users;
    }
}
