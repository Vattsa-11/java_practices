// LAB PROBLEM 2: Abstract Shape and Drawable Interface

// Interface Drawable
interface Drawable {
    void draw();
}

// Abstract class Shape
abstract class Shape {
    protected double area;
    protected double perimeter;
    
    abstract void calculateArea();
    abstract void calculatePerimeter();
}

// Circle class extending Shape and implementing Drawable
class Circle extends Shape implements Drawable {
    private double radius;
    
    public Circle(double radius) {
        this.radius = radius;
    }
    
    @Override
    void calculateArea() {
        area = Math.PI * radius * radius;
        System.out.println("Area of Circle: " + area);
    }
    
    @Override
    void calculatePerimeter() {
        perimeter = 2 * Math.PI * radius;
        System.out.println("Perimeter of Circle: " + perimeter);
    }
    
    @Override
    public void draw() {
        System.out.println("Drawing a circle with radius: " + radius);
    }
}

// Main class
public class Q2 {
    public static void main(String[] args) {
        Circle circle = new Circle(5.0);
        circle.draw();
        circle.calculateArea();
        circle.calculatePerimeter();
    }
}
