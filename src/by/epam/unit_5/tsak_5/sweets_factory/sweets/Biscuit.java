package by.epam.unit_5.tsak_5.sweets_factory.sweets;

public class Biscuit implements Sweets {
    private String name = "Бисквит";
    private double price = 4.60;
    private int size = 5;

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
