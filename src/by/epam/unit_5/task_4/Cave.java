package by.epam.unit_5.task_4;

import java.util.ArrayList;
import java.util.List;

public class Cave {
    private List<Treasure> treasures;

    public Cave() {
        this.treasures = createTreasures();
    }

    public Cave(List<Treasure> treasures) {
        this.treasures = treasures;
    }

    private List<Treasure> createTreasures() {
        List<Treasure> treasures = new ArrayList<>(100);

        for (int i = 0; i < 100; i++) {
            treasures.add(new Treasure());
        }
        return treasures;
    }

    public List<Treasure> getTreasures() {
        return treasures;
    }

    public void setTreasures(List<Treasure> treasures) {
        this.treasures = treasures;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Cave treasure list:\n");
        treasures.forEach(treasure -> sb.append(treasure).append("\n"));
        return sb.toString();
    }
}
