package by.epam.unit_5.tsak_5.boxes_factory.factory;

public class MiddleBox implements Boxes {
    private final double price;
    private final int capacity;

    public MiddleBox() {
        this.price = 2.15;
        this.capacity = 10;
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
