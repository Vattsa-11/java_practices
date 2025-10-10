class Outer {
    private String message;
    
    public Outer(String message) {
        this.message = message;
    }
    
    // Non-static Member Inner Class
    class Inner {
        public void display() {
            // Inner class can directly access outer class members (even private)
            System.out.println("Message from Inner class: " + message);
        }
        
        public void displayWithDetails() {
            System.out.println("Outer class message: " + message);
            System.out.println("This is a member inner class!");
        }
    }
    
    // Method to create and return Inner class object
    public Inner createInner() {
        return new Inner();
    }
}

public class Lab5_InnerClass {
    public static void main(String[] args) {
        // Create an object of Outer class
        Outer outer1 = new Outer("Hello from Outer class!");
        
        // Method 1: Create Inner class object using Outer.Inner syntax
        Outer.Inner inner1 = outer1.new Inner();
        inner1.display();
        
        System.out.println();
        
        // Create another Outer object with different message
        Outer outer2 = new Outer("Welcome to Inner Classes!");
        
        // Method 2: Create Inner class object using the outer class method
        Outer.Inner inner2 = outer2.createInner();
        inner2.displayWithDetails();
        
        System.out.println();
        
        // Demonstrate multiple inner objects from same outer object
        Outer outer3 = new Outer("Java Inner Class Demo");
        Outer.Inner inner3a = outer3.new Inner();
        Outer.Inner inner3b = outer3.new Inner();
        
        System.out.println("--- Multiple Inner Objects ---");
        inner3a.display();
        inner3b.display();
    }
}
