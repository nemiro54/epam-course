package by.epam.unit_3.task_1_15;

/*
task15: Строка Х состоит из нескольких предложений, каждое из которых кончается точкой, восклицательным или
вопросительным знаком. Определить количество предложений в стоке Х.
 */

public class Task15 {
    public static void main(String[] args) {
        System.out.println(countSentences(
                "Hello, world. " +
                "This is my first year learning english and java! " +
                "I'm really happy." +
                "Will I be able to finish my journey and get a job offer this year? " +
                        "How do you think?"));
    }

    static int countSentences(String str) {
        int count = 0;

        for (char c : str.toCharArray()) {
            if (c == '.' || c == '!' || c == '?') {
                count++;
            }
        }

        return count;
    }
}
