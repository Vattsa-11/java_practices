public class Car {
    // Instance variables
    private String brand;
    private String model;
    private int year;
    private String color;
    private boolean isRunning;

    public Car(String brand, String model, int year, String color) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.color = color;
        this.isRunning = false;
    }

    public void startEngine() {
        isRunning = true;
        System.out.println(brand + " " + model + " engine started.");
    }

    public void stopEngine() {
        isRunning = false;
        System.out.println(brand + " " + model + " engine stopped.");
    }

    public void displayInfo() {
        System.out.println("Car: " + brand + " " + model + " (" + year + "), " + color + 
                          ", Running: " + isRunning);
    }

    public int getAge() {
        return java.time.Year.now().getValue() - year;
    }

    public static void main(String[] args) {
        Car car1 = new Car("Toyota", "Corolla", 2015, "Red");
        Car car2 = new Car("Honda", "Civic", 2020, "Blue");
        Car car3 = new Car("Ford", "Mustang", 2018, "Black");
        car1.displayInfo();
        car1.startEngine();
        car1.stopEngine();
        System.out.println("Age: " + car1.getAge() + " years\n");

        car2.displayInfo();
        car2.startEngine();
        System.out.println("Age: " + car2.getAge() + " years\n");

        car3.displayInfo();
        car3.startEngine();
        System.out.println("Age: " + car3.getAge() + " years\n");
    }
}
