class Vehicle {
    int speed;

    Vehicle(int s) {
        speed = s;
    }

    Vehicle() {
        this(0); // Properly call parameterized constructor using this()
    }
    void showSpeed(){
        System.out.println("Speed: "+speed);
    }
    public static void main(String[] args) {
        Vehicle v1 = new Vehicle();
        Vehicle v2 = new Vehicle(20);

        v1.showSpeed();
        v2.showSpeed();
    }
}
