package by.epam.unit_6.task_2.notepad;

import by.epam.unit_6.task_2.email.EMail;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class NotePad implements Serializable {
    private List<Note> notes = new ArrayList<>();

    public static NotePad loadFile(String path) {
        try (FileInputStream inputStream = new FileInputStream(path);
             ObjectInputStream objectInputStream = new ObjectInputStream(inputStream)) {
            return (NotePad) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void saveFile(NotePad notePad, String path) {
        try (FileOutputStream outputStream = new FileOutputStream(path);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream)) {
            objectOutputStream.writeObject(notePad);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addNote(Note note) {
        notes.add(note);
    }

    public void searchNote(Topic topic) {
        for (Note note : notes) {
            if (note.getTopic().equals(topic)) {
                System.out.println(note);
            }
        }
    }
}
