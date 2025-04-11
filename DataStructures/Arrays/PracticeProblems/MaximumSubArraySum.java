package DataStructures.Arrays.PracticeProblems;

public class MaximumSubArraySum {

    /// In this problem, we have given an integer array, and we have to find the maximum sum of a sub array.
    /// Sub array: Sub Array is an array that is formed by picking contiguous elements from an array.

    /**
     * Naive Method
     * Time Complexity: O(n ^ 2)
     * */
    private static int maxSubArraySumByNaiveMethod(int[] arr) {
        int res = arr[0];

        for (int i = 0; i < arr.length; i++) {
            int current = 0;

            for (int j = i; j < arr.length; j++) {
                current += arr[j];
                res = Math.max(res, current);
            }
        }

        return res;
    }

    /**
     * Efficient Method (Kadane's Algorithm)
     * Time Complexity: O(n)
     * */
    private static int maxSubArraySumByEfficientMethod(int[] arr) {
        int res = arr[0];
        int maxEnding = arr[0];

        for (int i = 1; i < arr.length; i++) {
            maxEnding = Math.max(maxEnding + arr[i], arr[i]);
            res = Math.max(res, maxEnding);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, -8, 7, -1, 2, 3};
//        int[] arr = {5, 8, 3};
//        int[] arr = {-6, -1, -8};
//        int[] arr = {1, -2, 3, -1, 2};

        System.out.println(maxSubArraySumByNaiveMethod(arr));
        System.out.println(maxSubArraySumByEfficientMethod(arr));
    }
}
