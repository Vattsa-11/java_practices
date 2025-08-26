public class BankAccount {
    private static String bankName;
    private static int totalAccounts = 0;
    private static double interestRate;
    
    private String accountNumber;
    private String accountHolder;
    private double balance;
    
    public BankAccount(String accountNumber, String accountHolder, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
        totalAccounts++;
    }
    
    public static void setBankName(String name) {
        bankName = name;
    }
    
    public static void setInterestRate(double rate) {
        interestRate = rate;
    }
    
    public static int getTotalAccounts() {
        return totalAccounts;
    }
    
    public static void displayBankInfo() {
        System.out.println("Bank Name: " + bankName);
        System.out.println("Total Accounts: " + totalAccounts);
    }
    
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount);
        }
    }
    
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: $" + amount);
        } else {
            System.out.println("Insufficient funds");
        }
    }
    
    public double calculateInterest() {
        return balance * interestRate;
    }
    
    public void displayAccountInfo() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Balance: $" + balance);
        System.out.println("Interest Amount: $" + calculateInterest());
    }
    
    public static void main(String[] args) {
        BankAccount.setBankName("Global Bank");
        BankAccount.setInterestRate(0.05);
        
        BankAccount account1 = new BankAccount("A001", "John Smith", 1000);
        BankAccount account2 = new BankAccount("A002", "Jane Doe", 2000);
        
        System.out.println("Bank info through class:");
        BankAccount.displayBankInfo();
        
        System.out.println("\nBank info through object:");
        account1.displayAccountInfo();
        
        System.out.println("\nAccount operations:");
        account1.deposit(500);
        account1.withdraw(200);
        
        System.out.println("\nUpdated account info:");
        account1.displayAccountInfo();
        
        System.out.println("\nSecond account info:");
        account2.displayAccountInfo();
        
        System.out.println("\nTotal accounts: " + BankAccount.getTotalAccounts());
    }
}