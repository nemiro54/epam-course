package by.epam.unit_5.tsak_5.sweets_factory.factory;

import by.epam.unit_5.tsak_5.sweets_factory.sweets.Biscuit;
import by.epam.unit_5.tsak_5.sweets_factory.sweets.Sweets;

public class BiscuitFactory implements SweetsFactory {
    @Override
    public Sweets createSweet() {
        return new Biscuit();
    }
}
