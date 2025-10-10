import java.util.Scanner;

public class StringMethods{ 
    public static void main(String[] args) { 
        Scanner scanner = new Scanner(System.in); 
        System.out.print("Enter your full name (first and last): ");
        String fullName = scanner.nextLine();

        System.out.print("Enter your favorite programming language: ");
        String programmingLanguage = scanner.nextLine();

        System.out.print("Enter a sentence about your programming experience: ");
        String experienceSentence = scanner.nextLine();

        String[] nameParts = fullName.split(" ");
        String firstName = nameParts[0];
        
        int totalCharacters = experienceSentence.replace(" ", "").length();
        String upperCaseLanguage = programmingLanguage.toUpperCase();
        System.out.println("Summary:");
        System.out.println("First Name: " + firstName);
        System.out.println("Last Name: " + (nameParts.length > 1 ? nameParts[1] : "N/A"));
        System.out.println("Total Characters in Experience Sentence (excluding spaces): " + totalCharacters);
         
        scanner.close(); 
    } 
} 