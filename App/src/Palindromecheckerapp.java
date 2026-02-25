import java.util.Scanner;

/**
 * Service class to encapsulate Palindrome logic.
 * Demonstrates Encapsulation and Reusability.
 */
class PalindromeService {

    /**
     * Public method to check if a string is a palindrome.
     * Internal implementation details are hidden from the caller.
     */
    public boolean checkPalindrome(String input) {
        if (input == null) return false;

        String cleaned = preprocess(input);
        return validate(cleaned);
    }

    /**
     * Private helper method for string normalization.
     */
    private String preprocess(String str) {
        return str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
    }

    /**
     * Private logic to perform the comparison.
     */
    private boolean validate(String str) {
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}

public class Palindromecheckerapp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Creating an instance of the service (Object-Oriented approach)
        PalindromeService service = new PalindromeService();

        System.out.println("--- UC11: Object-Oriented Palindrome Service ---");
        System.out.print("Enter a string to validate: ");
        String userInput = scanner.nextLine();

        // Using the object's behavior
        boolean isPalindrome = service.checkPalindrome(userInput);

        if (isPalindrome) {
            System.out.println("Result: The input is a valid palindrome.");
        } else {
            System.out.println("Result: The input is NOT a palindrome.");
        }

        scanner.close();
    }
}