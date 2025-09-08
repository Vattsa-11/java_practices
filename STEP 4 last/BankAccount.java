// Problem 2: Bank Account System
import java.util.Random;

public class BankAccount {
    String accountHolder;
    int accountNumber;
    double balance;

    // Default constructor
    public BankAccount() {
        this("Unknown", 0, 0.0);
    }
    // Constructor with name
    public BankAccount(String accountHolder) {
        this(accountHolder, new Random().nextInt(90000) + 10000, 0.0);
    }
    // Constructor with name and initial balance
    public BankAccount(String accountHolder, double balance) {
        this(accountHolder, new Random().nextInt(90000) + 10000, balance);
    }
    // Full constructor
    public BankAccount(String accountHolder, int accountNumber, double balance) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
    public void deposit(double amount) {
        balance += amount;
    }
    public void withdraw(double amount) {
        if (amount <= balance) balance -= amount;
    }
    public void displayAccount() {
        System.out.printf("Holder: %s | Account#: %d | Balance: %.2f\n", accountHolder, accountNumber, balance);
    }
    public static void main(String[] args) {
        BankAccount a1 = new BankAccount();
        BankAccount a2 = new BankAccount("Alice");
        BankAccount a3 = new BankAccount("Bob", 500.0);
        a2.deposit(200);
        a3.withdraw(100);
        a1.displayAccount();
        a2.displayAccount();
        a3.displayAccount();
    }
}
