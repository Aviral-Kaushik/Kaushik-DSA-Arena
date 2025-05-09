package Hashing.PracticeProblem;

import java.util.HashMap;

public class LongestSubArrayWithEqual0And1 {

    /// Problem Statement:
    /// In this problem, in this problem we have given a binary array, and we need to return the length of the longest
    /// sub array which has equal number of 0's and 1's.

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * */
    private static int getLengthOfLongestSubArrayWithEqual0And1(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                arr[i] = -1;
            }
        }

        return LongestSubArrayWithGivenSum.getLongestSubArrayWithGivenSumLength(arr, 0);
    }

    public static void main(String[] args) {
        int[] testCase1 = {1, 0, 1, 1, 1, 0, 0};
        int[] testCase2 = {1, 1, 1, 1};
        int[] testCase3 = {0, 0, 1, 1, 1, 1, 1, 0};
        int[] testCase4 = {0, 0, 1, 0, 1, 1};
        int[] testCase5 = {1, 1, 1, 0, 1, 0};

        System.out.println(getLengthOfLongestSubArrayWithEqual0And1(testCase1));
        System.out.println(getLengthOfLongestSubArrayWithEqual0And1(testCase2));
        System.out.println(getLengthOfLongestSubArrayWithEqual0And1(testCase3));
        System.out.println(getLengthOfLongestSubArrayWithEqual0And1(testCase4));
        System.out.println(getLengthOfLongestSubArrayWithEqual0And1(testCase5));
    }

}
