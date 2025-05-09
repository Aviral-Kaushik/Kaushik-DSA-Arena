package Hashing.PracticeProblem;

import java.util.HashMap;

public class LongestSubArrayWithGivenSum {

    /// Problem Statement:
    /// In this problem, we have given an array, and we need to return the length of longest sub array with given sum.

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * */
    public static int getLongestSubArrayWithGivenSumLength(int[] arr, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int prefixSum = 0;
        int result = 0;

        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];

            prefixSum += num;

            if (prefixSum == target) {
                result = i + 1;
            }

            if (!hashMap.containsKey(prefixSum)) {
                hashMap.put(prefixSum, i);
            }

            if (hashMap.containsKey(prefixSum - target)) {
                result = Math.max(result, i - hashMap.get(prefixSum - target));
            }

        }

        return result;
    }

    public static void main(String[] args) {
        int[] testCase1 = {5, 8, -4, -4, 9, -2, 2};
        int[] testCase2 = {3, 1, 0, 1, 8, 2, 3, 6};
        int[] testCase3 = {8, 3, 7};
        int[] testCase4 = {5, 2, 3, 4};
        int[] testCase5 = {8, 3, 1, 5, -6, 6, 2, 2};

        System.out.println(getLongestSubArrayWithGivenSumLength(testCase1, 0));
        System.out.println(getLongestSubArrayWithGivenSumLength(testCase2, 5));
        System.out.println(getLongestSubArrayWithGivenSumLength(testCase3, 15));
        System.out.println(getLongestSubArrayWithGivenSumLength(testCase4, 5));
        System.out.println(getLongestSubArrayWithGivenSumLength(testCase5, 4));
    }

}
