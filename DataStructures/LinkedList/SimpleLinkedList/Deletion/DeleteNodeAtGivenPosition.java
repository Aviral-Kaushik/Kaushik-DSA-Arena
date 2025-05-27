package DataStructures.LinkedList.SimpleLinkedList.Deletion;

import DataStructures.LinkedList.SimpleLinkedList.Implementation.Node;
import DataStructures.LinkedList.SimpleLinkedList.Implementation.Traversing;

public class DeleteNodeAtGivenPosition {

    /**
     * Time Complexity: O(position)
     * */
    private static Node deleteNodeAtGivenPosition(Node head, int position) {
        if (head == null) {
            return null;
        }

        if (position == 1) {
            head = head.next;
            return head;
        }

        Node current = head;
        int i = 1;

        while (i <= position - 1 && current.next != null) {
            current = current.next;

            i++;
        }

        if (current.next == null) {
            return head;
        }

        current.next = current.next.next;

        return head;
    }

    public static void main(String[] args) {
        Node testCase1Head = new Node(10);
        testCase1Head.next = new Node(20);
        testCase1Head.next.next = new Node(30);
        testCase1Head.next.next.next = new Node(40);

        Node testCase2Head = new Node(10);

        Node testCase3Head = new Node(20);
        testCase3Head.next = new Node(25);
        testCase3Head.next.next = new Node(35);

        testCase1Head = deleteNodeAtGivenPosition(testCase1Head, 3);
        testCase2Head = deleteNodeAtGivenPosition(testCase2Head, 2);
        testCase3Head = deleteNodeAtGivenPosition(testCase3Head, 1);

        Traversing.traverseLinkedList(testCase1Head);
        System.out.println();

        Traversing.traverseLinkedList(testCase2Head);
        System.out.println();

        Traversing.traverseLinkedList(testCase3Head);
    }
}
