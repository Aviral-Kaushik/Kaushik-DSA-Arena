package DataStructures.LinkedList.PracticeProblems;

import DataStructures.LinkedList.SimpleLinkedList.Helper;
import DataStructures.LinkedList.SimpleLinkedList.Implementation.Node;
import DataStructures.LinkedList.SimpleLinkedList.Implementation.Traversing;

import java.util.HashSet;

public class RemoveDuplicatesFromSortedLinkedList {

    /// Problem Statement:
    /// In this problem, we have given a sorted singly linked list that might contain duplicates and our task is to
    /// remove duplicates from that sorted singly linked list.

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * This method will also work even if the provided linked list is not sorted.
     * */
    private static Node removeDuplicatesUsingHashSet(Node head) {
        if (head == null) {
            return null;
        }

        HashSet<Integer> seenElements = new HashSet<>();

        Node current = head;

        while (current != null && current.next != null) {

            if (seenElements.contains(current.next.getData())) {
                // Duplicate Element found
                current.next = current.next.next;
            } else {
                seenElements.add(current.next.getData());
                current = current.next;
            }
        }

        return head;
    }

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * This method will not work if the provided linked list is not un-sorted.
     * */
    private static Node removeDuplicates(Node head) {
        if (head == null) {
            return null;
        }

        Node current = head;

        while (current.next != null) {
            if (current.getData() == current.next.getData()) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }

        return head;
    }

    public static void main(String[] args) {
        Node testCase1 = Helper.buildLinkedList(new int[]{10, 20, 20, 30, 30, 30});
        Node testCase2 = Helper.buildLinkedList(new int[]{5, 10, 15, 20});

        Traversing.traverseLinkedList(removeDuplicatesUsingHashSet(testCase1));
        Traversing.traverseLinkedList(removeDuplicates(testCase1));
        System.out.println();

        Traversing.traverseLinkedList(removeDuplicatesUsingHashSet(testCase2));
        Traversing.traverseLinkedList(removeDuplicates(testCase2));
    }

}
