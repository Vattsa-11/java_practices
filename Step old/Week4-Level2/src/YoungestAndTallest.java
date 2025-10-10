import java.util.Scanner;

public class YoungestAndTallest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] age = new int[3];
        int[] height = new int[3];

        System.out.print("Enter 3 Ages: ");
        age[0] = input.nextInt();
        age[1] = input.nextInt();
        age[2] = input.nextInt();

        System.out.print("Enter 3 Heights: ");
        height[0] = input.nextInt();
        height[1] = input.nextInt();
        height[2] = input.nextInt();
        youngest(age);
        tallest(height);
    }
    public static void youngest(int[] age){
        if (age[0] < age[1] && age[0] < age[2]) {
            System.out.println("The youngest person is Amar, "+age[0]);
        } else if (age[1] < age[0] && age[1] < age[2]) {
            System.out.println("The youngest person is Akbar, "+age[1]);
        } else {
            System.out.println("The youngest person is Anthony, "+age[2]);
        }
    }
    public static void tallest(int[] height){
        if (height[0] > height[1] && height[0] > height[2]) {
            System.out.println("The tallest person is Amar,"+height[0]);
        } else if (height[1] > height[0] && height[1] > height[2]) {
            System.out.println("The tallest person is Akbar, "+height[1]);
        } else {
            System.out.println("The tallest person is Anthony, "+height[2]);
        }
    }
}