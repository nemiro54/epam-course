package by.epam.unit_4.task_15;

public class TravelVoucher {
    private String country;
    private String location;
    private TypeVoucher typeVoucher;
    private Transport transport;
    private Nutrition nutrition;
    private int numberOfDays;

    public TravelVoucher(String country, String location, TypeVoucher typeVoucher, Transport transport, Nutrition nutrition, int numberOfDays) {
        this.country = country;
        this.location = location;
        this.typeVoucher = typeVoucher;
        this.transport = transport;
        this.nutrition = nutrition;
        this.numberOfDays = numberOfDays;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public TypeVoucher getTypeVoucher() {
        return typeVoucher;
    }

    public void setTypeVoucher(TypeVoucher typeVoucher) {
        this.typeVoucher = typeVoucher;
    }

    public Transport getTransport() {
        return transport;
    }

    public void setTransport(Transport transport) {
        this.transport = transport;
    }

    public Nutrition getNutrition() {
        return nutrition;
    }

    public void setNutrition(Nutrition nutrition) {
        this.nutrition = nutrition;
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }

    public void setNumberOfDays(int numberOfDays) {
        this.numberOfDays = numberOfDays;
    }

    @Override
    public String toString() {
        return String.format("%s, %s: %s. Транспорт: %s. Питание: %s. Количество дней: %d.",
                country, location, typeVoucher, transport, nutrition, numberOfDays);
    }
}
