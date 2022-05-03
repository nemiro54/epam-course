package by.epam.unit_4.task_13;

import java.util.ArrayList;
import java.util.List;

public class Country {
    private String name;
    private List<Region> regions;
    private static City capital;

    public Country(String name, List<Region> regions, City capital) {
        this.name = name;
        this.regions = regions;
        Country.capital = capital;
    }

    public void printCapital() {
        System.out.printf("Столица государства - %s.\n", getCapital().getName());
    }

    public void printCountRegions() {
        System.out.printf("Количество областей - %d.\n", regions.size());
    }

    public void printArea() {
        System.out.printf("Площадь государства - %.2f кв.км.\n", getArea());
    }

    public void printRegionCenters() {
        List<City> centers = new ArrayList<>();

        for (Region region : regions) {
            centers.add(region.getRegionCenter());
        }

        System.out.println("Областные центры государства: ");

        centers.forEach(System.out::println);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Region> getRegions() {
        return regions;
    }

    public void setRegions(List<Region> regions) {
        this.regions = regions;
    }

    public static City getCapital() {
        return capital;
    }

    public static void setCapital(City capital) {
        Country.capital = capital;
    }

    public int getPopulation() {
        return regions.stream().mapToInt(Region::getPopulation).sum();
    }

    public double getArea() {
        return regions.stream().mapToDouble(Region::getArea).sum();
    }

    @Override
    public String toString() {
        return String.format("%s: население - %d чел., площадь - %.2f. кв. км.", name, getPopulation(), getArea());
    }
}
