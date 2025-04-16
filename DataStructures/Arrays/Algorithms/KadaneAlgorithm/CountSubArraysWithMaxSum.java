package DataStructures.Arrays.Algorithms.KadaneAlgorithm;

public class CountSubArraysWithMaxSum {

    /// Problem:
    /// Count the number of contiguous sub arrays that have the maximum sum (as per Kadane).

    /// Input: [1, -1, 1, -1, 1]
    /// Output: 1

    /**
     * Time Complexity: O(n ^ 2)
     * */
    private static int countSubArraysWithMaxSumUsingKadaneAlgorithm(int[] arr) {
        int maxSum = kadane(arr);
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            int sum = 0;

            for (int j = i; j < arr.length; j++) {
                sum += arr[j];

                if (sum == maxSum) {
                    count++;
                }
            }
        }

        return count;
    }

    // Kadane’s algorithm to find max sub array sum
    private static int kadane(int[] arr) {
        int currentSum = arr[0], maxSum = arr[0];

        for (int i = 1; i < arr.length; i++) {
            currentSum = Math.max(arr[i], currentSum + arr[i]);
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = {1, -1, 1, -1, 1};

        System.out.println(countSubArraysWithMaxSumUsingKadaneAlgorithm(arr));
    }

}
