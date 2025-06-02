package DataStructures.LinkedList.CircularLinkedList.Deletion;

import DataStructures.LinkedList.CircularLinkedList.Helper;
import DataStructures.LinkedList.CircularLinkedList.Implementation.Traversing;
import DataStructures.LinkedList.SimpleLinkedList.Implementation.Node;

public class DeleteNodeAtGivenPosition {

    /// Assumption: Number of Nodes >= k

    /**
     * Time Complexity: O(position)
     * */
    private static Node deleteNodeAtGivenPosition(Node head, int position) {
        if (head == null || position <= 0) {
            return head;
        }

        // Case 1: List has only one node
        if (head.next == head && position == 1) {
            return null;
        }

        // Case 2: Delete head node
        if (position == 1) {
//            Node tail = head;
//            while (tail.next != head) {
//                tail = tail.next;
//            }
//
//            head = head.next;
//            tail.next = head;

            Node nextElement = head.next;

            head.setData(nextElement.getData());
            head.next = nextElement.next;

            return head;
        }

        // Case 3: Delete at position > 1
        Node current = head;
        int i = 1;

        while (i < position - 1 && current.next != head) {
            current = current.next;
            i++;
        }

        // If position is invalid (beyond list size)
        if (current.next == head) {
            return head;
        }

        // Skip the node at the given position
        current.next = current.next.next;

        return head;
    }

    public static void main(String[] args) {
        Node testCase1 = Helper.createCircularLinkedList(new int[]{10, 20, 30, 40});
        Node testCase2 = Helper.createCircularLinkedList(new int[]{75, 35, 125});
        Node testCase3 = Helper.createCircularLinkedList(new int[]{33, 47, 65});

        testCase1 = deleteNodeAtGivenPosition(testCase1, 2);

        testCase2 = deleteNodeAtGivenPosition(testCase2, 1);

        testCase3 = deleteNodeAtGivenPosition(testCase3, 5);

        Traversing.traverse(testCase1);
        System.out.println();

        Traversing.traverse(testCase2);
        System.out.println();

        Traversing.traverse(testCase3);
    }

}
