package by.epam.unit_4.task_15;

public enum Transport {
    BUS("автобус"),
    TRAIN("поезд"),
    AIRPLANE("самолет");

    private final String transport;

    Transport(String transport) {
        this.transport = transport;
    }

    private String getTransport() {
        return transport;
    }

    @Override
    public String toString() {
        return getTransport();
    }
}
