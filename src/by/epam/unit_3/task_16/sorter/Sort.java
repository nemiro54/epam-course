package by.epam.unit_3.task_16.sorter;

import by.epam.unit_3.task_16.composite.Word;
import by.epam.unit_3.task_16.parser.Split;
import java.util.*;

import static java.util.Arrays.*;

public class Sort {
    public static List<String> sortParagraphs(String text) {
        // делим текст на абзацы
        String[] paragraphs = text.split("\n");

        // в каждом абзаце сравниваем количество предложений
        return stream(paragraphs)
                .sorted(Comparator.comparingInt(c -> c.split("[.!?]").length))
                .toList();
    }

    public static List<String> sortSentences(String text) {
        // делим текст на предложения
        String[] sentences = Split.splitSentence(text);

        List<String> sortedSentences = new ArrayList<>();

        for (String sentence : sentences) {
            // делим предложение на отдельные слова
            String[] words = Split.splitWords(sentence);

            // сортируем слова по длине
            sort(words, Comparator.comparingInt(String::length));

            sortedSentences.add(Arrays.toString(words));
        }

        return sortedSentences;
    }

    public static List<String> sortLexemes(String text, char element) {
        // делим текст на предложения
        String[] sentences = Split.splitSentence(text);

        List<String> sortedWords = new ArrayList<>();

        for (String sentence : sentences) {
            // делим предложения на отдельные слова
            String[] words = Split.splitWords(sentence);

            List<Word> wordList = new ArrayList<>();

            for (String word : words) {
                wordList.add(new Word(word, element));
            }

            // сортируем по количеству вхождений или алфавиту (если кол-во равно)
            wordList.sort(Comparator.comparingInt(Word::getCount)
                    .reversed()
                    .thenComparing(Word::getWordToLowerCase));

            sentence = wordList.toString();
            sortedWords.add(sentence);
        }

        return sortedWords;
    }
}

