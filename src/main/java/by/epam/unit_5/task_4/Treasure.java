package by.epam.unit_5.task_4;

public class Treasure {
    private String name;
    private int price;

    public Treasure() {
        this.name = "";
        this.price = (int) (Math.random() * Integer.MAX_VALUE + 1);
    }

    public Treasure(String name) {
        this.name = name;
        this.price = (int) (Math.random() * Integer.MAX_VALUE + 1);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("Treasure \"%s\", price: %d", getName(), getPrice());
    }
}
