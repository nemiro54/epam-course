package by.epam.unit_6.task_3.xml;

import by.epam.unit_6.task_3.archive.Archive;
import by.epam.unit_6.task_3.archive.Case;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

import java.io.File;
import java.util.List;

public class XmlWriter {
    public void writeXml(List<Case> cases, String path) {
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
}
