public class Q3 {
    static class BankAccount {
        private 
        String accountNumber;
        String accountHolder;
        double balance; 

        public 
        BankAccount(String accNum, String accHolder, double bal) {
            accountNumber = accNum;
            accountHolder = accHolder;
            balance = bal;
        }

        void displayBalance() {
            System.out.println("Account Number: " + accountNumber);
            System.out.println("Account Holder: " + accountHolder);
            System.out.println("Current Balance: " + balance);
        }
    }

    public static void main(String[] args) {
        BankAccount b1 = new BankAccount("123456789", "Alice Johnson", 1500.75);
        BankAccount b2 = new BankAccount("987654321", "Bob Smith", 2500.50);

        b1.displayBalance();
        b2.displayBalance();
    }
}
