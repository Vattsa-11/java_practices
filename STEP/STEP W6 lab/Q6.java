class Box {
    protected int length;
    protected int width;
    protected int height;
    
    public Box(int length, int width, int height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }
    
    public void pack() {
        System.out.println("Box: Adding basic protective packaging");
        System.out.println("Box: Sealing with standard tape");
    }
    
    public void unpack() {
        System.out.println("Box: Removing standard tape");
        System.out.println("Box: Removing basic packaging");
    }
}

class GiftBox extends Box {
    private String occasion;
    private String wrappingColor;
    
    public GiftBox(int length, int width, int height, String occasion, String wrappingColor) {
        super(length, width, height);
        this.occasion = occasion;
        this.wrappingColor = wrappingColor;
    }
    
    @Override
    public void pack() {
        // Call parent packing method first
        super.pack();
        // Add gift-specific packing
        System.out.println("GiftBox: Adding " + wrappingColor + " gift wrap");
        System.out.println("GiftBox: Adding bow for " + occasion);
        System.out.println("GiftBox: Attaching gift card");
    }
    
    @Override
    public void unpack() {
        // Add gift-specific unpacking
        System.out.println("GiftBox: Carefully removing gift card");
        System.out.println("GiftBox: Preserving the bow");
        System.out.println("GiftBox: Unwrapping " + wrappingColor + " gift wrap");
        // Call parent unpacking method last
        super.unpack();
    }
}

public class Q6 {
    public static void main(String[] args) {
        System.out.println("Testing regular box:");
        Box regularBox = new Box(10, 10, 10);
        regularBox.pack();
        System.out.println("\nUnpacking regular box:");
        regularBox.unpack();
        
        System.out.println("\nTesting gift box:");
        GiftBox birthdayBox = new GiftBox(12, 12, 12, "Birthday", "Red");
        birthdayBox.pack();
        System.out.println("\nUnpacking gift box:");
        birthdayBox.unpack();
    }
}