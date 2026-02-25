import java.util.*;

// 1. Define the Strategy Interface
interface PalindromeStrategy {
    boolean isValid(String input);
}

// 2. Concrete Strategy: Stack-Based
class StackStrategy implements PalindromeStrategy {
    @Override
    public boolean isValid(String input) {
        String cleaned = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        Stack<Character> stack = new Stack<>();
        for (char c : cleaned.toCharArray()) stack.push(c);

        for (char c : cleaned.toCharArray()) {
            if (c != stack.pop()) return false;
        }
        return true;
    }
}

// 3. Concrete Strategy: Deque-Based
class DequeStrategy implements PalindromeStrategy {
    @Override
    public boolean isValid(String input) {
        String cleaned = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        Deque<Character> deque = new ArrayDeque<>();
        for (char c : cleaned.toCharArray()) deque.addLast(c);

        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) return false;
        }
        return true;
    }
}

// 4. Context Class
class PalindromeContext {
    private PalindromeStrategy strategy;

    public void setStrategy(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean executeStrategy(String input) {
        return strategy.isValid(input);
    }
}

// 5. Main Application
public class Palindromecheckerapp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PalindromeContext context = new PalindromeContext();

        System.out.println("--- UC12: Strategy Pattern Palindrome Checker ---");
        System.out.print("Enter string: ");
        String text = scanner.nextLine();

        System.out.println("Choose Strategy: 1) Stack 2) Deque");
        int choice = scanner.nextInt();

        if (choice == 1) {
            context.setStrategy(new StackStrategy());
            System.out.println("Using Stack Strategy...");
        } else {
            context.setStrategy(new DequeStrategy());
            System.out.println("Using Deque Strategy...");
        }

        if (context.executeStrategy(text)) {
            System.out.println("Result: It is a palindrome!");
        } else {
            System.out.println("Result: Not a palindrome.");
        }
        scanner.close();
    }
}