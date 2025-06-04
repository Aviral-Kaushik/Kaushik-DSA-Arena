package DataStructures.LinkedList.Algorithms.FloydCycleDetection;

import DataStructures.LinkedList.SimpleLinkedList.Implementation.Node;
import DataStructures.LinkedList.SimpleLinkedList.Implementation.Traversing;

public class DetectAndDeleteLoop {

    /// Problem Statement:
    /// In this problem, we have given a linked list that might contains loop/cycle and our task is to detect the loop
    /// and delete the loop from the linked list.

    /// Solution Idea:
    /// Firstly we detect that does linked list contains a loop or not using Floyd Cycle Detection Algorithm.
    /// If slow and fast pointers meet at a position then we point slow pointer to head again.
    /// After that we move both of the pointers with same speed (one node at a time).
    /// At the place, where both pointers will meet this time will be start of the cycle & we point that node's next to
    /// null, .i.e, delete the loop/cycle.

    /**
     * Time Complexity: O(n)
     * */
    private static Node deleteLoop(Node head) {
        if (head == null) {
            return null;
        }

        Node slow = head, fast = head;
        boolean containsLoop = false;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                containsLoop = true;
                break;
            }
        }

        if (!containsLoop) {
            return head;
        }

        slow = head;

        while (slow.next != fast.next) {
            slow = slow.next;
            fast = fast.next;
        }

        fast.next = null;

        return head;
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

        Traversing.traverseLinkedList(deleteLoop(testCase1Head));
        System.out.println();

        Traversing.traverseLinkedList(deleteLoop(testCase2Head));
    }

}
