package impl;

import java.util.*;

import models.Account;
import models.CheckingAccount;
import models.SavingsAccount;
import models.User;
import services.BankService;

public class SimpleBank implements BankService {
    private Map<Integer, Account> accounts = new HashMap<>();
    private int nextAccountNumber = 1001;

    @Override
    public void createAccount(String name, int age, String type) {
        User user = new User(name, age);

        Account acc = type.equalsIgnoreCase("savings") ? new SavingsAccount(nextAccountNumber, user)
                : new CheckingAccount(nextAccountNumber, user);

        accounts.put(nextAccountNumber, acc);
        System.out.println("Account create with number: " + nextAccountNumber);
        nextAccountNumber++;
    }

    @Override
    public void deposit(int accNumber, double amount) {
        Account acc = accounts.get(accNumber);
        if (acc != null) {
            acc.deposit(amount);
            System.out.println("Deposited: " + amount);
        }
    }

    @Override
    public void withdraw(int accNumber, double amount) {
        Account acc = accounts.get(accNumber);
        if (acc != null)
            acc.withdraw(amount);
    }

    @Override
    public void showAccount(int accNumber) {
        Account acc = accounts.get(accNumber);
        if (acc != null) {
            System.out.println("Account No: " + acc.getAccountNumber());
            System.out.println("User: " + acc.getUser().geName());
            System.out.println("Balance: " + acc.getBalance());
        }
    }

    @Override
    public void transfer(int from, int to, double amount) {
        Account acc1 = accounts.get(from);
        Account acc2 = accounts.get(to);

        if (acc1 != null && acc2 != null && acc1.getBalance() >= amount) {
            acc1.withdraw(amount);
            acc2.deposit(amount);
            System.out.println("Transferred " + amount);
        } else {
            System.out.println("Transfer failed");
        }
    }

    @Override
    public void showAllAccounts() {
        for (Account acc : accounts.values()) {
            showAccount(acc.getAccountNumber());
            System.out.println("---------");
        }
    }

    public Collection<Account> getAllAccounts() {
        return accounts.values();
    }

}
