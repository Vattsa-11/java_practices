// Problem 8: Virtual Pet Simulator - Complete Polymorphism Mastery
import java.util.*;

// Base Pet class demonstrating inheritance hierarchy
abstract class Pet {
    protected String name;
    protected int age;
    protected int happiness;
    protected int hunger;
    protected int energy;
    protected String species;
    
    public Pet(String name, int age, String species) {
        this.name = name;
        this.age = age;
        this.species = species;
        this.happiness = 50;
        this.hunger = 50;
        this.energy = 50;
    }
    
    // Common method for all pets (inheritance) - same way for all
    public void feed() {
        hunger = Math.max(0, hunger - 30);
        happiness += 10;
        energy += 5;
        System.out.println("🍽️ " + name + " the " + species + " is eating happily!");
        System.out.println("   Hunger reduced, happiness and energy increased!");
    }
    
    // Abstract method to be overridden (method overriding)
    public abstract void play();
    
    // Method overloading - different care options
    public void care() {
        System.out.println("💝 Giving basic care to " + name);
        happiness += 5;
        System.out.println("   Basic happiness boost!");
    }
    
    public void care(String careType) {
        System.out.println("💝 Giving " + careType + " care to " + name);
        switch (careType.toLowerCase()) {
            case "medical":
                happiness += 15;
                energy += 10;
                System.out.println("   Health checkup completed! Feeling much better!");
                break;
            case "grooming":
                happiness += 20;
                System.out.println("   Looking clean and beautiful!");
                break;
            case "exercise":
                energy += 25;
                hunger += 10;
                System.out.println("   Great workout! Feeling energetic but hungry!");
                break;
            default:
                happiness += 5;
                System.out.println("   General care provided!");
        }
    }
    
    public void care(String careType, int duration) {
        System.out.println("💝 Giving " + careType + " care to " + name + " for " + duration + " minutes");
        int multiplier = duration / 10; // Every 10 minutes = 1x effect
        
        switch (careType.toLowerCase()) {
            case "medical":
                happiness += 15 * multiplier;
                energy += 10 * multiplier;
                System.out.println("   Extended medical care - comprehensive health boost!");
                break;
            case "grooming":
                happiness += 20 * multiplier;
                System.out.println("   Thorough grooming session - looking magnificent!");
                break;
            case "exercise":
                energy += 25 * multiplier;
                hunger += 10 * multiplier;
                System.out.println("   Long exercise session - great workout!");
                break;
            case "training":
                happiness += 10 * multiplier;
                energy -= 5 * multiplier;
                System.out.println("   Training session completed - learned new skills!");
                break;
        }
    }
    
    public void displayStatus() {
        System.out.println("📊 " + name + " (" + species + ") Status:");
        System.out.println("   Age: " + age + " | Happiness: " + happiness + "/100");
        System.out.println("   Hunger: " + hunger + "/100 | Energy: " + energy + "/100");
    }
    
    // Getters for safe downcasting checks
    public String getName() { return name; }
    public String getSpecies() { return species; }
}

// Dog class demonstrating method overriding
class Dog extends Pet {
    private boolean hasWalked;
    private String favoriteGame;
    
    public Dog(String name, int age, String favoriteGame) {
        super(name, age, "Dog");
        this.hasWalked = false;
        this.favoriteGame = favoriteGame;
    }
    
    @Override
    public void play() {
        System.out.println("🐕 " + name + " wants to play " + favoriteGame + "!");
        if (favoriteGame.toLowerCase().contains("fetch")) {
            System.out.println("   🎾 Fetching the ball with excitement!");
            System.out.println("   Running back and forth happily!");
        } else if (favoriteGame.toLowerCase().contains("tug")) {
            System.out.println("   🪢 Playing tug of war!");
            System.out.println("   Pulling with all their strength!");
        } else {
            System.out.println("   🎮 Playing their favorite game!");
        }
        happiness += 25;
        energy -= 15;
        hunger += 10;
    }
    
    // Dog-specific methods for downcasting
    public void walk() {
        System.out.println("🚶 Taking " + name + " for a walk!");
        System.out.println("   Exploring the neighborhood, sniffing everything!");
        hasWalked = true;
        happiness += 20;
        energy -= 10;
        hunger += 15;
    }
    
    public void barkAt(String target) {
        System.out.println("🔊 " + name + " is barking at " + target + "!");
        System.out.println("   WOOF WOOF! Protecting the house!");
        energy -= 5;
    }
    
