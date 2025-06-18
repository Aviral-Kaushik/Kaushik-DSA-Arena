package DataStructures.Stack.Utils;

public class StringStack {

    private Node top;
    private int size;

    public StringStack() {
        this.top = null;
        this.size = 0;
    }

    /**
     * Time Complexity: O(1)
     * */
    public void push(char element) {
        Node newNode = new Node(element);
        newNode.next = top;
        top = newNode;
        size++;
    }

    /**
     * Time Complexity: O(1)
     * */
    public char pop() {
        if (top == null) throw new RuntimeException("Stack Underflow!");

        char res = top.data;
        top = top.next;
        size--;

        return res;
    }

    /**
     * Time Complexity: O(1)
     * */
    public char peek() {
        if (top == null) throw new RuntimeException("Stack is Empty!");

        return top.data;
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

    static class Node {
        char data;
        Node next;

        public Node(char data) {
            this.data = data;
        }
    }

}
