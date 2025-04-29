package DataStructures.Arrays.Matrix;

public class SpiralTraversal {

    /// Problem Statement:
    /// In this problem, we have given a matrix and we have to print spiral traversal of it.

    /// Test Cases:
    /// Input: 1  2  3  4
    ///        5  6  7  8
    ///        9  10 11 12
    ///        13 14 15 16
    /// Output: 1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10

    /// Input: 1 2 3
    ///        4 5 6
    /// Output: 1 2 3 6 5 4

    /// Input: 10 20 30
    /// Output: 10 20 30

    /**
     * Time Complexity: O(row * column)
     * */
    private static void printSpiralTraversal(int[][] matrix) {
        int top = 0;
        int right = matrix[matrix.length - 1].length - 1;
        int bottom = matrix.length - 1;
        int left = 0;

        while (top <= bottom && left <= right) {
            for (int i = left; i <= right; i++) {
                System.out.print(matrix[top][i] + " ");
            }
            top++;

            for (int i = top; i <= bottom; i++) {
                System.out.print(matrix[i][right] + " ");
            }
            right--;

            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    System.out.print(matrix[bottom][i] + " ");
                }
                bottom--;
            }

            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    System.out.print(matrix[i][left] + " ");
                }
                left++;
            }
        }

    }

    public static void main(String[] args) {
        int[][] testCase1 = {{1, 2, 3, 4},
                             {5, 6, 7, 8},
                             {9, 10, 11, 12},
                             {13, 14, 15, 16}};
        int[][] testCase2 = {{1, 2, 3},
                             {4, 5, 6}};
        int[][] testCase3 = {{10, 20, 30}};

        printSpiralTraversal(testCase1);
        System.out.println();
        printSpiralTraversal(testCase2);
        System.out.println();
        printSpiralTraversal(testCase3);
    }
}