    public boolean needsWalk() {
        return !hasWalked && energy > 20;
    }
}

// Cat class demonstrating method overriding
class Cat extends Pet {
    private int cleanlinessLevel;
    private boolean isHunting;
    
    public Cat(String name, int age) {
        super(name, age, "Cat");
        this.cleanlinessLevel = 80; // Cats are naturally clean
        this.isHunting = false;
    }
    
    @Override
    public void play() {
        System.out.println("🐱 " + name + " is playing in a typical cat way!");
        Random rand = new Random();
        String[] catActivities = {
            "Chasing a laser pointer in circles",
            "Pouncing on invisible prey",
            "Playing with a ball of yarn",
            "Hunting imaginary mice"
        };
        String activity = catActivities[rand.nextInt(catActivities.length)];
        System.out.println("   " + activity + "!");
        System.out.println("   Graceful and independent play style!");
        happiness += 20;
        energy -= 10;
    }
    
    // Cat-specific methods for downcasting
    public void groom() {
        System.out.println("🧼 " + name + " is grooming themselves meticulously!");
        System.out.println("   Licking paws and cleaning fur to perfection!");
        cleanlinessLevel = Math.min(100, cleanlinessLevel + 20);
        happiness += 15;
        energy -= 5;
    }
    
    public void huntMice() {
        System.out.println("🐭 " + name + " is hunting mice!");
        isHunting = true;
        System.out.println("   Stalking silently... pouncing with precision!");
        if (isHunting) {
            System.out.println("   Successfully caught something! Natural instincts satisfied!");
        }
        happiness += 30;
        energy -= 20;
        hunger -= 10;
        isHunting = false; // Hunt completed
    }
    
    public void sleep() {
        System.out.println("😴 " + name + " is taking a cat nap...");
        System.out.println("   Curled up in a sunny spot, purring softly!");
        energy = Math.min(100, energy + 30);
        happiness += 10;
    }
    
    public int getCleanlinessLevel() { return cleanlinessLevel; }
}

// Bird class demonstrating method overriding
class Bird extends Pet {
    private String[] knownWords;
    private boolean canFly;
    private int flyingTime;
    
    public Bird(String name, int age, boolean canFly) {
        super(name, age, "Bird");
        this.canFly = canFly;
        this.flyingTime = 0;
        this.knownWords = new String[]{"Hello", "Pretty bird"};
    }
    
    @Override
    public void play() {
        System.out.println("🐦 " + name + " is playing like a happy bird!");
        if (canFly) {
            System.out.println("   Flying around the room, showing off aerial skills!");
            flyingTime += 15;
        } else {
            System.out.println("   Hopping around and playing with toys!");
        }
        System.out.println("   Chirping melodiously!");
        happiness += 20;
        energy -= 12;
    }
    
    // Bird-specific methods for downcasting
    public void fly() {
        if (canFly && energy > 20) {
            System.out.println("✈️ " + name + " is flying freely!");
            System.out.println("   Soaring through the air with beautiful wings spread!");
            flyingTime += 30;
            happiness += 25;
            energy -= 15;
        } else if (!canFly) {
            System.out.println("😔 " + name + " cannot fly - maybe wings are clipped for safety");
        } else {
            System.out.println("😴 " + name + " is too tired to fly right now");
        }
    }
    
    public void sing() {
        System.out.println("🎵 " + name + " is singing a beautiful song!");
        Random rand = new Random();
        String[] songs = {"Tweet tweet!", "Chirp chirp chirp!", "La la la tweet!"};
        System.out.println("   ♪ " + songs[rand.nextInt(songs.length)] + " ♪");
        happiness += 15;
        energy -= 5;
    }
    
    public void learnWord(String word) {
        System.out.println("🗣️ Teaching " + name + " to say: " + word);
        String[] newWords = Arrays.copyOf(knownWords, knownWords.length + 1);
        newWords[newWords.length - 1] = word;
        knownWords = newWords;
        System.out.println("   " + name + " learned a new word: " + word + "!");
        happiness += 20;
    }
    
    public void speak() {
        if (knownWords.length > 0) {
            Random rand = new Random();
            String word = knownWords[rand.nextInt(knownWords.length)];
            System.out.println("💬 " + name + " says: \"" + word + "\"");
        }
    }
    
    public boolean canFly() { return canFly; }
    public int getFlyingTime() { return flyingTime; }
}

