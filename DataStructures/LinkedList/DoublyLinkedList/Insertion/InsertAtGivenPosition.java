package DataStructures.LinkedList.DoublyLinkedList.Insertion;

import DataStructures.LinkedList.DoublyLinkedList.Helper;
import DataStructures.LinkedList.DoublyLinkedList.Implementation.Node;
import DataStructures.LinkedList.DoublyLinkedList.Implementation.Traversing;

public class InsertAtGivenPosition {

    private static Node insertAtPosition(Node head, int value, int position) {
        Node newNode = new Node(value);

        if (position == 1) {
            newNode.next = head;

            if (head != null) {
                head.prev = newNode;
            }

            head = newNode;
            return head;
        }

        int i = 1;
        Node current = head;

        while (i < position - 1 && current != null) {
            current = current.next;
            i++;
        }

        if (current == null) {
            return head;
        }

        newNode.next = current.next;
        newNode.prev = current;

        if (current.next != null) {
            current.next.prev = newNode;
        }

        current.next = newNode;

        return head;
    }

    public static void main(String[] args) {
        Node testCase1Head = Helper.buildDoublyLinkedList(new int[]{10, 20, 30});
        Node testCase2Head = Helper.buildDoublyLinkedList(new int[]{5, 10, 20, 30});
        Node testCase3Head = Helper.buildDoublyLinkedList(new int[]{5});

        testCase1Head = insertAtPosition(testCase1Head, 40, 3);
        testCase2Head = insertAtPosition(testCase2Head, 23, 4);
        testCase3Head = insertAtPosition(testCase3Head, 45, 1);

        Traversing.traverseLinkedList(testCase1Head);
        System.out.println();

        Traversing.traverseLinkedList(testCase2Head);
        System.out.println();

        Traversing.traverseLinkedList(testCase3Head);
    }

}
