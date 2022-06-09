package by.epam.unit_6.task_2.notepad;

import by.epam.unit_6.task_2.email.EMail;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
            try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(path))) {
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

    public void searchNote(String word) {
        Pattern pattern = Pattern.compile(word.toLowerCase());
        Matcher matcherTopic;
        Matcher matcherMessage;

        for (Note note : notes) {
            matcherTopic = pattern.matcher(note.getTopic().toLowerCase());
            matcherMessage = pattern.matcher(note.getMessage().toLowerCase());

            if (matcherTopic.matches() || matcherMessage.matches()) {
                System.out.println(note);
            }
        }
    }

    public void searchNote(LocalDate localDate) {
        Pattern pattern = Pattern.compile(localDate.toString());
        Matcher matcher;

        for (Note note : notes) {
            matcher = pattern.matcher(note.getLocalDate().toString());

            if (matcher.matches()) {
                System.out.println(note);
            }
        }
    }

    public void searchNote(EMail eMail) {
        Pattern pattern = Pattern.compile(eMail.toString());
        Matcher matcher;

        for (Note note : notes) {
            matcher = pattern.matcher(note.getEMail().toString());

            if (matcher.matches()) {
                System.out.println(note);
            }
        }
    }

    public void searchNote(String word, LocalDate localDate) {
        Pattern patternWord = Pattern.compile(word.toLowerCase());
        Pattern patternLocalDate = Pattern.compile(localDate.toString());
        Matcher matcherTopic;
        Matcher matcherMessage;
        Matcher matcherLocalDate;

        for (Note note : notes) {
            matcherTopic = patternWord.matcher(note.getTopic().toLowerCase());
            matcherMessage = patternWord.matcher(note.getMessage().toLowerCase());
            matcherLocalDate = patternLocalDate.matcher(note.getLocalDate().toString());

            if ((matcherTopic.matches() || matcherMessage.matches()) && matcherLocalDate.matches()) {
                System.out.println(note);
            }
        }
    }

    public void searchNote(String word, EMail eMail) {
        Pattern patternWord = Pattern.compile(word.toLowerCase());
        Pattern patternEmail = Pattern.compile(eMail.toString().toLowerCase());
        Matcher matcherTopic;
        Matcher matcherMessage;
        Matcher matcherEmail;

        for (Note note : notes) {
            matcherTopic = patternWord.matcher(note.getTopic().toLowerCase());
            matcherMessage = patternWord.matcher(note.getMessage().toLowerCase());
            matcherEmail = patternEmail.matcher(note.getEMail().toString().toLowerCase());

            if ((matcherTopic.matches() || matcherMessage.matches()) && matcherEmail.matches()) {
                System.out.println(note);
            }
        }
    }

    public void sortNotesByTopic() {
        notes.stream()
                .sorted(Comparator.comparing(x -> x.getTopic().toLowerCase()))
                .forEach(System.out::println);
    }

    public void sortNotesByDate() {
        notes.stream()
                .sorted(Comparator.comparing(Note::getLocalDate))
                .forEach(System.out::println);
    }

    public void sortNotesByEmail() {
        notes.stream()
                .sorted(Comparator.comparing(x -> x.getEMail().toString().toLowerCase()))
                .forEach(System.out::println);
    }

    public void printNotes() {
        notes.forEach(System.out::println);
    }
}
