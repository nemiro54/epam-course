package by.epam.unit_3.task_16.composite;

public class Word {
    String word;
    char element;

    public Word(String word , char element) {
        this.word = word;
        this.element = element;
    }

    public int getCount() {
        int count = 0;
        char[] chars = word.toCharArray();

        for (char c : chars) {
            if (c == element) {
                count++;
            }
        }
        return count;
    }

    public String getWordToLowerCase() {
        return word.toLowerCase();
    }

    @Override
    public String toString() {
        return word;
    }
}
