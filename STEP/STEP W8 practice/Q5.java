// Problem 5: Abstract Employee Class with Bonus Calculation

abstract class Employee {
    protected String name;
    protected double salary;
    
    // Constructor to initialize values
    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }
    
    // Abstract method calculateBonus()
    public abstract double calculateBonus();
    
    // Non-abstract method displayDetails()
    public void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Salary: $" + salary);
        System.out.println("Bonus: $" + calculateBonus());
    }
}

class Manager extends Employee {
    public Manager(String name, double salary) {
        super(name, salary);
    }
    
    // Implement calculateBonus() -> salary * 0.20
    @Override
    public double calculateBonus() {
        return salary * 0.20;
    }
}

class Developer extends Employee {
    public Developer(String name, double salary) {
        super(name, salary);
    }
    
    // Implement calculateBonus() -> salary * 0.10
    @Override
    public double calculateBonus() {
        return salary * 0.10;
    }
}

public class Q5 {
    public static void main(String[] args) {
        // Create Employee reference -> Manager("Alice", 50000)
        Employee manager = new Manager("Alice", 50000);
        
        // Create Employee reference -> Developer("Bob", 40000)
        Employee developer = new Developer("Bob", 40000);
        
        // Call displayDetails() and calculateBonus() for both
        System.out.println("Manager Details:");
        manager.displayDetails();
        
        System.out.println("\nDeveloper Details:");
        developer.displayDetails();
    }
}