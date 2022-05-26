package by.epam.unit_5.task_5.sweets_factory.sweets;

public class Candy implements Sweets {
    private final String name;
    private final double price;
    private final int size;

    public Candy() {
        this.name = "Конфета";
        this.price = 0.45;
        this.size = 1;
    }

    @Override
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
