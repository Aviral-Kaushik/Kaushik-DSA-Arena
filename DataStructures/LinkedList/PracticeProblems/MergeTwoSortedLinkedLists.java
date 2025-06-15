package DataStructures.LinkedList.PracticeProblems;

import DataStructures.LinkedList.SimpleLinkedList.Helper;
import DataStructures.LinkedList.SimpleLinkedList.Implementation.Node;
import DataStructures.LinkedList.SimpleLinkedList.Implementation.Traversing;

public class MergeTwoSortedLinkedLists {

    /// Problem Statement:
    /// In this problem, we have given 2 sorted linked list, and we need to merge them in a way that result linked list
    /// must be sorted.

    /**
     * Time Complexity: O(m + n)
     * Space Complexity: O(1)
     * Where m is the length of first linked list and n is the length of second linked list.
     * */
    private static Node mergeSortedLinkedList(Node head1, Node head2) {
        if (head1 == null) {
            return head2;
        }

        if (head2 == null) {
            return head1;
        }

        Node head, tail;

        Node current1 = head1;
        Node current2 = head2;

        if (head1.getData() < head2.getData()) {
            head = head1;
            tail = head1;

            current1 = current1.next;
        } else {
            head = head2;
            tail = head2;

            current2 = current2.next;
        }


        while (current1 != null && current2 != null) {
            if (current1.getData() < current2.getData()) {
                tail.next = current1;
                tail = current1;

                current1 = current1.next;
            } else {
                tail.next = current2;
                tail = current2;

                current2 = current2.next;
            }
        }

        if (current1 != null) {
            tail.next = current1;
        } else {
            tail.next = current2;
        }

        return head;
    }

    public static void main(String[] args) {
        Node testCase1Head1 = Helper.buildLinkedList(new int[]{10, 20, 30});
        Node testCase1Head2 = Helper.buildLinkedList(new int[]{5, 25});

        Node testCase2Head1 = Helper.buildLinkedList(new int[]{10});
        Node testCase2Head2 = Helper.buildLinkedList(new int[]{40, 50});

        Node testCase3Head1 = Helper.buildLinkedList(new int[]{10, 20, 30, 40});
        Node testCase3Head2 = Helper.buildLinkedList(new int[]{5, 15, 17, 18, 35});

        Traversing.traverseLinkedList(mergeSortedLinkedList(testCase1Head1, testCase1Head2));
        System.out.println();

        Traversing.traverseLinkedList(mergeSortedLinkedList(testCase2Head1, testCase2Head2));
        System.out.println();

        Traversing.traverseLinkedList(mergeSortedLinkedList(testCase3Head1, testCase3Head2));
    }

}
