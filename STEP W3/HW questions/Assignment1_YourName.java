/**
 * Assignment 1: Personal Finance Manager
 * Author: YourName
 * Date: 2025-09-01
 *
 * Simple personal finance management system demonstrating OOP concepts.
 */
class PersonalAccount {
    private String accountHolderName;
    private String accountNumber;
    private double currentBalance;
    private double totalIncome;
    private double totalExpenses;

    private static int totalAccounts = 0;
    private static String bankName = "Default Bank";
    public static String getBankName() {
        return bankName;
    }

    public PersonalAccount(String name) {
        this.accountHolderName = name;
        this.accountNumber = generateAccountNumber();
        this.currentBalance = 0.0;
        this.totalIncome = 0.0;
        this.totalExpenses = 0.0;
        totalAccounts++;
    }

    public void addIncome(double amount, String description) {
        if (amount > 0) {
            totalIncome += amount;
            currentBalance += amount;
            System.out.println(description + ": Income added: " + amount);
        }
    }

    public void addExpense(double amount, String description) {
        if (amount > 0 && amount <= currentBalance) {
            totalExpenses += amount;
            currentBalance -= amount;
            System.out.println(description + ": Expense deducted: " + amount);
        } else {
            System.out.println("Expense failed: Insufficient balance or invalid amount.");
        }
    }

    public double calculateSavings() {
        return totalIncome - totalExpenses;
    }

    public void displayAccountSummary() {
        System.out.println("--- Account Summary ---");
        System.out.println("Bank Name: " + bankName);
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Current Balance: " + currentBalance);
        System.out.println("Total Income: " + totalIncome);
        System.out.println("Total Expenses: " + totalExpenses);
        System.out.println("Savings: " + calculateSavings());
        System.out.println();
    }

    public static void setBankName(String name) {
        bankName = name;
    }

    public static int getTotalAccounts() {
        return totalAccounts;
    }

    public static String generateAccountNumber() {
        return "ACCT" + (1000 + totalAccounts);
    }
}

public class Assignment1_YourName {
    public static void main(String[] args) {
        PersonalAccount.setBankName("Future Bank");
        PersonalAccount acc1 = new PersonalAccount("Alice");
        PersonalAccount acc2 = new PersonalAccount("Bob");
        PersonalAccount acc3 = new PersonalAccount("Charlie");

        acc1.addIncome(1000, "Salary");
        acc1.addExpense(200, "Groceries");
        acc1.addExpense(100, "Transport");
        acc1.displayAccountSummary();

        acc2.addIncome(1500, "Freelance");
        acc2.addExpense(500, "Rent");
        acc2.displayAccountSummary();

        acc3.addIncome(2000, "Business");
        acc3.addExpense(300, "Shopping");
        acc3.addExpense(100, "Dining");
        acc3.displayAccountSummary();

        System.out.println("Total Accounts: " + PersonalAccount.getTotalAccounts());
    System.out.println("Bank Name (shared): " + PersonalAccount.getBankName());
    }
}
