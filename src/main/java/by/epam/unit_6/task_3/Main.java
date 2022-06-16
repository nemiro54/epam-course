package by.epam.unit_6.task_3;

/*
unit_6.task_3: Создайте клиент-серверное приложение "Архив".

Общие требования к заданию:
- В архиве хранятся Дела (например, студентов). Архив находится на сервере.
- Клиент, в зависимости от прав, может запросить дело на просмотр, внести в него изменения, или создать новое дело.

Требования к коду лабораторной работы:
- Для реализации сетевого соединения используйте сокеты.
- Формат хранения данных на сервере - xml-файлы.
 */

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class Main {
    public static void main(String[] args) {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;

        try {
            builder = factory.newDocumentBuilder();

            Document document = builder.newDocument();

//            root element
            Element root = document.createElement("students");
            document.appendChild(root);

//            student element
            Element student = document.createElement("student");
            root.appendChild(student);

//            set an attribute to student
            Attr attr = document.createAttribute("name");
            attr.setValue("Sasha");
            student.setAttributeNode(attr);

//            one more way
//            student.setAttribute("name", "Masha");

//            faculty element
            Element faculty = document.createElement("faculty");
            faculty.appendChild(document.createTextNode("history"));
            student.appendChild(faculty);

//            email element
            Element email = document.createElement("email");
            email.appendChild(document.createTextNode("example@gmail.com"));
            student.appendChild(email);

//            course element
            Element course = document.createElement("course");
            course.appendChild(document.createTextNode("3"));
            student.appendChild(course);

//            transform the DOM object to an XML file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource domSource = new DOMSource(document);
            StreamResult streamResult = new StreamResult(new File("src/main/java/by/epam/unit_6/task_3/xml/file.xml"));
            transformer.transform(domSource, streamResult);
        } catch (ParserConfigurationException | TransformerException e) {
            e.printStackTrace();
        }
    }
}

