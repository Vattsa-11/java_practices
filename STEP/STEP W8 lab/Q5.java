// LAB PROBLEM 5: Abstract Animal and Soundable Interface

// Interface Soundable
interface Soundable {
    void makeSound();
}

// Abstract class Animal
abstract class Animal {
    protected String name;
    protected String habitat;
    
    abstract void eat();
}

// Dog class extending Animal and implementing Soundable
class Dog extends Animal implements Soundable {
    
    public Dog(String name, String habitat) {
        this.name = name;
        this.habitat = habitat;
    }
    
    @Override
    void eat() {
        System.out.println(name + " eats meat and dog food");
    }
    
    @Override
    public void makeSound() {
        System.out.println(name + " says: Woof! Woof!");
    }
    
    public void displayInfo() {
        System.out.println("Dog Name: " + name);
        System.out.println("Habitat: " + habitat);
    }
}

// Main class
public class Q5 {
    public static void main(String[] args) {
        Dog dog = new Dog("Buddy", "House");
        dog.displayInfo();
        dog.eat();
        dog.makeSound();
    }
}
