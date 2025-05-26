package DataStructures.LinkedList.SimpleLinkedList.Insertion;

import DataStructures.LinkedList.SimpleLinkedList.Implementation.Node;
import DataStructures.LinkedList.SimpleLinkedList.Implementation.Traversing;

public class InsertAtTheBeginning {


    /// Problem Statement:
    /// In this problem, we have given a linked list and data and out task is to insert the new node with that data
    /// at the starting of the provided linked list.

    /**
     * Time Complexity: O(1)
     * */
    private static Node insertAtBeginning(Node head, int data) {
        Node newNode = new Node(data);
        newNode.next = head;

        return newNode;
    }

    public static void main(String[] args) {
        Node testCase1Head = new Node(10);
        testCase1Head.next = new Node(20);
        testCase1Head.next.next = new Node(30);

        Node testCase2Head = new Node(10);

        Node testCase3Head = null;

        testCase1Head = insertAtBeginning(testCase1Head, 5);
        testCase2Head = insertAtBeginning(testCase2Head, 15);
        testCase3Head = insertAtBeginning(testCase3Head, 17);

        Traversing.traverseLinkedList(testCase1Head);
        System.out.println();

        Traversing.traverseLinkedList(testCase2Head);
        System.out.println();

        Traversing.traverseLinkedList(testCase3Head);
    }

}
