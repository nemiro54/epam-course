package by.epam.unit_4.task_6;

/*
task6: Составьте описание класса для представления времени. Предусмотрите возможность установки времени и изменения
его отдельных полей (час, минута, секунда) с проверкой допустимости вводимых значений. В случае недопустимых значений
полей, поле устанавливается в значение 0. Создать методы изменения времени на заданное количество часов минут и секунд.
 */

public class Solution {
    public static void main(String[] args) {
        Time time = new Time(0, 0, 0);

        System.out.println(time);

        time.addMinute(50);
        System.out.println(time);

        time.addSecond(75);
        System.out.println(time);

        time.addHour(3);
        System.out.println(time);
    }
}
