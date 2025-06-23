package DataStructures.Stack.PracticeProblems;

import DataStructures.Stack.Implementation.StackUsingLinkedList;

public class NextGreaterElement {

    /// Problem Statement:
    /// In this problem, we have given an array of integers, and we need to find closet next greater element (position
    /// wise on right side) for every element and if there is no greater element on right side print -1.

    /**
     * Naive Method
     * Time Complexity: O(n ^ 2)
     * Space Complexity: O(1)
     * */
    private static void printNextGreaterElementUsingNaiveMethod(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                if (arr[j] > arr[i]) {
                    System.out.print(arr[j] + " ");
                    break;
                }

                if (j == arr.length - 1)
                    System.out.print(-1 + " ");
            }
        }
    }

    /**
     * Prints output in reverse order
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * */
    private static void printNextGreaterElementInReverseOrder(int[] arr) {
        StackUsingLinkedList stack = new StackUsingLinkedList();
        int n = arr.length;

        stack.push(arr[n - 1]);

        System.out.print(-1 + " ");

        for (int i = n - 2; i >= 0; i--) {
            int current = arr[i];

            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }

            int nextGreaterElement = stack.isEmpty() ? -1 : stack.peek();
            System.out.print(nextGreaterElement + " ");

            stack.push(current);
        }
    }

    /**
     * Return an array in correct order
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * */
    public static int[] findNextGreaterElementInSameOrder(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        StackUsingLinkedList stack = new StackUsingLinkedList();

        // Traverse from right to left
        for (int i = n - 1; i >= 0; i--) {
            int current = nums[i];

            // Remove elements smaller than or equal to current
            while (!stack.isEmpty() && stack.peek() <= current) {
                stack.pop();
            }

            // If stack is not empty, top is the next greater
            result[i] = stack.isEmpty() ? -1 : stack.peek();

            // Push this element for the next iteration
            stack.push(current);
        }

        return result;
    }

    private static void printArray(int[] arr) {
        for (int num: arr)
            System.out.print(num + " ");
    }

    public static void main(String[] args) {
        int[] testCase1 = {5, 15, 10, 8, 6, 12, 9, 18};
        int[] testCase2 = {10, 15, 20, 25};
        int[] testCase3 = {25, 20, 15, 10};
        int[] testCase4 = {4, 5, 2, 25};

        printNextGreaterElementUsingNaiveMethod(testCase1);
        System.out.println();
        printNextGreaterElementInReverseOrder(testCase1);
        System.out.println();
        printArray(findNextGreaterElementInSameOrder(testCase1));
        System.out.println();

        printNextGreaterElementUsingNaiveMethod(testCase2);
        System.out.println();
        printNextGreaterElementInReverseOrder(testCase2);
        System.out.println();
        printArray(findNextGreaterElementInSameOrder(testCase2));
        System.out.println();

        printNextGreaterElementUsingNaiveMethod(testCase3);
        System.out.println();
        printNextGreaterElementInReverseOrder(testCase3);
        System.out.println();
        printArray(findNextGreaterElementInSameOrder(testCase3));
        System.out.println();

        printNextGreaterElementUsingNaiveMethod(testCase4);
        System.out.println();
        printNextGreaterElementInReverseOrder(testCase4);
        System.out.println();
        printArray(findNextGreaterElementInSameOrder(testCase4));
        System.out.println();
    }

}
