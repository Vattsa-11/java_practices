import java.util.Scanner;
public class SixToNine {
    public static void main(String[] args){
    Scanner input = new Scanner(System.in);
    int num = input.nextInt();
    int[] arr = new int[4];

    for (int i = 0; i < arr.length; i++) {
        arr[i] = (i+6)*num;
    }
    for (int i = 0; i < arr.length; i++) {
        System.out.println(num +"x" +(i+6) +"="+arr[i]);
    }
    input.close();
  }
}



