package by.epam.unit_6.task_4.ship;

public class Ship {
    private final ShipTarget target;
    private final ShipCapacity shipCapacity;

    public Ship(ShipTarget target, ShipCapacity capacity) {
        this.target = target;
        this.shipCapacity = capacity;
    }


    public ShipTarget getTarget() {
        return target;
    }

    public ShipCapacity getShipCapacity() {
        return shipCapacity;
    }

    @Override
    public String toString() {
        return "Ship{" +
                "target=" + target +
                ", shipCapacity=" + shipCapacity +
                '}';
    }
}
