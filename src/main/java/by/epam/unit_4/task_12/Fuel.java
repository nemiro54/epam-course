package by.epam.unit_4.task_12;

public enum Fuel {
    DIESEL("Дизельное топливо"),
    PETROL("Бензин"),
    GAS("Газ");

    private final String fuel;

    Fuel(String fuel) {
        this.fuel = fuel;
    }

    public String getFuel() {
        return fuel;
    }

    @Override
    public String toString() {
        return getFuel();
    }
}
