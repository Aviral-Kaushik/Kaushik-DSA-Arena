package DataStructures.LinkedList.PracticeProblems;

import DataStructures.LinkedList.SimpleLinkedList.Helper;
import DataStructures.LinkedList.SimpleLinkedList.Implementation.Node;
import DataStructures.LinkedList.SimpleLinkedList.Implementation.Traversing;

import java.util.ArrayList;

public class ReverseSinglyLinkedList {

    /// Problem Statement:
    /// In this problem, we have given a linked list, and we have to reverse that linked list.

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * */
    private static Node reverseLinkedListUsingNaiveMethod(Node head) {
        if (head == null) {
            return null;
        }

        ArrayList<Integer> arr = new ArrayList<>();

        for (Node current = head; current != null; current = current.next) {
            arr.add(current.getData());
        }

        for (Node current = head; current != null; current = current.next) {
            current.setData(arr.remove(arr.size() - 1));
        }

        return head;
    }

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * */
    private static Node reverseLinkedListUsingEfficientMethod(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node current = head;
        Node prev = null;

        while (current != null) {
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }

    public static void main(String[] args) {
        Node testCase1 = Helper.buildLinkedList(new int[]{10, 20, 30, 40});
        Node testCase2 = Helper.buildLinkedList(new int[]{10, 20, 30});
        Node testCase3 = Helper.buildLinkedList(new int[]{10});

        Traversing.traverseLinkedList(reverseLinkedListUsingNaiveMethod(testCase1));
        System.out.println();

        Traversing.traverseLinkedList(reverseLinkedListUsingEfficientMethod(testCase1));
        System.out.println();

        Traversing.traverseLinkedList(reverseLinkedListUsingNaiveMethod(testCase2));
        System.out.println();

        Traversing.traverseLinkedList(reverseLinkedListUsingEfficientMethod(testCase2));
        System.out.println();

        Traversing.traverseLinkedList(reverseLinkedListUsingNaiveMethod(testCase3));
        System.out.println();

        Traversing.traverseLinkedList(reverseLinkedListUsingEfficientMethod(testCase3));
        System.out.println();
    }

}
