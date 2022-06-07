package by.epam.unit_6.task_2.notepad;

import by.epam.unit_6.task_2.email.EMail;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

public class Note implements Serializable {
    @Serial
    private static final long serialVersionUID = -1618472200206113548L;
    private String topic;
    private LocalDate localDate;
    private EMail eMail;
    private String message;

    public Note(String topic, EMail eMail, String message) {
        this.topic = topic;
        this.eMail = eMail;
        this.message = message;
        this.localDate = LocalDate.now();
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    public EMail getEMail() {
        return eMail;
    }

    public void setEMail(EMail eMail) {
        this.eMail = eMail;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Note{" +
                "topic='" + topic + '\'' +
                ", localDate=" + localDate +
                ", eMail=" + eMail +
                ", message='" + message + '\'' +
                '}';
    }
}
