package by.epam.unit_4.task_15;

public enum TypeVoucher {
    REST("отдых"),
    EXCURSION("экскурсия"),
    TREATMENT("лечение"),
    SHOPPING("шоппинг"),
    CRUISE("круиз");

    private final String type;

    TypeVoucher(String type) {
        this.type = type;
    }

    private String getType() {
        return type;
    }

    @Override
    public String toString() {
        return getType();
    }
}
