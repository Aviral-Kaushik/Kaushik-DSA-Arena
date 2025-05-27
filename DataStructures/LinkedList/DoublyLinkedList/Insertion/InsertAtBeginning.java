package DataStructures.LinkedList.DoublyLinkedList.Insertion;

import DataStructures.LinkedList.DoublyLinkedList.Helper;
import DataStructures.LinkedList.DoublyLinkedList.Implementation.Node;
import DataStructures.LinkedList.DoublyLinkedList.Implementation.Traversing;

public class InsertAtBeginning {

    /**
     * Time Complexity: O(1)
     * */
    private static Node insetAtBeginning(Node head, int value) {
        Node newNode = new Node(value);

        if (head == null) {
            return newNode;
        }

        newNode.next = head;
        head.prev = newNode;
        head = newNode;

        return head;
    }

    public static void main(String[] args) {
        Node testCase1Head = Helper.buildDoublyLinkedList(new int[]{10, 20, 30});
        Node testCase2Head = Helper.buildDoublyLinkedList(new int[]{5, 10, 20, 30});
        Node testCase3Head = Helper.buildDoublyLinkedList(new int[]{5});

        testCase1Head = insetAtBeginning(testCase1Head, 5);
        testCase2Head = insetAtBeginning(testCase2Head, 25);
        testCase3Head = insetAtBeginning(testCase3Head, 10);

        Traversing.traverseLinkedList(testCase1Head);
        System.out.println();

        Traversing.traverseLinkedList(testCase2Head);
        System.out.println();

        Traversing.traverseLinkedList(testCase3Head);
    }
}
