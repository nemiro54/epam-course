package by.epam.unit_5.tsak_5.sweets_factory.sweets;

public class Candy implements Sweets {
    private String name = "Конфета";
    private double price = 0.45;
    private int size = 1;

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
