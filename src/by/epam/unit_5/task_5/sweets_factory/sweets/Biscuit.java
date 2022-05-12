package by.epam.unit_5.task_5.sweets_factory.sweets;

public class Biscuit implements Sweets {
    private final String name;
    private final double price;
    private final int size;

    public Biscuit() {
        this.name = "Бисквит";
        this.price = 4.60;
        this.size = 5;
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
