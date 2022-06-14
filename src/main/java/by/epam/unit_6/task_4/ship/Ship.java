package by.epam.unit_6.task_4.ship;

public class Ship {
    private final ShipTarget target;
    private final ShipCapacity shipCapacity;
    private int count;

    public Ship(ShipTarget target, ShipCapacity capacity) {
        this.target = target;
        this.shipCapacity = capacity;
    }

    public void add(int count) {
        this.count += count;
    }

    public void get(int count) {
        this.count -= count;
    }

    public boolean isLoaded() {
        return count >= shipCapacity.getValue();
    }

    public boolean isUnloaded() {
        return count <= 0;
    }

    public ShipTarget getTarget() {
        return target;
    }

    public ShipCapacity getShipCapacity() {
        return shipCapacity;
    }

    public int getCount() {
        return count;
    }

    @Override
    public String toString() {
        return "Ship{" +
                "target=" + target +
                ", shipCapacity=" + shipCapacity +
                '}';
    }
}
