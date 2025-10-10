// Interface for anonymous inner class
interface MathOperation {
    int perform(int a, int b);
}

class Calculator {
    
    // 1. Static Nested Class - Operation for addition
    static class Operation {
        public int add(int a, int b) {
            return a + b;
        }
    }
    
    // 2. Method with Local Inner Class for subtraction
    public void performSubtraction(int a, int b) {
        // Local Inner Class defined inside a method
        class Subtraction {
            public int subtract() {
                return a - b;
            }
        }
        
        Subtraction sub = new Subtraction();
        System.out.println("Subtraction (Local Inner Class): " + a + " - " + b + " = " + sub.subtract());
    }
    
    // 3. Method demonstrating Anonymous Inner Class for multiplication
    public void performMultiplication(int a, int b) {
        // Anonymous Inner Class implementing MathOperation interface
        MathOperation multiply = new MathOperation() {
            @Override
            public int perform(int x, int y) {
                return x * y;
            }
        };
        
        System.out.println("Multiplication (Anonymous Inner Class): " + a + " * " + b + " = " + multiply.perform(a, b));
    }
}

public class Lab6_Calculator {
    public static void main(String[] args) {
        int num1 = 20;
        int num2 = 5;
        
        System.out.println("=== Calculator Operations ===\n");
        
        // 1. Using Static Nested Class for Addition
        Calculator.Operation operation = new Calculator.Operation();
        int additionResult = operation.add(num1, num2);
        System.out.println("Addition (Static Nested Class): " + num1 + " + " + num2 + " = " + additionResult);
        
        // 2. Using Local Inner Class for Subtraction
        Calculator calc = new Calculator();
        calc.performSubtraction(num1, num2);
        
        // 3. Using Anonymous Inner Class for Multiplication
        calc.performMultiplication(num1, num2);
        
        System.out.println("\n=== Additional Operations ===\n");
        
        // Another example with different numbers
        int num3 = 15;
        int num4 = 3;
        
        System.out.println("Addition: " + num3 + " + " + num4 + " = " + operation.add(num3, num4));
        calc.performSubtraction(num3, num4);
        calc.performMultiplication(num3, num4);
        
        // Demonstrating another anonymous inner class for division
        System.out.println("\n=== Bonus: Division using Anonymous Inner Class ===");
        MathOperation divide = new MathOperation() {
            @Override
            public int perform(int x, int y) {
                return y != 0 ? x / y : 0;
            }
        };
        System.out.println("Division: " + num1 + " / " + num2 + " = " + divide.perform(num1, num2));
    }
}
