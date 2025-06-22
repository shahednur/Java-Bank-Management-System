package models;

public abstract class Account {
    protected int accountNumber;
    protected User user;
    protected double balance;

    public Account(int accountNumber, User user) {
        this.accountNumber = accountNumber;
        this.user = user;
        this.balance = 0;
    }

    public abstract void withdraw(double amount);

    public void deposit(double amount) {
        balance += amount;
    }

    public double getBalance() {
        return balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public User getUser() {
        return user;
    }
}
