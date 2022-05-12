package by.epam.unit_5.task_5.boxes_factory.factory;

public class BigBox implements Boxes {
    private final double price;
    private final int capacity;

    public BigBox() {
        this.price = 3.80;
        this.capacity = 15;
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
