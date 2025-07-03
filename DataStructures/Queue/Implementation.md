# 📘 Queue Implementation in Java 

### ✅ 1. Queue Implementation Using Array (Fixed Size)
```
class ArrayQueue {
    private int[] arr;
    private int front, rear, size, capacity;

    ArrayQueue(int capacity) {
        this.capacity = capacity;
        arr = new int[capacity];
        front = 0;
        size = 0;
        rear = -1;
    }

    void enqueue(int data) {
        if (size == capacity) throw new RuntimeException("Queue Overflow");
        rear = (rear + 1) % capacity;
        arr[rear] = data;
        size++;
    }

    int dequeue() {
        if (isEmpty()) throw new RuntimeException("Queue Underflow");
        int val = arr[front];
        front = (front + 1) % capacity;
        size--;
        return val;
    }

    int peek() {
        if (isEmpty()) throw new RuntimeException("Queue is Empty");
        return arr[front];
    }

    boolean isEmpty() {
        return size == 0;
    }

    int getSize() {
        return size;
    }
}
```

### ✅ 2. Queue Implementation Using Linked List
```
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
    }
}

class LinkedListQueue {
    private Node front, rear;

    void enqueue(int data) {
        Node newNode = new Node(data);
        if (rear == null) {
            front = rear = newNode;
            return;
        }
        rear.next = newNode;
        rear = newNode;
    }

    int dequeue() {
        if (front == null) throw new RuntimeException("Queue Underflow");
        int val = front.data;
        front = front.next;
        if (front == null) rear = null;
        return val;
    }

    int peek() {
        if (front == null) throw new RuntimeException("Queue is Empty");
        return front.data;
    }

    boolean isEmpty() {
        return front == null;
    }
}
```

### ✅ 3. Queue Using Java’s Built-in Queue Interface (LinkedList)
```
import java.util.*;

public class BuiltInQueueExample {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(10);  // enqueue
        queue.offer(20);
        queue.offer(30);

        System.out.println(queue.peek());    // 10
        System.out.println(queue.poll());    // 10 (dequeue)
        System.out.println(queue.isEmpty()); // false
    }
}
```

- ```offer()``` – add to queue
- ```poll()``` – remove from front
- ```peek()``` – get front element
- ```isEmpty()``` – check if empty

### ⚙️ Time Complexity Summary
| Operation | Array Queue | LinkedList Queue | Java Queue |
|-----------|-------------|------------------|------------|
| Enqueue   | O(1)        | O(1)             | O(1)       |
| Dequeue   | O(1)        | O(1)             | O(1)       |
| Peek      | O(1)        | O(1)             | O(1)       |
