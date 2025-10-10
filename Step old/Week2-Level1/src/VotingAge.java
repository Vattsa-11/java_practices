import java.util.Scanner;

public class VotingAge {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your Age: ");
        int age = input.nextInt();
        if (age >= 18) {
            System.out.println("The person can vote.");
        } else {
            System.out.println("The person cannot vote");
        }
        input.close();
    }
}
