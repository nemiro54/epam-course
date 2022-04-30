package by.epam.unit_4.task_12;

public enum CarBody {
    COUPE("Купе"),
    SEDAN("Седан"),
    ESTATE("Универсал"),
    HATCHBACK("Хэтчбек"),
    CABRIOLET("Кабриолет");

    private final String carBody;

    CarBody(String carBody) {
        this.carBody = carBody;
    }

    public String getCarBody() {
        return carBody;
    }

    @Override
    public String toString() {
        return getCarBody();
    }
}
