// PROBLEM 7: Banking Transaction System - Multiple Polymorphism Integration

class BankAccount {
    protected String accountNumber;
    protected String accountHolder;
    protected double balance;

    public BankAccount(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    // Method Overloading - different transaction types
    public void processTransaction(double amount) {
        System.out.println("Processing basic transaction: $" + amount);
    }

    public void processTransaction(double amount, String transactionType) {
        System.out.println("Processing " + transactionType + " transaction: $" + amount);
    }

    public void processTransaction(double amount, String transactionType, String description) {
        System.out.println("Processing " + transactionType + " transaction: $" + amount);
        System.out.println("Description: " + description);
    }

    // Method Overriding - account-specific processing
    public void calculateFees() {
        System.out.println("Calculating standard fees for account: " + accountNumber);
    }

    public void displayAccountInfo() {
        System.out.println("\nAccount: " + accountNumber);
        System.out.println("Holder: " + accountHolder);
        System.out.println("Balance: $" + balance);
    }
}

class SavingsAccount extends BankAccount {
    private double interestRate;
    private double withdrawalLimit;

    public SavingsAccount(String accountNumber, String accountHolder, double balance, 
                         double interestRate, double withdrawalLimit) {
        super(accountNumber, accountHolder, balance);
        this.interestRate = interestRate;
        this.withdrawalLimit = withdrawalLimit;
    }

    public void calculateInterest() {
        double interest = balance * interestRate / 100;
        System.out.println("Interest earned: $" + interest);
        balance += interest;
    }

    @Override
    public void calculateFees() {
        System.out.println("Savings account - No monthly fees");
    }

    @Override
    public void processTransaction(double amount) {
        if (amount <= withdrawalLimit) {
            super.processTransaction(amount);
            System.out.println("Withdrawal approved (within limit)");
        } else {
            System.out.println("Withdrawal exceeds limit of $" + withdrawalLimit);
        }
    }

    @Override
    public void displayAccountInfo() {
        super.displayAccountInfo();
        System.out.println("Type: Savings Account");
        System.out.println("Interest Rate: " + interestRate + "%");
        System.out.println("Withdrawal Limit: $" + withdrawalLimit);
    }
}

class CheckingAccount extends BankAccount {
    private double overdraftLimit;
    private double monthlyFee;

    public CheckingAccount(String accountNumber, String accountHolder, double balance,
                          double overdraftLimit, double monthlyFee) {
        super(accountNumber, accountHolder, balance);
        this.overdraftLimit = overdraftLimit;
        this.monthlyFee = monthlyFee;
    }

    public void checkOverdraftProtection(double amount) {
        if (balance - amount < 0 && Math.abs(balance - amount) <= overdraftLimit) {
            System.out.println("Overdraft protection activated");
        }
    }

    @Override
    public void calculateFees() {
        System.out.println("Monthly maintenance fee: $" + monthlyFee);
        balance -= monthlyFee;
    }

    @Override
    public void displayAccountInfo() {
        super.displayAccountInfo();
        System.out.println("Type: Checking Account");
        System.out.println("Overdraft Limit: $" + overdraftLimit);
        System.out.println("Monthly Fee: $" + monthlyFee);
    }
}

class InvestmentAccount extends BankAccount {
    private String portfolioType;
    private String riskLevel;

    public InvestmentAccount(String accountNumber, String accountHolder, double balance,
                            String portfolioType, String riskLevel) {
        super(accountNumber, accountHolder, balance);
        this.portfolioType = portfolioType;
        this.riskLevel = riskLevel;
    }

    public void assessRisk() {
        System.out.println("Risk Assessment - Level: " + riskLevel);
        System.out.println("Portfolio Type: " + portfolioType);
    }

    public void managePortfolio() {
        System.out.println("Managing " + portfolioType + " portfolio");
    }

    @Override
    public void calculateFees() {
        double managementFee = balance * 0.01; // 1% management fee
        System.out.println("Investment management fee: $" + managementFee);
        balance -= managementFee;
    }

    @Override
    public void displayAccountInfo() {
        super.displayAccountInfo();
        System.out.println("Type: Investment Account");
        System.out.println("Portfolio: " + portfolioType);
        System.out.println("Risk Level: " + riskLevel);
    }
}

class BusinessAccount extends BankAccount {
    private String businessName;
    private boolean merchantServices;

    public BusinessAccount(String accountNumber, String accountHolder, double balance,
                          String businessName, boolean merchantServices) {
        super(accountNumber, accountHolder, balance);
        this.businessName = businessName;
        this.merchantServices = merchantServices;
    }

    public void processBulkTransactions(int count, double totalAmount) {
        System.out.println("Processing bulk transaction");
        System.out.println("Number of transactions: " + count);
        System.out.println("Total amount: $" + totalAmount);
    }

    @Override
    public void calculateFees() {
        double baseFee = 25.0;
        double merchantFee = merchantServices ? 15.0 : 0.0;
        System.out.println("Business account fee: $" + (baseFee + merchantFee));
        balance -= (baseFee + merchantFee);
    }

    @Override
    public void displayAccountInfo() {
        super.displayAccountInfo();
        System.out.println("Type: Business Account");
        System.out.println("Business: " + businessName);
        System.out.println("Merchant Services: " + (merchantServices ? "Yes" : "No"));
    }
}

public class Problem7 {
    public static void main(String[] args) {
        // Mixed account portfolio
        BankAccount[] accounts = new BankAccount[4];
        
        accounts[0] = new SavingsAccount("SAV001", "John Doe", 5000, 3.5, 1000);
        accounts[1] = new CheckingAccount("CHK001", "Jane Smith", 2000, 500, 10);
        accounts[2] = new InvestmentAccount("INV001", "Bob Johnson", 50000, "Balanced", "Medium");
        accounts[3] = new BusinessAccount("BUS001", "Tech Corp", 100000, "Tech Solutions", true);

        System.out.println("===== BANKING TRANSACTION SYSTEM =====");

        // Display all accounts
        for (BankAccount account : accounts) {
            account.displayAccountInfo();
        }

        System.out.println("\n===== PROCESSING TRANSACTIONS =====");
        
        // Method overloading - different transaction types
        accounts[0].processTransaction(500);
        accounts[1].processTransaction(300, "Withdrawal");
        accounts[2].processTransaction(1000, "Investment", "Stock purchase");

        System.out.println("\n===== CALCULATING FEES =====");
        
        // Polymorphic fee calculation
        for (BankAccount account : accounts) {
            System.out.println("\n" + account.accountNumber + ":");
            account.calculateFees();
        }

        System.out.println("\n===== SAFE CASTING - SPECIFIC OPERATIONS =====");
        
        // Safe downcasting for account-specific operations
        for (BankAccount account : accounts) {
            if (account instanceof SavingsAccount) {
                SavingsAccount savings = (SavingsAccount) account;
                System.out.println("\nSavings Account Operations:");
                savings.calculateInterest();
            } else if (account instanceof InvestmentAccount) {
                InvestmentAccount investment = (InvestmentAccount) account;
                System.out.println("\nInvestment Account Operations:");
                investment.assessRisk();
                investment.managePortfolio();
            } else if (account instanceof BusinessAccount) {
                BusinessAccount business = (BusinessAccount) account;
                System.out.println("\nBusiness Account Operations:");
                business.processBulkTransactions(50, 25000);
            }
        }
    }
}
