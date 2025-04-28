package DataStructures.Arrays.Matrix;

public class PrintMatrixInSnakeOrder {

    /// Problem Statement:
    /// In this problem we have given a matrix 2D-array & we have to print the matrix in snake order.

    /// Test Cases:
    /// Input: 1  2  3  4
    ///        5  6  7  8
    ///        9  10 11 12
    ///        13 14 15 16
    /// Output: 1 2 3 4 8 7 6 5 9 10 11 12 16 15 14 13

    /// Input: 1  2  3  4
    ///        5  6  7  8
    ///        9 10 11 12
    /// Output: 1 2 3 4 8 7 6 5 9 10 11 12


    private static void snakeTraversal(int[][] matrix) {
        for (int i = 0; i < matrix.length ; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < matrix[i].length; j++) {
                    System.out.print(matrix[i][j] + " ");
                }
            } else {
                for (int j = matrix[i].length - 1; j >= 0 ; j--) {
                    System.out.print(matrix[i][j] + " ");
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] testCase1 = {{1, 2, 3, 4},
                             {5, 6, 7, 8},
                             {9, 10, 11, 12},
                             {13, 14, 15, 16}};

        int[][] testCase2 = {{1, 2, 3, 4},
                             {5, 6, 7, 8},
                             {9, 10, 11, 12}};

        snakeTraversal(testCase1);

        System.out.println();

        snakeTraversal(testCase2);
    }

}
