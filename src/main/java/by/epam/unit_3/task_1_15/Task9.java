package by.epam.unit_3.task_1_15;

/*
task9: С помощью функции копирования и операции конкатенации составить из частей слова "информатика" слово "торт".
 */

public class Task9 {
    public static void main(String[] args) {
        System.out.println(concatenation());
    }

    static String concatenation() {
        String initialWord = "информатика";
        String finalWord;

        return initialWord.charAt(7) + initialWord.substring(3, 5) + initialWord.charAt(7);
    }
}
