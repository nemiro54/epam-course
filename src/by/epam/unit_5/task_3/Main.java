package by.epam.unit_5.task_3;

/*
task_3: Создать класс Календарь с внутренним классом, с помощью объектов которого можно хранить информацию о
выходных и праздничных днях.
 */

import java.time.LocalDate;
import java.time.Month;

public class Main {
    public static void main(String[] args) {
        Calendar calendar = new Calendar();

        calendar.addWeekends(LocalDate.of(2022, Month.MAY, 8));
        calendar.addWeekends("2022-05-08");
        calendar.addWeekends("2022-05-09");
        calendar.addWeekends(LocalDate.of(2022, Month.MAY, 9));
        calendar.addWeekends(LocalDate.of(2022, Month.MAY, 10));

        calendar.addHoliday("2021-12-31");
        calendar.addHoliday(LocalDate.of(2021, Month.DECEMBER, 31));
        calendar.addHoliday(LocalDate.of(2022, Month.MAY, 9));
        calendar.addHoliday(LocalDate.of(2021, Month.MAY, 9));
        calendar.addHoliday(LocalDate.of(2021, Month.MAY, 9));

        calendar.printWeekends();
        calendar.printHolidays();
    }
}
