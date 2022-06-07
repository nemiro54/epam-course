package by.epam.unit_6.task_2.menu;

import by.epam.unit_6.task_2.email.EMail;
import by.epam.unit_6.task_2.notepad.Note;
import by.epam.unit_6.task_2.notepad.NotePad;

public class MainMenu {
    private final static String path = "src/main/java/by/epam/unit_6/task_2/notepad/notes.txt";
    private static NotePad notePad;

    public static void startProgram() {
        notePad = NotePad.loadFile(path);

        NotePad.saveFile(notePad, path);
    }
}
