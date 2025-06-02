package DataStructures.LinkedList.CircularLinkedList.Implementation;

import DataStructures.LinkedList.CircularLinkedList.Helper;
import DataStructures.LinkedList.SimpleLinkedList.Implementation.Node;

public class Traversing {

    /**
     * Time Complexity: O(n)
     * */
    public static void traverse(Node head) {
        if (head == null) {
            return;
        }

        Node current = head;

        do {
            System.out.print(current.getData() + " ");
            current = current.next;
        } while (current != head);
    }

    public static void main(String[] args) {
        Node testCase1 = Helper.createCircularLinkedList(new int[]{10, 20, 30, 40});
        Node testCase2 = Helper.createCircularLinkedList(new int[]{75, 35, 125});
        Node testCase3 = Helper.createCircularLinkedList(new int[]{33, 47, 65});

        traverse(testCase1);
        System.out.println();

        traverse(testCase2);
        System.out.println();

        traverse(testCase3);
    }
}
