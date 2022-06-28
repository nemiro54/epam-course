package by.epam.unit_6.task_4.ship;

public class Ship {
    private final ShipTarget TARGET;
    private final ShipCapacity SHIP_CAPACITY;
    private int count;

    public Ship(ShipTarget target, ShipCapacity capacity) {
        this.TARGET = target;
        this.SHIP_CAPACITY = capacity;
    }

    public void addCargo(int count) {
        this.count += count;
    }

    public void getCargo(int count) {
        this.count -= count;
    }

    public boolean isLoaded() {
        return count >= SHIP_CAPACITY.getValue();
    }

    public boolean isUnloaded() {
        return count <= 0;
    }

    public ShipTarget getTarget() {
        return TARGET;
    }

    public ShipCapacity getShipCapacity() {
        return SHIP_CAPACITY;
    }

    public int getCount() {
        return count;
    }

    @Override
    public String toString() {
        return "Ship{" +
                "target=" + TARGET +
                ", shipCapacity=" + SHIP_CAPACITY +
                '}';
    }
}
