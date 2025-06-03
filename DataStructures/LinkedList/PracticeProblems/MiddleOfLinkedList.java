package DataStructures.LinkedList.PracticeProblems;

import DataStructures.LinkedList.SimpleLinkedList.Helper;
import DataStructures.LinkedList.SimpleLinkedList.Implementation.Node;

public class MiddleOfLinkedList {

    /// Problem Statement:
    /// In this problem, we have given a singly linked list, and we have to find the middle element of it.

    /**
     * Time Complexity: O(n)
     * */
    private static Node getMiddleNode(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static void main(String[] args) {
        Node testCase1 = Helper.buildLinkedList(new int[]{10, 5, 20, 15, 25}); // 20
        Node testCase2 = Helper.buildLinkedList(new int[]{10, 5, 20, 15, 25, 30}); // 15
        Node testCase3 = Helper.buildLinkedList(new int[]{10}); // 10
        Node testCase4 = Helper.buildLinkedList(new int[]{10, 20}); // 20
        Node testCase5 = Helper.buildLinkedList(new int[]{10, 20, 30, 40}); // 30
        Node testCase6 = Helper.buildLinkedList(new int[]{10, 20, 30, 40, 50}); // 30
        Node testCase7 = Helper.buildLinkedList(new int[]{10, 20, 30}); // 20

        System.out.println(getMiddleNode(testCase1));
        System.out.println(getMiddleNode(testCase2));
        System.out.println(getMiddleNode(testCase3));
        System.out.println(getMiddleNode(testCase4));
        System.out.println(getMiddleNode(testCase5));
        System.out.println(getMiddleNode(testCase6));
        System.out.println(getMiddleNode(testCase7));
    }
}
