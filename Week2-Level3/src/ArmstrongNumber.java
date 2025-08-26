import java.util.Scanner;

public class ArmstrongNumber {
    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a Number: ");
        int ogNum = input.nextInt();
        int tempNum = ogNum;
        int sumNum = 0;
        while (tempNum > 0) {
            int rem = tempNum % 10;
            sumNum += rem*rem*rem;
            tempNum -= rem;
            tempNum /= 10;
        }
        if (ogNum == sumNum) {
            System.out.print("The Number "+ogNum+" is an Armstrong Number.");
        } else {
            System.out.print("The Number "+ogNum+" is Not an Armstrong Number.");
        }
        input.close();
    }
}
