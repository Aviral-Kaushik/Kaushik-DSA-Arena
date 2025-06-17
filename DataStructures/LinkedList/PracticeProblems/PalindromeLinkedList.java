package DataStructures.LinkedList.PracticeProblems;

import java.util.Objects;

public class PalindromeLinkedList {

    /// Problem Statement:
    /// In this problem, we have given a linked list and otu task to check whether the linked list is palindrome or not.

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * */
    private static boolean isPalindrome(Node head) {
        if (head == null) {
            return true;
        }

        Node slow = head, fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node rev = reverseLinkedList(slow.next);
        Node current = head;

        while (rev != null) {
            if (!Objects.equals(rev.data, current.data)) {
                return false;
            }

            rev = rev.next;
            current = current.next;
        }

        return true;
    }

    private static Node reverseLinkedList(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node current = head;
        Node prev = null;

        while (current != null) {
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }

    public static void main(String[] args) {
        Node testCase1 = new Node("R");
        testCase1.next = new Node("A");
        testCase1.next.next = new Node("D");
        testCase1.next.next.next = new Node("A");
        testCase1.next.next.next.next = new Node("R");

        Node testCase2 = new Node("G");
        testCase2.next = new Node("F");
        testCase2.next.next = new Node("G");

        Node testCase3 = new Node("G");
        testCase3.next = new Node("E");
        testCase3.next.next = new Node("E");
        testCase3.next.next.next = new Node("K");

        System.out.println(isPalindrome(testCase1));
        System.out.println(isPalindrome(testCase2));
        System.out.println(isPalindrome(testCase3));
    }

    static class Node {
        String data;
        Node next;

        public Node(String data) {
            this.data = data;
        }
    }
}
