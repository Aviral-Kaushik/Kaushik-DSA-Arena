package DataStructures.LinkedList.PracticeProblems;

import DataStructures.LinkedList.SimpleLinkedList.Helper;
import DataStructures.LinkedList.SimpleLinkedList.Implementation.Node;

public class NthNodeFromEnd {

    /// Problem Statement:
    /// In this problem, we have given a linked list and number n, and our task to print nth node from the end of the
    /// linked list.

    /**
     * Time Complexity: O(n)
     * */
    private static Node getNthLastNodeUsingNaiveMethod(Node head, int value) {
        int length = 0;

        for (Node current = head; current != null; current = current.next) {
            length++;
        }

        if (length < value) {
            return null;
        }

        Node current = head;

        for (int i = 1; i < length - value + 1; i++) {
            current = current.next;
        }

        return current;
    }

    /**
     * Time complexity: O(n)
     * */
    private static Node getNthNodeUsingEfficientMethod(Node head, int value) {
        if (head == null) {
            return null;
        }

        Node slow = head, fast = head;

        // Move fast pointer ahead by n position
        for (int i = 0; i < value; i++) {
            if (fast == null) {
                return null;
            }

            fast = fast.next;
        }

        // Move fast and slow pointer with same speed
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        // When fast pointer become null then slow pointer will be at n position behind last node which we needed.
        return slow;
    }

    public static void main(String[] args) {
        Node testCase1 = Helper.buildLinkedList(new int[]{10, 20, 30, 40, 50});
        Node testCase2 = Helper.buildLinkedList(new int[]{10, 20, 30});
        Node testCase3 = Helper.buildLinkedList(new int[]{10, 20});
        Node testCase4 = Helper.buildLinkedList(new int[]{10, 20, 30, 40, 50, 60, 70});

        System.out.println(getNthLastNodeUsingNaiveMethod(testCase1, 2));
        System.out.println(getNthNodeUsingEfficientMethod(testCase1, 2));

        System.out.println(getNthLastNodeUsingNaiveMethod(testCase2, 3));
        System.out.println(getNthNodeUsingEfficientMethod(testCase2, 3));

        System.out.println(getNthLastNodeUsingNaiveMethod(testCase3, 3));
        System.out.println(getNthNodeUsingEfficientMethod(testCase3, 3));

        System.out.println(getNthLastNodeUsingNaiveMethod(testCase2, 1));
        System.out.println(getNthNodeUsingEfficientMethod(testCase2, 1));

        System.out.println(getNthLastNodeUsingNaiveMethod(testCase4, 3));
        System.out.println(getNthNodeUsingEfficientMethod(testCase4, 3));
    }

}
