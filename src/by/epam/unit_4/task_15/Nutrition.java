package by.epam.unit_4.task_15;

public enum Nutrition {
    WITHOUT_NUTRITION("без питания", 0),
    BREAKFAST("только завтрак", 1),
    TWICE_MEALS("двухразовое питание", 2),
    THREE_MEALS("трехразовое питание", 3),
    ALL_INCLUSIVE("все включено", 4);

    private final String nutrition;
    private final int flag;

    Nutrition(String nutrition, int flag) {
        this.nutrition = nutrition;
        this.flag = flag;
    }

    public String getNutrition() {
        return nutrition;
    }

    public int getFlag() {
        return flag;
    }

    @Override
    public String toString() {
        return getNutrition();
    }
}
