package by.epam.unit_5.task_5.boxes_factory.factory;

public class MiddleBox implements Boxes {
    private final double price;
    private final static int capacity = 10;

    public MiddleBox() {
        this.price = 2.15;
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
        return "middle box";
    }
}
