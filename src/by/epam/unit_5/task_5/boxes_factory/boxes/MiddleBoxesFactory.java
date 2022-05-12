package by.epam.unit_5.task_5.boxes_factory.boxes;

import by.epam.unit_5.task_5.boxes_factory.factory.Boxes;
import by.epam.unit_5.task_5.boxes_factory.factory.MiddleBox;

public class MiddleBoxesFactory implements BoxesFactory {
    @Override
    public Boxes createBox() {
        return new MiddleBox();
    }
}
