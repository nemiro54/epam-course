package by.epam.unit_4.task_12;

public class Wheel {
    private int width;
    private int height;
    private int size;

    public Wheel(int width, int height, int size) {
        this.width = width;
        this.height = height;
        this.size = size;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        return String.format("Колесо: " +
                "ширина покрышки - %d мм., " +
                "высота покрышки - %d %%, " +
                "диаметр колеса - %d\"",
                width, height, size);
    }
}
