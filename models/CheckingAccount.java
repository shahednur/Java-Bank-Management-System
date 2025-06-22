package models;

public class CheckingAccount extends Account {

    public CheckingAccount(int acc, User user) {
        super(acc, user);
    }

    @Override
    public void withdraw(double amount) {
        balance -= amount;
    }
}
