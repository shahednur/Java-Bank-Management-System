import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import impl.SimpleBank;

public class MainUI extends JFrame {
    private SimpleBank bank;

    public MainUI() {
        bank = new SimpleBank();
        setTitle("Java Bank System");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Top menu buttons
        JPanel panel = new JPanel();
        JButton createBtn = new JButton("Create Account");
        JButton depositBtn = new JButton("Deposite");
        JButton showBtn = new JButton("Show All Accounts");

        panel.add(createBtn);
        panel.add(depositBtn);
        panel.add(showBtn);

        add(panel, BorderLayout.NORTH);

        JTextArea output = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(output);
        add(scrollPane, BorderLayout.CENTER);

        // Create Account
        createBtn.addActionListener(e -> {
            String name = JOptionPane.showInputDialog("Enter name:");
            int age = Integer.parseInt(JOptionPane.showInputDialog("Enter age:"));
            String type = JOptionPane.showInputDialog("Type (savings/checking)");
            bank.createAccount(name, age, type);
            output.append("Account created for " + name + "\n");
        });

        // Deposit
        depositBtn.addActionListener(e -> {
            int acc = Integer.parseInt(JOptionPane.showInputDialog("Account Number: "));
            double amount = Double.parseDouble(JOptionPane.showInputDialog("Deposit Amount: "));
            bank.deposit(acc, amount);
            output.append("Deposited " + amount + "to account " + acc + "\n");
        });

        // Show All
        showBtn.addActionListener(e -> {
            output.append("----- All Accounts -----\n");
            bank.getAllAccounts().forEach(acc -> {
                output.append("Acc: " + acc.getAccountNumber() + " | " + acc.getUser().geName() + " | Balance: "
                        + acc.getBalance());
            });
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainUI().setVisible(true));
    }
}
