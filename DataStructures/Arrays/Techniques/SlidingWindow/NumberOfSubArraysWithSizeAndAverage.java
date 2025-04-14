package DataStructures.Arrays.Techniques.SlidingWindow;

public class NumberOfSubArraysWithSizeAndAverage {

    /// Problem Statement:
    /// Given an array of integers arr and two integers k and threshold, return the number of sub-arrays of size k
    /// and average greater than or equal to threshold.

    /**
     * Time Complexity: O(n)
     * */
    private static int countOfSubArrayWithSizeAndAverage(int[] arr, int k, int threshold) {
        int count = 0;
        int windowSum = 0;
        int targetSum = k * threshold;

        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
        }

        if (windowSum >= targetSum) {
            count++;
        }

        for (int i = k; i < arr.length; i++) {
            windowSum += arr[i] - arr[i - k];

            if (windowSum >= targetSum) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] arr1 = {2, 2, 2, 2, 5, 5, 5, 8};
        int[] arr2 = {11, 13, 17, 23, 29, 31, 7, 5, 2, 3};

        System.out.println(countOfSubArrayWithSizeAndAverage(arr1, 3, 4));
        System.out.println(countOfSubArrayWithSizeAndAverage(arr2, 3, 5));
    }

}
