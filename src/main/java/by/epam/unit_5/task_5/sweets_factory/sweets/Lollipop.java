package by.epam.unit_5.task_5.sweets_factory.sweets;

public class Lollipop implements Sweets {
    private final String name;
    private final double price;
    private final int size;

    public Lollipop() {
        this.name = "Леденец";
        this.price = 2.10;
        this.size = 2;
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
