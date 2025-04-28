package DataStructures.Arrays.Matrix;

public class MatrixBoundaryTraversal {

    /// Problem Statement:
    /// In this problem, we have given a matrix, and we have to print all the boundary elements of it. (Boundary Traversal).

    /// Test Cases:
    /// Input: 1  2  3  4
    ///        5  6  7  8
    ///        9  10 11 12
    ///        13 14 15 16
    /// Output: 1 2 3 4 8 12 16 15 14 13 9 5

    /// Input: 1 2 3 4
    ///        5 6 7 8
    /// Output: 1 2 3 4 8 7 6 5

    /// Input: 1 2 3 4
    /// Output: 1 2 3 4

    /**
     * Time Complexity: O(row + column)
     * */
    private static void boundaryTraversal(int[][] matrix) {
        int row = matrix.length;
        int column = matrix[0].length;

        if (row == 1) {
            for (int i = 0; i < column; i++) {
                System.out.print(matrix[0][i] + " ");
            }
        } else if (column == 1) {
            for (int i = 0; i < row; i++) {
                System.out.print(matrix[i][0] + " ");
            }
        } else {
            for (int i = 0; i < column; i++) {
                System.out.print(matrix[0][i] + " ");
            }
            for (int i = 1; i < row; i++) {
                System.out.print(matrix[i][column - 1] + " ");
            }
            for (int i = column - 2; i >= 0; i--) {
                System.out.print(matrix[row - 1][i] + " ");
            }
            for (int i = row - 2; i >= 1; i--) {
                System.out.print(matrix[i][0] + " ");
            }
        }
    }

    public static void main(String[] args) {
        int[][] testCase1 = {{1, 2, 3, 4},
                             {5, 6, 7, 8},
                             {9, 10, 11, 12},
                             {13, 14, 15, 16}};

        int[][] testCase2 = {{1, 2, 3, 4},
                             {5, 6, 7, 8}};

        int[][] testCase3 = {{1, 2, 3, 4}};

        boundaryTraversal(testCase1);

        System.out.println();

        boundaryTraversal(testCase2);

        System.out.println();

        boundaryTraversal(testCase3);
    }

}
