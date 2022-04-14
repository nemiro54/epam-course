package by.epam.unit_3.task_1_15;

/*
task4: В строке найти количество чисел.
 */

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task4 {
    public static void main(String[] args) {
    }

    static int countNumbers(String str){
        int countNumbers = 0;

        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(str);

        while (matcher.find()) {
            countNumbers++;
        }
        return countNumbers;
    }
}
