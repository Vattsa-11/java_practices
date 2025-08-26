import java.util.Scanner;

public class MultiDimensionalArray {
    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter No of rows: ");
        int row = input.nextInt();
        System.out.print("Enter No of columns: ");
        int column = input.nextInt();
        int[][] twoDarray = new int[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                System.out.print("Enter element for ["+i+"]["+j+"]: ");
                twoDarray[i][j] = input.nextInt();
            }
        }
        int[] array = new int[row*column];
        int count = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                array[count++] = twoDarray[i][j];
            }
        }
        for (int k = 0; k < array.length; k++) System.out.print(array[k] + " ");
        input.close();
    }
}
