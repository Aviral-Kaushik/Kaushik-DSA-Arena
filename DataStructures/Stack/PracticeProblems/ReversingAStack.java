package DataStructures.Stack.PracticeProblems;

import java.util.Stack;

public class ReversingAStack {

    /**
     * Time Complexity: O(n²) in worst-case due to nested recursion.
     * Space Complexity: O(n) for recursion call stack.
     * */
    private static void reverseStack(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }

        int top = stack.pop();
        reverseStack(stack);
        insertAtBottom(stack, top);
    }

    private static void insertAtBottom(Stack<Integer> stack, int item) {
        if (stack.isEmpty()) {
            stack.push(item);
            return;
        }

        int top = stack.pop();
        insertAtBottom(stack, item);
        stack.push(top);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        System.out.println("Original Stack: " + stack);
        reverseStack(stack);
        System.out.println("Reversed Stack: " + stack);
    }
}
