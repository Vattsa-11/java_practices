import java.util.Scanner;
public class Bonus {
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Salary: ");
        int salary = input.nextInt();
        System.out.println("Enter Years: ");
        int years = input.nextInt();
        if(years>=5){
            int bonus = (int)(salary * 0.05);
            System.out.println("You are eligible for bonus: "+bonus);
        } else {
            System.out.println("you are not eligible for bonus sorry!");
        }
    }
}
