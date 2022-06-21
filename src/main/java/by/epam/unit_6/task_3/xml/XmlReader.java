package by.epam.unit_6.task_3.xml;

import by.epam.unit_6.task_3.archive.Archive;
import by.epam.unit_6.task_3.archive.Case;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.List;

public class XmlReader {
    public List<Case> readXml(String path) {
        if (new File(path).length() != 0) {
            try {

                JAXBContext context = JAXBContext.newInstance(Archive.class);

                Unmarshaller unmarshaller = context.createUnmarshaller();
                Archive archive = (Archive) unmarshaller.unmarshal(new InputStreamReader(new FileInputStream(path)));

                return archive.getArchive();
            } catch (JAXBException | FileNotFoundException e) {
                e.printStackTrace();
                return null;
            }
        } else {
            return null;
        }
    }
}
