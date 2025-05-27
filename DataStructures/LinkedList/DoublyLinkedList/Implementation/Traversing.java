package DataStructures.LinkedList.DoublyLinkedList.Implementation;

public class Traversing {

    /// Problem Statement:
    /// In this problem, we have given a head node of linked list & we need to traverse the whole linked list;

    /**
     * Time Complexity: O(n)
     * */
    public static void traverseLinkedList(Node head) {
        Node current = head;

        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);

        traverseLinkedList(head);
    }
}

