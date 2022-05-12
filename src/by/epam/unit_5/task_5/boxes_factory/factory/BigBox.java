package by.epam.unit_5.task_5.boxes_factory.factory;

public class BigBox implements Boxes {
    private final double price;
    private final static int capacity = 15;

    public BigBox() {
        this.price = 3.80;
    }

    @Override
    public double getPrice() {
        return price;
    }

    public static int getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        return "big box";
    }
}
