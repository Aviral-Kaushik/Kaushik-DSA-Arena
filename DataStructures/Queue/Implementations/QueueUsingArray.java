package DataStructures.Queue.Implementations;

public class QueueUsingArray {

    /**
     * Circular Implementation
     * */
    private final int[] queue;
    private final int capacity;
    private int front, rear, size;

    public QueueUsingArray(int capacity) {
        this.capacity = capacity;
        queue = new int[capacity];
        front = size = 0;
        rear = capacity - 1;
    }

    /**
     * Time Complexity: O(1)
     * */
    public void enqueue(int data) {
        if (isFull())
            throw new RuntimeException("Queue Overflow!");

        rear = (rear + 1) % capacity;
        queue[rear] = data;
        size++;
    }

    /**
     * Time Complexity: O(1)
     * */
    public int dequeue() {
        if (isEmpty())
            throw new RuntimeException("Queue Underflow!");

        int result = queue[front];
        front = (front + 1) % capacity;
        size--;
        return result;
    }

    /**
     * Time Complexity: O(1)
     * */
    public int peek() {
        if (isEmpty())
            throw new RuntimeException("Queue is Empty!");

        return queue[front];
    }

    /**
     * Time Complexity: O(1)
     * */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Time Complexity: O(1)
     * */
    public boolean isFull() {
        return size == capacity;
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
            return -1;

        return queue[front];
    }

    /**
     * Time Complexity: O(1)
     * */
    public int getRear() {
        if (isEmpty())
            return -1;

        return queue[rear];
    }
}
