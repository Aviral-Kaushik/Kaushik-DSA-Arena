package DataStructures.LinkedList.Algorithms.FloydCycleDetection;

import DataStructures.LinkedList.SimpleLinkedList.Implementation.Node;

public class LoopDetection {

    /// Problem Statement:
    /// In this algorithm, we have given a linked list, and we need to detect that this linked list contains a loop or not.

    /// Floyd Cycle Detection Algorithm (Time Complexity: O(n))
    /// This algorithm uses 2 pointer slow & fast pointers, initially both pointers point to head.
    /// Then slow pointer moves one node at a time and fast pointer moves two nodes at a time.
    /// If both pointers meet at a point then linked list contains a loop or cycle and if they do not meet then
    /// it does not contain loop or cycle.

    /**
     * Floyd Cycle Detection Algorithm
     * Time Complexity: O(n)
     * */
    private static boolean containsLoop(Node head) {
        if (head == null) {
            return false;
        }

        Node slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Node testCase1Head = new Node(10);
        Node testCase1Node2 = new Node(12);
        testCase1Head.next = testCase1Node2;
        testCase1Node2.next = new Node(15);
        testCase1Node2.next.next = new Node(20);
        testCase1Node2.next.next.next = new Node(25);
        testCase1Node2.next.next.next.next = testCase1Node2; // Adding a loop/cycle

        Node testCase2Head = new Node(57);
        testCase2Head.next = new Node(117);
        testCase2Head.next.next = new Node(37);
        testCase2Head.next.next.next = new Node(42);
        testCase2Head.next.next.next.next = new Node(33);
        testCase2Head.next.next.next.next.next = null;

        System.out.println(containsLoop(testCase1Head));
        System.out.println(containsLoop(testCase2Head));
    }
}
