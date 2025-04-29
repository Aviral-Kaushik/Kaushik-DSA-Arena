package DataStructures.Arrays.Matrix;

public class SearchingInSortedMatrix {

    /// Problem Statement:
    /// In this problem, we have given a sorted matrix, and we need to search for a number in that sorted matrix.
    /// In the given matrix every row is sorted in increasing order.

    /// Test Cases:
    /// Input: 10 20 30 40 & 29
    ///        15 25 35 45
    ///        27 29 37 48
    ///        32 33 39 50
    /// Output: Found at (2, 1)

    /// Input: 10 20 & 15
    ///        12 30
    /// Output: Not Found

    /**
     * Naive Method
     * Time Complexity: O(row * column)
     * */
    private static void searchUsingNaiveMethod(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == target) {
                    System.out.println("Found at (" + i + ", " + j + ")");
                    break;
                }
            }
        }

        System.out.println("Not Found");
    }

    /**
     * Efficient Method
     * Time Complexity: O(row + column)
     * */
    private static void searchUsingEfficientMethod(int[][] matrix, int target) {
        int i = 0;
        int j = matrix[0].length - 1;

        while (i < matrix.length && j >= 0) {
            if (matrix[i][j] == target) {
                System.out.println("Found at (" + i + ", " + j + ")");
                return;
            } else if (matrix[i][j] > target) {
                j--;
            } else {
                i++;
            }
        }

        System.out.println("Not Found");
    }

    public static void main(String[] args) {
        int[][] testCase1 = {{10, 20, 30, 40},
                             {15, 25, 35, 45},
                             {27, 29, 37, 48},
                             {32, 33, 39, 50}};

        int[][] testCase2 = {{10, 20},
                             {12, 30}};

        searchUsingNaiveMethod(testCase1, 29);
        searchUsingEfficientMethod(testCase1, 29);

        searchUsingNaiveMethod(testCase2, 15);
        searchUsingEfficientMethod(testCase2, 15);
    }
}
