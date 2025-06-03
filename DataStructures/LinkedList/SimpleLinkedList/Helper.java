package DataStructures.LinkedList.SimpleLinkedList;

import DataStructures.LinkedList.SimpleLinkedList.Implementation.Node;

public class Helper {

    public static Node buildLinkedList(int[] values) {
        if (values == null || values.length == 0) return null;

        Node head = new Node(values[0]);
        Node current = head;

        for (int i = 1; i < values.length; i++) {
            Node newNode = new Node(values[i]);
            current.next = newNode;
            current = newNode;
        }

        return head; // return head of the list
    }
}
