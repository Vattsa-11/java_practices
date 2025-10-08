// Practice Problem 1: Gaming Arena - Method Overloading
// File: GameBattle.java

public class GameBattle {
    // Basic attack method
    public void attack(int damage) {
        System.out.println("Basic attack for " + damage + " points!");
    }
    
    // Overloaded attack method with weapon
    public void attack(int damage, String weapon) {
        System.out.println("Attacking with " + weapon + " for " + damage + " points!");
    }
    
    // Overloaded attack method for critical hits
    public void attack(int damage, String weapon, boolean isCritical) {
        if (isCritical) {
            System.out.println("CRITICAL HIT! " + weapon + " deals " + (damage * 2) + " points!");
        } else {
            attack(damage, weapon); // Use the previous overloaded method
        }
    }
    
    // Overloaded attack method for team attacks
    public void attack(int damage, String[] teammates) {
        String teamNames = "";
        for (int i = 0; i < teammates.length; i++) {
            teamNames += teammates[i];
            if (i < teammates.length - 1) {
                teamNames += ", ";
            }
        }
        int totalDamage = damage * teammates.length;
        System.out.println("Team attack with " + teamNames + " for " + totalDamage + " total damage!");
    }
    
    public static void main(String[] args) {
        System.out.println("=== Gaming Battle Simulation ===");
        
        // Create a GameBattle object
        GameBattle battle = new GameBattle();
        
        // Test all overloaded attack methods
        System.out.println("\n1. Basic attack:");
        battle.attack(50);
        
        System.out.println("\n2. Weapon attack:");
        battle.attack(75, "Sword");
        
        System.out.println("\n3. Critical attacks:");
        battle.attack(60, "Bow", true);  // Critical hit
        battle.attack(60, "Bow", false); // Normal hit
        
        System.out.println("\n4. Team attack:");
        String[] team = {"Alice", "Bob"};
        battle.attack(40, team);
        
        System.out.println("\n=== Compiler chooses methods based on parameters! ===");
    }
}