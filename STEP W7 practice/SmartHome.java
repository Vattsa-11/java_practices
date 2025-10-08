// Practice Problem 6: Smart Home - Safe Downcasting with instanceof
// File: SmartHome.java

class SmartDevice {
    protected String deviceName;
    protected boolean isOn;
    
    public SmartDevice(String deviceName) {
        this.deviceName = deviceName;
        this.isOn = false;
    }
    
    // Basic device operations
    public void turnOn() {
        isOn = true;
        System.out.println(deviceName + " is now ON");
    }
    
    public void turnOff() {
        isOn = false;
        System.out.println(deviceName + " is now OFF");
    }
    
    public void getStatus() {
        System.out.println(deviceName + " status: " + (isOn ? "ON" : "OFF"));
    }
}

class SmartLight extends SmartDevice {
    private int brightness;
    private String color;
    
    public SmartLight(String deviceName, String color) {
        super(deviceName);
        this.color = color;
        this.brightness = 50; // Default brightness
    }
    
    // Light-specific methods
    public void setBrightness(int brightness) {
        this.brightness = Math.max(0, Math.min(100, brightness));
        System.out.println(deviceName + " brightness set to " + this.brightness + "%");
    }
    
    public void changeColor(String newColor) {
        this.color = newColor;
        System.out.println(deviceName + " color changed to " + color);
    }
    
    public void dimLight() {
        setBrightness(brightness - 20);
    }
}

class SmartThermostat extends SmartDevice {
    private int temperature;
    private String mode;
    
    public SmartThermostat(String deviceName) {
        super(deviceName);
        this.temperature = 22; // Default 22°C
        this.mode = "auto";
    }
    
    // Thermostat-specific methods
    public void setTemperature(int temp) {
        this.temperature = temp;
        System.out.println(deviceName + " temperature set to " + temperature + "°C");
    }
    
    public void setMode(String mode) {
        this.mode = mode;
        System.out.println(deviceName + " mode set to " + mode);
    }
    
    public void getTemperature() {
        System.out.println(deviceName + " current temperature: " + temperature + "°C (" + mode + " mode)");
    }
}

class SmartSpeaker extends SmartDevice {
    private int volume;
    private String currentSong;
    
    public SmartSpeaker(String deviceName) {
        super(deviceName);
        this.volume = 50;
        this.currentSong = "No music playing";
    }
    
    // Speaker-specific methods
    public void setVolume(int volume) {
        this.volume = Math.max(0, Math.min(100, volume));
        System.out.println(deviceName + " volume set to " + this.volume);
    }
    
    public void playMusic(String song) {
        this.currentSong = song;
        System.out.println(deviceName + " now playing: " + song);
    }
    
    public void stopMusic() {
        System.out.println(deviceName + " stopping: " + currentSong);
        this.currentSong = "No music playing";
        System.out.println(deviceName + " music stopped");
    }
}

public class SmartHome {
    // Method to safely control any smart device
    public static void controlDevice(SmartDevice device) {
        System.out.println("\n=== Controlling Device: " + device.deviceName + " ===");
        
        // Basic operations available to all devices
        device.turnOn();
        device.getStatus();
        
        // Safe downcasting using instanceof
        if (device instanceof SmartLight) {
            System.out.println("💡 Detected Smart Light - accessing light features:");
            SmartLight light = (SmartLight) device; // Safe downcast
            light.setBrightness(80);
            light.changeColor("Blue");
            light.dimLight();
            
        } else if (device instanceof SmartThermostat) {
            System.out.println("🌡️ Detected Smart Thermostat - accessing climate features:");
            SmartThermostat thermostat = (SmartThermostat) device; // Safe downcast
            thermostat.setTemperature(24);
            thermostat.setMode("heating");
            thermostat.getTemperature();
            
        } else if (device instanceof SmartSpeaker) {
            System.out.println("🔊 Detected Smart Speaker - accessing audio features:");
            SmartSpeaker speaker = (SmartSpeaker) device; // Safe downcast
            speaker.setVolume(70);
            speaker.playMusic("Relaxing Jazz Playlist");
            
        } else {
            System.out.println("🤖 Generic Smart Device - only basic controls available");
        }
        
        device.turnOff();
    }
    
    public static void main(String[] args) {
        System.out.println("=== Smart Home Control System ===");
        
        // Create array of SmartDevice references with different actual types
        SmartDevice[] devices = {
            new SmartLight("Living Room Light", "Warm White"),
            new SmartThermostat("Main Thermostat"),
            new SmartSpeaker("Kitchen Speaker"),
            new SmartDevice("Generic IoT Device") // Base class object
        };
        
        // Control each device safely using instanceof
        for (SmartDevice device : devices) {
            controlDevice(device);
        }
        
        System.out.println("\n=== instanceof Safety Demo ===");
        SmartDevice unknownDevice = new SmartLight("Bedroom Light", "Red");
        
        // Safe type checking before downcasting
        System.out.println("Is unknownDevice a SmartLight? " + (unknownDevice instanceof SmartLight));
        System.out.println("Is unknownDevice a SmartSpeaker? " + (unknownDevice instanceof SmartSpeaker));
        System.out.println("Is unknownDevice a SmartDevice? " + (unknownDevice instanceof SmartDevice));
        
        // Demonstrating safe vs unsafe downcasting
        if (unknownDevice instanceof SmartSpeaker) {
            SmartSpeaker speaker = (SmartSpeaker) unknownDevice; // This won't execute
            speaker.playMusic("Some Song");
        } else {
            System.out.println("✅ Safe! unknownDevice is NOT a SmartSpeaker - no casting attempted");
        }
        
        System.out.println("\n=== instanceof Best Practices: ===");
        System.out.println("🛡️ ALWAYS use instanceof before downcasting");
        System.out.println("✅ Prevents ClassCastException at runtime");
        System.out.println("🎯 Enables flexible polymorphic code");
        System.out.println("📝 Pattern: if (obj instanceof Type) { Type t = (Type) obj; }");
    }
}