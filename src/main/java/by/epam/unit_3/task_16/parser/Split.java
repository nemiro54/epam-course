package by.epam.unit_3.task_16.parser;

import java.util.regex.Pattern;

public class Split {
    public static String[] splitSentence(String text) {
        Pattern pattern = Pattern.compile("\\.*[.!?]\\s*"); // делим текст на отдельные предложения
        return pattern.split(text);
    }

    public static String[] splitWords(String sentence) {
        Pattern pattern = Pattern.compile("\\s*(\\s|,|;|:)\\s*"); // делим предложение на отдельные слова
        return pattern.split(sentence);
    }
}
