package DataStructures.Arrays.Algorithms.KadaneAlgorithm;

public class MaximumSubArraySum {

    /// Problem:
    /// Given an array of integers, find the contiguous sub array (containing at least one number) which has the largest
    /// sum and return its sum.

    /// Input: [-2, 1, -3, 4, -1, 2, 1, -5, 4]
    /// Output: 6

    /**
     * Kadane's Algorithm
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * */
    private static int getMaxSubArraySum(int[] arr) {
        int maxSum = arr[0];
        int currentSum = arr[0];

        for (int i = 1; i < arr.length; i++) {
            currentSum = Math.max(arr[i], currentSum + arr[i]);
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        System.out.println(getMaxSubArraySum(arr));
    }
}
