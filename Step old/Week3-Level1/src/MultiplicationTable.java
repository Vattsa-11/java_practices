import java.util.Scanner;
public class MultiplicationTable {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int ogNum = input.nextInt();
        int []array = new int[10];
        for(int i = 0; i < array.length; i++){
            array[i] = (i+1) * ogNum;
        }
        for(int i = 0; i < array.length;i++){
            System.out.printf("%d x %d = %d\n", ogNum, (i+1), array[i]);
        }
        input.close();
    }
}
