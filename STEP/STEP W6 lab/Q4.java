class Color {
    protected String name;
    
    public Color(String name) {
        System.out.println("Color constructor called");
        this.name = name;
    }
    
    public void showInfo() {
        System.out.println("Color: " + name);
    }
}

class PrimaryColor extends Color {
    protected int intensity;
    
    public PrimaryColor(String name, int intensity) {
        super(name);
        System.out.println("PrimaryColor constructor called");
        this.intensity = intensity;
    }
    
    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("Intensity: " + intensity + "%");
    }
}

class RedColor extends PrimaryColor {
    private String shade;
    
    public RedColor(int intensity, String shade) {
        super("Red", intensity);
        System.out.println("RedColor constructor called");
        this.shade = shade;
    }
    
    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("Shade: " + shade);
    }
}

public class Q4 {
    public static void main(String[] args) {
        System.out.println("Creating RedColor object:");
        RedColor red = new RedColor(75, "Crimson");
        System.out.println("\nDisplaying color information:");
        red.showInfo();
    }
}