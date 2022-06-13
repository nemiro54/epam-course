package by.epam.unit_6.task_4;

/*
unit_6.task_4: Многопоточность. Порт. Корабли заходят в порт для разгрузки / загрузки контейнеров. Число контейнеров,
находящихся в текущий момент в порту и на корабле, должно быть не отрицательным и превышающим заданную грузоподъемность
судна и вместимость порта. В порту работает несколько причалов. У одного причала может стоять один корабль.
Корабль может загружаться у причала или разгружаться.
 */

import by.epam.unit_6.task_4.port.Port;
import by.epam.unit_6.task_4.ship.ShipGenerator;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) {
        Port port = new Port();
        ShipGenerator shipGenerator = new ShipGenerator(port);

        ExecutorService service = Executors.newCachedThreadPool();
        service.execute(shipGenerator);
    }
}
