package by.epam.unit_6.task_3_v1.xml;

import by.epam.unit_6.task_3_v1.archive.Archive;
import by.epam.unit_6.task_3_v1.archive.Case;
import by.epam.unit_6.task_3_v1.user.User;
import by.epam.unit_6.task_3_v1.user.UserDatabase;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class XmlReader {
    public List<Case> readArchiveXml(String path) {
        if (new File(path).length() != 0) {
            try {

                JAXBContext context = JAXBContext.newInstance(Archive.class);

                Unmarshaller unmarshaller = context.createUnmarshaller();
                Archive archive = (Archive) unmarshaller.unmarshal(new InputStreamReader(new FileInputStream(path)));

                return archive.getCases();
            } catch (JAXBException | FileNotFoundException e) {
                e.printStackTrace();
                return new ArrayList<>();
            }
        } else {
            return new ArrayList<>();
        }
    }

    public List<User> readUserDatabaseXml(String path) {
        if (new File(path).length() != 0) {
            try {

                JAXBContext context = JAXBContext.newInstance(UserDatabase.class);

                Unmarshaller unmarshaller = context.createUnmarshaller();
                UserDatabase userDatabase = (UserDatabase) unmarshaller.unmarshal(new InputStreamReader(new FileInputStream(path)));

                return userDatabase.getUsers();
            } catch (JAXBException | FileNotFoundException e) {
                e.printStackTrace();
                return new ArrayList<>();
            }
        } else {
            return new ArrayList<>();
        }
    }
}
