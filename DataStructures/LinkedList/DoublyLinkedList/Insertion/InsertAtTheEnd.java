package DataStructures.LinkedList.DoublyLinkedList.Insertion;

import DataStructures.LinkedList.DoublyLinkedList.Helper;
import DataStructures.LinkedList.DoublyLinkedList.Implementation.Node;
import DataStructures.LinkedList.DoublyLinkedList.Implementation.Traversing;

public class InsertAtTheEnd {

    /**
     * Time Complexity: O(n)
     * */
    private static Node insertAtTheEnd(Node head, int value) {
        Node newNode = new Node(value);

        if (head == null) {
            return newNode;
        }

        Node currentNode = head;

        while (currentNode.next != null) {
            currentNode = currentNode.next;
        }

        newNode.prev = currentNode;
        currentNode.next = newNode;

        return head;
    }

    public static void main(String[] args) {
        Node testCase1Head = Helper.buildDoublyLinkedList(new int[]{10, 20, 30});
        Node testCase2Head = Helper.buildDoublyLinkedList(new int[]{5, 10, 20, 30});
        Node testCase3Head = Helper.buildDoublyLinkedList(new int[]{5});

        testCase1Head = insertAtTheEnd(testCase1Head, 40);
        testCase2Head = insertAtTheEnd(testCase2Head, 23);
        testCase3Head = insertAtTheEnd(testCase3Head, 45);

        Traversing.traverseLinkedList(testCase1Head);
        System.out.println();

        Traversing.traverseLinkedList(testCase2Head);
        System.out.println();

        Traversing.traverseLinkedList(testCase3Head);
    }
}
