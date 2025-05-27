package DataStructures.LinkedList.PracticeProblems;

import DataStructures.LinkedList.SimpleLinkedList.Implementation.Node;

public class Searching {

    /**
     * Time Complexity: O(n)
     * */
    private static int searchIteratively(Node head, int target) {
        int position = 1;

        while (head != null) {
            if (head.getData() == target) {
                return position;
            }

            head = head.next;

            position++;
        }

        return -1;
    }

    private static int searchRecursively(Node head, int target) {
        if (head == null) {
            return -1;
        }

        if (head.getData() == target) {
            return 1;
        }

        int res = searchRecursively(head.next, target);
        return res == -1 ? -1 : res + 1;
    }

    public static void main(String[] args) {
        Node testCase1Head = new Node(10);
        testCase1Head.next = new Node(5);
        testCase1Head.next.next = new Node(20);
        testCase1Head.next.next.next = new Node(15);

        Node testCase2Head = new Node(10);
        testCase2Head.next = new Node(15);

        Node testCase3Head = new Node(3);
        testCase3Head.next = new Node(20);
        testCase3Head.next.next = new Node(5);

        System.out.println(searchIteratively(testCase1Head, 20));
        System.out.println(searchRecursively(testCase1Head, 20));

        System.out.println(searchIteratively(testCase2Head, 20));
        System.out.println(searchRecursively(testCase2Head, 20));

        System.out.println(searchIteratively(testCase3Head, 3));
        System.out.println(searchRecursively(testCase3Head, 3));
    }

}
