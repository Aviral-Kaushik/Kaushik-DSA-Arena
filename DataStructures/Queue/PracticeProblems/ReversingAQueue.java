package DataStructures.Queue.PracticeProblems;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReversingAQueue {

    /// Problem Statement:
    /// In this problem, we have given a queue and our task is to reverse that queue.

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * */
    private static void reverseQueue(Queue<Integer> queue) {
        Stack<Integer> stack = new Stack<>();

        while (!queue.isEmpty()) {
            stack.push(queue.peek());
            queue.remove();
        }

        while (!stack.isEmpty()) {
            queue.add(stack.peek());
            stack.pop();
        }
    }

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * */
    private static void reverseQueueUsingRecursion(Queue<Integer> queue) {
        if (queue.isEmpty()) {
            return;
        }

        int element = queue.peek();

        queue.remove();

        reverseQueueUsingRecursion(queue);

        queue.add(element);
    }

    public static void main(String[] args) {
        Queue<Integer> testCase1 = new LinkedList<>();
        testCase1.add(10);
        testCase1.add(5);
        testCase1.add(15);
        testCase1.add(20);

        reverseQueue(testCase1);
        System.out.println(testCase1);

        reverseQueueUsingRecursion(testCase1);
        System.out.println(testCase1);

    }

}
