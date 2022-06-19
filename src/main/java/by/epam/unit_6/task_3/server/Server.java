package by.epam.unit_6.task_3.server;

import by.epam.unit_6.task_3.server.archive.Case;
import by.epam.unit_6.task_3.server.xml.XmlReader;

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
                    String response = parseAndHandleRequest(request);

                    write(writer, response);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String parseAndHandleRequest(String request) {
        String[] dataRequest = request.split(";");

        if ("show case".equals(dataRequest[0])) {
            return showCase(dataRequest[1], dataRequest[2]);
        } else if ("change case".equals(dataRequest[0])) {
            return changeCase();
        } else if ("add new case".equals(dataRequest[0])) {
            return "add new case";
        } else {
            return "0";
        }
    }

    private static String showCase(String firsName, String lastName) {
        StringBuilder stringCases = new StringBuilder();

        for (Case aCase : cases) {
            if (aCase.getFirstName().equalsIgnoreCase(firsName)
                    && aCase.getLastName().equalsIgnoreCase(lastName)) {
                stringCases.append(aCase).append("\n");
            }
        }

        return stringCases.toString();
    }

    private static String changeCase() {
        System.out.println("change case");
        return "";
    }

    private static void addNewCase() {
        System.out.println("add new case");
    }

    private static void write(BufferedWriter writer, String response) {
        try {
            writer.write(response);
            writer.newLine();
            writer.flush();
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
