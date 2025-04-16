package DataStructures.Arrays.Algorithms.KadaneAlgorithm;

public class PrintMaximumSumSubArray {

    /// Problem:
    /// Along with the sum, also return the sub array that gives the maximum sum.

    /// Input: [1, 2, -5, 4, 7, -2]
    /// Output: 11, SubArray: [4, 7].


    /**
     * Kadane's Algorithm
     * Time Complexity: O(n)
     * */
    private static void printMaxSumAndSubArray(int[] arr) {
        int currentSum = arr[0];
        int maxSum = arr[0];
        int start = 0, end = 0, tempStart = 0;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > currentSum + arr[i]) {
                tempStart = i;
                currentSum = arr[i];
            } else {
                currentSum += arr[i];
            }

            if (currentSum > maxSum) {
                maxSum = currentSum;
                start = tempStart;
                end = i;
            }
        }

        System.out.println(maxSum + " SubArray: [" + arr[start] + ", " + arr[end] + "]");
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, -5, 4, 7, -2};
//        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        printMaxSumAndSubArray(arr);
    }

}
