package DataStructures.Queue.Implementations;

import DataStructures.LinkedList.SimpleLinkedList.Implementation.Node;

public class QueueUsingLinkedList {

    private Node front, rear;
    private int size;

    /**
     * Time Complexity: O(1)
     * */
    public void enqueue(int data) {
        Node newNode = new Node(data);

        if (rear == null) {
            front = rear = newNode;
            return;
        }

        rear.next = newNode;
        rear = newNode;

        size++;
    }

    /**
     * Time Complexity: O(1)
     * */
    public int dequeue() {
        if (front == null)
            throw new RuntimeException("Queue Underflow!");

        int result = front.getData();
        front = front.next;

        if (front == null)
            rear = null;

        size--;

        return result;
    }

    /**
     * Time Complexity: O(1)
     * */
    public int peek() {
        if (front == null)
            throw new RuntimeException("Queue is Empty!");

        return front.getData();
    }

    /**
     * Time Complexity: O(1)
     * */
    public boolean isEmpty() {
        return front == null;
    }

    /**
     * Time Complexity: O(1)
     * */
    public int getSize() {
        return size;
    }

    /**
     * Time Complexity: O(1)
     * */
    public int getFront() {
        if (isEmpty())
            throw new RuntimeException("Queue is empty!");

        return front.getData();
    }

    /**
     * Time Complexity: O(1)
     * */
    public int getRear() {
        if (isEmpty())
            throw new RuntimeException("Queue is empty!");

        return rear.getData();
    }
}
