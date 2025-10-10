class Payment {
    public void pay() {
        System.out.println("Generic payment");
    }
}

class CreditCardPayment extends Payment {
    @Override
    public void pay() {
        System.out.println("Paid using Credit Card");
    }
}

class WalletPayment extends Payment {
    @Override
    public void pay() {
        System.out.println("Paid using Wallet");
    }
}

public class Q3_PaymentGateway {
    public static void main(String[] args) {
        // 1. Create array of Payment references
        Payment[] payments = new Payment[3];
        payments[0] = new CreditCardPayment();
        payments[1] = new WalletPayment();
        payments[2] = new CreditCardPayment();
        
        // 2. Loop, call getClass().getSimpleName(), and pay()
        for (Payment payment : payments) {
            System.out.print("Payment Type: " + payment.getClass().getSimpleName() + " -> ");
            payment.pay();
        }
    }
}
