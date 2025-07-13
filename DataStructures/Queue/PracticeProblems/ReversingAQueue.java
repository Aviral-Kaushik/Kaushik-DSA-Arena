package DataStructures.Queue.PracticeProblems;

import DataStructures.Queue.Utils.PrintQueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReversingAQueue {

    /// Problem Statement:
    /// In this problem, we have given a queue and our task is to reverse that queue.

    private static Queue<Integer> reverseQueue(Queue<Integer> queue) {
        Stack<Integer> stack = new Stack<>();

        while (!queue.isEmpty()) {
            stack.push(queue.peek());
            queue.remove();
        }

        while (stack.isEmpty()) {
            queue.add(stack.peek());
            stack.pop();
        }

        return queue;
    }

    public static void main(String[] args) {
        Queue<Integer> testCase1 = new LinkedList<>();
        testCase1.add(10);
        testCase1.add(5);
        testCase1.add(15);
        testCase1.add(20);

        PrintQueue.printQueue(reverseQueue(testCase1));
    }

}
