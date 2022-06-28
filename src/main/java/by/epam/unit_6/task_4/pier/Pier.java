package by.epam.unit_6.task_4.pier;

import by.epam.unit_6.task_4.port.Port;
import by.epam.unit_6.task_4.ship.Ship;

public record Pier(Port port) implements Runnable {

    @Override
    public void run() {
        while (true) {
            try {
                Ship ship = port.getShip();
                if (ship != null) {
                    switch (ship.getTarget()) {
                        case LOAD -> load(ship);
                        case UNLOAD -> unload(ship);
                    }
                    System.out.println("CURRENT PORT  LOAD: " + port.getCurrentLoad());
                    Thread.sleep(5000);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException();
            }
        }
    }

    private void load(Ship ship) throws InterruptedException {
        while (!ship.isLoaded()) {
            ship.addCargo(100);
            port.decrementCurrentLoad(100);
            System.out.println(ship + " - " + " is loading...");
            Thread.sleep(1000);
        }
        System.out.println(ship + " is loaded!");

    }

    private void unload(Ship ship) throws InterruptedException {
        while (!ship.isUnloaded()) {
            ship.getCargo(100);
            port.incrementCurrentLoad(100);
            System.out.println(ship + " is unloading...");
            Thread.sleep(1000);
        }
        System.out.println(ship + " is unloaded!");
    }
}
