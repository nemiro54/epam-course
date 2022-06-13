package by.epam.unit_6.task_4.ship;

public enum ShipCapacity {
    MIN(100),
    MIDDLE(200),
    MAX(300);

    private final int capacity;

    ShipCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }
}
