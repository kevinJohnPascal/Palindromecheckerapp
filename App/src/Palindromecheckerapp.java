import java.util.Stack;

public class Palindromecheckerapp {
 public static void main(String[] args) {
  String input = "racecar";
  Stack<Character> stack = new Stack<>();

  // 1. Push: Add all characters of the string into the stack
  for (int i = 0; i < input.length(); i++) {
   stack.push(input.charAt(i));
  }

  // 2. Pop and Compare: Build the reversed string
  String reversed = "";
  while (!stack.isEmpty()) {
   // Pop removes the top element (the last one pushed)
   reversed = reversed + stack.pop();
  }

  // 3. Output Result
  if (input.equals(reversed)) {
   System.out.println(input + " is a palindrome.");
  } else {
   System.out.println(input + " is not a palindrome.");
  }
 }
}