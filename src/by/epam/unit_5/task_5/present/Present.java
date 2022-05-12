package by.epam.unit_5.task_5.present;

import by.epam.unit_5.task_5.boxes_factory.AddBox;
import by.epam.unit_5.task_5.boxes_factory.boxes.BoxesFactory;
import by.epam.unit_5.task_5.boxes_factory.factory.BigBox;
import by.epam.unit_5.task_5.boxes_factory.factory.Boxes;
import by.epam.unit_5.task_5.boxes_factory.factory.MiddleBox;
import by.epam.unit_5.task_5.boxes_factory.factory.SmallBox;
import by.epam.unit_5.task_5.sweets_factory.AddSweet;
import by.epam.unit_5.task_5.sweets_factory.factory.SweetsFactory;
import by.epam.unit_5.task_5.sweets_factory.sweets.Sweets;

import java.util.ArrayList;
import java.util.List;

public class Present {
    private final List<Sweets> sweets;
    private final List<Boxes> boxes;
    private int sizePresent;
    private double totalPrice = 0;

/*  создаем подарок на основе сладостей;
    рассчитываем и создаем необходимое число упаковок для сладостей*/

    public Present(List<String> sweets) {
        this.sweets = new ArrayList<>();
        this.boxes = new ArrayList<>();

        createSweets(sweets);
        createBoxes(this.sweets);
        countTotalPrice();
    }

    //    конвертация строк сладостей в объекты Sweets
    private void createSweets(List<String> sweets) {
        for (String s : sweets) {
            SweetsFactory sweetsFactory = AddSweet.addSweet(s);
            this.sweets.add(sweetsFactory.createSweet());
        }
    }

    //    создание нужного кол-ва упаковок
    private void createBoxes(List<Sweets> sweets) {
        int sizeSmallBox = SmallBox.getCapacity();
        int sizeMiddleBox = MiddleBox.getCapacity();
        int sizeBigBox = BigBox.getCapacity();
        int currSize = 0;

        currSize = sweets.stream().mapToInt(Sweets::getSize).sum();

        sizePresent = currSize;

        while (currSize > 0) {
            BoxesFactory boxesFactory;

            if (currSize <= sizeSmallBox) {
                boxesFactory = AddBox.addBox("small");
                this.boxes.add(boxesFactory.createBox());
                currSize -= sizeSmallBox;
            } else if (currSize <= sizeMiddleBox) {
                boxesFactory = AddBox.addBox("middle");
                this.boxes.add(boxesFactory.createBox());
                currSize -= sizeMiddleBox;
            } else {
                boxesFactory = AddBox.addBox("big");
                this.boxes.add(boxesFactory.createBox());
                currSize -= sizeBigBox;
            }
        }
    }

    //    общая цена подарка (сладости + упаковка)
    private void countTotalPrice() {
        totalPrice += sweets.stream().mapToDouble(Sweets::getPrice).sum();
        totalPrice += boxes.stream().mapToDouble(Boxes::getPrice).sum();
    }

    public List<Sweets> getSweets() {
        return sweets;
    }

    public List<Boxes> getBoxes() {
        return boxes;
    }

    public int getSizePresent() {
        return sizePresent;
    }

    @Override
    public String toString() {
        return String.format("""
                Сладости в коробке: %s
                Итого цена: %.2f""", sweets, totalPrice);
    }
}
