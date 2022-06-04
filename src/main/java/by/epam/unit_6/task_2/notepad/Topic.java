package by.epam.unit_6.task_2.notepad;

import java.io.Serial;
import java.io.Serializable;

public class Topic implements Serializable {
    @Serial
    private static final long serialVersionUID = 4038465086183605049L;
    private String topic;

    public Topic(String topic) {
        this.topic = topic;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    @Override
    public String toString() {
        return topic;
    }
}
