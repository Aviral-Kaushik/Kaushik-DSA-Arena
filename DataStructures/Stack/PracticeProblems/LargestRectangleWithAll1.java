package DataStructures.Stack.PracticeProblems;

import DataStructures.Stack.Implementation.StackUsingLinkedList;

public class LargestRectangleWithAll1 {

    /// Problem Statement:
    /// In this problem, we have given a matrix that contains 0's and 1's, and we need to find the largest rectangular
    /// sub matrix with all 1's, and we need to return number of 1 in that rectangular sub matrix.

    /**
     * Efficient Method
     * Time Complexity: O(R * C)
     * Space Complexity: O(C)
     * Where R is number of elements in row in the matrix, and C is number of elements in column of matrix.
     * */
    private static int getLargestRectangleWithAllOnes(int[][] matrix) {
        int result = getMaxRectangularArea(matrix[0]);

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 1) {
                    matrix[i][j] += matrix[i - 1][j];
                }
            }

            result = Math.max(result, getMaxRectangularArea(matrix[i]));
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] testCase1 = {{0, 1, 1, 0},
                             {1, 1, 1, 1},
                             {1, 1, 1, 1},
                             {1, 1, 0, 0}};

        int[][] testCase2 = {{0, 1, 1},
                             {1, 1, 1},
                             {0, 1, 1}};

        int[][] testCase3 = {{0, 0},
                             {0, 0}};

        int[][] testCase4 = {{0, 0},
                             {0, 1}};

        int[][] testCase5 = {{1, 1, 1}};

        int[][] testCase6 = {{1, 0, 0, 1, 1},
                             {0, 0, 0, 1, 1},
                             {1, 1, 1, 1, 1},
                             {0, 1, 1, 1, 1}};

        System.out.println(getLargestRectangleWithAllOnes(testCase1));
        System.out.println(getLargestRectangleWithAllOnes(testCase2));
        System.out.println(getLargestRectangleWithAllOnes(testCase3));
        System.out.println(getLargestRectangleWithAllOnes(testCase4));
        System.out.println(getLargestRectangleWithAllOnes(testCase5));
        System.out.println(getLargestRectangleWithAllOnes(testCase6));
    }

    /**
     * This function has been copied from Largest Rectangular Area in Histogram.
     * */
    private static int getMaxRectangularArea(int[] arr) {
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


}
