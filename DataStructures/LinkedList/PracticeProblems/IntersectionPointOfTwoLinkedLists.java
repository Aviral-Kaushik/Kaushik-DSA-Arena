package DataStructures.LinkedList.PracticeProblems;

import DataStructures.LinkedList.SimpleLinkedList.Implementation.Node;

import java.util.HashSet;

public class IntersectionPointOfTwoLinkedLists {

    /// Problem Statement:
    /// In this problem, we have given 2 linked list that might have common element and we need to return the intersection point
    /// after which all elements are common in both linked list.

    /**
     * Time Complexity: O(m + n)
     * Space Complexity: O(n)
     * Where m is number of elements in linked list 1 and n is the number of elements in linked list 2.
     * */
    private static Node getIntersectionPointUsingHasSetMethod(Node head1, Node head2) {
        HashSet<Node> set = new HashSet<>();

        Node current = head1;

        while (current != null) {
            set.add(current);
            current = current.next;
        }

        current = head2;

        while (current != null) {
            if (set.contains(current)) {
                return current;
            }

            current = current.next;
        }

        return null;
    }

    /**
     * Time Complexity: O(m + n)
     * Space Complexity: O(1)
     * Where m is number of elements in linked list 1 and n is the number of elements in linked list 2.
     * */
    private static Node getIntersectionPointUsingDifferenceMethod(Node head1, Node head2) {
        Node current1 = head1;
        Node current2 = head2;

        int numberOfElementInLL1 = getCount(head1);
        int numberOfElementInLL2 = getCount(head2);
        int difference;

        if (numberOfElementInLL1 > numberOfElementInLL2) {
            difference = numberOfElementInLL1 - numberOfElementInLL2;
        } else {
            difference = numberOfElementInLL2 - numberOfElementInLL1;

            Node temp = current1;
            current1 = current2;
            current2 = temp;
        }

        // Move the pointer forward by d nodes
        for (int i = 0; i < difference; i++) {
            if (current1 == null)
                return null;
            current1 = current1.next;
        }

        // Move both pointers until they intersect
        while (current1 != null && current2 != null) {
            if (current1 == current2)
                return current1;
            current1 = current1.next;
            current2 = current2.next;
        }

        return null;
    }


    // Function to get the count of nodes in a linked list
    static int getCount(Node head) {
        int cnt = 0;
        Node curr = head;
        while (curr != null) {
            cnt++;
            curr = curr.next;
        }
        return cnt;
    }

    public static void main(String[] args) {
        // creation of first list: 10 -> 15 -> 30
        Node head1 = new Node(10);
        head1.next = new Node(15);
        head1.next.next = new Node(30);

        // creation of second list: 3 -> 6 -> 9 -> 15 -> 30
        Node head2 = new Node(3);
        head2.next = new Node(6);
        head2.next.next = new Node(9);

        // 15 is the intersection point
        head2.next.next.next = head1.next;

        System.out.println(getIntersectionPointUsingHasSetMethod(head1, head2));
        System.out.println(getIntersectionPointUsingDifferenceMethod(head1, head2));
    }

}
