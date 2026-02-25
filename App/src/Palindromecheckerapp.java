import java.util.Scanner;

public class Palindromecheckerapp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- UC10: Case-Insensitive & Space-Ignored Palindrome ---");
        System.out.print("Enter a string (e.g., 'Race Car' or 'A man, a plan...'): ");
        String input = scanner.nextLine();

        // Step 1: Normalize the string
        String cleaned = normalizeString(input);

        System.out.println("Normalized String: " + cleaned);

        // Step 2: Validate using the Two-Pointer approach
        if (isPalindrome(cleaned)) {
            System.out.println("Result: It IS a palindrome (ignoring case/spaces).");
        } else {
            System.out.println("Result: It is NOT a palindrome.");
        }

        scanner.close();
    }

    /**
     * Normalizes the string by removing all non-alphanumeric characters
     * and converting everything to lowercase.
     */
    public static String normalizeString(String input) {
        if (input == null) return "";
        // Regex [^a-zA-Z0-9] matches anything that is NOT a letter or a number
        return input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
    }

    public static boolean isPalindrome(String str) {
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