package by.epam.unit_3.task_16.reader;

import by.epam.unit_3.task_16.exceptions.IncorrectInputFileException;
import java.io.*;

public class ReadStringFromFile {

    public static String read(File file) throws IncorrectInputFileException {
        String text;
        byte[] bytes;

        if (file == null || !file.exists() || file.length() == 0) {
            throw new IncorrectInputFileException("Something was wrong. Incorrect file.");
        }

        try(FileInputStream fileInputStream = new FileInputStream(file.getPath())) {
            bytes = fileInputStream.readAllBytes();
            text = new String(bytes);

            return text;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}

