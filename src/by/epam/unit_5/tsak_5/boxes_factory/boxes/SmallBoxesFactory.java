package by.epam.unit_5.tsak_5.boxes_factory.boxes;

import by.epam.unit_5.tsak_5.boxes_factory.factory.Boxes;
import by.epam.unit_5.tsak_5.boxes_factory.factory.SmallBox;

public class SmallBoxesFactory implements BoxesFactory {
    @Override
    public Boxes createBox() {
        return new SmallBox();
    }
}
