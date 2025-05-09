package Hashing.PracticeProblem;

import java.util.HashSet;

public class PairWithGivenSum {

    /// Problem Statement
    /// In this problem, we have given an array of integers and our task is to check weather a pair exits with given su or not.
    /// If a pair exits return true else return false.

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * */
    private static boolean doesPairExits(int[] arr, int target) {
        HashSet<Integer> hashSet = new HashSet<>();

        for (int num: arr) {
            if (hashSet.contains(target - num)) {
                return true;
            } else {
                hashSet.add(num);
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] testCase1 = {3, 2, 8, 15, -8};
        int[] testCase2 = {2, 1, 6, 3};
        int[] testCase3 = {5, 8, -3, 6};
        int[] testCase4 = {8, 3, 2, 5};
        int[] testCase5 = {8, 3, 4, 2, 5};

        System.out.println(doesPairExits(testCase1, 17));
        System.out.println(doesPairExits(testCase2, 6));
        System.out.println(doesPairExits(testCase3, 3));
        System.out.println(doesPairExits(testCase4, 6));
        System.out.println(doesPairExits(testCase5, 6));
    }
}