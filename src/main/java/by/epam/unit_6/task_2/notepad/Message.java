package by.epam.unit_6.task_2.notepad;

import java.io.Serial;
import java.io.Serializable;

public class Message implements Serializable {
    @Serial
    private static final long serialVersionUID = 8906179987092376108L;
    private String message;

    public Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
