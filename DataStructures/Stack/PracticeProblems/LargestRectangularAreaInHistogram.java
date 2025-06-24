package DataStructures.Stack.PracticeProblems;

import DataStructures.Stack.Implementation.StackUsingLinkedList;

public class LargestRectangularAreaInHistogram {

    /// Problem Statement:
    /// In this problem, we have given an integer array and each element represent height of bar in a histogram chart,
    /// and width of the bars in histogram is same

    /**
     * Time Complexity: O(n ^ 2)
     * Space Complexity: O(1)
     * */
    private static int getMaxRectangularAreaUsingNaiveMethod(int[] arr) {
        int res = 0;

        for (int i = 0; i < arr.length; i++) {
            int current = arr[i];

            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] >= arr[i])
                    current += arr[i];
                else
                    break;
            }

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] >= arr[i])
                    current += arr[i];
                else
                    break;
            }

            res = Math.max(res, current);
        }

        return res;
    }

    /**
     * Better Method (as it uses 2 stacks, 2 new arrays and 3 traversals of input array that's why better not efficient).
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * */
    private static int getMaxRectangularAreaUsingBetterMethod(int[] arr) {
        int result = 0;

        int[] previousSmaller = getPreviousSmallerElements(arr);
        int[] nextSmaller = getNextSmallerElements(arr);

        for (int i = 0; i < arr.length; i++) {
            int current = arr[i];
            current += (i - previousSmaller[i] - 1) * arr[i];
            current += (nextSmaller[i] - i - 1) * arr[i];

            result = Math.max(result, current);
        }

        return result;
    }

    /**
     * Efficient Method (as it uses only 1 stack, 1 traversal of array so it is more efficient)
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * */
    private static int getMaxRectangularAreaUsingEfficientMethod(int[] arr) {
        StackUsingLinkedList stack = new StackUsingLinkedList();
        int result = 0;
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                int top = stack.pop();
                int current = arr[top] * (stack.isEmpty() ? i : (i - stack.peek() - 1));
                result = Math.max(result, current);
            }

            stack.push(i);
        }

        // Processing Remaining Elements of Stack
        while (!stack.isEmpty()) {
            int top = stack.pop();
            int current = arr[top] * (stack.isEmpty() ? n : (n - stack.peek() - 1));
            result = Math.max(result, current);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] testCase1 = {6, 2, 5, 4, 1, 5, 6};
        int[] testCase2 = {2, 5, 1};
        int[] testCase3 = {60, 20, 50, 40, 10, 50, 60};

        System.out.println(getMaxRectangularAreaUsingNaiveMethod(testCase1));
        System.out.println(getMaxRectangularAreaUsingBetterMethod(testCase1));
        System.out.println(getMaxRectangularAreaUsingEfficientMethod(testCase1));

        System.out.println(getMaxRectangularAreaUsingNaiveMethod(testCase2));
        System.out.println(getMaxRectangularAreaUsingBetterMethod(testCase2));
        System.out.println(getMaxRectangularAreaUsingEfficientMethod(testCase2));

        System.out.println(getMaxRectangularAreaUsingNaiveMethod(testCase3));
        System.out.println(getMaxRectangularAreaUsingBetterMethod(testCase3));
        System.out.println(getMaxRectangularAreaUsingEfficientMethod(testCase3));
    }


    private static int[] getPreviousSmallerElements(int[] arr) {
        StackUsingLinkedList stack = new StackUsingLinkedList();

        int[] results = new int[arr.length];

        results[0] = -1;
        stack.push(0);

        for (int i = 1; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }

            results[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        return results;
    }

    private static int[] getNextSmallerElements(int[] arr) {
        int n = arr.length;
        StackUsingLinkedList stack = new StackUsingLinkedList();
        int[] results = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }

            results[i] = stack.isEmpty() ? n : stack.peek();

            stack.push(i);
        }

        return results;
    }

}
