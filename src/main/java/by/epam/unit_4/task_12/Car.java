package by.epam.unit_4.task_12;

public class Car {
    private final String brand;
    private final String model;
    private CarBody carBody;
    private Engine engine;
    private int fuelTankVolume;
    private int fuelLevel;
    private Wheel[] wheels;

    public Car(String brand, String model, CarBody carBody, Engine engine, int fuelTankVolume, int fuelLevel, Wheel[] wheels) {
        this.brand = brand;
        this.model = model;
        this.carBody = carBody;
        this.engine = engine;
        this.fuelTankVolume = fuelTankVolume;

        if (fuelLevel >= 0 && fuelLevel <= fuelTankVolume) {
            this.fuelLevel = fuelLevel;
        } else {
            this.fuelLevel = 0;
        }

        if (wheels.length == 4) {
            this.wheels = wheels;
        } else {
            this.wheels = new Wheel[4];
        }
    }

    public void changeWheel(Wheel newWheel, int wheelNumber) {
        if (wheelNumber > 0 && wheelNumber <= wheels.length) {
            wheels[wheelNumber - 1] = null;
            System.out.printf("Колесо №%d снято.\n", wheelNumber);

            wheels[wheelNumber - 1] = newWheel;
            System.out.println("Новое колесо установлено.");
        } else {
            System.out.println("Замена невозможна. Колесо с таким  номером не существует!");
        }
    }

    public void printModel() {
        System.out.println(brand + " " + model);
    }

    public void drive() {
        engine.startEngine();
        System.out.println("Автомобиль едет!");
    }

    public void refuel(int liters) {
        if (fuelLevel == fuelTankVolume) {
            System.out.println("Бак заполнен, заправка не требуется!");
        } else if (fuelLevel + liters > fuelTankVolume) {
            int tmp = fuelTankVolume - fuelLevel;

            fuelLevel += tmp;
            System.out.printf("Заправлено в бак %d л.", tmp);
            System.out.printf("Заправлено в канистру %d л.", liters - tmp);
        } else {
            fuelLevel += liters;
            System.out.printf("Заправлено в бак %d л.", liters);
        }
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public CarBody getCarBody() {
        return carBody;
    }

    public void setCarBody(CarBody carBody) {
        this.carBody = carBody;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public int getFuelTankVolume() {
        return fuelTankVolume;
    }

    public void setFuelTankVolume(int fuelTankVolume) {
        this.fuelTankVolume = fuelTankVolume;
    }

    public int getFuelLevel() {
        return fuelLevel;
    }

    public void setFuelLevel(int fuelLevel) {
        this.fuelLevel = fuelLevel;
    }

    public Wheel[] getWheels() {
        return wheels;
    }

    public void setWheels(Wheel[] wheels) {
        this.wheels = wheels;
    }

    @Override
    public String toString() {
        return String.format("Автомобиль: " +
                "марка - %s, " +
                "модель - %s, " +
                "кузов - %s, " +
                "двигатель - %s.",
                brand, model, carBody, engine.getName());
    }
}
