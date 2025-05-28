package DataStructures.LinkedList.DoublyLinkedList.Deletion;

import DataStructures.LinkedList.DoublyLinkedList.Helper;
import DataStructures.LinkedList.DoublyLinkedList.Implementation.Node;
import DataStructures.LinkedList.DoublyLinkedList.Implementation.Traversing;

public class DeleteLastNode {

    /**
     * Time Complexity: O(n)
     * */
    private static Node deleteLastNode(Node head) {
        if (head == null || head.next == null) {
            return null;
        }

        Node currentNode = head;

        while(currentNode.next != null) {
            currentNode = currentNode.next;
        }

        currentNode.prev.next = null;

        return head;
    }

    public static void main(String[] args) {
        Node testCase1Head = Helper.buildDoublyLinkedList(new int[]{10, 20, 30});
        Node testCase2Head = Helper.buildDoublyLinkedList(new int[]{5, 10, 20, 30});
        Node testCase3Head = Helper.buildDoublyLinkedList(new int[]{5});

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
