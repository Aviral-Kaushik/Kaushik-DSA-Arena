package DataStructures.Stack.Implementation;

public class StackUsingArray {

    /// Imp: We can use Array List instead of array to create dynamic size stack, in which we does want pass capacity to stack.
    private final int[] arr;
    private final int capacity;
    private int top;

    public StackUsingArray(int capacity) {
        this.capacity = capacity;
        arr = new int[capacity];
        top = -1;
    }

    /**
     * Time Complexity: O(1)
     * */
    public void push(int element) {
        if (top == capacity - 1) throw new RuntimeException("Stack Overflow!");

        arr[++top] = element;
    }

    /**
     * Time Complexity: O(1)
     * */
    public int pop() {
        if (top == -1) throw new RuntimeException("Stack Underflow!");

        return arr[top--];
    }

    /**
     * Time Complexity: O(1)
     * */
    public int peek() {
        if (top == -1) throw new RuntimeException("Stack is empty!");

        return arr[top];
    }

    /**
     * Time Complexity: O(1)
     * */
    public int size() {
        return top + 1;
    }

    /**
     * Time Complexity: O(1)
     * */
    public boolean isEmpty() {
        return top == -1;
    }
}
