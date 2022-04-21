package by.epam.unit_3.task_16.sorter;

import by.epam.unit_3.task_16.composite.Word;
import by.epam.unit_3.task_16.parser.Split;
import java.util.*;

import static java.util.Arrays.*;

public class Sort {
    public static List<String> sortParagraphs(String text) {
        String[] paragraphs = text.split("\n"); // делим текст на абзацы

        return stream(paragraphs)
                .sorted(Comparator.comparingInt(c -> c.split("[.!?]").length)) // в каждом абзаце сравниваем количество предложений
                .toList();
    }

    public static List<String> sortSentences(String text) {
        String[] sentences = Split.splitSentence(text); // делим текст на предложения

        List<String> sortedSentences = new ArrayList<>();

        for (String sentence : sentences) {
            String[] words = Split.splitWords(sentence); // делим предложение на отдельные слова

            sort(words, Comparator.comparingInt(String::length)); // сортируем слова по длине

            sortedSentences.add(Arrays.toString(words));
        }

        return sortedSentences;
    }

    public static List<String> sortLexemes(String text, char element) {
        String[] sentences = Split.splitSentence(text);

        for (String sentence : sentences) {
            String[] words = Split.splitWords(sentence);

            List<Word> wordList = new ArrayList<>();

            for (String word : words) {
                wordList.add(new Word(word, element));
            }

            wordList.sort(Comparator.comparingInt(Word::getCount)
                    .reversed());
        }

        return null;
    }
}

