package by.epam.unit_6.task_4.port;

import by.epam.unit_6.task_4.ship.Ship;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Port {
    private static final int PORT_CAPACITY = 50000;
    private final BlockingQueue<Ship> SHIPS_QUEUE = new ArrayBlockingQueue<>(5, true);
    private final Lock LOCK = new ReentrantLock();
    private final Condition CONDITION = LOCK.newCondition();

    private AtomicInteger currentLoad = new AtomicInteger(0);
    private AtomicInteger shipCounter = new AtomicInteger(0);

    public void addShip(Ship ship) {
        LOCK.lock();
        try {
            while (true) {
                if (shipCounter.get() < 2) {
                    CONDITION.signalAll();
                    SHIPS_QUEUE.put(ship);
                    System.out.println(ship + " - " + SHIPS_QUEUE.size() + ": --> new ship was arrived in the port.");
                    shipCounter.getAndIncrement();
                } else {
                    System.out.println("There is no place for a new ship in the port.");
                    CONDITION.await();
                }
                Thread.sleep(3000);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException();
        } finally {
            LOCK.unlock();
        }
    }

    public Ship getShip() {
        LOCK.lock();
        try {
            while (true) {
                if (shipCounter.get() > 0) {
                    CONDITION.signalAll();
                    for (Ship ship : SHIPS_QUEUE) {
                        ship = SHIPS_QUEUE.take();
                        System.out.println(ship + " - " + SHIPS_QUEUE.size() + ": --> Ship was taken from the port.");
                        shipCounter.getAndDecrement();
                        return ship;
                    }
                } else {
                    System.out.println("The port is empty!");
                    CONDITION.await();
                }
                Thread.sleep(3000);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException();
        } finally {
            LOCK.unlock();
        }
    }

    public synchronized void incrementCurrentLoad(int value) {
        currentLoad.addAndGet(value);
    }

    public synchronized void decrementCurrentLoad(int value) {
        currentLoad.set(currentLoad.get() - value);
    }

    public int getPortCapacity() {
        return PORT_CAPACITY;
    }

    public AtomicInteger getShipCounter() {
        return shipCounter;
    }

    public void setShipCounter(AtomicInteger shipCounter) {
        this.shipCounter = shipCounter;
    }

    public AtomicInteger getCurrentLoad() {
        return currentLoad;
    }

    public void setCurrentLoad(AtomicInteger currentLoad) {
        this.currentLoad = currentLoad;
    }
}
