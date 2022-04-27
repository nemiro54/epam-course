package by.epam.unit_4.task_8;

import java.util.Arrays;
import java.util.Comparator;

public class AggregateCustomer {
    private Customer[] customers;

    public AggregateCustomer(Customer[] customers) {
        this.customers = customers;
    }

    public void sortByAlphabet() {
        Arrays.sort(customers, Comparator.comparing(Customer::getLastName)
                .thenComparing(Customer::getFirstName)
                .thenComparing(Customer::getMiddleName));

        Arrays.stream(customers)
                .forEach(System.out::println);
    }

    public void sortByCard(int begin, int end) {
        Arrays.stream(customers)
                .filter(x -> x.getCreditCard() >= begin)
                .filter(x -> x.getCreditCard() <= end)
                .forEach(System.out::println);
    }
}
