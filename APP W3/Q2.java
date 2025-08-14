public class Q2 {
    
    static class Mobile {
        private 
        String brand;
        String model;
        double price;

        public
        Mobile(String b, String m, double p) {
            brand = b;
            model = m;
            price = p;
        }

        void showDetails() {
            System.out.println("Brand: " + brand);
            System.out.println("Model: " + model);
            System.out.println("Price: " + price);
        }
    }

    public static void main(String[] args) {
        Mobile m1 = new Mobile("Apple", "iPhone 14", 999.99);
        Mobile m2 = new Mobile("Samsung", "Galaxy S22", 799.99);
        Mobile m3 = new Mobile("Google", "Pixel 6", 599.99);

        m1.showDetails();
        m2.showDetails();
        m3.showDetails();
    }
}
