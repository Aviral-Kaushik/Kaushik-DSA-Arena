package DataStructures.Stack.PracticeProblems;

import java.util.Objects;
import java.util.Stack;

public class StackWithGetMin {

    /// Problem Statement:
    /// In this problem, we need to support getMin function in stack that returns the minimum element in stack at any
    /// moment in O(1) time complexity along with push, pop, peek, isEmpty & size operations.

    public static void main(String[] args) {
        StackWithGetMinUsingAuxiliaryStack stack1 = new StackWithGetMinUsingAuxiliaryStack();
        StackWithGetMinInConstantSpace stack2 = new StackWithGetMinInConstantSpace();

//        stack1.push(20);
//        stack1.push(10);
//        System.out.print(stack1.getMin() + " ");
//        stack1.push(5);
//        System.out.print(stack1.getMin() + " ");
//        stack1.pop();
//        System.out.print(stack1.getMin() + " ");
//        stack1.pop();
//        System.out.print(stack1.getMin() + " ");

        stack1.push(5);
        stack1.push(4);
        stack1.push(3);
        System.out.print(stack1.getMin() + " ");
        stack1.pop();
        System.out.print(stack1.getMin() + " ");
        stack1.push(2);
        System.out.print(stack1.getMin() + " ");

        System.out.println();

        stack2.push(5);
        stack2.push(4);
        stack2.push(3);
        System.out.print(stack2.getMin() + " ");
        stack2.pop();
        System.out.print(stack2.getMin() + " ");
        stack2.push(2);
        System.out.print(stack2.getMin() + " ");
        stack2.push(-5);
        stack2.push(-3);
        stack2.push(2);
        stack2.push(-10);
        System.out.print(stack2.getMin() + " ");
        stack2.pop();
        System.out.print(stack2.getMin() + " ");
        stack2.pop();
        stack2.pop();
        System.out.print(stack2.getMin() + " ");
        stack2.pop();
        System.out.print(stack2.getMin() + " ");
        stack2.pop();
        stack2.pop();
        stack2.pop();
        System.out.print(stack2.getMin() + " ");
    }

}

class StackWithGetMinUsingAuxiliaryStack {

    /// Better Method (not efficient method) as it maintains an extra auxiliary stack for minimum elements.

    private final Stack<Integer> mainStack, auxiliaryStack;

    public StackWithGetMinUsingAuxiliaryStack() {
        mainStack = new Stack<>();
        auxiliaryStack = new Stack<>();
    }

    public void push(int data) {
        mainStack.push(data);

        if (auxiliaryStack.isEmpty()) {
            auxiliaryStack.push(data);
            return;
        }

        if (auxiliaryStack.peek() >= mainStack.peek()) {
            auxiliaryStack.push(data);
        }
    }

    public int pop() {
        if (mainStack.isEmpty()) {
            System.out.println("Stack Underflow");
            return -1;
        }

        if (Objects.equals(mainStack.peek(), auxiliaryStack.peek())) {
            auxiliaryStack.pop();
        }

        return mainStack.pop();
    }

    public int peek() {
        return mainStack.peek();
    }

    public boolean isEmpty() {
        return mainStack.isEmpty();
    }

    public int size() {
        return mainStack.size();
    }

    public int getMin() {
        return auxiliaryStack.peek();
    }
}

class StackWithGetMinInConstantSpace {

    /// Efficient Method as it does not require one more stack and hence it is more memory friendly.
    /// Note: This implementation also handles negative numbers insertion and deletion in the stack.

    private final Stack<Integer> stack;
    private int min;

    public StackWithGetMinInConstantSpace() {
        stack = new Stack<>();
    }

    public void push(int element) {
        if (stack.isEmpty()) {
            stack.push(element);
            min = element;
        } else if (element <= min) {
            stack.push(2 * element - min);
            min = element;
        } else {
            stack.push(element);
        }
    }

    public int pop() {
        if (stack.isEmpty()) {
            System.out.println("Stack Underflow!");
            return -1;
        }

        int res = stack.pop();

        if (res <= min) {
            int originalMin = min;
            min = 2 * min - res;
            return originalMin;
        }

        return res;
    }

    public int peek() {
        int res = stack.peek();
        return res <= min ? min : res;
    }

    public int getMin() {
        return min;
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public int size() {
        return stack.size();
    }
}
