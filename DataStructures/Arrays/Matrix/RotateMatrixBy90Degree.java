package DataStructures.Arrays.Matrix;

public class RotateMatrixBy90Degree {

    /// Problem Statement:
    /// In this problem, we have given a matrix, and we have rotate it by 90 degree.

    /// Test Cases:
    /// Input: 1 2 3
    ///        4 5 6
    ///        7 8 9
    /// Output: 3 6 9
    ///         2 5 8
    ///         1 4 7

    /// Input: 1  2  3  4
    ///        5  6  7  8
    ///        9  10 11 12
    ///        13 14 15 16
    /// Output: 4 8 12 16
    ///         3 7 11 15
    ///         2 6 10 14
    ///         1 5 9  13


    /**
     * Naive Method
     * Time Complexity: O(n ^ 2)
     * Space Complexity: O(n ^ 2)
     * */
    private static int[][] rotateMatrixBy90DegreeUsingNaiveMethod(int[][] matrix) {
        int row = matrix.length;
        int column = matrix[0].length;
        /// Row and column are equal to each other
        int[][] rotatedMatrix = new int[row][column];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                rotatedMatrix[row - j - 1][i] = matrix[i][j];
            }
        }

        return rotatedMatrix;
    }

    /**
     * Efficient Method
     * Time Complexity: O(n ^ 2)
     * Space Complexity: O(1)
     * Idea
     * 1. First find Transpose of the matrix.
     * 2. Reverse the individuals columns of transposed matrix.
     * */
    private static int[][] rotateMatrixBy90DegreeUsingEfficientMethod(int[][] matrix) {

        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix[0].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for (int i = 0; i  < matrix[0].length; i++) {
            int low = 0, high = matrix[0].length - 1;
            while (low <= high) {
                int temp = matrix[low][i];
                matrix[low][i] = matrix[high][i];
                matrix[high][i] = temp;

                low++;
                high--;
            }
        }


        return matrix;
    }

    public static void main(String[] args) {
        int[][] testCase1 = {{1, 2, 3},
                             {4, 5, 6},
                             {7, 8, 9}};

        int[][] testCase2 = {{1, 2, 3, 4},
                             {5, 6, 7, 8},
                             {9, 10, 11, 12},
                             {13, 14, 15, 16}};

        TransposeOfMatrix.printMatrix(rotateMatrixBy90DegreeUsingNaiveMethod(testCase1));
        System.out.println();
        TransposeOfMatrix.printMatrix(rotateMatrixBy90DegreeUsingEfficientMethod(testCase1));
        System.out.println();
        TransposeOfMatrix.printMatrix(rotateMatrixBy90DegreeUsingNaiveMethod(testCase2));
        System.out.println();
        TransposeOfMatrix.printMatrix(rotateMatrixBy90DegreeUsingEfficientMethod(testCase2));
    }

}
