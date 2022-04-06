package by.epam.unit_3;

/*
task6: Дан текст (строка). Найдите наибольшее количество подряд идущих робелов в нем.
 */

public class Task6 {
    public static void main(String[] args) {

    }

    static int maxCountSpace(String str) {
        int curr = 0;
        int max = 0;

        for (char c : str.toCharArray()) {
            if (c == ' ') {
                curr++;

                if (curr > max) {
                    max = curr;
                }
            } else {
                curr = 0;
            }
        }
        return max;
    }
}
