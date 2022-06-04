package by.epam.unit_6.task_2.notepad;

import by.epam.unit_6.task_2.email.EMail;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

public class Note implements Serializable {
    @Serial
    private static final long serialVersionUID = -1618472200206113548L;
    private Topic topic;
    private LocalDate localDate;
    private EMail eMail;
    private Message message;

    public Note(Topic topic, EMail eMail, Message message) {
        this.topic = topic;
        this.eMail = eMail;
        this.message = message;
        this.localDate = LocalDate.now();
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public LocalDate getDate() {
        return localDate;
    }

    public void setDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    public EMail getEMail() {
        return eMail;
    }

    public void setEMail(EMail eMail) {
        this.eMail = eMail;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
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
