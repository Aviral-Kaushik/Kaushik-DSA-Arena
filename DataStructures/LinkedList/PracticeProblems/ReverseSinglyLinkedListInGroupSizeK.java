package DataStructures.LinkedList.PracticeProblems;

import DataStructures.LinkedList.SimpleLinkedList.Helper;
import DataStructures.LinkedList.SimpleLinkedList.Implementation.Node;
import DataStructures.LinkedList.SimpleLinkedList.Implementation.Traversing;

public class ReverseSinglyLinkedListInGroupSizeK {

    /// Problem Statement:
    /// In this problem, we have given a single linked list and a value k and our task is to reverse the linked list
    /// in group of size k.

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n / k)
     * */
    private static Node reverseLinkedListInGroupKRecursiveSolution(Node head, int k) {
        if (head == null) {
            return null;
        }

        Node current = head;
        Node prev = null, next = null;
        int count = 0;

        while (current != null && count < k) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;

            count++;
        }

        if (next != null) {
            head.next = reverseLinkedListInGroupKRecursiveSolution(next, k);
        }

        return prev;
    }

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * */
    private static Node reverseLinkedListInGroupKIterativeSolution(Node head, int k) {
        if (head == null) {
            return null;
        }

        Node current = head, prevFirst = null;
        boolean isFirstPass = true;

        while (current != null) {
            Node first = current, prev = null;
            int count = 0;

            while (current != null && count < k) {
                Node next = current.next;
                current.next = prev;
                prev = current;
                current = next;

                count++;
            }

            if (isFirstPass) {
                head = prev;
                isFirstPass = false;
            } else {
                prevFirst.next = prev;
            }

            prevFirst = first;
        }

        return head;
    }

    public static void main(String[] args) {
        Node testCase1 = Helper.buildLinkedList(new int[]{10, 20, 30, 40, 50, 60}); // k = 3; O/P: 30 20 10 60 50 40
        Node testCase2 = Helper.buildLinkedList(new int[]{10, 20, 30, 40, 50}); // k = 3; O/P: 30 20 10 50 40
        Node testCase3 = Helper.buildLinkedList(new int[]{10, 20, 30}); // k = 4; O/P: 30 20 10
        Node testCase4 = Helper.buildLinkedList(new int[]{1, 2, 3, 4, 5}); // k = 3; O/P: 3 2 1 5 4

//        Traversing.traverseLinkedList(reverseLinkedListInGroupKRecursiveSolution(testCase1, 3));
        System.out.println();

        Traversing.traverseLinkedList(reverseLinkedListInGroupKIterativeSolution(testCase1, 3));
        System.out.println();

//        Traversing.traverseLinkedList(reverseLinkedListInGroupKRecursiveSolution(testCase2, 3));
        System.out.println();

        Traversing.traverseLinkedList(reverseLinkedListInGroupKIterativeSolution(testCase2, 3));
        System.out.println();

//        Traversing.traverseLinkedList(reverseLinkedListInGroupKRecursiveSolution(testCase3, 4));
        System.out.println();

        Traversing.traverseLinkedList(reverseLinkedListInGroupKIterativeSolution(testCase3, 4));
        System.out.println();

        Traversing.traverseLinkedList(reverseLinkedListInGroupKRecursiveSolution(testCase4, 3));
        System.out.println();

//        Traversing.traverseLinkedList(reverseLinkedListInGroupKIterativeSolution(testCase4, 3));
        System.out.println();

    }
}
