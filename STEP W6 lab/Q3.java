class Bird {
    protected String name;
    
    public Bird(String name) {
        this.name = name;
    }
    
    public void fly() {
        System.out.println("Bird is flying");
    }
}

class Penguin extends Bird {
    public Penguin() {
        super("Penguin");
    }
    
    @Override
    public void fly() {
        System.out.println("Penguin cannot fly, but can swim!");
    }
}

class Eagle extends Bird {
    public Eagle() {
        super("Eagle");
    }
    
    @Override
    public void fly() {
        System.out.println("Eagle soars high in the sky!");
    }
}

public class Q3 {
    public static void main(String[] args) {
        // Create array of Bird references
        Bird[] birds = new Bird[3];
        birds[0] = new Bird("Generic Bird");
        birds[1] = new Penguin();
        birds[2] = new Eagle();
        
        // Test polymorphic behavior
        System.out.println("Testing flying behavior:");
        for (Bird bird : birds) {
            System.out.print(bird.name + ": ");
            bird.fly();
        }
    }
}