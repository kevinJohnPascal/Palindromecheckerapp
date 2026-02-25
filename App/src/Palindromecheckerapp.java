import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Palindromecheckerapp {

 public static void main(String[] args) {
  Scanner scanner = new Scanner(System.in);

  System.out.println("--- UC6: Queue + Stack Based Palindrome Check ---");
  System.out.print("Enter a string: ");
  String input = scanner.nextLine();

  if (isPalindrome(input)) {
   System.out.println("Result: '" + input + "' is a palindrome.");
  } else {
   System.out.println("Result: '" + input + "' is NOT a palindrome.");
  }

  scanner.close();
 }

 public static boolean isPalindrome(String input) {
  // Clean the input: remove non-alphanumeric characters and convert to lowercase
  String cleaned = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

  Queue<Character> queue = new LinkedList<>();
  Stack<Character> stack = new Stack<>();

  // Enqueue and Push each character
  for (char ch : cleaned.toCharArray()) {
   queue.add(ch);  // Enqueue
   stack.push(ch); // Push
  }

  // Logical Comparison: Compare FIFO vs LIFO
  while (!queue.isEmpty()) {
   char fromQueue = queue.poll(); // Dequeue (First character)
   char fromStack = stack.pop();  // Pop (Last character)

   if (fromQueue != fromStack) {
    return false; // Mismatch found
   }
  }

  return true; // All characters matched
 }
}