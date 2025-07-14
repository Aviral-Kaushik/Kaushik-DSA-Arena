# 📘 Deque Implementation in Java

### ✅ 1. Custom Deque Implementation Using Doubly Linked List
```
class Node {
    int data;
    Node prev, next;

    Node(int data) {
        this.data = data;
    }
}

class MyDeque {
    private Node front, rear;
    private int size;

    public void addFirst(int data) {
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

    public void addLast(int data) {
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

    public int removeFirst() {
        if (front == null) throw new RuntimeException("Deque Underflow");
        int val = front.data;
        front = front.next;
        if (front != null) front.prev = null;
        else rear = null;
        size--;
        return val;
    }

    public int removeLast() {
        if (rear == null) throw new RuntimeException("Deque Underflow");
        int val = rear.data;
        rear = rear.prev;
        if (rear != null) rear.next = null;
        else front = null;
        size--;
        return val;
    }

    public int peekFirst() {
        if (front == null) throw new RuntimeException("Deque is Empty");
        return front.data;
    }

    public int peekLast() {
        if (rear == null) throw new RuntimeException("Deque is Empty");
        return rear.data;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }
}
```

### ✅ 2. Using Java’s Built-in ArrayDeque (Recommended)
```ArrayDeque``` is part of Java’s **Collections Framework** and is the preferred way to use a deque due to its high performance.
```
import java.util.*;

public class DequeDemo {
    public static void main(String[] args) {
        Deque<Integer> deque = new ArrayDeque<>();

        deque.addFirst(10);  // insert at front
        deque.addLast(20);   // insert at rear
        deque.offerFirst(5); // safe add at front
        deque.offerLast(25); // safe add at rear

        System.out.println(deque.peekFirst()); // 5
        System.out.println(deque.peekLast());  // 25

        deque.removeFirst(); // removes 5
        deque.removeLast();  // removes 25

        System.out.println(deque); // [10, 20]
    }
}
```

### 🔄 Time Complexity
| Operation     | Time (Built-in & Custom) |
|---------------|--------------------------|
| `addFirst`    | O(1)                     |
| `addLast`     | O(1)                     |
| `removeFirst` | O(1)                     |
| `removeLast`  | O(1)                     |
| `peekFirst`   | O(1)                     |
| `peekLast`    | O(1)                     |
