// Practice Problem 2: Medieval Kingdom Builder with Magic System
// Demonstrates inheritance, constructor chaining, instanceof, static/final usage
import java.util.*;


class KingdomManager {
    public static boolean canStructuresInteract(MagicalStructure s1, MagicalStructure s2) {
        if ((s1 instanceof WizardTower && s2 instanceof MysticLibrary) ||
            (s1 instanceof MysticLibrary && s2 instanceof WizardTower)) {
            return true;
        }
        if ((s1 instanceof EnchantedCastle && s2 instanceof DragonLair) ||
            (s1 instanceof DragonLair && s2 instanceof EnchantedCastle)) {
            return true;
        }
        return false;
    }
    public static String performMagicBattle(MagicalStructure attacker, MagicalStructure defender) {
        if (attacker.magicPower > defender.magicPower) {
            return attacker.structureName + " wins!";
        } else if (attacker.magicPower < defender.magicPower) {
            return defender.structureName + " wins!";
        } else {
            return "Draw!";
        }
    }
    public static int calculateKingdomMagicPower(MagicalStructure[] structures) {
        int total = 0;
        for (MagicalStructure s : structures) {
            total += s.magicPower;
        }
        return total;
    }
    public static void applySpecialEffects(MagicalStructure[] structures) {
        for (MagicalStructure s1 : structures) {
            for (MagicalStructure s2 : structures) {
                if (s1 != s2 && canStructuresInteract(s1, s2)) {
                    if (s1 instanceof WizardTower && s2 instanceof MysticLibrary) {
                        ((WizardTower)s1).doubleSpellCapacity();
                        System.out.println("Knowledge boost: Spell capacity doubled!");
                    }
                    if (s1 instanceof EnchantedCastle && s2 instanceof DragonLair) {
                        ((EnchantedCastle)s1).tripleDefense();
                        System.out.println("Dragon guard: Defense tripled!");
                    }
                }
            }
        }
    }
    public static void categorizeStructures(MagicalStructure[] structures) {
        int towers = 0, castles = 0, libraries = 0, lairs = 0;
        for (MagicalStructure s : structures) {
            if (s instanceof WizardTower) towers++;
            else if (s instanceof EnchantedCastle) castles++;
            else if (s instanceof MysticLibrary) libraries++;
            else if (s instanceof DragonLair) lairs++;
        }
        System.out.printf("Towers: %d, Castles: %d, Libraries: %d, Lairs: %d\n", towers, castles, libraries, lairs);
    }
    public static void main(String[] args) {
        MagicalStructure[] kingdom = {
            new WizardTower(),
            new MysticLibrary(),
            new EnchantedCastle(),
            new DragonLair(),
            new WizardTower("Tower of Light", 10)
        };
        for (MagicalStructure s : kingdom) {
            s.castMagicSpell();
        }
        applySpecialEffects(kingdom);
        categorizeStructures(kingdom);
        System.out.println("Kingdom Magic Power: " + calculateKingdomMagicPower(kingdom));
        System.out.println(performMagicBattle(kingdom[0], kingdom[2]));
    }
}

abstract class MagicalStructure {
    protected String structureName;
    protected int magicPower;
    protected String location;
    protected boolean isActive;
    // Constructor chaining
    public MagicalStructure() {
        this("Unknown Structure", 10, "Unknown", true);
    }
    public MagicalStructure(String structureName) {
        this(structureName, 20, "Central", true);
    }
    public MagicalStructure(String structureName, int magicPower) {
        this(structureName, magicPower, "Central", true);
    }
    public MagicalStructure(String structureName, int magicPower, String location, boolean isActive) {
        this.structureName = structureName;
        this.magicPower = magicPower;
        this.location = location;
        this.isActive = isActive;
    }
    public abstract void castMagicSpell();
}

class WizardTower extends MagicalStructure {
    private int spellCapacity;
    private String[] knownSpells;
    public WizardTower() {
        this("Wizard Tower", 50, "North", true, 5, new String[]{"Fireball", "Shield"});
    }
    public WizardTower(String name, int spellCapacity) {
        this(name, 60, "East", true, spellCapacity, new String[]{"Lightning"});
    }
    public WizardTower(String name, int magicPower, String location, boolean isActive, int spellCapacity, String[] knownSpells) {
        super(name, magicPower, location, isActive);
        this.spellCapacity = spellCapacity;
        this.knownSpells = knownSpells;
    }
    @Override
    public void castMagicSpell() {
        System.out.println(structureName + " casts " + knownSpells[0] + "!");
    }
    public int getSpellCapacity() { return spellCapacity; }
    public void doubleSpellCapacity() { spellCapacity *= 2; }
}

class EnchantedCastle extends MagicalStructure {
    private int defenseRating;
    private boolean hasDrawbridge;
    public EnchantedCastle() {
        this("Enchanted Castle", 80, "West", true, 100, true);
    }
    public EnchantedCastle(String name, int defenseRating) {
        this(name, 70, "South", true, defenseRating, false);
    }
    public EnchantedCastle(String name, int magicPower, String location, boolean isActive, int defenseRating, boolean hasDrawbridge) {
        super(name, magicPower, location, isActive);
        this.defenseRating = defenseRating;
        this.hasDrawbridge = hasDrawbridge;
    }
    @Override
    public void castMagicSpell() {
        System.out.println(structureName + " activates magical shield!");
    }
    public void tripleDefense() { defenseRating *= 3; }
}

class MysticLibrary extends MagicalStructure {
    private int bookCount;
    private String ancientLanguage;
    public MysticLibrary() {
        this("Mystic Library", 40, "East", true, 1000, "Latin");
    }
    public MysticLibrary(String name, int bookCount) {
        this(name, 45, "North", true, bookCount, "Greek");
    }
    public MysticLibrary(String name, int magicPower, String location, boolean isActive, int bookCount, String ancientLanguage) {
        super(name, magicPower, location, isActive);
        this.bookCount = bookCount;
        this.ancientLanguage = ancientLanguage;
    }
    @Override
    public void castMagicSpell() {
        System.out.println(structureName + " reveals ancient secrets!");
    }
    public void doubleBookCount() { bookCount *= 2; }
}

class DragonLair extends MagicalStructure {
    private String dragonType;
    private int treasureValue;
    public DragonLair() {
        this("Dragon Lair", 100, "Cave", true, "Fire Dragon", 1000);
    }
    public DragonLair(String name, String dragonType) {
        this(name, 120, "Mountain", true, dragonType, 2000);
    }
    public DragonLair(String name, int magicPower, String location, boolean isActive, String dragonType, int treasureValue) {
        super(name, magicPower, location, isActive);
        this.dragonType = dragonType;
        this.treasureValue = treasureValue;
    }
    @Override
    public void castMagicSpell() {
        System.out.println(structureName + " unleashes " + dragonType + " magic!");
    }
    public void tripleTreasure() { treasureValue *= 3; }
}
