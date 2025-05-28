package DataStructures.LinkedList.DoublyLinkedList.Deletion;

import DataStructures.LinkedList.DoublyLinkedList.Helper;
import DataStructures.LinkedList.DoublyLinkedList.Implementation.Node;
import DataStructures.LinkedList.DoublyLinkedList.Implementation.Traversing;

public class DeleteNodeAtGivenPosition {

    /**
     * Time Complexity: O(position)
     * */
    private static Node deleteNodeAtGivenPosition(Node head, int position) {
        if (head == null) {
            return head;
        }

        if (position == 1) {
            Node newHead = head.next;
            if (newHead != null) {
                newHead.prev = null;
            }
            return newHead;
        }

        Node current = head;
        int i = 1;

        // Traverse to the node at the given position
        while (i < position && current != null) {
            current = current.next;
            i++;
        }

        if (current == null) {
            // Position is beyond the length of the list
            return head;
        }

        if (current.prev != null) {
            current.prev.next = current.next;
        }

        if (current.next != null) {
            current.next.prev = current.prev;
        }

        return head;
    }

    public static void main(String[] args) {
        Node testCase1Head = Helper.buildDoublyLinkedList(new int[]{10, 20, 30});
        Node testCase2Head = Helper.buildDoublyLinkedList(new int[]{5, 10, 20, 30});
        Node testCase3Head = Helper.buildDoublyLinkedList(new int[]{5});

        testCase1Head = deleteNodeAtGivenPosition(testCase1Head, 2);
        testCase2Head = deleteNodeAtGivenPosition(testCase2Head, 3);
        testCase3Head = deleteNodeAtGivenPosition(testCase3Head, 2);

        Traversing.traverseLinkedList(testCase1Head);
        System.out.println();

        Traversing.traverseLinkedList(testCase2Head);
        System.out.println();

        Traversing.traverseLinkedList(testCase3Head);
    }

}