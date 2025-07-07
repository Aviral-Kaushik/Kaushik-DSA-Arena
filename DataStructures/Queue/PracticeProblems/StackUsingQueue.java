package DataStructures.Queue.PracticeProblems;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {

    Queue<Integer> queue;

    public StackUsingQueue() {
        queue = new LinkedList<>();
    }

    // Time Complexity: O(n)
    public void push(int element) {
        queue.add(element);
        int size = queue.size();

        for (int i = 0; i < size; i++) {
            queue.add(queue.remove());
        }
    }

    // Time Complexity: O(1)
    public int pop() {
        if (queue.isEmpty()) throw new RuntimeException("Stack is empty");
        return queue.remove();
    }

    // Time Complexity: O(1)
    public int getSize() {
        return queue.size();
    }

    // Time Complexity: O(1)
    public int top() {
        if (queue.isEmpty()) throw new RuntimeException("Stack is empty");
        return queue.peek();
    }

    // Time Complexity: O(1)
    public boolean isEmpty() {
        return queue.isEmpty();
    }
}
