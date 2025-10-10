import java.util.Scanner;
public class MultipleVariables {
    public static void main(String[]args){
        Scanner input = new Scanner(System.in);
        double num = input.nextDouble();
        double []arr= new double[10];
        int i = 0;
        while(true){
            arr[i] = num;
            i++;
            num = input.nextDouble();
            if(num==0 || i==9){
                break;
            }
        }
        for (int j = 0; j < 10; j++) {
            System.out.println(arr[j]);
        }
    }
}
