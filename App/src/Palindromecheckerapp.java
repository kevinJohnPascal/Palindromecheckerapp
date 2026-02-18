public class Palindromecheckerapp {
 public static void main(String[] args) {
  // 1. Define the input string
  String original = "radar";
  String reversed = "";

  // 2. The Reversal Loop (Core of UC3)
  // We start at the last index (length - 1) and count down to 0
  for (int i = original.length() - 1; i >= 0; i--) {
   // Concept: String Concatenation (+)
   // Note: Each addition here creates a new String object in memory
   reversed = reversed + original.charAt(i);
  }

  // 3. The Comparison
  // Concept: .equals() compares the letters, not the memory address
  if (original.equalsIgnoreCase(reversed)) {
   System.out.println("Result: " + original + " is a palindrome.");
  } else {
   System.out.println("Result: " + original + " is NOT a palindrome.");
  }
 }
}