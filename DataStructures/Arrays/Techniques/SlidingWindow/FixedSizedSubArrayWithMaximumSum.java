package DataStructures.Arrays.Techniques.SlidingWindow;

public class FixedSizedSubArrayWithMaximumSum {

    /// Problem Statement:
    /// Given an array of integers, find the maximum sum of a sub-array with a fixed window size.

    /**
     * Brute Force Approach
     * Time Complexity: O(n * k)
     * Space Complexity: O(1)
     * */
    private static int maxSumOfKSizedSubArrayUsingBruteForceMethod(int[] arr, int k) {
        int maxSum = 0;

        for (int i = 0; i < arr.length - k; i++) {
            int currentSum = 0;

            for (int j = 0; j < k; j++) {
                currentSum += arr[i + j];
            }

            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

    /**
     * Sliding Window Technique
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * */
    private static int maxSumOfKSizedSubArrayUsingSlidingWindow(int[] arr, int k) {
        int maxSum = 0;
        int windowSum = 0;

        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
        }

        maxSum = windowSum;

        for (int i = k; i < arr.length; i++) {
            windowSum += arr[i] - arr[i - k];
            maxSum = Math.max(maxSum, windowSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = {1, 8, 30, -5, 20, 7};
//        int[] arr = {5, -10, 6, 90, 3};
//        int[] arr = {10, 5, -2, 20, 1};

        System.out.println(maxSumOfKSizedSubArrayUsingBruteForceMethod(arr, 4));
        System.out.println(maxSumOfKSizedSubArrayUsingSlidingWindow(arr, 4));
    }

}
