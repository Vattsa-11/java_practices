import java.util.Scanner;

public class Q4 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a sentence: ");
        String sentence = input.nextLine();
        String[] split_sen;
        split_sen = sentence.split(" ");
        for (int i = 0; i < split_sen.length; i++){
            System.out.printf("\n" + split_sen[i]);
        }
        input.close();
    }
}
