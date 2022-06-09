package by.epam.unit_6.task_2.menu;

import by.epam.unit_6.task_2.email.EMail;
import by.epam.unit_6.task_2.notepad.Note;
import by.epam.unit_6.task_2.notepad.NotePad;

import java.time.LocalDate;
import java.util.Scanner;

public abstract class MainMenu {
    private final static String path = "src/main/java/by/epam/unit_6/task_2/notepad/notes.txt";
    private static NotePad notePad;

    public static void startProgram() {
        boolean exit = false;

        notePad = NotePad.loadFile(path);

        while (!exit) {
            System.out.println("""
                    Choose an action (enter a number):
                    1. Add new note;
                    2. Search note;
                    3. Sort notes;
                    4. Print all notes;
                    5. Exit.""");

            int choose = choicePosition(1, 5);

            switch (choose) {
                case 1 -> addNote();
                case 2 -> searchNote();
                case 3 -> sortNotes();
                case 4 -> printNotes();
                case 5 -> exit = true;
            }
        }

        NotePad.saveFile(notePad, path);
    }

    private static Note getNote() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter note topic: ");
        String topic = scanner.nextLine();

        System.out.print("Enter user e-mail: ");
        EMail eMail = new EMail(scanner.nextLine());

        System.out.print("Enter note message: ");
        String message = scanner.nextLine();

        return new Note(topic, eMail, message);
    }

    private static int choicePosition(int min, int max) {
        Scanner scanner = new Scanner(System.in);
        int res = scanner.nextInt();

        if (res < min || res > max) {
            System.out.println("Invalid input! Try again: ");
            return choicePosition(min, max);
        } else {
            return res;
        }
    }

    private static LocalDate getLocalDate() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a year: ");
        int year = scanner.nextInt();
        System.out.print("Enter a month: ");
        int month = scanner.nextInt();
        System.out.print("Enter a day: ");
        int day = scanner.nextInt();

        return LocalDate.of(year, month, day);
    }

    private static EMail getEMail() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter e-mail: ");

        return new EMail(scanner.nextLine());
    }

    private static String getWord() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a word: ");

        return scanner.nextLine();
    }

    private static void addNote() {
        notePad.addNote(getNote());
    }

    private static void searchNote() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("""
                Choose how to search (enter a number):
                1. By word;
                2. By date;
                3. By e-mail;
                4. Word and date;
                5. Word and e-mail;
                6. Exit.""");

        int choose = choicePosition(1, 6);

        switch (choose) {
            case 1 -> notePad.searchNote(getWord());
            case 2 -> notePad.searchNote(getLocalDate());
            case 3 -> notePad.searchNote(getEMail());
            case 4 -> notePad.searchNote(getWord(), getLocalDate());
            case 5 -> notePad.searchNote(getWord(), getEMail());
        }
    }

    private static void sortNotes() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("""
                Choose how to sort (enter a number):
                1. By topic;
                2. By date;
                3. By e-mail;
                4. Exit.""");

        int choose = choicePosition(1, 4);

        switch (choose) {
            case 1 -> notePad.sortNotesByTopic();
            case 2 -> notePad.sortNotesByDate();
            case 3 -> notePad.sortNotesByEmail();
        }
    }

    private static void printNotes() {
        notePad.printNotes();
    }
}
