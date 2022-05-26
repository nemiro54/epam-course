package by.epam.unit_4.task_14;

public class Account {
    private long number;
    private long balance;
    private boolean isBlocked;

    public Account(long number, long balance) {
        this.number = number;
        this.balance = balance;
        this.isBlocked = balance < 0;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public boolean isBlocked() {
        return isBlocked;
    }

    public void setBlocked(boolean blocked) {
        isBlocked = blocked;
    }

    @Override
    public String toString() {
        return String.format("""
                Номер счета: %d
                Баланс: %d
                %s
                """, number, balance, isBlocked ? "Счет заблокирован" : "Счет доступен");
    }
}
