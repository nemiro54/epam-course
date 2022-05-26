package by.epam.unit_5.task_3;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.*;

public class Calendar {
    private ArrayList<HolidaysAndWeekends> holidays;
    private ArrayList<HolidaysAndWeekends> weekends;

    public Calendar() {
        this.holidays = new ArrayList<>();
        this.weekends = new ArrayList<>();
    }

    public void printHolidays() {
        System.out.println("Holidays:");
        this.holidays.forEach(System.out::println);
    }

    public void printWeekends() {
        System.out.println("Weekends:");
        this.weekends.forEach(System.out::println);
    }

    public void addHoliday(LocalDate localDate) {
        HolidaysAndWeekends holiday = new HolidaysAndWeekends(localDate);

        if (holidays.isEmpty()) {
            holidays.add(holiday);
        } else {
            for (HolidaysAndWeekends haw : holidays) {
                if (haw.getLocalDate().equals(localDate)) {
                    return;
                }
            }
            holidays.add(holiday);
        }
    }

    public void addHoliday(String localDate) {
        HolidaysAndWeekends holiday = new HolidaysAndWeekends(LocalDate.parse(localDate));

        if (holidays.isEmpty()) {
            holidays.add(holiday);
        } else {
            for (HolidaysAndWeekends haw : holidays) {
                if (haw.getLocalDate().equals(LocalDate.parse(localDate))) {
                    return;
                }
            }
            holidays.add(holiday);
        }
    }

    public void addWeekends(LocalDate localDate) {
        HolidaysAndWeekends weekend = new HolidaysAndWeekends(localDate);

        if (weekend.isWeekend()) {
            if (weekends.isEmpty()) {
                weekends.add(weekend);
            } else {
                for (HolidaysAndWeekends haw : weekends) {
                    if (haw.getLocalDate().equals(localDate)) {
                        return;
                    }
                }
                weekends.add(weekend);
            }
        }
    }

    public void addWeekends(String localDate) {
        HolidaysAndWeekends weekend = new HolidaysAndWeekends(localDate);

        if (weekend.isWeekend()) {
            if (weekends.isEmpty()) {
                weekends.add(weekend);
            } else {
                for (HolidaysAndWeekends haw : weekends) {
                    if (haw.getLocalDate().equals(LocalDate.parse(localDate))) {
                        return;
                    }
                }
                weekends.add(weekend);
            }
        }
    }

    private class HolidaysAndWeekends {
        private LocalDate localDate;

        private HolidaysAndWeekends(LocalDate localDate) {
            this.localDate = localDate;
        }

        private HolidaysAndWeekends(String date) {
            this.localDate = LocalDate.parse(date);
        }

        private boolean isWeekend() {
            return localDate.getDayOfWeek() == DayOfWeek.SATURDAY || localDate.getDayOfWeek() == DayOfWeek.SUNDAY;
        }

        private LocalDate getLocalDate() {
            return localDate;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            HolidaysAndWeekends that = (HolidaysAndWeekends) o;
            return getLocalDate().getYear() == that.getLocalDate().getYear()
                    && getLocalDate().getMonthValue() == that.getLocalDate().getMonthValue()
                    && getLocalDate().getDayOfMonth() == getLocalDate().getDayOfMonth();
        }

        @Override
        public int hashCode() {
            final int PRIME = 31;
            int result = 1;
            return PRIME * result
                    + getLocalDate().getYear()
                    + getLocalDate().getMonthValue()
                    + getLocalDate().getDayOfMonth();
        }

        @Override
        public String toString() {
            return String.format("%d-%s-%d-%s",
                    localDate.getYear(), localDate.getMonth(), localDate.getDayOfMonth(), localDate.getDayOfWeek());
        }
    }
}
