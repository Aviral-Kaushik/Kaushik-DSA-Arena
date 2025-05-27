package DataStructures.LinkedList.SimpleLinkedList.Deletion;

import DataStructures.LinkedList.SimpleLinkedList.Implementation.Node;
import DataStructures.LinkedList.SimpleLinkedList.Implementation.Traversing;

public class DeleteLastNode {

    /**
     * Time Complexity: O(n)
     * */
    private static Node deleteLastNode(Node head) {
        if (head == null || head.next == null) {
            return null;
        }

        Node currentNode = head;

        while (currentNode.next.next != null) {
            currentNode = currentNode.next;
        }

        currentNode.next = null;

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

        testCase1Head = deleteLastNode(testCase1Head);
        testCase2Head = deleteLastNode(testCase2Head);
        testCase3Head = deleteLastNode(testCase3Head);

        Traversing.traverseLinkedList(testCase1Head);
        System.out.println();

        Traversing.traverseLinkedList(testCase2Head);
        System.out.println();

        Traversing.traverseLinkedList(testCase3Head);
    }
}
