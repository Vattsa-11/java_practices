// Practice Problem 1: Virtual Pet Evolution Simulator
// Demonstrates constructor overloading, this() chaining, static/final usage
import java.util.*;

public class VirtualPet {
    private final String petId;
    private String petName;
    private String species;
    private int age;
    private int happiness;
    private int health;
    private int stageIndex;
    private boolean isGhost;
    private static final String[] EVOLUTION_STAGES = {"Egg", "Baby", "Child", "Teen", "Adult", "Elder", "Ghost"};
    private static int totalPetsCreated = 0;

    // Default constructor: mysterious egg
    public VirtualPet() {
        this(generatePetId(), "Mystery", getRandomSpecies(), 0, 50, 50, 0, false);
    }
    // Constructor with name only: baby stage
    public VirtualPet(String petName) {
        this(generatePetId(), petName, getRandomSpecies(), 0, 60, 60, 1, false);
    }
    // Constructor with name and species: child stage
    public VirtualPet(String petName, String species) {
        this(generatePetId(), petName, species, 2, 70, 70, 2, false);
    }
    // Full constructor
    public VirtualPet(String petId, String petName, String species, int age, int happiness, int health, int stageIndex, boolean isGhost) {
        this.petId = petId;
        this.petName = petName;
        this.species = species;
        this.age = age;
        this.happiness = happiness;
        this.health = health;
        this.stageIndex = stageIndex;
        this.isGhost = isGhost;
        totalPetsCreated++;
    }
    public static String generatePetId() {
        return "PET-" + UUID.randomUUID().toString().substring(0, 8);
    }
    private static String getRandomSpecies() {
        String[] speciesList = {"Cat", "Dog", "Dragon", "Bird", "Rabbit", "Fox"};
        return speciesList[new Random().nextInt(speciesList.length)];
    }
    public void feedPet() {
        if (!isGhost) health = Math.min(100, health + 10);
    }
    public void playWithPet() {
        if (!isGhost) happiness = Math.min(100, happiness + 10);
    }
    public void healPet() {
        if (!isGhost) health = Math.min(100, health + 20);
    }
    public void simulateDay() {
        if (!isGhost) {
            age++;
            happiness = Math.max(0, happiness + (new Random().nextInt(11) - 5));
            health = Math.max(0, health + (new Random().nextInt(11) - 5));
            evolvePet();
            if (health <= 0) {
                isGhost = true;
                stageIndex = EVOLUTION_STAGES.length - 1;
                species = "Ghost";
            }
        }
    }
    public void evolvePet() {
        if (!isGhost && stageIndex < EVOLUTION_STAGES.length - 2) {
            if (age > 15) stageIndex = 5; // Elder
            else if (age > 10) stageIndex = 4; // Adult
            else if (age > 7) stageIndex = 3; // Teen
            else if (age > 3) stageIndex = 2; // Child
            else if (age > 0) stageIndex = 1; // Baby
        }
    }
    public String getPetStatus() {
        return EVOLUTION_STAGES[stageIndex];
    }
    public void hauntOtherPet(VirtualPet other) {
        if (isGhost) {
            other.happiness = Math.max(0, other.happiness - 10);
        }
    }
    public void displayProfile() {
        System.out.printf("🐾 PetID: %s | Name: %s | Species: %s | Age: %d | Stage: %s | Happy: %d | Health: %d | Ghost: %b\n",
                petId, petName, species, age, getPetStatus(), happiness, health, isGhost);
    }
    public static int getTotalPetsCreated() {
        return totalPetsCreated;
    }
    public static void main(String[] args) {
        List<VirtualPet> daycare = new ArrayList<>();
        daycare.add(new VirtualPet());
        daycare.add(new VirtualPet("Fluffy"));
        daycare.add(new VirtualPet("Sparky", "Dog"));
        daycare.add(new VirtualPet(generatePetId(), "Draco", "Dragon", 8, 80, 80, 3, false));
        for (int day = 1; day <= 7; day++) {
            System.out.println("--- Day " + day + " ---");
            for (VirtualPet pet : daycare) {
                pet.simulateDay();
                pet.displayProfile();
            }
        }
        // Ghost haunting demo
        VirtualPet ghostPet = new VirtualPet("Ghosty", "Ghost");
        ghostPet.isGhost = true;
        ghostPet.stageIndex = EVOLUTION_STAGES.length - 1;
        daycare.get(0).hauntOtherPet(daycare.get(1));
        System.out.println("After haunting:");
        daycare.get(1).displayProfile();
        System.out.println("Total pets created: " + getTotalPetsCreated());
    }
}
