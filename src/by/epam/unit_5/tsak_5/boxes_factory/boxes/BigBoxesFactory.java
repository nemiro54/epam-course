package by.epam.unit_5.tsak_5.boxes_factory.boxes;

import by.epam.unit_5.tsak_5.boxes_factory.factory.BigBox;
import by.epam.unit_5.tsak_5.boxes_factory.factory.Boxes;

public class BigBoxesFactory implements BoxesFactory {
    @Override
    public Boxes createBox() {
        return new BigBox();
    }
}