public class Problem8 {
    public static void main(String[] args) {
        System.out.println("=== Virtual Pet Simulator - Complete Polymorphism Mastery ===\n");
        
        // Create different pet types (upcasting)
        List<Pet> petCollection = new ArrayList<>();
        petCollection.add(new Dog("Buddy", 3, "fetch"));
        petCollection.add(new Cat("Whiskers", 2));
        petCollection.add(new Bird("Polly", 1, true));
        petCollection.add(new Dog("Rex", 5, "tug of war"));
        petCollection.add(new Cat("Shadow", 4));
        petCollection.add(new Bird("Charlie", 2, false));
        
        System.out.println("=== Pet Collection Overview ===");
        for (Pet pet : petCollection) {
            pet.displayStatus();
            System.out.println();
        }
        
        System.out.println("=== Feeding Time - Inheritance (Same for All) ===");
        for (Pet pet : petCollection) {
            pet.feed(); // Same method for all pets
        }
        System.out.println();
        
        System.out.println("=== Play Time - Method Overriding (Different Behavior) ===");
        for (Pet pet : petCollection) {
            pet.play(); // Different behavior based on actual type
            System.out.println();
        }
        
        System.out.println("=== Care Session - Method Overloading (Multiple Options) ===");
        Pet buddy = petCollection.get(0);
        
        // Different ways to care for pets (method overloading)
        buddy.care(); // Basic care
        buddy.care("grooming"); // Care with type
        buddy.care("exercise", 30); // Care with type and duration
        buddy.care("training", 20); // Different care type with duration
        System.out.println();
        
        System.out.println("=== Special Activities - Safe Downcasting ===");
        for (Pet pet : petCollection) {
            System.out.println("Checking " + pet.getName() + " for special activities...");
            
            // Safe downcasting with instanceof
            if (pet instanceof Dog) {
                Dog dog = (Dog) pet;
                if (dog.needsWalk()) {
                    dog.walk();
                }
                dog.barkAt("mailman");
                
            } else if (pet instanceof Cat) {
                Cat cat = (Cat) pet;
                cat.groom();
                if (cat.getCleanlinessLevel() > 90) {
                    cat.huntMice();
                }
                cat.sleep();
                
            } else if (pet instanceof Bird) {
                Bird bird = (Bird) pet;
                bird.sing();
                if (bird.canFly()) {
                    bird.fly();
                }
                bird.speak();
                bird.learnWord("Good morning!");
                bird.speak(); // Should now say the new word
            }
            System.out.println();
        }
        
        System.out.println("=== Pet Status After Activities ===");
        for (Pet pet : petCollection) {
            pet.displayStatus();
            System.out.println();
        }
        
        System.out.println("=== Advanced Pet Care Demo ===");
        // Demonstrate multiple polymorphism concepts together
        Pet[] mixedPets = {
            new Dog("Max", 4, "frisbee"),
            new Cat("Luna", 3),
            new Bird("Sunny", 1, true)
        };
        
        for (Pet pet : mixedPets) {
            System.out.println("🎯 Advanced care for " + pet.getName() + ":");
            
            // Inheritance - same feeding method
            pet.feed();
            
            // Method overriding - different play styles
            pet.play();
            
            // Method overloading - different care approaches
            pet.care("medical", 25);
            
            // Safe downcasting - type-specific features
            if (pet instanceof Dog && pet.getName().equals("Max")) {
                Dog dog = (Dog) pet;
                dog.walk();
                dog.barkAt("stranger");
            } else if (pet instanceof Cat) {
                Cat cat = (Cat) pet;
                cat.huntMice();
                cat.groom();
            } else if (pet instanceof Bird) {
                Bird bird = (Bird) pet;
                bird.learnWord("I love Java!");
                bird.fly();
                bird.speak();
            }
            
            pet.displayStatus();
            System.out.println("─".repeat(50));
        }
        
        System.out.println("\n🎉 Complete Polymorphism Mastery Demonstrated!");
        System.out.println("✅ Inheritance: Common feeding behavior for all pets");
        System.out.println("✅ Method Overriding: Different play styles per pet type");
        System.out.println("✅ Method Overloading: Multiple care options with different parameters");
        System.out.println("✅ Dynamic Method Dispatch: Runtime determines correct method");
        System.out.println("✅ Safe Downcasting: Access specific features without crashes");
        System.out.println("✅ Polymorphic Collections: Mixed pet types in same array");
    }
}