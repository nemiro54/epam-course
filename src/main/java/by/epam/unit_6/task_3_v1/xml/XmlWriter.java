package by.epam.unit_6.task_3_v1.xml;

import by.epam.unit_6.task_3_v1.archive.Archive;
import by.epam.unit_6.task_3_v1.archive.Case;
import by.epam.unit_6.task_3_v1.user.User;
import by.epam.unit_6.task_3_v1.user.UserDatabase;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

import java.io.File;
import java.util.List;

public class XmlWriter {
    public void writeArchiveXml(List<Case> cases, String path) {
        Archive archive = new Archive(cases);

        try {
            JAXBContext context = JAXBContext.newInstance(Archive.class);

            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(archive, new File(path));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public void writeUserDatabaseXml(List<User> users, String path) {
        UserDatabase userDatabase = new UserDatabase(users);

        try {
            JAXBContext context = JAXBContext.newInstance(UserDatabase.class);

            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(userDatabase, new File(path));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
