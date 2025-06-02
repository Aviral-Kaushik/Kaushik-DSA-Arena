package DataStructures.LinkedList.CircularLinkedList.Insertion;

import DataStructures.LinkedList.CircularLinkedList.Helper;
import DataStructures.LinkedList.CircularLinkedList.Implementation.Traversing;
import DataStructures.LinkedList.SimpleLinkedList.Implementation.Node;

public class InsertAtBeginning {

    /**
     * Time Complexity: O(n)
     * */
    private static Node insertAtBeginning(Node head, int data) {
        Node newNode = new Node(data);

        if (head == null) {
            newNode.next = newNode;
            return newNode;
        }

        Node currentNode = head;

        while (currentNode.next != head) {
            currentNode = currentNode.next;
        }

        currentNode.next = newNode;
        newNode.next = head;
        head = newNode;

        return head;
    }

    /**
     * Time Complexity: O(1)
     * */
    private static Node insertAtBeginningUsingEfficientSolution(Node head, int data) {
        Node newNode = new Node(data);

        if (head == null) {
            newNode.next = newNode;
            return newNode;
        }

        newNode.next = head.next;
        head.next = newNode;

        int temp = head.getData();
        head.setData(newNode.getData());
        newNode.setData(temp);

        return head;
    }

    public static void main(String[] args) {
        Node testCase1 = Helper.createCircularLinkedList(new int[]{10, 20, 30, 40});
        Node testCase2 = Helper.createCircularLinkedList(new int[]{75, 35, 125});
        Node testCase3 = Helper.createCircularLinkedList(new int[]{33, 47, 65});

        testCase1 = insertAtBeginning(testCase1, 15);
        testCase1 = insertAtBeginningUsingEfficientSolution(testCase1, 5);

        testCase2 = insertAtBeginning(testCase2, 105);
        testCase2 = insertAtBeginningUsingEfficientSolution(testCase2, 7);

        testCase3 = insertAtBeginning(testCase3, 87);
        testCase3 = insertAtBeginningUsingEfficientSolution(testCase3, 17);

        Traversing.traverse(testCase1);
        System.out.println();

        Traversing.traverse(testCase2);
        System.out.println();

        Traversing.traverse(testCase3);
    }
}
