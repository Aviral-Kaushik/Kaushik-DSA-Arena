package DataStructures.LinkedList.PracticeProblems;

import DataStructures.LinkedList.SimpleLinkedList.Helper;
import DataStructures.LinkedList.SimpleLinkedList.Implementation.Node;
import DataStructures.LinkedList.SimpleLinkedList.Implementation.Traversing;

public class SortedInsert {

    /// Problem Statement:
    /// In this problem, we have given a sorted linked list and value, we need to insert that value in the linked list
    /// such that linked list remains sorted.

    /**
     * Time Complexity: O(n)
     * */
    private static Node sortedInsert(Node head, int data) {
        Node newNode = new Node(data);

        if (head == null) {
            return newNode;
        }

        if (data < head.getData()) {
            newNode.next = head;
            return newNode;
        }

        Node current = head;

        while (current.next != null && current.next.getData() < data) {
            current = current.next;
        }

        newNode.next = current.next;
        current.next = newNode;

        return head;
    }

    public static void main(String[] args) {
        Node testCase1 = Helper.buildLinkedList(new int[]{10, 20, 30, 40});
        Node testCase2 = Helper.buildLinkedList(new int[]{10, 25});
        Node testCase3 = Helper.buildLinkedList(new int[]{10, 20});
        Node testCase4 = Helper.buildLinkedList(new int[]{10, 20, 30, 40, 50});

        testCase1 = sortedInsert(testCase1, 25);
        testCase2 = sortedInsert(testCase2, 5);
        testCase3 = sortedInsert(testCase3, 30);
        testCase4 = sortedInsert(testCase4, 45);

        Traversing.traverseLinkedList(testCase1);
        System.out.println();

        Traversing.traverseLinkedList(testCase2);
        System.out.println();

        Traversing.traverseLinkedList(testCase3);
        System.out.println();

        Traversing.traverseLinkedList(testCase4);
    }

}
