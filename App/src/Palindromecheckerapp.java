import java.util.*;

public class UseCase13PalindromeCheckerApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("--- UC13: Performance Comparison ---");
        System.out.print("Enter a long string to test performance: ");
        String input = scanner.nextLine();

        // Clean the input once to ensure fairness
        String cleaned = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        System.out.println("\nMeasuring performance for " + cleaned.length() + " characters...\n");

        // Test 1: Iterative (Two-Pointer)
        long start = System.nanoTime();
        checkIterative(cleaned);
        long end = System.nanoTime();
        System.out.printf("Iterative (Two-Pointer): %d ns\n", (end - start));

        // Test 2: Stack-Based
        start = System.nanoTime();
        checkStack(cleaned);
        end = System.nanoTime();
        System.out.printf("Stack-Based:           %d ns\n", (end - start));

        // Test 3: Deque-Based
        start = System.nanoTime();
        checkDeque(cleaned);
        end = System.nanoTime();
        System.out.printf("Deque-Based:           %d ns\n", (end - start));

        // Test 4: Recursive (Note: Can hit StackOverflow if string is too long)
        try {
            start = System.nanoTime();
            checkRecursive(cleaned, 0, cleaned.length() - 1);
            end = System.nanoTime();
            System.out.printf("Recursive:             %d ns\n", (end - start));
        } catch (StackOverflowError e) {
            System.out.println("Recursive:             Failed (Stack Overflow)");
        }

        scanner.close();
    }

    // Iterative Logic - O(1) space
    public static boolean checkIterative(String str) {
        int left = 0, right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left++) != str.charAt(right--)) return false;
        }
        return true;
    }

    // Stack Logic - O(n) space
    public static boolean checkStack(String str) {
        Stack<Character> stack = new Stack<>();
        for (char c : str.toCharArray()) stack.push(c);
        for (char c : str.toCharArray()) {
            if (c != stack.pop()) return false;
        }
        return true;
    }

    // Deque Logic - O(n) space
    public static boolean checkDeque(String str) {
        Deque<Character> deque = new ArrayDeque<>();
        for (char c : str.toCharArray()) deque.addLast(c);
        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) return false;
        }
        return true;
    }

    // Recursive Logic - O(n) call stack space
    public static boolean checkRecursive(String str, int s, int e) {
        if (s >= e) return true;
        if (str.charAt(s) != str.charAt(e)) return false;
        return checkRecursive(str, s + 1, e - 1);
    }
}