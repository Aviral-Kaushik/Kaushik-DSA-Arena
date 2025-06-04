package DataStructures.LinkedList.PracticeProblems;

import DataStructures.LinkedList.SimpleLinkedList.Implementation.Node;
import DataStructures.LinkedList.SimpleLinkedList.Implementation.Traversing;

public class DeleteNodeWithOnlyPointer {

    /// Problem Statement:
    /// In this problem, we have given a pointer that points to a node in the linked list and our task is to delete
    /// that node from the linked list.
    /// Assumption: The node that we have to delete will not be the last node in the linked list

    /// Solution Idea:
    /// For solving this question what we do we copy the data of next node to the node given as input & then we
    /// delete the next node by adjusting the links.

    /**
     * Time Complexity: O(1)
     * */
    private static void deleteNode(Node node) {
        node.setData(node.next.getData());
        node.next = node.next.next;
    }

    public static void main(String[] args) {
        Node testCase1Head = new Node(10);
        testCase1Head.next = new Node(20);
        Node testCase1Ptr = new Node(30);
        testCase1Head.next.next = testCase1Ptr;
        testCase1Ptr.next = new Node(40);
        testCase1Ptr.next.next = new Node(50);

        deleteNode(testCase1Ptr);

        Traversing.traverseLinkedList(testCase1Head);
    }

}
