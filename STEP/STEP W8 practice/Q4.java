// Problem 4: Multiple Interfaces with Devices

interface Camera {
    // Declare method takePhoto()
    void takePhoto();
}

interface MusicPlayer {
    // Declare method playMusic()
    void playMusic();
}

class SmartPhone implements Camera, MusicPlayer {
    // Implement takePhoto() -> "Taking photo with smartphone"
    @Override
    public void takePhoto() {
        System.out.println("Taking photo with smartphone");
    }
    
    // Implement playMusic() -> "Playing music on smartphone"
    @Override
    public void playMusic() {
        System.out.println("Playing music on smartphone");
    }
}

public class Q4 {
    public static void main(String[] args) {
        // Create SmartPhone object
        SmartPhone phone = new SmartPhone();
        
        // Call takePhoto()
        phone.takePhoto();
        
        // Call playMusic()
        phone.playMusic();
    }
}