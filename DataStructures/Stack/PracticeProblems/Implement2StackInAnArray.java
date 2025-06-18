package DataStructures.Stack.PracticeProblems;

public class Implement2StackInAnArray {

    /// Problem Statement
    /// Your task is to implement 2 stacks in one array efficiently. You need to implement 4 methods.
    ///
    /// twoStacks : Initialize the data structures and variables to be used to implement 2 stacks in one array.
    /// push1 : pushes element into the first stack.
    /// push2 : pushes element into the second stack.
    /// pop1 : pops an element from the first stack and returns the popped element. If the first stack is empty, it should return -1.
    /// pop2 : pops an element from the second stack and returns the popped element. If the second stack is empty, it should return -1.

    public static void main(String[] args) {
        TwoStacks ts = new TwoStacks(5);

        ts.push1(2);
        ts.push1(3);
        ts.push2(4);
        ts.push2(5);

        System.out.print(ts.pop1() + " ");
        System.out.print(ts.pop2() + " ");
        System.out.print(ts.pop2() + " ");
    }

    static class TwoStacks {
        private final int[] arr;
        private final int capacity;
        private int top1, top2;

        public TwoStacks(int capacity) {
            this.capacity = capacity;
            arr = new int[capacity];
            top1 = -1;
            top2 = capacity;
        }

        private void push1(int element) {
            if (top1 < top2 - 1) {
                top1++;
                arr[top1] = element;
            } else {
                throw new RuntimeException("Stack 1 Overflow!");
            }
        }

        private void push2(int element) {
            if (top1 < top2 - 1) {
                top2--;
                arr[top2] = element;
            } else {
                throw new RuntimeException("Stack 2 Overflow!");
            }
        }

        private int pop1() {
            if (top1 >= 0) {
                int x = arr[top1];
                top1--;

                return x;
            }

            throw new RuntimeException("Stack 1 Underflow!");
        }

        private int pop2() {
            if (top2 < capacity) {
                int x = arr[top2];
                top2++;

                return x;
            }

            throw new RuntimeException("Stack 2 Underflow!");
        }

        private int size1() {
            return top1 + 1;
        }

        private int size2() {
            return capacity - top2;
        }
    }
}
