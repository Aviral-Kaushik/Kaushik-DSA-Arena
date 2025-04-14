package DataStructures.Arrays.Techniques.PrefixSum;

public class MaximumSumSubArrayOfSizeK {

    /// Problem:
    /// Given an array arr and an integer k, find the maximum sum of any sub array of size k.

    /**
     * Time Complexity: O(n)
     * */
    private static int maximumSumOfSubArrayUsingSlidingWindow(int[] arr, int k) {
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

    /**
     * Time Complexity: O(n)
     * */
    private static int maximumSumOfSubArrayUsingPrefixSum(int[] arr, int k) {
        int[] prefixSum = getPrefixSum(arr);
        int maxSum = 0;
        int currentSum = 0;

        for (int i = 0; i < arr.length - k; i++) {
            int j = i + k - 1;
            currentSum = getSum(prefixSum, i, j);
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

    private static int getSum(int[] prefixSum, int left, int right) {
        if (left == 0) {
            return prefixSum[right];
        }

        return prefixSum[right] - prefixSum[left - 1];
    }

    private static int[] getPrefixSum(int[] arr) {
        int[] prefixSum = new int[arr.length];

        prefixSum[0] = arr[0];

        for (int i = 1; i < arr.length; i++) {
            prefixSum[i] = arr[i] + prefixSum[i - 1];
        }

        return prefixSum;
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 2, 10, 23, 3, 1, 0, 20};

        System.out.println(maximumSumOfSubArrayUsingSlidingWindow(arr, 4));
        System.out.println(maximumSumOfSubArrayUsingPrefixSum(arr, 4));
    }

}
