package by.epam.unit_4.task_15;

public enum Nutrition {
    WITHOUT_NUTRITION("без питания"),
    BREAKFAST("только завтрак"),
    TWICE_MEALS("двухразовое питание"),
    THREE_MEALS("трехразовое питание"),
    ALL_INCLUSIVE("все включено");

    private final String nutrition;

    Nutrition(String nutrition) {
        this.nutrition = nutrition;
    }

    public String getNutrition() {
        return nutrition;
    }

    @Override
    public String toString() {
        return getNutrition();
    }
}
