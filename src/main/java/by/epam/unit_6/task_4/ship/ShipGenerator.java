package by.epam.unit_6.task_4.ship;

import by.epam.unit_6.task_4.port.Port;

import java.util.Random;

public record ShipGenerator(Port port) implements Runnable {

    @Override
    public void run() {
        while (true) {
            try {
                Thread.currentThread().setName("Generator ship");
                port.addShip(new Ship(getRandomTarget(), getRandomSize()));
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException();
            }
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
