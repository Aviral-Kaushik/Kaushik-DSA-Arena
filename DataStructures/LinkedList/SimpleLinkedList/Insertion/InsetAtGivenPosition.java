package DataStructures.LinkedList.SimpleLinkedList.Insertion;

import DataStructures.LinkedList.SimpleLinkedList.Implementation.Node;
import DataStructures.LinkedList.SimpleLinkedList.Implementation.Traversing;

public class InsetAtGivenPosition {

    /// Problem Statement:
    /// In this problem, weh have given a linked list, data and a position and out task is to insert a new node with
    /// that data and the given position is the provided linked list.

    /**
     * Time Complexity: O(position)
     * */
    private static Node insertAtGivenPosition(Node head, int data, int position) {
        Node newNode = new Node(data);

        if (position == 1) {
            head = new Node(data);
            return head;
        }

        int i = 1;
        Node current = head;

        while (i <= position - 2 && current != null) {
            current = current.next;

            i++;
        }

        if (current == null) {
            return head;
        }

        newNode.next = current.next;
        current.next = newNode;

        return head;
    }


    public static void main(String[] args) {
        Node testCase1Head = new Node(10);
        testCase1Head.next = new Node(30);
        testCase1Head.next.next = new Node(50);
        testCase1Head.next.next.next = new Node(70);

        Node testCase2Head = new Node(5);
        testCase2Head.next = new Node(15);
        testCase2Head.next.next = new Node(25);
        testCase2Head.next.next.next = new Node(35);

        Node testCase3Head = new Node(10);
        testCase3Head.next = new Node(20);

        Node testCase4Head = new Node(10);
        testCase4Head.next = new Node(20);
        testCase4Head.next.next = new Node(30);
        testCase4Head.next.next.next = new Node(40);
        testCase4Head.next.next.next.next = new Node(50);

        testCase1Head = insertAtGivenPosition(testCase1Head, 20, 2);
        testCase2Head = insertAtGivenPosition(testCase2Head, 10, 5);
        testCase3Head = insertAtGivenPosition(testCase3Head, 8, 4);
        testCase4Head = insertAtGivenPosition(testCase4Head, 45, 4);

        Traversing.traverseLinkedList(testCase1Head);
        System.out.println();

        Traversing.traverseLinkedList(testCase2Head);
        System.out.println();

        Traversing.traverseLinkedList(testCase3Head);
        System.out.println();

        Traversing.traverseLinkedList(testCase4Head);
    }

}
