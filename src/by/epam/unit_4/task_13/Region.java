package by.epam.unit_4.task_13;

import java.util.List;

public class Region {
    private String name;
    private List<District> districts;
    private City regionCenter;

    public Region(String name, List<District> districts, City regionCenter) {
        this.name = name;
        this.districts = districts;
        this.regionCenter = regionCenter;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<District> getDistricts() {
        return districts;
    }

    public void setDistricts(List<District> districts) {
        this.districts = districts;
    }

    public City getRegionCenter() {
        return regionCenter;
    }

    public void setRegionCenter(City regionCenter) {
        this.regionCenter = regionCenter;
    }

    public int getPopulation() {
        return districts.stream()
                .mapToInt(District::getPopulation)
                .sum();
    }

    public double getArea() {
        return districts.stream()
                .mapToDouble(District::getArea)
                .sum();
    }

    @Override
    public String toString() {
        return String.format("%s область: население - %d чел., площадь - %.2f. кв. км.", name, getPopulation(), getArea());
    }
}
