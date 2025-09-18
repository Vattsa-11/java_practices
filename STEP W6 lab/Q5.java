class Instrument {
    protected String name;
    protected String material;
    
    public Instrument(String name, String material) {
        this.name = name;
        this.material = material;
    }
    
    public void play() {
        System.out.println("Playing " + name);
    }
    
    public void displayInfo() {
        System.out.println(name + " made of " + material);
    }
}

class Piano extends Instrument {
    private int numberOfKeys;
    
    public Piano(String material, int numberOfKeys) {
        super("Piano", material);
        this.numberOfKeys = numberOfKeys;
    }
    
    @Override
    public void play() {
        System.out.println("Playing piano keys melodically");
    }
}

class Guitar extends Instrument {
    private int numberOfStrings;
    
    public Guitar(String material, int numberOfStrings) {
        super("Guitar", material);
        this.numberOfStrings = numberOfStrings;
    }
    
    @Override
    public void play() {
        System.out.println("Strumming guitar strings");
    }
}

class Drum extends Instrument {
    private String type;
    
    public Drum(String material, String type) {
        super("Drum", material);
        this.type = type;
    }
    
    @Override
    public void play() {
        System.out.println("Beating the " + type + " drums");
    }
}

public class Q5 {
    public static void main(String[] args) {
        Instrument[] instruments = new Instrument[3];
        instruments[0] = new Piano("Wood", 88);
        instruments[1] = new Guitar("Maple", 6);
        instruments[2] = new Drum("Metal", "Bass");
        
        System.out.println("Testing instrument behaviors:");
        for (Instrument instrument : instruments) {
            instrument.displayInfo();
            instrument.play();
            System.out.println();
        }
    }
}