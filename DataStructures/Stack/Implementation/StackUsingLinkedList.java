package DataStructures.Stack.Implementation;

import DataStructures.LinkedList.SimpleLinkedList.Implementation.Node;

public class StackUsingLinkedList {

    private Node top;
    private int size;

    public StackUsingLinkedList() {
        this.top = null;
        this.size = 0;
    }

    /**
     * Time Complexity: O(1)
     * */
    public void push(int element) {
        Node newNode = new Node(element);
        newNode.next = top;
        top = newNode;
        size++;
    }

    /**
     * Time Complexity: O(1)
     * */
    public int pop() {
        if (top == null) throw new RuntimeException("Stack Underflow!");

        int res = top.getData();
        top = top.next;
        size--;

        return res;
    }

    /**
     * Time Complexity: O(1)
     * */
    public int peek() {
        if (top == null) throw new RuntimeException("Stack is Empty!");

        return top.getData();
    }

    /**
     * Time Complexity: O(1)
     * */
    public int size() {
        return size;
    }

    /**
     * Time Complexity: O(1)
     * */
    public boolean isEmpty() {
        return top == null;
    }
}
