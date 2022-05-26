package by.epam.unit_5.task_5.sweets_factory;

import by.epam.unit_5.task_5.sweets_factory.factory.*;

/*
Шаблон проектирования: фабрика.
Создание объектов сладостей.
 */

public class AddSweet {
    public static SweetsFactory addSweet(String str) {
        if (str.equalsIgnoreCase("cake")) {
            return new CakeFactory();
        } else if (str.equalsIgnoreCase("biscuit")) {
            return new BiscuitFactory();
        } else if (str.equalsIgnoreCase("candy")) {
            return new CandyFactory();
        } else if (str.equalsIgnoreCase("lollipop")) {
            return new LollipopFactory();
        } else {
            System.out.println("Нет такой сладости :(");
            throw new RuntimeException();
        }
    }
}
