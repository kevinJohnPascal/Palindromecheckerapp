



 public class Palindromecheckerapp{
 public static void main(String[] args) {
 // 1. Hardcoded String (The input)

 String original = "madam";
 String reversed = "";

 // 2. Logic: Reverse the string using a for loop
 // We start from the last character and move to the first
 for (int i = original.length() - 1; i >= 0; i--) {
 reversed = reversed + original.charAt(i);
 }

 // 3. Comparison: Check if original equals reversed
 // Note: Use .equals() for content comparison, not ==
 if (original.equals(reversed)) {
 System.out.println(original + " is a palindrome.");
 } else {
 System.out.println(original + " is not a palindrome.");
 }
 }
 }