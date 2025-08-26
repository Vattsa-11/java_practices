public class Q1Procedural {

    public static double totalBalance(double[] bal){
        double totalBalance = 0; 
        for (double b: bal){
            totalBalance += b;
        }
        return totalBalance;
    }
   public static void main(String[] args){
        double[] balance = {10000.39, 1020.50, 750.75, 800.99, 120.30, 401.55};
        
        System.out.printf("Total Balance = %.2f",  totalBalance(balance));
    }
}
