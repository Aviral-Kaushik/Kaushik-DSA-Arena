package DataStructures.LinkedList.CircularLinkedList.Insertion;

import DataStructures.LinkedList.CircularLinkedList.Helper;
import DataStructures.LinkedList.CircularLinkedList.Implementation.Traversing;
import DataStructures.LinkedList.SimpleLinkedList.Implementation.Node;

public class InsertAtGivenPosition {

    /**
     * Time Complexity: O(position)
     * */
    private static Node insertAtGivenPosition(Node head, int position, int data) {
        Node newNode = new Node(data);

        // Case 1: Empty list, and insert at position 1
        if (head == null) {
            if (position == 1) {
                newNode.next = newNode;
                head = newNode;
            }

            return head;
        }

        // Case 2: Insert at position 1 (before head)
        if (position == 1) {
            Node tail = head;
            while (tail.next != head) {
                tail = tail.next;
            }

            newNode.next = head;
            tail.next = newNode;
            return newNode; // new node becomes new head
        }

        // Case 3: Insert at position > 1
        Node currentNode = head;
        int i = 1;

        while (i < position - 1 && currentNode.next != head) {
            currentNode = currentNode.next;
            i++;
        }

        // If position is beyond the length + 1, ignore
        if (i != position - 1) {
            return head;
        }

        newNode.next = currentNode.next;
        currentNode.next = newNode;

        return head;
    }

    public static void main(String[] args) {
        Node testCase1 = Helper.createCircularLinkedList(new int[]{10, 20, 30, 40});
        Node testCase2 = Helper.createCircularLinkedList(new int[]{75, 35, 125});
        Node testCase3 = Helper.createCircularLinkedList(new int[]{33, 47, 65});

        testCase1 = insertAtGivenPosition(testCase1, 3, 15);
        testCase2 = insertAtGivenPosition(testCase2, 2, 105);
        testCase3 = insertAtGivenPosition(testCase3, 5, 87);

        Traversing.traverse(testCase1);
        System.out.println();

        Traversing.traverse(testCase2);
        System.out.println();

        Traversing.traverse(testCase3);
    }

}
