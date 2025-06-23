package DataStructures.Stack.PracticeProblems;

import DataStructures.Stack.Implementation.StackUsingLinkedList;

public class StockSpanProblem {

    /// Problem Statement:
    /// In this problem we have given an integer array that represents price of stock for n consecutive days and our
    /// task is to find out span of stock on every day.
    /// The span of the stock’s price on a given day is defined as the maximum number of consecutive days (including
    /// the current day) just before the given day, for which the price of the stock was less than or equal to its
    /// price on the given day.

    /**
     * Naive Method
     * Time Complexity: O(n ^ 2)
     * Space Complexity: O(1)
     * */
    private static void stockSpanUsingNaiveMethod(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int span = 1;

            for (int j = i - 1; j >= 0 && arr[j] <= arr[i]; j--)
                span++;

            System.out.print(span + " ");
        }
    }

    /**
     * Formula for Calculating Stock Span,
     * Stock Span = (Index of current element) - (Index of closet greater element on the left side)
     * <p>
     * Efficient Method (Using Stack)
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * */
    private static void stockSpanUsingEfficientMethod(int[] arr) {
        StackUsingLinkedList stack = new StackUsingLinkedList();
        stack.push(0);

        System.out.print(1 + " ");

        for (int i = 1; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
                stack.pop();
            }

            int span = stack.isEmpty() ? i + 1 : i - stack.peek();

            System.out.print(span + " ");

            stack.push(i);
        }
    }

    public static void main(String[] args) {
        int[] testCase1 = {13, 15, 12, 14, 16, 8, 6, 4, 10, 30};
        int[] testCase2 = {10, 20, 30, 40};
        int[] testCase3 = {40, 30, 20, 10};
        int[] testCase4 = {30, 20, 25, 28, 27, 29};
        int[] testCase5 = {18, 12, 13, 14, 11, 16};
        int[] testCase6 = {60, 10, 20, 40, 35, 30, 50, 70, 65};
        int[] testCase7 = {60, 10, 20, 15, 35, 50};

        stockSpanUsingNaiveMethod(testCase1);
        System.out.println();
        stockSpanUsingEfficientMethod(testCase1);
        System.out.println();

        stockSpanUsingNaiveMethod(testCase2);
        System.out.println();
        stockSpanUsingEfficientMethod(testCase2);
        System.out.println();

        stockSpanUsingNaiveMethod(testCase3);
        System.out.println();
        stockSpanUsingEfficientMethod(testCase3);
        System.out.println();

        stockSpanUsingNaiveMethod(testCase4);
        System.out.println();
        stockSpanUsingEfficientMethod(testCase4);
        System.out.println();

        stockSpanUsingNaiveMethod(testCase5);
        System.out.println();
        stockSpanUsingEfficientMethod(testCase5);
        System.out.println();

        stockSpanUsingNaiveMethod(testCase6);
        System.out.println();
        stockSpanUsingEfficientMethod(testCase6);
        System.out.println();

        stockSpanUsingNaiveMethod(testCase7);
        System.out.println();
        stockSpanUsingEfficientMethod(testCase7);
        System.out.println();
    }


}
