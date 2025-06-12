package DataStructures.LinkedList.PracticeProblems;

import DataStructures.LinkedList.Utils.NodeWithRandomPointer;

import java.util.HashMap;

public class CloneLinkedListWithRandomPointers {

    /// Problem Statement:
    /// In this problem, we have given a linked list which has a next node and also has a random pointer and this random
    /// pointer can point to any node inside the linked list and our task is to clone the exact same linked list with
    /// same next pointer and same linked list.

    /**
     * HashMap Method
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * */
    private static NodeWithRandomPointer cloneLinkedListWithRandomPointersUsingHashMap(NodeWithRandomPointer head) {
        if (head == null) {
            return null;
        }

        if (head.next == null) {
            return new NodeWithRandomPointer(head.getData());
        }

        HashMap<NodeWithRandomPointer, NodeWithRandomPointer> map = new HashMap<>();

        NodeWithRandomPointer current = head;

        while (current != null) {
            map.put(current, new NodeWithRandomPointer(current.getData()));
            current = current.next;
        }

        current = head;

        while (current != null) {
            NodeWithRandomPointer clone = map.get(current);
            clone.next = map.get(current.next);
            clone.random = map.get(current.random);

            current = current.next;
        }

        return map.get(head);
    }

    /**
     * Efficient Method
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * */
    private static NodeWithRandomPointer cloneLinkedListWithRandomPointersUsingEfficientMethod(NodeWithRandomPointer head) {
        if (head == null) {
            return null;
        }

        if (head.next == null) {
            return new NodeWithRandomPointer(head.getData());
        }

        NodeWithRandomPointer current = head;

        while (current != null) {
            NodeWithRandomPointer next = current.next;
            current.next = new NodeWithRandomPointer(current.getData());
            current.next.next = next;

            current = next;
        }

        for (NodeWithRandomPointer curr = head; curr != null; curr = curr.next.next) {
            curr.next.random = (curr.random == null) ? null : curr.random.next;
        }

        NodeWithRandomPointer newLinkedList = head.next;
        NodeWithRandomPointer clone = newLinkedList;

        for (NodeWithRandomPointer curr = head; curr != null; curr = curr.next) {
            curr.next = curr.next.next;
            clone.next = clone.next != null? clone.next.next : null;
            clone = clone.next;
        }

        return newLinkedList;
    }

    private static void printLinkedList(NodeWithRandomPointer head) {
        NodeWithRandomPointer current = head;

        while (current != null) {
            System.out.print(current.getData() + " ");
            System.out.print(current.getNext() + " ");
            System.out.print(current.getRandom() + " ");

            current = current.next;
        }
    }

    public static void main(String[] args) {
        NodeWithRandomPointer testCase1Head = new NodeWithRandomPointer(10);
        testCase1Head.next = new NodeWithRandomPointer(5);
        testCase1Head.next.next = new NodeWithRandomPointer(20);
        testCase1Head.next.next.next = new NodeWithRandomPointer(15);
        testCase1Head.next.next.next.next = new NodeWithRandomPointer(20);
        testCase1Head.random = testCase1Head.next.next;
        testCase1Head.next.random = testCase1Head.next.next.next;
        testCase1Head.next.next.random = testCase1Head;
        testCase1Head.next.next.next.random = testCase1Head.next.next;
        testCase1Head.next.next.next.next.random = testCase1Head.next.next.next;

        printLinkedList(testCase1Head);
        System.out.println();

        printLinkedList(cloneLinkedListWithRandomPointersUsingHashMap(testCase1Head));
        System.out.println();

        printLinkedList(cloneLinkedListWithRandomPointersUsingEfficientMethod(testCase1Head));
    }

}
