// Topic 1: Abstract Class with Abstract and Concrete Methods

// Abstract class Shape
abstract class Shape {
    abstract void area();
    abstract void perimeter();
    
    // Concrete method
    void displayInfo() {
        System.out.println("This is a shape");
    }
}

// Circle class
class Circle extends Shape {
    private double radius;
    
    public Circle(double radius) {
        this.radius = radius;
    }
    
    @Override
    void area() {
        double area = Math.PI * radius * radius;
        System.out.println("Area of Circle: " + area);
    }
    
    @Override
    void perimeter() {
        double perimeter = 2 * Math.PI * radius;
        System.out.println("Perimeter of Circle: " + perimeter);
    }
}

// Rectangle class
class Rectangle extends Shape {
    private double length;
    private double width;
    
    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }
    
    @Override
    void area() {
        double area = length * width;
        System.out.println("Area of Rectangle: " + area);
    }
    
    @Override
    void perimeter() {
        double perimeter = 2 * (length + width);
        System.out.println("Perimeter of Rectangle: " + perimeter);
    }
}

// Main class
public class Q1 {
    public static void main(String[] args) {
        Circle circle = new Circle(5.0);
        circle.displayInfo();
        circle.area();
        circle.perimeter();
        
        System.out.println();
        
        Rectangle rectangle = new Rectangle(4.0, 6.0);
        rectangle.displayInfo();
        rectangle.area();
        rectangle.perimeter();
    }
}
