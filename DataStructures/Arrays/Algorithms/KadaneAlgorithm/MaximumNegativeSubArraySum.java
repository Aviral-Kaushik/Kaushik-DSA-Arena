package DataStructures.Arrays.Algorithms.KadaneAlgorithm;

public class MaximumNegativeSubArraySum {

    /// Problem:
    /// What if all numbers in the array are negative? Modify Kadane’s algorithm to return the maximum (least negative)
    /// element.

    /// Input: [-8, -3, -6, -2, -5, -4]
    /// Output: -2

    /**
     * Kadane's Algorithm
     * This solution will only if there are all negative elements.
     * Time Complexity: O(n)
     * */
    private static int getMaxSubArraySum(int[] arr) {
        int maxSum = arr[0];

        for (int i = 1; i < arr.length; i++) {
            maxSum = Math.max(arr[i], maxSum);
        }

        return maxSum;
    }

    /**
     * Kadane's Algorithm
     * This solution will only if array contains both positive and negative elements.
     * Time Complexity: O(n)
     * */
    private static int getMaxSubArraySumForBothPositiveAndNegativeElements(int[] arr) {
        int maxEndingHere = arr[0];
        int maxSoFar = arr[0];

        for (int i = 1; i < arr.length; i++) {
            maxEndingHere = Math.max(arr[i], maxEndingHere + arr[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }

        return maxSoFar;
    }

    public static void main(String[] args) {
        int[] arr = {-8, -3, -6, -2, -5, -4};

        System.out.println(getMaxSubArraySum(arr));
        System.out.println(getMaxSubArraySumForBothPositiveAndNegativeElements(arr));
    }
}
