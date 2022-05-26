package by.epam.unit_5.task_4;

import java.util.Comparator;
import java.util.List;

public class Dragon {
    private String name;
    private Cave cave;
    private List<Treasure> treasures;

    public Dragon(String name) {
        this.name = name;
        this.cave = new Cave();
        this.treasures = cave.getTreasures();
    }

    public Dragon(String name, Cave cave) {
        this.name = name;
        this.cave = cave;
        this.treasures = cave.getTreasures();
    }

    public void printTreasures() {
        System.out.println(getCave());
    }

    public void printMostExpensiveTreasure() {
        treasures.sort((x1, x2) -> x2.getPrice() - x1.getPrice());
        System.out.println(treasures.get(0));
    }

    public void printForSum(long amount) {
        long currAmount = 0;
        int i = 0;

        while (currAmount < amount) {
            treasures.sort(Comparator.comparingInt(Treasure::getPrice));
            Treasure currTreasure = cave.getTreasures().get(i);
            System.out.println(currTreasure);
            currAmount += currTreasure.getPrice();
            i++;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Cave getCave() {
        return cave;
    }

    public void setCave(Cave cave) {
        this.cave = cave;
    }

    @Override
    public String toString() {
        return name;
    }
}
