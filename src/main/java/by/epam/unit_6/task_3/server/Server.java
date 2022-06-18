package by.epam.unit_6.task_3.server;

import by.epam.unit_6.task_3.server.archive.Archive;
import by.epam.unit_6.task_3.server.archive.Case;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

public class Server {
    public static void main(String[] args) {
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

    static class XmlWriter {
        private static final String ARCHIVE_PATH = "src/main/java/by/epam/unit_6/task_3/server/archive/cases.xml";

        private void writeXml(List<Case> cases) {
            Archive archive = new Archive(cases);

            try {
                JAXBContext context = JAXBContext.newInstance(Archive.class);

                Marshaller marshaller = context.createMarshaller();
                marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
                marshaller.marshal(archive, new File(ARCHIVE_PATH));
            } catch (JAXBException e) {
                e.printStackTrace();
            }
        }
    }

    static class XmlReader {
        private static final String ARCHIVE_PATH = "src/main/java/by/epam/unit_6/task_3/server/archive/cases.xml";

        private List<Case> readXml() {
            try {
                JAXBContext context = JAXBContext.newInstance(Archive.class);

                Unmarshaller unmarshaller = context.createUnmarshaller();
                Archive archive = (Archive) unmarshaller.unmarshal(new InputStreamReader(new FileInputStream(ARCHIVE_PATH)));

                return archive.getCases();
            } catch (JAXBException | FileNotFoundException e) {
                e.printStackTrace();
                return null;
            }
        }
    }
}
