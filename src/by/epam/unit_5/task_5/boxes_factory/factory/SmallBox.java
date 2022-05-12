package by.epam.unit_5.task_5.boxes_factory.factory;

public class SmallBox implements Boxes {
    private final double price;
    private final static int capacity = 5;

    public SmallBox() {
        this.price = 1.20;
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
        return "small box";
    }
}
