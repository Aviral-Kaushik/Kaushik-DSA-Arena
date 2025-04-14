package DataStructures.Arrays.Techniques.PrefixSum;

import java.util.HashSet;

public class SubArrayWithGivenSum {

    /// Problem:
    /// Given an array and a value target, return true if there exists a contiguous sub array that sums to target.

    private static boolean hasSubArrayWithSum(int[] arr, int target) {
        int prefixSum = 0;
        HashSet<Integer> seen = new HashSet<>();
        seen.add(arr[0]);

        for (int num: arr) {
            prefixSum += num;

            if (seen.contains(prefixSum - target)) {
                return true;
            }

            seen.add(prefixSum);
        }

        return false;
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 1, 5, 3};

        System.out.println(hasSubArrayWithSum(arr, 9));
    }

}
