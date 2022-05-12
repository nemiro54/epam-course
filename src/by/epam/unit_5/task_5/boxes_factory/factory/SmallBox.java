package by.epam.unit_5.task_5.boxes_factory.factory;

public class SmallBox implements Boxes {
    private final double price;
    private final int capacity;

    public SmallBox() {
        this.price = 1.20;
        this.capacity = 5;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public int getCapacity() {
        return capacity;
    }
}
