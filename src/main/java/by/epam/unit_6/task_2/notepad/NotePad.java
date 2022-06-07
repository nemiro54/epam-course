package by.epam.unit_6.task_2.notepad;

import by.epam.unit_6.task_2.email.EMail;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class NotePad implements Serializable {
    @Serial
    private static final long serialVersionUID = 7648686049343133630L;
    private List<Note> notes = new ArrayList<>();
    private static File file;

    public static NotePad loadFile(String path) {
        file = new File(path);

        if (file.exists() && file.canRead() && file.length() != 0) {
            try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(path))) {
                return (NotePad) objectInputStream.readObject();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
                return new NotePad();
            }
        } else {
            return new NotePad();
        }
    }

    public static void saveFile(NotePad notePad, String path) {
        if (file.canWrite()) {
            try (FileOutputStream outputStream = new FileOutputStream(path);
                 ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream)) {
                objectOutputStream.writeObject(notePad);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("File not saved");
        }
    }

    public void addNote(Note note) {
        notes.add(note);
    }

    public void addNote(List<Note> notes) {
        this.notes.addAll(notes);
    }

    public void searchNote(String word) {
        if (!word.equals("")) {
            notes.stream()
                    .filter(x -> x.getTopic().toLowerCase().contains(word)
                            || x.getMessage().toLowerCase().contains(word))
                    .forEach(System.out::println);
        }
    }

    public void searchNote(LocalDate localDate) {
        notes.stream()
                .filter(x -> x.getLocalDate().equals(localDate))
                .forEach(System.out::println);
    }

    public void searchNote(EMail eMail) {
        notes.stream()
                .filter(x -> x.getEMail().equals(eMail))
                .forEach(System.out::println);
    }

    public void searchNote(String word, LocalDate localDate) {
        if (!word.equals("")) {
            notes.stream()
                    .filter(x -> x.getLocalDate().equals(localDate))
                    .filter(x -> x.getTopic().toLowerCase().contains(word)
                            || x.getMessage().toLowerCase().contains(word))
                    .forEach(System.out::println);
        }
    }

    public void searchNote(String word, EMail eMail) {
        if (!word.equals("")) {
            notes.stream()
                    .filter(x -> x.getEMail().equals(eMail))
                    .filter(x -> x.getTopic().toLowerCase().contains(word)
                            || x.getMessage().toLowerCase().contains(word))
                    .forEach(System.out::println);
        }
    }

    public void printNotes() {
        notes.forEach(System.out::println);
    }
}
