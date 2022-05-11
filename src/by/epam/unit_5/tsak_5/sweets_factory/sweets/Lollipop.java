package by.epam.unit_5.tsak_5.sweets_factory.sweets;

public class Lollipop implements Sweets {
    private String name = "Леденец";
    private double price = 2.10;
    private int size = 2;

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
