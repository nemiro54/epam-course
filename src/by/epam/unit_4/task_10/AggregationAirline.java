package by.epam.unit_4.task_10;

import java.time.LocalTime;
import java.util.Arrays;

public class AggregationAirline {
    private Airline[] airlines;

    public AggregationAirline(Airline[] airlines) {
        this.airlines = airlines;
    }

    public void filterByDestination(String destination) {
        Arrays.stream(airlines)
                .filter(x -> x.getDestination().toLowerCase().contains(destination))
                .forEach(System.out::println);
    }

    public void filterByDays(Days day) {
        Arrays.stream(airlines)
                .filter(x -> x.getDay().equals(day))
                .forEach(System.out::println);
    }

    public void filterByDays(Days day, LocalTime departureTime) {
        Arrays.stream(airlines)
                .filter(x -> x.getDay().equals(day))
                .filter(x -> x.getDepartureTime().isAfter(departureTime))
                .forEach(System.out::println);
    }

    public Airline[] getAirlines() {
        return airlines;
    }

    public void setAirlines(Airline[] airlines) {
        this.airlines = airlines;
    }
}
