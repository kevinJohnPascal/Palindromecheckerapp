import java.util.Scanner;

class Node {
 char data;
 Node next;

 Node(char data) {
  this.data = data;
  this.next = null;
 }
}

public class Palindromecheckerapp {

 public static void main(String[] args) {
  Scanner scanner = new Scanner(System.in);

  System.out.println("--- UC8: Linked List Based Palindrome Checker ---");
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
  String cleaned = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
  if (cleaned.isEmpty()) return true;

  // Step 1: Build the Singly Linked List
  Node head = new Node(cleaned.charAt(0));
  Node current = head;
  for (int i = 1; i < cleaned.length(); i++) {
   current.next = new Node(cleaned.charAt(i));
   current = current.next;
  }

  // Step 2: Find the middle using Fast & Slow pointers
  Node slow = head;
  Node fast = head;
  while (fast != null && fast.next != null) {
   slow = slow.next;
   fast = fast.next.next;
  }

  // Step 3: Reverse the second half of the list
  Node secondHalf = reverseList(slow);
  Node firstHalf = head;

  // Step 4: Compare halves
  Node tempSecond = secondHalf;
  boolean result = true;
  while (tempSecond != null) {
   if (firstHalf.data != tempSecond.data) {
    result = false;
    break;
   }
   firstHalf = firstHalf.next;
   tempSecond = tempSecond.next;
  }

  return result;
 }

 // Helper method to reverse a linked list in-place
 private static Node reverseList(Node head) {
  Node prev = null;
  Node current = head;
  while (current != null) {
   Node nextNode = current.next;
   current.next = prev;
   prev = current;
   current = nextNode;
  }
  return prev;
 }
}