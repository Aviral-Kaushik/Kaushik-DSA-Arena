package DataStructures.Stack.PracticeProblems;

import DataStructures.Stack.Implementation.StackUsingLinkedList;

public class PreviousGreaterElement {

    /// Problem Statement:
    /// In this problem, we have given an integer array of distinct elements, and we need to find the position wise
    /// closet greater element left to it. If there is no greater element on the left print -1.

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * */
    private static void printPreviousGreaterElement(int[] arr) {
        StackUsingLinkedList stack = new StackUsingLinkedList();

        stack.push(arr[0]);
        System.out.print(-1 + " ");

        for (int i = 1; i < arr.length; i++) {
            while (!stack.isEmpty() && stack.peek() < arr[i]) {
                stack.pop();
            }

            int previousGreaterElement = stack.isEmpty() ? -1 : stack.peek();
            stack.push(arr[i]);

            System.out.print(previousGreaterElement + " ");
        }
    }

    public static void main(String[] args) {
        int[] testCase1 = {15, 10, 18, 12, 4, 6, 2, 8};
        int[] testCase2 = {5, 10, 12};
        int[] testCase3 = {12, 10, 8};
        int[] testCase4 = {20, 30, 10, 5, 15};

        printPreviousGreaterElement(testCase1);
        System.out.println();

        printPreviousGreaterElement(testCase2);
        System.out.println();

        printPreviousGreaterElement(testCase3);
        System.out.println();

        printPreviousGreaterElement(testCase4);
    }

}
