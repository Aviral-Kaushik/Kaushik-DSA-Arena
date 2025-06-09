package DataStructures.LinkedList.PracticeProblems;

import DataStructures.LinkedList.SimpleLinkedList.Helper;
import DataStructures.LinkedList.SimpleLinkedList.Implementation.Node;
import DataStructures.LinkedList.SimpleLinkedList.Implementation.Traversing;

public class SegregateEvenAndOddNodes {

    /// Problem Statement:
    /// In this problem, we have given a singly linked list and out task is to put all even nodes a together and odd
    /// nodes together (segregate) in same order.

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * */
    private static Node segregateEvenAndOddNodesUsingNaiveMethod(Node head) {
        Node evenStart = null, evenEnd = null, oddStart = null, oddEnd = null;

        for (Node current = head; current != null; current = current.next) {
            int currentData = current.getData();

            if (currentData % 2 == 0) {
                if (evenStart == null) {
                    evenStart = current;
                    evenEnd = current;
                } else {
                    evenEnd.next = current;
                    evenEnd = current;
                }
            } else {
                if (oddStart == null) {
                    oddStart = current;
                    oddEnd = current;
                } else {
                    oddEnd.next = current;
                    oddEnd = current;
                }
            }
        }

        if (evenStart == null || oddStart == null) {
            return head;
        }

        evenEnd.next = oddStart;
        oddEnd.next = null;

        return evenStart;
    }

    public static void main(String[] args) {
        Node testCase1 = Helper.buildLinkedList(new int[]{17, 15, 8, 12, 5});
        Node testCase2 = Helper.buildLinkedList(new int[]{8, 12, 20});
        Node testCase3 = Helper.buildLinkedList(new int[]{3, 5, 1});
        Node testCase4 = Helper.buildLinkedList(new int[]{10, 5, 4, 3, 6});

        Traversing.traverseLinkedList(segregateEvenAndOddNodesUsingNaiveMethod(testCase1));
        System.out.println();

        Traversing.traverseLinkedList(segregateEvenAndOddNodesUsingNaiveMethod(testCase2));
        System.out.println();

        Traversing.traverseLinkedList(segregateEvenAndOddNodesUsingNaiveMethod(testCase3));
        System.out.println();

        Traversing.traverseLinkedList(segregateEvenAndOddNodesUsingNaiveMethod(testCase4));
    }

}
