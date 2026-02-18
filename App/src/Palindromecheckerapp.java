public class Palindromecheckerapp {
 public static void main(String[] args) {
  String input = "deified";

  // 1. Convert String to Character Array
  char[] charArray = input.toCharArray();

  // 2. Initialize Two Pointers
  int start = 0;
  int end = charArray.length - 1;
  boolean isPalindrome = true;

  // 3. Two-Pointer Logic
  while (start < end) {
   // Compare characters at both ends
   if (charArray[start] != charArray[end]) {
    isPalindrome = false;
    break; // Optimization: stop as soon as a mismatch is found
   }
   start++; // Move forward
   end--;   // Move backward
  }

  // 4. Output Result
  if (isPalindrome) {
   System.out.println(input + " is a palindrome.");
  } else {
   System.out.println(input + " is not a palindrome.");
  }
 }
}