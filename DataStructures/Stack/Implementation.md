# Stack Implementation

### 1. Stack Implementation using Array
```
class Stack {
    private int[] arr;
    private int top;
    private int capacity;

    Stack(int size) {
        arr = new int[size];
        capacity = size;
        top = -1;
    }

    void push(int x) {
        if (top == capacity - 1) throw new RuntimeException("Stack Overflow");
        arr[++top] = x;
    }

    int pop() {
        if (top == -1) throw new RuntimeException("Stack Underflow");
        return arr[top--];
    }

    int peek() {
        if (top == -1) throw new RuntimeException("Stack is Empty");
        return arr[top];
    }
    
    public int size() {
        return top + 1;
    }

    boolean isEmpty() {
        return top == -1;
    }
}
```

### 2. Stack Implementation Using Linked List
```
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class StackUsingLinkedList {
    private Node top;
    private int size;

    public StackUsingLinkedList() {
        this.top = null;
        this.size = 0;
    }

    public void push(int x) {
        Node newNode = new Node(x);
        newNode.next = top;
        top = newNode;
        size++;
    }

    public int pop() {
        if (top == null) throw new RuntimeException("Stack Underflow");
        int val = top.data;
        top = top.next;
        size--;
        return val;
    }

    public int peek() {
        if (top == null) throw new RuntimeException("Stack is Empty");
        return top.data;
    }
    
    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return top == null;
    }
}
```

### 3. Stack Implementation Using Built-in Java Library:
```
import java.util.Stack;

class StackUsingLibrary {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Top element: " + stack.peek());   // 30
        System.out.println("Popped: " + stack.pop());         // 30
        System.out.println("Is empty? " + stack.isEmpty());   // false
    }
}
```