import java.time.LocalDateTime;
import java.util.*;

// Immutable Transaction class
final class Transaction {
    private final String transactionId;
    private final LocalDateTime timestamp;
    private final double amount;
    private final String transactionType;
    private final String description;
    private final String fromAccount;
    private final String toAccount;

    public Transaction(String fromAccount, String toAccount, double amount, 
                      String transactionType, String description) {
        this.transactionId = "TXN-" + UUID.randomUUID().toString().substring(0, 8);
        this.timestamp = LocalDateTime.now();
        this.amount = amount;
        this.transactionType = transactionType;
        this.description = description;
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
    }

    public String getTransactionId() { return transactionId; }
    public LocalDateTime getTimestamp() { return timestamp; }
    public double getAmount() { return amount; }
    public String getTransactionType() { return transactionType; }
    public String getDescription() { return description; }

    public final boolean isValid() {
        return amount > 0 && fromAccount != null;
    }

    public String getFromAccount() {
        return fromAccount;
    }
}

class BankAccount {
    private final String accountNumber;
    private final String accountType;
    private final String ownerId;
    private double balance;
    private String accountStatus;
    private final List<Transaction> transactionHistory;

    public BankAccount(String ownerId, String accountType) {
        this.accountNumber = "ACC-" + UUID.randomUUID().toString().substring(0, 8);
        this.ownerId = ownerId;
        this.accountType = accountType;
        this.balance = 0.0;
        this.accountStatus = "ACTIVE";
        this.transactionHistory = new ArrayList<>();
    }

    // Package-private access for internal operations
    double getInternalBalance() {
        return balance;
    }

    // Public access for limited account information
    public String getPublicAccountInfo() {
        return String.format("Account: XXXX%s, Type: %s, Status: %s",
            accountNumber.substring(accountNumber.length() - 4),
            accountType,
            accountStatus);
    }

    public boolean processTransaction(Transaction txn) {
        if (!txn.isValid()) return false;

        switch (txn.getTransactionType()) {
            case "DEPOSIT":
                balance += txn.getAmount();
                break;
            case "WITHDRAWAL":
                if (balance < txn.getAmount()) return false;
                balance -= txn.getAmount();
                break;
            default:
                return false;
        }

        transactionHistory.add(txn);
        return true;
    }
}

class BankTeller {
    public final String tellerId;
    private final String branch;
    private final List<String> permissions;

    public BankTeller(String tellerId, String branch) {
        this.tellerId = tellerId;
        this.branch = branch;
        this.permissions = Arrays.asList("DEPOSIT", "WITHDRAWAL", "INQUIRY");
    }

    public boolean hasPermission(String operation) {
        return permissions.contains(operation);
    }
}

final class BankingSystem {
    private static final Map<String, BankAccount> accountRegistry = new HashMap<>();
    private static final Map<String, BankTeller> tellerRegistry = new HashMap<>();

    public static boolean processTransaction(Transaction transaction, BankTeller staff) {
        if (!validateStaffPermissions(staff, transaction.getTransactionType())) {
            return false;
        }

        BankAccount account = accountRegistry.get(transaction.getFromAccount());
        if (account == null) return false;

        return account.processTransaction(transaction);
    }

    private static boolean validateStaffPermissions(BankTeller staff, String operation) {
        return staff != null && staff.hasPermission(operation);
    }

    public static void main(String[] args) {
        // Create a bank account
        BankAccount account = new BankAccount("CUST001", "SAVINGS");
        accountRegistry.put(account.getPublicAccountInfo(), account);

        // Create a bank teller
        BankTeller teller = new BankTeller("T001", "MAIN");
        tellerRegistry.put(teller.tellerId, teller);

        // Process some transactions
        Transaction deposit = new Transaction(
            account.getPublicAccountInfo(),
            null,
            1000.0,
            "DEPOSIT",
            "Initial deposit"
        );

        Transaction withdrawal = new Transaction(
            account.getPublicAccountInfo(),
            null,
            500.0,
            "WITHDRAWAL",
            "ATM withdrawal"
        );

        // Execute transactions
        System.out.println("\nProcessing deposit:");
        System.out.println(processTransaction(deposit, teller));
        System.out.println("Account info after deposit:");
        System.out.println(account.getPublicAccountInfo());
        System.out.println("Balance: $" + account.getInternalBalance());

        System.out.println("\nProcessing withdrawal:");
        System.out.println(processTransaction(withdrawal, teller));
        System.out.println("Account info after withdrawal:");
        System.out.println(account.getPublicAccountInfo());
        System.out.println("Balance: $" + account.getInternalBalance());
    }
}
