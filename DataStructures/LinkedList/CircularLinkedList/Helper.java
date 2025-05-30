package DataStructures.LinkedList.CircularLinkedList;

import DataStructures.LinkedList.SimpleLinkedList.Implementation.Node;

public class Helper {

    // Helper function to create a circular linked list from an array
    public static Node createCircularLinkedList(int[] values) {
        if (values == null || values.length == 0) {
            return null;
        }

        Node head = new Node(values[0]);
        Node current = head;

        for (int i = 1; i < values.length; i++) {
            current.next = new Node(values[i]);
            current = current.next;
        }

        current.next = head;  // Make it circular
        return head;
    }
}
