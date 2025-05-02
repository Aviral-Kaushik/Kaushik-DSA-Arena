package DataStructures.Arrays.Matrix;

import java.util.Arrays;

public class MedianOfRowWiseSortedMatrix {

    /// Problem Statement:
    /// In this problem we have given a matrix in which there are odd number of rows & columns, each row is sorted in
    /// increasing order and every element is distinct, and we have to find it's median.
    /// So, we need to traverse the whole matrix and put all element in an array and that should be sorted and return
    /// the middle element of it. (Middle Element is the median).

    /// Test Cases:
    /// Input: 1  10 20
    ///        15 25 35
    ///        5  30 40
    /// Output: 20 // as sorted array [1, 5, 10, 15, 20, 25, 30, 35, 40]

    /// Input:  2   4   6   8   10
    ///         1   3   5   7   9
    ///        100 200 400 500 800
    /// Output: 8 // as sorted array [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 100, 200, 400, 500, 800]


    /**
     * Naive Method
     * Time Complexity: O(r * c * log (r * c)) Time Complexity of sorting algo
     * Space Complexity: O(r * c)
     * */
    private static int getMedianUsingNaiveMethod(int[][] matrix) {
        int[] arr = new int[matrix.length * matrix[0].length];
        int count = 0;

        for (int[] ints : matrix) {
            for (int j = 0; j < matrix[0].length; j++) {
                arr[count] = ints[j];
                count++;
            }
        }

        Arrays.sort(arr);

        return arr[(arr.length - 1) / 2];
    }


    /**
     * Efficient Method
     * Time Complexity: O(r * log (max - min) * log c)
     * */
    private static int getMedianUsingEfficientMethod(int[][] matrix) {
        int row = matrix.length, column = matrix[0].length;
        int min = matrix[0][0], max = matrix[0][column - 1];

        for (int[] value : matrix) {
            if (value[0] < min) {
                min = value[0];
            }

            if (value[column - 1] > max) {
                max = value[column - 1];
            }
        }

        int medPos = (row * column + 1) / 2;

        while (min < max) {
            int mid = (min + max) / 2, midPos = 0;

            for (int[] ints : matrix) {
                int pos = Arrays.binarySearch(ints, mid) + 1;
                midPos += Math.abs(pos);
            }

            if (midPos < medPos) {
                min = mid + 1;
            } else {
                max = mid;
            }
        }

        return min;
    }

    public static void main(String[] args) {
        int[][] testCase1 = {{1, 10, 20},
                             {15, 25, 35},
                             {5, 30, 40}};

        int[][] testCase2 = {{2, 4, 6, 8, 10},
                             {1, 3, 5, 7, 9},
                             {100, 200, 400, 500, 800}};

        int[][] testCase3 = {{5, 10, 20, 30, 40},
                             {1, 2, 3, 4, 6},
                             {11, 13, 15, 17, 19}};

        System.out.println(getMedianUsingNaiveMethod(testCase1));
        System.out.println(getMedianUsingEfficientMethod(testCase1));

        System.out.println(getMedianUsingNaiveMethod(testCase2));
        System.out.println(getMedianUsingEfficientMethod(testCase2));

        System.out.println(getMedianUsingNaiveMethod(testCase3));
        System.out.println(getMedianUsingEfficientMethod(testCase3));
    }
}
