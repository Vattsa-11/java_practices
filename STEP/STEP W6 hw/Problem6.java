// Problem 6: Weather System Hierarchy

class Weather {
    protected String location;
    protected double temperature;
    
    public Weather() {
        this("Unknown", 20.0);
        System.out.println("Weather default constructor");
    }
    
    public Weather(String location, double temperature) {
        this.location = location;
        this.temperature = temperature;
        System.out.println("Weather constructor with parameters");
    }
    
    public void displayWeather() {
        System.out.println("Weather at " + location + ": " + temperature + "°C");
    }
    
    public void forecast() {
        System.out.println("General weather forecast for " + location);
    }
}

// Multilevel inheritance: Weather -> Storm -> Thunderstorm
class Storm extends Weather {
    protected int windSpeed;
    
    public Storm() {
        this("Unknown", 15.0, 50);
        System.out.println("Storm default constructor");
    }
    
    public Storm(String location, double temperature, int windSpeed) {
        super(location, temperature);
        this.windSpeed = windSpeed;
        System.out.println("Storm constructor with parameters");
    }
    
    @Override
    public void displayWeather() {
        super.displayWeather();
        System.out.println("Wind Speed: " + windSpeed + " km/h");
    }
    
    @Override
    public void forecast() {
        System.out.println("Storm warning for " + location + " - High winds expected!");
    }
    
    public void stormWarning() {
        System.out.println("Storm warning issued for " + location);
    }
}

class Thunderstorm extends Storm {
    private int lightningStrikes;
    private boolean hailExpected;
    
    public Thunderstorm() {
        this("Unknown", 18.0, 70, 15, true);
        System.out.println("Thunderstorm default constructor");
    }
    
    public Thunderstorm(String location, double temperature, int windSpeed, 
                       int lightningStrikes, boolean hailExpected) {
        super(location, temperature, windSpeed);
        this.lightningStrikes = lightningStrikes;
        this.hailExpected = hailExpected;
        System.out.println("Thunderstorm constructor with parameters");
    }
    
    @Override
    public void displayWeather() {
        super.displayWeather();
        System.out.println("Lightning Strikes: " + lightningStrikes + "/hour");
        System.out.println("Hail Expected: " + (hailExpected ? "Yes" : "No"));
    }
    
    @Override
    public void forecast() {
        System.out.println("SEVERE THUNDERSTORM WARNING for " + location + 
                          " - Take shelter immediately!");
    }
    
    public void severeLightningWarning() {
        System.out.println("Severe lightning warning - " + lightningStrikes + 
                          " strikes per hour expected!");
    }
}

// Hierarchical inheritance: Weather -> Sunshine
class Sunshine extends Weather {
    private int uvIndex;
    private boolean clearSky;
    
    public Sunshine() {
        this("Unknown", 25.0, 5, true);
        System.out.println("Sunshine default constructor");
    }
    
    public Sunshine(String location, double temperature, int uvIndex, boolean clearSky) {
        super(location, temperature);
        this.uvIndex = uvIndex;
        this.clearSky = clearSky;
        System.out.println("Sunshine constructor with parameters");
    }
    
    @Override
    public void displayWeather() {
        super.displayWeather();
        System.out.println("UV Index: " + uvIndex);
        System.out.println("Clear Sky: " + (clearSky ? "Yes" : "No"));
    }
    
    @Override
    public void forecast() {
        System.out.println("Beautiful sunny weather expected in " + location + 
                          " - Perfect for outdoor activities!");
    }
    
    public void sunProtectionAdvice() {
        if (uvIndex > 7) {
            System.out.println("High UV index - Use sunscreen and wear protective clothing!");
        } else {
            System.out.println("Moderate UV - Enjoy the sunshine safely!");
        }
    }
}

public class Problem6 {
    public static void main(String[] args) {
        System.out.println("=== Constructor Chaining Demo ===");
        Thunderstorm storm = new Thunderstorm("New York", 16.0, 80, 25, true);
        System.out.println("Created thunderstorm: " + storm.getClass().getSimpleName());
        
        System.out.println("\n=== Polymorphism Demo ===");
        // Array of Weather references - polymorphism
        Weather[] weatherConditions = {
            new Weather("London", 22.0),
            new Storm("Chicago", 12.0, 60),
            new Thunderstorm("Miami", 28.0, 90, 30, false),
            new Sunshine("Los Angeles", 28.0, 8, true)
        };
        
        System.out.println("\nWeather reports using polymorphism:");
        for (Weather weather : weatherConditions) {
            System.out.println("\n--- Weather Report ---");
            weather.displayWeather();  // Calls overridden method
            weather.forecast();        // Calls overridden method
            System.out.println("Actual class: " + weather.getClass().getSimpleName());
        }
        
        System.out.println("\n=== Method Overriding at Different Levels ===");
        Weather baseWeather = new Weather("Base City", 20.0);
        Storm baseStorm = new Storm("Storm City", 15.0, 55);
        Thunderstorm severeStorm = new Thunderstorm("Danger City", 18.0, 85, 40, true);
        Sunshine brightDay = new Sunshine("Sunny City", 30.0, 9, true);
        
        baseWeather.forecast();
        baseStorm.forecast();
        severeStorm.forecast();
        brightDay.forecast();
        
        System.out.println("\n=== Specific Methods Demo ===");
        severeStorm.severeLightningWarning();
        brightDay.sunProtectionAdvice();
    }
}