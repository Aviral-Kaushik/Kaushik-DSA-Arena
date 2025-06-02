package DataStructures.LinkedList.CircularLinkedList.Deletion;

import DataStructures.LinkedList.CircularLinkedList.Helper;
import DataStructures.LinkedList.CircularLinkedList.Implementation.Traversing;
import DataStructures.LinkedList.SimpleLinkedList.Implementation.Node;

public class DeleteFirstNode {

    /**
     * Time Complexity: O(n)
     * */
    private static Node deleteFirstNode(Node head) {
        if (head == null || head.next == null) {
            return null;
        }

        Node currentNode = head;
        Node newHead = head.next;

        while (currentNode.next != head) {
            currentNode = currentNode.next;
        }

        currentNode.next = newHead;

        return newHead;
    }

    /**
     * Time Complexity: O(1)
     * */
    private static Node deleteFirstNodeEfficiently(Node head) {
        if (head == null || head.next == null) {
            return null;
        }

        Node nextElement = head.next;

        head.setData(nextElement.getData());
        head.next = nextElement.next;

        return head;
    }

    public static void main(String[] args) {
        Node testCase1 = Helper.createCircularLinkedList(new int[]{10, 20, 30, 40});
        Node testCase2 = Helper.createCircularLinkedList(new int[]{75, 35, 125});
        Node testCase3 = Helper.createCircularLinkedList(new int[]{33, 47, 65});

        testCase1 = deleteFirstNode(testCase1);
        testCase1 = deleteFirstNodeEfficiently(testCase1);

        testCase2 = deleteFirstNode(testCase2);
        testCase2 = deleteFirstNodeEfficiently(testCase2);

        testCase3 = deleteFirstNode(testCase3);
        testCase3 = deleteFirstNodeEfficiently(testCase3);

        Traversing.traverse(testCase1);
        System.out.println();

        Traversing.traverse(testCase2);
        System.out.println();

        Traversing.traverse(testCase3);
    }
}
