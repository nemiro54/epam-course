package by.epam.unit_4.task_12;

public class Engine {
    private String name;
    private Fuel fuel;
    private int volume;
    private int power;

    public Engine(String name, Fuel fuel, int volume, int power) {
        this.name = name;
        this.fuel = fuel;
        this.volume = volume;
        this.power = power;
    }

    public void startEngine() {
        System.out.println("Двигатель запущен!");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Fuel getFuel() {
        return fuel;
    }

    public void setFuel(Fuel fuel) {
        this.fuel = fuel;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    @Override
    public String toString() {
        return String.format("Двигатель: " +
                        "модель - %s, " +
                        "топливо - %s, " +
                        "объем - %d куб. см., " +
                        "мощность - %d л.с.",
                name, fuel, volume, power);
    }
}
