package by.epam.unit_6.task_4.ship;

import by.epam.unit_6.task_4.port.Port;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

public class ShipGenerator implements Runnable {
    private final Random random;
    private final Port port;

    public ShipGenerator(Port port) throws NoSuchAlgorithmException {
        this.port = port;
        this.random = SecureRandom.getInstanceStrong();
    }

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
        return ShipTarget.values()[random.nextInt(ShipTarget.values().length)];
    }

    private ShipCapacity getRandomSize() {
        return ShipCapacity.values()[random.nextInt(ShipCapacity.values().length)];
    }
}
