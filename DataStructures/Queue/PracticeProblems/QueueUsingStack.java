package DataStructures.Queue.PracticeProblems;

import java.util.Stack;

public class QueueUsingStack {

    Stack<Integer> stack1 = new Stack<>(); // For enqueue
    Stack<Integer> stack2 = new Stack<>(); // For dequeue

    // Enqueue operation (O(1))
    public void enqueue(int x) {
        stack1.push(x);
    }

    // Dequeue operation (Amortized O(1))
    public int dequeue() {
        if (isEmpty())
            throw new RuntimeException("Queue is Empty!");

        if (stack2.isEmpty()) {
            // Transfer elements from stack1 to stack2
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        return stack2.pop();
    }

    // peek operation (Amortized O(1))
    public int peek() {
        if (isEmpty())
            throw new RuntimeException("Queue is Empty!");

        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        return stack2.peek();
    }

    // Time Complexity (O(1))
    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    // Time Complexity (O(1))
    public int getSize() {
        return stack1.size() + stack2.size();
    }

}
