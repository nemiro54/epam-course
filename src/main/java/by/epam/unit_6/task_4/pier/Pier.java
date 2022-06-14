package by.epam.unit_6.task_4.pier;

import by.epam.unit_6.task_4.port.Port;
import by.epam.unit_6.task_4.ship.Ship;

public class Pier implements Runnable {
    private final Port port;

    public Pier(Port port) {
        this.port = port;

    }

    @Override
    public void run() {
        while (true) {
            Ship ship = port.getShip();
            if (ship != null) {
                switch (ship.getTarget()) {
                    case LOAD -> load(ship);
                    case UNLOAD -> unload(ship);
                }
            }
        }
    }

    private void load(Ship ship) {
        while (!ship.isLoaded()) {
            ship.add(100);
            System.out.println(Thread.currentThread().getName() + " - " + " is loading...");
        }
        System.out.println(Thread.currentThread().getName() + " is loaded!");

    }

    private void unload(Ship ship) {
        while (!ship.isUnloaded()) {
            ship.get(100);
            System.out.println(Thread.currentThread().getName() + " is unloading...");
        }
        System.out.println(Thread.currentThread().getName() + " is unloaded!");
    }
}
