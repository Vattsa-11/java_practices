public class Q2OOPs {
    static class Order{
        private
        double price;
        public
        Order(double p){
            price = p;
        }
        double getPrice(){
            return price;
        }
    }
    public static void main(String[] args){
        Order[] o = {
            new Order(100.59),
            new Order(120.55),
            new Order(69.45),
            new Order(34.22),
            new Order(72.35)
        };
        double totalPrice = 0;
        for (Order ord : o){
            totalPrice += ord.getPrice();
        }
        System.out.printf("Total Price: %.2f",totalPrice);
    }
}
