package by.epam.unit_4.task_11;

public class Sentence {
    Word[] words;
    char punctuationMark;

    public Sentence(Word[] words, char punctuationMark) {
        this.words = words;
        this.punctuationMark = punctuationMark;
    }

    public Word[] getWords() {
        return words;
    }

    public void setWords(Word[] words) {
        this.words = words;
    }

    public char getPunctuationMark() {
        return punctuationMark;
    }

    public void setPunctuationMark(char punctuationMark) {
        this.punctuationMark = punctuationMark;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        for (Word word : this.words) {
            stringBuilder.append(word.getWord()).append(" ");
        }

        return stringBuilder.toString().trim() + this.punctuationMark;
    }
}
