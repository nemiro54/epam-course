package by.epam.unit_4.task_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;

public class Train {
    String destination;
    int trainNumber;
    Date departureTime;

    public Train(){
    }

    public Train(String destination, int trainNumber, Date departureTime) {
        this.destination = destination;
        this.trainNumber = trainNumber;
        this.departureTime = departureTime;
    }

    public String getDestination() {
        return destination;
    }

    public int getTrainNumber() {
        return trainNumber;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public static Train[] sortByNumbers(Train[] trains) {
        Arrays.sort(trains, Comparator.comparingInt(Train::getTrainNumber));
        return trains;
    }

    public static Train[] sortByDestination(Train[] trains) {
        Arrays.sort(trains, Comparator.comparing(Train::getDestination).thenComparing(Train::getDepartureTime));
        return trains;
    }

    public static String trainInformation(Train[] trains) {
        int number;

        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.print("Enter train number: ");

            int currCount = 0;
            String str = reader.readLine();
            number = Integer.parseInt(str);

            Train tmpTrain = new Train();

            for (Train train : trains) {
                if (number == train.trainNumber) {
                    tmpTrain = train;
                } else {
                    currCount++;
                }
            }

            return currCount != trains.length ? tmpTrain.toString() : "Invalid train number entered!";
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public String toString() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH-mm");

        return "Train: " +
                "Destination = " + destination +
                ", Train Number = " + trainNumber +
                ", Departure Time = " + simpleDateFormat.format(departureTime);
    }
}
