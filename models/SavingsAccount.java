package models;

public class SavingsAccount extends Account {

    public SavingsAccount(int acc, User user) {
        super(acc, user);
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= balance)
            balance -= amount;
        else
            System.out.println("Not enough balance!");
    }
}
