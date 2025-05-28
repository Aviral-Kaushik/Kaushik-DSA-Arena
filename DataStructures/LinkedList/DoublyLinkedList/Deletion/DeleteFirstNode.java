package DataStructures.LinkedList.DoublyLinkedList.Deletion;

import DataStructures.LinkedList.DoublyLinkedList.Helper;
import DataStructures.LinkedList.DoublyLinkedList.Implementation.Node;
import DataStructures.LinkedList.DoublyLinkedList.Implementation.Traversing;

public class DeleteFirstNode {

    /**
     * Time Complexity: O(1)
     * */
    private static Node deleteFirstNode(Node head) {
        if (head == null || head.next == null) {
            return null;
        }

        head = head.next;
        head.prev = null;

        return head;
    }

    public static void main(String[] args) {
        Node testCase1Head = Helper.buildDoublyLinkedList(new int[]{10, 20, 30});
        Node testCase2Head = Helper.buildDoublyLinkedList(new int[]{5, 10, 20, 30});
        Node testCase3Head = Helper.buildDoublyLinkedList(new int[]{5});

        testCase1Head = deleteFirstNode(testCase1Head);
        testCase2Head = deleteFirstNode(testCase2Head);
        testCase3Head = deleteFirstNode(testCase3Head);

        Traversing.traverseLinkedList(testCase1Head);
        System.out.println();

        Traversing.traverseLinkedList(testCase2Head);
        System.out.println();

        Traversing.traverseLinkedList(testCase3Head);
    }

}
