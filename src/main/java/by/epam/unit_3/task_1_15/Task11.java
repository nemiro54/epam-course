package by.epam.unit_3.task_1_15;

/*
task11: Из заданной строки получить новую, повторив каждый символ дважды.
 */

public class Task11 {
    public static void main(String[] args) {

    }

    static String newStr(String str) {
        StringBuilder sb = new StringBuilder();

        for (char c : str.toCharArray()) {
            sb.append(c);
            sb.append(c);
        }
        return sb.toString();
    }
}
