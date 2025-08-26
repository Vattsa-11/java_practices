public class Q1OOPS {

    static class Account{
        private
        double balance = 0;
        public
        Account(double b){
            balance += b;
        }
        double balance(){
            return balance;
        }
    }

    static class Bank{
        private
        Account[] acc;
        public 
        Bank(Account[] ac){
            this.acc = ac;
        }
        double getTotalBalance(){
            double total = 0;
            for (Account a : acc){
                total += a.balance();
            } 
            return total;
        }
    }
    public static void main(String[] args){
        Account[] savings = {
            new Account(500.75),
            new Account(120.5),
            new Account(200.7),
            new Account(63.71),
            new Account(700.70)
        };
        Bank b = new Bank(savings);
        System.out.printf("Total Balance: %.2f", b.getTotalBalance());
    }
}
