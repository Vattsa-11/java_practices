public class Q2Procedural {

    public static double totalPrice(double[] order){
        double total = 0;
        for (double o: order){
            total += o;
        }
        return total;
    }

    public static void main(String[] args){
        double[] order_price = {210, 450, 830, 321, 987.778, 234.566, 221, 33.3, 70.70};

        System.out.printf("Total Order Price: %.2f", totalPrice(order_price));
    }
}
