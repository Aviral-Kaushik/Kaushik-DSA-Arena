package DataStructures.Arrays.Techniques.PrefixSum;

import java.util.HashMap;

public class NumberOfSubArraysWithSumK {

    /// Problem:
    /// Given an array and an integer K, find the number of sub arrays whose sum is equal to K.

    private static int numberOfSubArraysWithSum(int[] arr, int target) {
        int prefixSum = 0;
        int count = 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for (int num: arr) {
            prefixSum += num;

            if (map.containsKey(prefixSum - target)) {
                count += map.get(prefixSum - target);
            }

            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        int[] testCase1 = {1, 1, 1};
        int[] testCase2 = {3, 4, 7, 2};
        int[] testCase3 = {0, 0, 0};
        int[] testCase4 = {1, -1, 1, -1, 1};

        System.out.println(numberOfSubArraysWithSum(testCase1, 2));
        System.out.println(numberOfSubArraysWithSum(testCase2, 7));
        System.out.println(numberOfSubArraysWithSum(testCase3, 0));
        System.out.println(numberOfSubArraysWithSum(testCase4, 0));
    }


}
