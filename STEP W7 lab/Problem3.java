// Problem 3: Gaming Character System - Dynamic Method Dispatch
class Character {
    protected String name;
    protected int health;
    protected int level;
    
    public Character(String name, int health, int level) {
        this.name = name;
        this.health = health;
        this.level = level;
    }
    
    // Method to be overridden by subclasses
    public void attack() {
        System.out.println(name + " performs a basic attack!");
    }
    
    public void displayInfo() {
        System.out.println("Name: " + name + ", Health: " + health + ", Level: " + level);
    }
}

class Warrior extends Character {
    private String weapon;
    private int defense;
    
    public Warrior(String name, int health, int level, String weapon, int defense) {
        super(name, health, level);
        this.weapon = weapon;
        this.defense = defense;
    }
    
    @Override
    public void attack() {
        System.out.println(name + " the Warrior attacks with " + weapon + "!");
        System.out.println("Weapon damage dealt! Defense: " + defense);
    }
}

class Mage extends Character {
    private int mana;
    private String spell;
    
    public Mage(String name, int health, int level, int mana, String spell) {
        super(name, health, level);
        this.mana = mana;
        this.spell = spell;
    }
    
    @Override
    public void attack() {
        if (mana > 0) {
            System.out.println(name + " the Mage casts " + spell + "!");
            System.out.println("Magical damage dealt! Current mana: " + (mana - 10));
            mana -= 10;
        } else {
            System.out.println(name + " is out of mana and cannot cast spells!");
        }
    }
}

class Archer extends Character {
    private int arrows;
    private String bowType;
    
    public Archer(String name, int health, int level, int arrows, String bowType) {
        super(name, health, level);
        this.arrows = arrows;
        this.bowType = bowType;
    }
    
    @Override
    public void attack() {
        if (arrows > 0) {
            System.out.println(name + " the Archer shoots an arrow with " + bowType + "!");
            System.out.println("Long-range damage dealt! Arrows remaining: " + (arrows - 1));
            arrows--;
        } else {
            System.out.println(name + " is out of arrows!");
        }
    }
}

public class Problem3 {
    public static void main(String[] args) {
        System.out.println("=== Gaming Character System - Dynamic Method Dispatch ===\n");
        
        // Create different character types
        Character[] army = {
            new Warrior("Thor", 150, 10, "Mjolnir", 80),
            new Mage("Gandalf", 100, 12, 200, "Fireball"),
            new Archer("Legolas", 120, 11, 50, "Elven Bow"),
            new Warrior("Conan", 140, 9, "Sword", 70),
            new Mage("Merlin", 90, 15, 250, "Lightning Bolt")
        };
        
        System.out.println("Army assembled! Let the battle begin!\n");
        
        // Dynamic method dispatch - same method call, different behavior
        for (Character character : army) {
            character.displayInfo();
            character.attack(); // Runtime decides which attack method to call
            System.out.println();
        }
        
        System.out.println("=== Special Battle Round ===");
        // Demonstrate that the same reference type can hold different objects
        Character currentFighter;
        
        currentFighter = new Warrior("Spartacus", 160, 8, "Spear", 75);
        currentFighter.attack();
        
        currentFighter = new Mage("Hermione", 95, 13, 180, "Expelliarmus");
        currentFighter.attack();
        
        currentFighter = new Archer("Robin Hood", 110, 10, 30, "Longbow");
        currentFighter.attack();
    }
}