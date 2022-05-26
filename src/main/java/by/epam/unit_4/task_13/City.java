package by.epam.unit_4.task_13;

public class City {
    private String name;
    private int population;
    private double area;
    private boolean isDistrictCenter;
    private boolean isRegionCenter;
    private boolean isCapital;

    public City(String name, int population, double area) {
        this.name = name;
        this.population = population;
        this.area = area;
        this.isDistrictCenter = false;
        this.isRegionCenter = false;
        this.isCapital = false;
    }

    public City(String name, int population, double area, boolean isDistrictCenter) {
        this(name, population, area);
        this.isDistrictCenter = isDistrictCenter;
    }

    public City(String name, int population, double area, boolean isDistrictCenter, boolean isRegionCenter) {
        this(name, population, area, isDistrictCenter);
        this.isRegionCenter = isRegionCenter;
    }

    public City(String name, int population, double area, boolean isDistrictCenter, boolean isRegionCenter, boolean isCapital) {
        this(name, population, area, isRegionCenter, isDistrictCenter);
        this.isCapital = isCapital;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public boolean isDistrictCenter() {
        return isDistrictCenter;
    }

    public void setDistrictCenter(boolean districtCenter) {
        isDistrictCenter = districtCenter;
    }

    public boolean isRegionCenter() {
        return isRegionCenter;
    }

    public void setRegionCenter(boolean regionCenter) {
        isRegionCenter = regionCenter;
    }

    public boolean isCapital() {
        return isCapital;
    }

    public void setCapital(boolean capital) {
        isCapital = capital;
    }

    @Override
    public String toString() {
        return String.format("%s: Население - %d чел., площадь - %.2f кв. км.", name, population, area);
    }
}
