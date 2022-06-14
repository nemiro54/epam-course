package by.epam.unit_6.task_4.port;

import by.epam.unit_6.task_4.ship.Ship;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Port {
    private final BlockingQueue<Ship> shipsQueue = new ArrayBlockingQueue<>(2, true);
    private int shipCounter = 0;

    private final Lock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();

    public void addShip(Ship ship) {
        lock.lock();
        try {
            while (true) {
                if (shipCounter < 2) {
                    condition.signalAll();
                    shipsQueue.put(ship);
                    System.out.println(ship + " - " + shipsQueue.size() + ": --> new ship was arrived in the port.");
                    shipCounter++;
                } else {
                    System.out.println("There is no place for a new ship in the port.");
                    condition.await();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public Ship getShip() {
        lock.lock();
        try {
            while (true) {
                if (shipCounter > 0) {
                    condition.signalAll();
                    for (Ship ship : shipsQueue) {
                        ship = shipsQueue.take();
                        System.out.println(ship + " - " + shipsQueue.size() + ": --> Ship was taken from the port.");
                        shipCounter--;
                        return ship;
                    }
                } else {
                    System.out.println("The port is empty!");
                    condition.await();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return null;
    }

    public BlockingQueue<Ship> getShipsQueue() {
        return shipsQueue;
    }
}
