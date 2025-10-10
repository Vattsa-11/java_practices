// Topic 4: Interface Inheritance (Extending Interface)

// Interface Animal
interface Animal {
    void eat();
}

// Interface Pet extending Animal
interface Pet extends Animal {
    void play();
}

// Dog class implementing Pet
class Dog implements Pet {
    private String name;
    
    public Dog(String name) {
        this.name = name;
    }
    
    @Override
    public void eat() {
        System.out.println(name + " is eating dog food");
    }
    
    @Override
    public void play() {
        System.out.println(name + " is playing fetch");
    }
}

// Main class
public class Q4 {
    public static void main(String[] args) {
        Dog dog = new Dog("Bruno");
        dog.eat();
        dog.play();
        
        System.out.println();
        
        // Demonstrating interface inheritance
        Pet pet = new Dog("Max");
        pet.eat();
        pet.play();
    }
}
