// Topic 6: Multiple Interfaces with Same Method Name

// Interface Printer
interface Printer {
    void connect();
}

// Interface Scanner
interface Scanner {
    void connect();
}

// AllInOneMachine class implementing both interfaces
class AllInOneMachine implements Printer, Scanner {
    
    @Override
    public void connect() {
        System.out.println("All-in-One Machine connected (Printer + Scanner)");
    }
    
    public void print() {
        System.out.println("Printing document...");
    }
    
    public void scan() {
        System.out.println("Scanning document...");
    }
}

// Main class
public class Q6 {
    public static void main(String[] args) {
        AllInOneMachine machine = new AllInOneMachine();
        machine.connect();
        machine.print();
        machine.scan();
        
        System.out.println();
        
        // Testing with Printer reference
        Printer p = new AllInOneMachine();
        p.connect();
        
        System.out.println();
        
        // Testing with Scanner reference
        Scanner s = new AllInOneMachine();
        s.connect();
    }
}
