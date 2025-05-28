package DataStructures.LinkedList.PracticeProblems;

import DataStructures.LinkedList.DoublyLinkedList.Helper;
import DataStructures.LinkedList.DoublyLinkedList.Implementation.Node;
import DataStructures.LinkedList.DoublyLinkedList.Implementation.Traversing;

public class ReverseDoublyLinkedList {

    /// Problem Statement:
    /// In this problem, we have given a doubly linked list and our task to reverse that linked list.

    /**
     * Time Complexity: O(n)
     * */
    private static Node reverseLinkedList(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node previousNode = null;
        Node currentNode = head;

        while (currentNode != null) {
            previousNode = currentNode.prev;
            currentNode.prev = currentNode.next;
            currentNode.next = previousNode;

            currentNode = currentNode.prev;
        }

        return previousNode.prev;
    }

    public static void main(String[] args) {
        Node testCase1Head = Helper.buildDoublyLinkedList(new int[]{10, 20, 30, 40});
        Node testCase2Head = Helper.buildDoublyLinkedList(new int[]{10});

        testCase1Head = reverseLinkedList(testCase1Head);
        testCase2Head = reverseLinkedList(testCase2Head);

        Traversing.traverseLinkedList(testCase1Head);
        Traversing.traverseLinkedList(testCase2Head);
    }
}
