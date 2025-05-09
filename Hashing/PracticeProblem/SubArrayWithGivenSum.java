package Hashing.PracticeProblem;

import java.util.HashSet;

public class SubArrayWithGivenSum {

    /// Problem Statement:
    /// In this problem, we have given an array and we need to return true if an sub array exits in it with given
    /// sum otherwise return false.

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * */
    private static boolean doesSubArrayExitsWithOSum(int[] arr) {
        HashSet<Integer> hashSet = new HashSet<>();

        int prefixSum = 0;
        for (int num: arr) {
            prefixSum += num;

            if (hashSet.contains(prefixSum) || prefixSum == 0) {
                return true;
            }

            hashSet.add(prefixSum);
        }

        return false;
    }

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * */
    private static boolean doesSubArrayExitsWithGiveSum(int[] arr, int target) {
        HashSet<Integer> hashSet = new HashSet<>();

        int prefixSum = 0;
        for (int num: arr) {
            prefixSum += num;

            if (hashSet.contains(prefixSum - target) || prefixSum == target) {
                return true;
            }

            hashSet.add(prefixSum);
        }

        return false;
    }

    public static void main(String[] args) {
        int[] testCase1 = {1, 4, 13, -3, -10, 5};
        int[] testCase2 = {-1, 4, -3, 5, 1};
        int[] testCase3 = {3, 1, -2, 5, 6};
        int[] testCase4 = {5, 6, 0, 8};
        int[] testCase5 = {-3, 4, -3, -1, 1};

        System.out.println(doesSubArrayExitsWithOSum(testCase1));;
        System.out.println(doesSubArrayExitsWithOSum(testCase2));;
        System.out.println(doesSubArrayExitsWithOSum(testCase3));;
        System.out.println(doesSubArrayExitsWithOSum(testCase4));;
        System.out.println(doesSubArrayExitsWithOSum(testCase5));;

        int[] testCase6 = {5, 8, 6, 13, 3, -1};
        int[] testCase7 = {15, 2, 8, 10, -5, -8, 6};
        int[] testCase8 = {3, 2, 5, 6};
        int[] testCase9 = {5, 8, 6, 13};

        System.out.println(doesSubArrayExitsWithGiveSum(testCase6, 22));
        System.out.println(doesSubArrayExitsWithGiveSum(testCase7, 3));
        System.out.println(doesSubArrayExitsWithGiveSum(testCase8, 10));
        System.out.println(doesSubArrayExitsWithGiveSum(testCase9, 14));
    }
}
