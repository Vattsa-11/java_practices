// Problem 1: Light and LED Multiple Constructors

class Light {
    private String color;
    private int brightness;
    private boolean isOn;
    
    // Default constructor
    public Light() {
        this("White", 50, false);
        System.out.println("Light default constructor called");
    }
    
    // Constructor with color
    public Light(String color) {
        this(color, 50, false);
        System.out.println("Light constructor with color called");
    }
    
    // Constructor with color and brightness
    public Light(String color, int brightness) {
        this(color, brightness, false);
        System.out.println("Light constructor with color and brightness called");
    }
    
    // Main constructor
    public Light(String color, int brightness, boolean isOn) {
        this.color = color;
        this.brightness = brightness;
        this.isOn = isOn;
        System.out.println("Light main constructor called");
    }
    
    public void display() {
        System.out.println("Light - Color: " + color + ", Brightness: " + brightness + ", On: " + isOn);
    }
}

class LED extends Light {
    private String type;
    
    // Default constructor
    public LED() {
        this("Standard");
        System.out.println("LED default constructor called");
    }
    
    // Constructor with type
    public LED(String type) {
        super("Blue", 80, true);
        this.type = type;
        System.out.println("LED constructor with type called");
    }
    
    // Constructor with all parameters
    public LED(String color, int brightness, boolean isOn, String type) {
        super(color, brightness, isOn);
        this.type = type;
        System.out.println("LED full constructor called");
    }
    
    public void display() {
        super.display();
        System.out.println("LED Type: " + type);
    }
}

public class Problem1 {
    public static void main(String[] args) {
        System.out.println("Creating Light with default constructor:");
        Light light1 = new Light();
        light1.display();
        
        System.out.println("\nCreating LED with default constructor:");
        LED led1 = new LED();
        led1.display();
        
        System.out.println("\nCreating LED with full constructor:");
        LED led2 = new LED("Red", 100, true, "High Power");
        led2.display();
    }
}