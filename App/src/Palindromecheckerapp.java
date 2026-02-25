import java.util.Scanner;

public class Palindromecheckerapp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- UC9: Recursive Palindrome Checker ---");
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Normalize input: remove non-alphanumeric and lowercase
        String cleaned = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        if (isPalindromeRecursive(cleaned, 0, cleaned.length() - 1)) {
            System.out.println("Result: '" + input + "' is a palindrome.");
        } else {
            System.out.println("Result: '" + input + "' is NOT a palindrome.");
        }

        scanner.close();
    }

    /**
     * Recursive method to check palindrome logic.
     * @param str The cleaned string
     * @param start The current left index
     * @param end The current right index
     * @return true if palindrome, false otherwise
     */
    public static boolean isPalindromeRecursive(String str, int start, int end) {
        // Base Case 1: If pointers meet or cross, we've checked everything
        if (start >= end) {
            return true;
        }

        // Base Case 2: If characters at current pointers don't match
        if (str.charAt(start) != str.charAt(end)) {
            return false;
        }

        // Recursive Step: Move pointers inward and call the method again
        return isPalindromeRecursive(str, start + 1, end - 1);
    }
}