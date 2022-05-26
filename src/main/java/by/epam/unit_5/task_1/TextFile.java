package by.epam.unit_5.task_1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class TextFile {
    private MyFile myFile;
    private String text;

    public TextFile(MyFile myFile, String text) {
        this.myFile = myFile;
        this.text = text;
        create();
    }

    private void create() {
        try {
            Files.writeString(myFile.getPath(), text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void rename(String newName) {
        Path source = myFile.getPath();
        try {
            Files.move(source, source.resolveSibling(newName + "." + myFile.getFormat()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void printText() {
        try {
            List<String> strings = Files.readAllLines(myFile.getPath());
            strings.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addText(String text) {
        try {
            this.text = getText() + text;
            Files.writeString(myFile.getPath(), this.text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deleteText() {
        try {
            Files.writeString(myFile.getPath(), "");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public MyFile getMyFile() {
        return myFile;
    }

    public void setMyFile(MyFile myFile) {
        this.myFile = myFile;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
