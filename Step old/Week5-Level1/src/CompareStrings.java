import java.util.Scanner;

public class CompareStrings {
    public static boolean compare(String string1, String string2){
        boolean value = true;
        for (int i = 0; i < string1.length(); i++){
            if (string1.charAt(i) == string2.charAt(i)) {
                continue;
            }else {
                value = false;
                break;
            }
        }
        return value;
    }
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter String 1: ");
        String s1 = input.next();
        System.out.print("Enter String 2: ");
        String s2 = input.next();
        System.out.println(s1.equals(s2));
        System.out.println(compare(s1, s2));
    }
}
