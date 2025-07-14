package DataStructures.Deque.Implementation;

import DataStructures.LinkedList.DoublyLinkedList.Implementation.Node;

public class DequeUsingDoublyLinkedList {

    private Node front, rear;
    private int size;

    /**
     * Time Complexity: O(n)
     * */
    public void addFront(int data) {
        Node newNode = new Node(data);

        if (front == null) {
            front = rear = newNode;
        } else {
            newNode.next = front;
            front.prev = newNode;
            front = newNode;
        }

        size++;
    }

    /**
     * Time Complexity: O(n)
     * */
    public void addRead(int data) {
        Node newNode = new Node(data);

        if (rear == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            newNode.prev = rear;
            rear = newNode;
        }

        size++;
    }

    /**
     * Time Complexity: O(n)
     * */
    public int removeFirst() {
        if (front == null)
            throw new RuntimeException("Deque is Empty!");

        int data = front.getData();

        front = front.next;
        if (front != null)
            front.prev = null;
        else
            rear = null;

        size--;

        return data;
    }

    /**
     * Time Complexity: O(n)
     * */
    public int removeLast() {
        if (rear == null)
            throw new RuntimeException("Deque is Empty!");

        int data = rear.getData();

        rear = rear.prev;
        if (rear != null)
            rear.next = null;
        else
            front = null;

        size--;
        return data;
    }

    /**
     * Time Complexity: O(n)
     * */
    public int peekFirst() {
        if (front == null)
            throw new RuntimeException("Deque is Empty!");

        return front.getData();
    }

    /**
     * Time Complexity: O(n)
     * */
    public int peekLast() {
        if (rear == null)
            throw new RuntimeException("Deque is Empty!");

        return rear.getData();
    }

    /**
     * Time Complexity: O(n)
     * */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Time Complexity: O(n)
     * */
    public int getSize() {
        return size;
    }

}
