public class Animal {
    protected String species;
    protected String habitat;
    protected int lifespan;
    protected boolean isWildlife;
    
    public Animal(String species, String habitat, int lifespan, boolean isWildlife) {
        this.species = species;
        this.habitat = habitat;
        this.lifespan = lifespan;
        this.isWildlife = isWildlife;
        System.out.println("Animal constructor: Creating " + species);
    }
    
    public void eat() {
        System.out.println("Animal is eating");
    }
    
    public void sleep() {
        System.out.println("Animal is sleeping");
    }
    
    public void move() {
        System.out.println("Animal is moving");
    }
    
    public String getAnimalInfo() {
        return String.format("Species: %s, Habitat: %s, Lifespan: %d years, Wildlife: %s",
                species, habitat, lifespan, isWildlife);
    }
}

class Mammal extends Animal {
    protected String furColor;
    protected boolean hasWarmBlood;
    protected int gestationPeriod;
    
    public Mammal(String species, String habitat, int lifespan, boolean isWildlife,
                  String furColor, int gestationPeriod) {
        super(species, habitat, lifespan, isWildlife);
        this.furColor = furColor;
        this.hasWarmBlood = true; // Always true for mammals
        this.gestationPeriod = gestationPeriod;
        System.out.println("Mammal constructor: Adding mammal traits");
    }
    
    @Override
    public void move() {
        super.move();
        System.out.println("Mammal is walking/running");
    }
    
    public void nurse() {
        System.out.println("Mammal is nursing offspring");
    }
    
    public void regulateTemperature() {
        System.out.println("Maintaining body temperature");
    }
}

class Dog extends Mammal {
    private String breed;
    private boolean isDomesticated;
    private int loyaltyLevel;
    private String favoriteActivity;
    
    // Constructor 1: Basic dog with minimal parameters
    public Dog(String breed) {
        super("Canis lupus familiaris", "Domestic", 12, false, "Brown", 63);
        this.breed = breed;
        this.isDomesticated = true;
        this.loyaltyLevel = 7;
        this.favoriteActivity = "Playing fetch";
    }
    
    // Constructor 2: Detailed dog with all parameters
    public Dog(String species, String habitat, int lifespan, boolean isWildlife,
               String furColor, int gestationPeriod, String breed, boolean isDomesticated,
               int loyaltyLevel, String favoriteActivity) {
        super(species, habitat, lifespan, isWildlife, furColor, gestationPeriod);
        this.breed = breed;
        this.isDomesticated = isDomesticated;
        this.loyaltyLevel = loyaltyLevel;
        this.favoriteActivity = favoriteActivity;
        System.out.println("Dog constructor: Creating " + breed + " dog");
    }
    
    // Constructor 3: Copy constructor
    public Dog(Dog source) {
        this(source.species, source.habitat, source.lifespan, source.isWildlife,
             source.furColor, source.gestationPeriod, source.breed, source.isDomesticated,
             source.loyaltyLevel, source.favoriteActivity);
    }
    
    @Override
    public void eat() {
        super.eat();
        System.out.println("Dog is wagging tail while eating");
    }
    
    @Override
    public void move() {
        System.out.println("Dog is running and playing");
    }
    
    @Override
    public void sleep() {
        System.out.println("Dog is sleeping in doghouse");
    }
    
    public void bark() {
        System.out.println("Woof! Woof!");
    }
    
    public void fetch() {
        System.out.println("Dog is fetching the ball");
    }
    
    public void showLoyalty() {
        System.out.println("Dog's loyalty level: " + loyaltyLevel + "/10");
    }
    
    public void demonstrateInheritance() {
        System.out.println("\nDemonstrating inheritance chain:");
        // Animal level methods
        eat();
        sleep();
        move();
        System.out.println(getAnimalInfo());
        
        // Mammal level methods
        nurse();
        regulateTemperature();
        
        // Dog level methods
        bark();
        fetch();
        showLoyalty();
    }
    
    public static void main(String[] args) {
        // Test constructor chaining
        System.out.println("\nCreating dog with basic constructor:");
        Dog dog1 = new Dog("Labrador");
        
        System.out.println("\nCreating dog with detailed constructor:");
        Dog dog2 = new Dog("Canis lupus familiaris", "Home", 15, false,
                          "Golden", 63, "Golden Retriever", true, 9, "Swimming");
        
        System.out.println("\nCreating dog using copy constructor:");
        Dog dog3 = new Dog(dog2);
        
        // Test method overriding across levels
        System.out.println("\nTesting method overriding:");
        dog1.move();  // Will use Dog's version
        dog1.eat();   // Will use Dog's version with super call
        
        // Test access to inherited members
        System.out.println("\nAccessing inherited members:");
        System.out.println(dog1.getAnimalInfo());
        dog1.regulateTemperature();
        
        // Demonstrate instanceof
        System.out.println("\nTesting instanceof:");
        System.out.println("dog1 instanceof Dog: " + (dog1 instanceof Dog));
        System.out.println("dog1 instanceof Mammal: " + (dog1 instanceof Mammal));
        System.out.println("dog1 instanceof Animal: " + (dog1 instanceof Animal));
        
        // Demonstrate inheritance chain
        dog1.demonstrateInheritance();
    }
}
