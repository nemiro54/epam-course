package by.epam.unit_5.tsak_5.sweets_factory.sweets;

public class Cake implements Sweets {
    private String name = "Кекс";
    private double price = 2.90;
    private int size = 3;

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
