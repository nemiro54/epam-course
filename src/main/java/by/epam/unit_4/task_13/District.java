package by.epam.unit_4.task_13;

import java.util.List;

public class District {
    private String name;
    private List<City> cities;
    private City districtCenter;

    public District(String name, List<City> cities, City districtCenter) {
        this.name = name;
        this.cities = cities;
        this.districtCenter = districtCenter;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }

    public City getDistrictCenter() {
        return districtCenter;
    }

    public void setDistrictCenter(City districtCenter) {
        this.districtCenter = districtCenter;
    }

    public int getPopulation() {
        return cities.stream().mapToInt(City::getPopulation).sum();
    }

    public double getArea() {
        return cities.stream().mapToDouble(City::getArea).sum();
    }

    @Override
    public String toString() {
        return String.format("%s район: население - %d чел., площадь - %.2f. кв. км.", name, getPopulation(), getArea());
    }
}
