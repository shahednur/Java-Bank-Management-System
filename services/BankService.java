package services;

public interface BankService {
    void createAccount(String name, int age, String type);

    void deposit(int accNumber, double amount);

    void withdraw(int accNumber, double amount);

    void showAccount(int accNumber);

    void transfer(int from, int to, double amount);

    void showAllAccounts();
}
