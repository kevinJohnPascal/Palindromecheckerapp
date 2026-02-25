import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Palindromecheckerapp {

 public static void main(String[] args) {
  Scanner scanner = new Scanner(System.in);

  System.out.println("--- UC7: Deque-Based Optimized Palindrome Checker ---");
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
  // Step 1: Normalize input (remove spaces/punctuation and lowercase)
  String cleaned = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

  // Step 2: Initialize Deque
  Deque<Character> deque = new ArrayDeque<>();

  // Step 3: Insert characters into the deque
  for (char ch : cleaned.toCharArray()) {
   deque.addLast(ch);
  }

  // Step 4: Compare front and rear until 0 or 1 element remains
  while (deque.size() > 1) {
   char front = deque.removeFirst();
   char rear = deque.removeLast();

   if (front != rear) {
    return false; // Not a palindrome
   }
  }

  return true; // Palindrome confirmed
 }
}