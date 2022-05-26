package by.epam.unit_4.task_6;

public class Time {
    private int hour;
    private int minute;
    private int second;

    public Time(int hour, int minute, int second) {
        setHour(hour);
        setMinute(minute);
        setSecond(second);
    }

    public Time(int hour, int minute) {
        this(hour, minute, 0);
    }

    public Time(int hour) {
        this(hour, 0, 0);
    }

    public Time() {
        this(0, 0, 0);
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        if (hour < 0 || hour > 23) {
            this.hour = 0;
        } else {
            this.hour = hour;
        }
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        if (minute < 0 || minute > 59) {
            this.minute = 0;
        } else {
            this.minute = minute;
        }
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        if (second < 0 || second > 59) {
            this.second = 0;
        } else {
            this.second = second;
        }
    }

    public void addHour(int hour) {
        addSecond(hour * 60 * 60);
    }

    public void addMinute(int minute) {
        addSecond(minute * 60);
    }

    public void addSecond(int second) {
        this.second += second;

        this.minute += this.second / 60;
        this.second %= 60;

        this.hour += this.minute / 60;
        this.minute %= 60;

        this.hour %= 24;
    }

    @Override
    public String toString() {
        return String.format("%02d:%02d:%02d", hour, minute, second);
    }
}
