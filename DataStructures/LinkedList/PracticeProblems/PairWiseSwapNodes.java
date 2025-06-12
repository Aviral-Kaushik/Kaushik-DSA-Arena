package DataStructures.LinkedList.PracticeProblems;

import DataStructures.LinkedList.SimpleLinkedList.Helper;
import DataStructures.LinkedList.SimpleLinkedList.Implementation.Node;
import DataStructures.LinkedList.SimpleLinkedList.Implementation.Traversing;

public class PairWiseSwapNodes {

    /// Problem Statement:
    /// In this problem, we have given a linked list and out task is swap it pair-wise, i.e., swap first 2 elements
    /// with each other -> then next 2 elements with each other and so on.

    /// Test Cases:
    /// Input: 1 -> 2 -> 3 -> 4
    /// Output: 2 -> 1 -> 4 -> 3

    /// Input: 1 -> 2 -> 3 -> 4 -> 5
    /// Output: 2 -> 1 -> 4 -> 3 -> 5

    /// Input: 1
    /// Output: 1

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * */
    private static Node pairWiseSwapUsingNaiveMethod(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node current = head;

        while (current != null && current.next != null) {
            int temp = current.getData();
            current.setData(current.next.getData());
            current.next.setData(temp);

            current = current.next.next;
        }

        return head;
    }

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * */
    private static Node pairWiseSwapUsingEfficientMethod(Node head) {
        // If list is empty or has only one node
        if (head == null || head.next == null) return head;

        Node prev = null;
        Node current = head;
        head = current.next; // New head will be the second node

        while (current != null && current.next != null) {
            Node nextNode = current.next;
            Node nextPair = nextNode.next;

            // Swap current and nextNode
            nextNode.next = current;
            current.next = nextPair;

            if (prev != null) {
                prev.next = nextNode;
            }

            // Update pointers for next pair
            prev = current;
            current = nextPair;
        }

        return head;
    }

    public static void main(String[] args) {
        Node testCase1 = Helper.buildLinkedList(new int[]{1, 2, 3, 4});
        Node testCase2 = Helper.buildLinkedList(new int[]{1, 2, 3, 4, 5});
        Node testCase3 = Helper.buildLinkedList(new int[]{1});

//        Traversing.traverseLinkedList(pairWiseSwapUsingNaiveMethod(testCase1));
//        System.out.println();
        Traversing.traverseLinkedList(pairWiseSwapUsingEfficientMethod(testCase1));
        System.out.println();

//        Traversing.traverseLinkedList(pairWiseSwapUsingNaiveMethod(testCase2));
//        System.out.println();
        Traversing.traverseLinkedList(pairWiseSwapUsingEfficientMethod(testCase2));
        System.out.println();

        Traversing.traverseLinkedList(pairWiseSwapUsingNaiveMethod(testCase3));
        System.out.println();
        Traversing.traverseLinkedList(pairWiseSwapUsingEfficientMethod(testCase3));

    }
}
