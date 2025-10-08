// Problem 5: Math Operations Inheritance

class BasicMath {
    // Overloaded calculate methods with different parameters
    public int calculate(int a, int b) {
        System.out.println("BasicMath: Adding " + a + " + " + b);
        return a + b;
    }
    
    public double calculate(double a, double b) {
        System.out.println("BasicMath: Adding " + a + " + " + b);
        return a + b;
    }
    
    public int calculate(int a, int b, int c) {
        System.out.println("BasicMath: Adding " + a + " + " + b + " + " + c);
        return a + b + c;
    }
    
    public int calculate(String operation, int a, int b) {
        System.out.println("BasicMath: " + operation + " operation on " + a + " and " + b);
        switch(operation.toLowerCase()) {
            case "add": return a + b;
            case "subtract": return a - b;
            case "multiply": return a * b;
            case "divide": return (b != 0) ? a / b : 0;
            default: return 0;
        }
    }
}

class AdvancedMath extends BasicMath {
    // Inherited all overloaded methods from BasicMath
    
    // Additional overloaded calculate methods
    public double calculate(double a, double b, double c) {
        System.out.println("AdvancedMath: Adding three doubles " + a + " + " + b + " + " + c);
        return a + b + c;
    }
    
    public int calculate(int base, int exponent, String operation) {
        if (operation.equals("power")) {
            System.out.println("AdvancedMath: " + base + " to the power of " + exponent);
            return (int) Math.pow(base, exponent);
        }
        return 0;
    }
    
    public double calculate(double radius, String shape) {
        if (shape.equals("circle")) {
            System.out.println("AdvancedMath: Area of circle with radius " + radius);
            return Math.PI * radius * radius;
        } else if (shape.equals("sphere")) {
            System.out.println("AdvancedMath: Volume of sphere with radius " + radius);
            return (4.0/3.0) * Math.PI * radius * radius * radius;
        }
        return 0.0;
    }
    
    public int[] calculate(int[] numbers, String operation) {
        System.out.println("AdvancedMath: Array operation - " + operation);
        int[] result = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            if (operation.equals("square")) {
                result[i] = numbers[i] * numbers[i];
            } else if (operation.equals("double")) {
                result[i] = numbers[i] * 2;
            } else {
                result[i] = numbers[i];
            }
        }
        return result;
    }
}

public class Problem5 {
    public static void main(String[] args) {
        BasicMath basic = new BasicMath();
        AdvancedMath advanced = new AdvancedMath();
        
        System.out.println("=== BasicMath Operations ===");
        System.out.println("Result: " + basic.calculate(5, 3));
        System.out.println("Result: " + basic.calculate(5.5, 3.2));
        System.out.println("Result: " + basic.calculate(1, 2, 3));
        System.out.println("Result: " + basic.calculate("multiply", 4, 6));
        
        System.out.println("\n=== AdvancedMath Operations ===");
        // Using inherited methods
        System.out.println("Result: " + advanced.calculate(10, 20));
        System.out.println("Result: " + advanced.calculate("divide", 15, 3));
        
        // Using new overloaded methods
        System.out.println("Result: " + advanced.calculate(1.1, 2.2, 3.3));
        System.out.println("Result: " + advanced.calculate(2, 3, "power"));
        System.out.println("Result: " + advanced.calculate(5.0, "circle"));
        
        int[] numbers = {1, 2, 3, 4, 5};
        int[] squared = advanced.calculate(numbers, "square");
        System.out.print("Squared array: ");
        for (int num : squared) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}