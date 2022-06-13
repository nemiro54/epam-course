package by.epam.unit_6.task_4.port;

import by.epam.unit_6.task_4.ship.Ship;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Port {
    private static final int numberOfPiers = 5;
    private BlockingQueue<Ship> ships = new ArrayBlockingQueue<>(5, true);

    public void addShip(Ship ship) {
        try {
            ships.put(ship);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public BlockingQueue<Ship> getShips() {
        return ships;
    }

    public void setShips(BlockingQueue<Ship> ships) {
        this.ships = ships;
    }
}
