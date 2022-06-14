package by.epam.unit_6.task_4.ship;

import by.epam.unit_6.task_4.port.Port;

import java.util.Random;

public class ShipGenerator implements Runnable {
    private final Port port;

    public ShipGenerator(Port port) {
        this.port = port;
    }

    @Override
    public void run() {
        while (true) {
            Thread.currentThread().setName("Generator ship");
            port.addShip(new Ship(getRandomTarget(), getRandomSize()));
        }
    }

    private ShipTarget getRandomTarget() {
        Random random = new Random();
        return ShipTarget.values()[random.nextInt(ShipTarget.values().length)];
    }

    private ShipCapacity getRandomSize() {
        Random random = new Random();
        return ShipCapacity.values()[random.nextInt(ShipCapacity.values().length)];
    }
}
