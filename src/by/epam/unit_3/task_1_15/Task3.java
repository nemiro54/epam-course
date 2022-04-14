package by.epam.unit_3.task_1_15;

/*
task3: В строке найти количество цифр.
 */
public class Task3 {
    public static void main(String[] args) {
    }

    static int countDigits(String str){
        return (int) str.codePoints().filter(Character::isDigit).count();
    }
}
