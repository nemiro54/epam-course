package by.epam.unit_4.task_11;

import java.util.Arrays;

public class Text {
    private String titles;
    private Sentence[] sentences;

    public Text(Sentence[] sentences) {
        this.sentences = sentences;
    }

    public Text(String titles, Sentence[] sentences) {
        this.titles = titles;
        this.sentences = sentences;
    }

    public Sentence[] addSentence(Sentence... sentenceAdd) {
        Sentence[] newText = Arrays.copyOf(this.sentences, this.sentences.length + sentenceAdd.length);
        System.arraycopy(sentenceAdd, 0, newText, this.sentences.length, sentenceAdd.length);

        this.sentences = newText;

        return this.sentences;
    }

    public void print() {
        StringBuilder stringBuilder = new StringBuilder();

        for (Sentence sentence : sentences) {
            System.out.println(sentence);
        }
    }

    public void printTitle() {
        System.out.println("Title: " + titles);
    }
}
