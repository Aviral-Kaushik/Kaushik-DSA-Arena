package DataStructures.LinkedList.SimpleLinkedList.Insertion;

import DataStructures.LinkedList.SimpleLinkedList.Implementation.Node;
import DataStructures.LinkedList.SimpleLinkedList.Implementation.Traversing;

public class InsertAtTheEnd {

    /// Problem Statement:
    /// In this problem, we have given a linked list and data and out task is to insert the new node with that data
    /// at the end of the provided linked list.

    /**
     * Time Complexity: O(n)
     * Where n is the length of the linked list
     * */
    private static Node insertAtTheEnd(Node head, int data) {
        if (head == null) {
            head = new Node(data);
            return head;
        }

        Node current = head;

        while (current.next != null) {
            current = current.next;
        }

        current.next = new Node(data);

        return head;
    }

    public static void main(String[] args) {
        Node testCase1Head = new Node(10);
        testCase1Head.next = new Node(20);
        testCase1Head.next.next = new Node(30);

        Node testCase2Head = null;

        Node testCase3Head = new Node(10);

        testCase1Head = insertAtTheEnd(testCase1Head, 40);
        testCase2Head = insertAtTheEnd(testCase2Head, 10);
        testCase3Head = insertAtTheEnd(testCase3Head, 20);

        Traversing.traverseLinkedList(testCase1Head);
        System.out.println();

        Traversing.traverseLinkedList(testCase2Head);
        System.out.println();

        Traversing.traverseLinkedList(testCase3Head);
    }
}
