package by.epam.unit_5.task_5;

/*
Стартовое меню программы;
выбор сладостей.
 */

import by.epam.unit_5.task_5.present.Present;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MainMenu {
    public static void startProgram() {
        Present present = new Present(selectSweets());

        userActionSelection();
    }

    private static void userActionSelection() {
//        заглушка выбора действий клиентом
    }

    //    добавление сладостей к подарку
    private static List<String> selectSweets() {
        List<String> sweets = new ArrayList<>();

        System.out.println("Добавьте сладости к подарку!");

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String line = reader.readLine();

            while (!line.equalsIgnoreCase("stop")) {
                if (line.equalsIgnoreCase("cake")
                        || line.equalsIgnoreCase("biscuit")
                        || line.equalsIgnoreCase("candy")
                        || line.equalsIgnoreCase("lollipop")) {
                    sweets.add(line);

                    System.out.println("Сладость добавлена!");
                } else {
                    System.out.println("Нет такой сладости. Попробуйте заново");
                }
                line = reader.readLine();
            }
            return sweets;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
