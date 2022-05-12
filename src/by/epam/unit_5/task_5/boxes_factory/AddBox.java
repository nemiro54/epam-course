package by.epam.unit_5.task_5.boxes_factory;

import by.epam.unit_5.task_5.boxes_factory.boxes.BigBoxesFactory;
import by.epam.unit_5.task_5.boxes_factory.boxes.BoxesFactory;
import by.epam.unit_5.task_5.boxes_factory.boxes.SmallBoxesFactory;

public class AddBox {
    public static BoxesFactory addBox(String str) {
        if (str.equalsIgnoreCase("small") || str.equalsIgnoreCase("smallfactory")) {
            return new SmallBoxesFactory();
        } else if (str.equalsIgnoreCase("middle") || str.equalsIgnoreCase("smallbox")) {
            return new SmallBoxesFactory();
        } else if (str.equalsIgnoreCase("big") || str.equalsIgnoreCase("bigbox")) {
            return new BigBoxesFactory();
        } else {
            System.out.println("Нет такой коробки :(");
            throw new RuntimeException();
        }
    }
}
