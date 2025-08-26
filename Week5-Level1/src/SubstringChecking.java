import java.util.Scanner;

public class SubstringChecking {
    public static StringBuilder substring(String str, int st, int en){
        StringBuilder sub = new StringBuilder();
        if (st < str.length() && en <= str.length()){
            for (int i = st; i < en; i++){
                sub.append(str.charAt(i));
            }
        }
        return sub;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a String: ");
        String s1 = input.next();
        System.out.print("Enter start index: ");
        int st_index = input.nextInt();
        System.out.print("Enter end index: ");
        int en_index = input.nextInt();
        System.out.println(substring(s1, st_index, en_index));
        System.out.println(s1.substring(st_index, en_index));
    }
}
