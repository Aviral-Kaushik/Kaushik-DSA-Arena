package Hashing.PracticeProblem;

import java.util.HashSet;

public class LongestConsecutiveSubSequence {

    /// Problem Statement:
    /// In this problem, we have given an array & we need to return the length of longest subsequence such that this
    /// subsequence has consecutive elements (like 1 2 3 or 5 6 7) in any order decreasing or increasing.

    /// ChatGPT Simpler Problem Statement:
    /// Problem Statement:
    /// You are given an array of integers, and you need to find the length of the longest subsequence of consecutive
    /// integers (not necessarily contiguous).
    /// A subsequence is a sequence that can be derived from the array by deleting some or no elements without changing
    /// the order of the remaining elements.
    /// However, here we only care about the numbers being consecutive, not their position in the array.

    /// Explanation
    /// Input:  arr[] = [100, 4, 200, 1, 3, 2]
    /// Output: 4
    /// Explanation: The longest consecutive subsequence is [1, 2, 3, 4]

    /// Input: arr[] = [3, 10, 2, 1, 20]
    /// Output: 3
    /// Explanation: The longest consecutive subsequence is [1, 2, 3] => length is 3


    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * */
    private static int getLengthOfLongestConsecutiveSubSequence(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        int longest = 0;

        for (int num: arr) {
            set.add(num);
        }

        for (int num: arr) {
            if (!set.contains(num - 1)) { // check if it's the start of a sequence
                int length = 1;
                while (set.contains(num + length)) {
                    length++;
                }
                longest = Math.max(longest, length);
            }
        }

        return longest;
    }

    public static void main(String[] args) {
        int[] testCase1 = {100, 4, 200, 1, 3, 2};
        int[] testCase2 = {3, 10, 2, 1, 20};
        int[] testCase3 = {2, 9, 4, 3, 10};
        int[] testCase4 = {3, 21, 2, 1, 4};
        int[] testCase5 = {1, 3, 4, 3, 3, 2, 9, 10};

        System.out.println(getLengthOfLongestConsecutiveSubSequence(testCase1));
        System.out.println(getLengthOfLongestConsecutiveSubSequence(testCase2));
        System.out.println(getLengthOfLongestConsecutiveSubSequence(testCase3));
        System.out.println(getLengthOfLongestConsecutiveSubSequence(testCase4));
        System.out.println(getLengthOfLongestConsecutiveSubSequence(testCase5));
    }

}
