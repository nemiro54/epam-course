package by.epam.unit_5.task_5.sweets_factory.sweets;

public class Cake implements Sweets {
    private final String name;
    private final double price;
    private final int size;

    public Cake() {
        this.name = "Кекс";
        this.price = 2.90;
        this.size = 3;
    }

    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        return getName();
    }
}
