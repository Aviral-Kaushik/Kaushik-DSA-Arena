package DataStructures.Arrays.Matrix;

public class TransposeOfMatrix {

    /// Problem Statement:
    /// In this problem, we have given a matrix, and we need to print transpose of it.

    /// Test Cases:
    /// Input: 1  2  3  4
    ///        5  6  7  8
    ///        9  10 11 12
    ///        13 14 15 16
    /// Output: 1 5  9 13
    ///         2 6 10 14
    ///         3 7 11 15
    ///         4 8 12 16

    /// Input: 1 1
    ///        2 2
    /// Output: 1 2
    ///         1 2

    /**
     * Time Complexity: O(row * column)
     * */
    private static int[][] getTranspose(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix[0].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        return matrix;
    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] testCase1 = {{1, 2, 3, 4},
                             {5, 6, 7, 8},
                             {9, 10, 11, 12},
                             {13, 14, 15, 16}};

        int[][] testCase2 = {{1, 1},
                             {2, 2}};

        printMatrix(getTranspose(testCase1));
        printMatrix(getTranspose(testCase2));
    }

}
