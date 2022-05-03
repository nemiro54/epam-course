package by.epam.unit_4.task_14;

import java.util.Comparator;
import java.util.List;

public class Client {
    private long id;
    private String firstName;
    private String lastName;
    private List<Account> accounts;

    public Client(long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Client(long id, String firstName, String lastName, List<Account> accounts) {
        this(id, firstName, lastName);
        this.accounts = accounts;
    }

    public void sortAccountByBalance() {
        accounts.stream()
                .sorted(Comparator.comparingLong(Account::getBalance))
                .forEach(System.out::println);
    }

    public void sortAccountByNumber() {
        accounts.stream()
                .sorted(Comparator.comparingLong(Account::getNumber))
                .forEach(System.out::println);
    }

    public Account findAccount(Account account) {
        for (Account currAccount : accounts) {
            if (account.getNumber() == currAccount.getNumber()) {
                return currAccount;
            }
        }

        System.out.println("У клиента нет такого счета.");
        return null;
    }

    public long sumBalance() {
        return accounts.stream()
                .mapToLong(Account::getBalance)
                .sum();
    }

    public long sumPositiveBalance() {
        return accounts.stream()
                .filter(x -> x.getBalance() > 0)
                .mapToLong(Account::getBalance)
                .sum();
    }

    public long sumNegativeBalance() {
        return accounts.stream()
                .filter(x -> x.getBalance() <= 0)
                .mapToLong(Account::getBalance)
                .sum();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    @Override
    public String toString() {
        return String.format("Клиент: %s %s, id - %d", firstName, lastName, id);
    }
}
