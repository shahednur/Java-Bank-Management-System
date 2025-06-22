import impl.SimpleBank;
import services.BankService;

public class Main {
    public static void main(String[] args) {
        BankService bank = new SimpleBank();

        bank.createAccount("Ahiyan", 21, "savings");
        bank.createAccount("Shahed", 25, "checking");

        bank.deposit(1001, 1000);
        bank.withdraw(1001, 200);
        bank.showAccount(1001);

        bank.transfer(1001, 1002, 300);
        bank.showAllAccounts();
    }
}
