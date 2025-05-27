package DataStructures.LinkedList.DoublyLinkedList;

import DataStructures.LinkedList.DoublyLinkedList.Implementation.Node;

public class Helper {

    public static Node buildDoublyLinkedList(int[] values) {
        if (values == null || values.length == 0) return null;

        Node head = new Node(values[0]);
        Node current = head;

        for (int i = 1; i < values.length; i++) {
            Node newNode = new Node(values[i]);
            current.next = newNode;
            newNode.prev = current;
            current = newNode;
        }

        return head; // return head of the list
    }
}
