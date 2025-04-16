package DataStructures.Arrays.PracticeProblems;

import java.util.HashMap;
import java.util.Map;

public class MaximumAppearingElementInRanges {

    /// In this problem, we have given 2 arrays first array represents starting points of the range and second array
    /// represents ending point of the range, so we need to return the element that appears most of the time in all ranges.

    /// Examples:

    /// 1. Input: left = [1, 2, 5, 15] & right = [5, 8, 7, 18]
    /// So, all the range arrays: [1, 2, 3, 4, 5], [2, 3, 4, 5, 6, 7, 8], [5, 6, 7] & [15, 16, 17, 18]
    /// Output: 5 (as 5 appears 3 times in all range arrays which is the maximum time for all the element).

    /// 2. Input: left = [1, 2] & right = [5, 4]
    /// So, all range arrays: [1, 2, 3, 4, 5] & [2, 3, 4]
    /// Output: 2 (both 2 and 3 appears 2 times which is maximum time).

    /// Constraints:
    /// 1. 0 <= left[/i] <= right[/i] <= 100 (elements value)
    /// 2. 0 <= i <= 10 ^ 5 (index value)


    /**
     * Naive Method
     * Time Complexity: O(n * MAX), in this problem MAX is 100.
     * Space Complexity: O(n)
     * */
    private static int getMaxAppearingElementUsingNaiveMethod(int[] left, int[] right) {
        int[] frequencies = new int[100];

        for (int i = 0; i < left.length; i++) {
            for (int j = left[i]; j <= right[i]; j++) {
                frequencies[j] += 1;
            }
        }

        int res = 0;

        for (int i = 1; i < 100; i++) {
            if (frequencies[i] > frequencies[res]) {
                res = i;
            }
        }

        return res;
    }

    /**
     * Efficient Solution using Hashmap
     * More Efficient for large ranges.
     * Time Complexity: O(n * R), where N is the number of ranges, and R is the average range size (right[i] - left[i]).
     * Space Complexity: O(n)
     * */
    private static int getMaxAppearingElementUsingHashMap(int[] left, int[] right) {
        HashMap<Integer, Integer> frequencies = new HashMap<>();
        int res = 0;
        int count = 0;

        for (int i = 0; i < left.length; i++) {
            for (int j = left[i]; j <= right[i]; j++) {
                frequencies.put(j, frequencies.getOrDefault(j, 0) + 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry: frequencies.entrySet()) {
            if (count < entry.getValue()) {
                count = entry.getValue();
                res = entry.getKey();
            }
        }

        return res;
    }

    /**
     * Efficient Solution
     * More Efficient for large ranges.
     * Time Complexity: O(N + M)
     * Space Complexity: O(M)
     * */
    private static int getMaxAppearingElementUsingPrefixSum(int[] left, int[] right) {
        int max = 0;

        // Find the maximum element to determine array size
        for (int i = 0; i < left.length; i++) {
            if (right[i] > max) {
                max = right[i];
            }
        }

        int[] frequencies = new int[max + 2]; // +2 to safely include right[i] + 1

        // Step 1: Use difference array
        for (int i = 0; i < left.length; i++) {
            frequencies[left[i]] += 1;
            frequencies[right[i] + 1] -= 1;
        }

        // Step 2: Prefix sum and find max
        int res = 0, maxFrequency = frequencies[0];
        for (int i = 1; i < frequencies.length; i++) {
            frequencies[i] += frequencies[i - 1];
            if (frequencies[i] > maxFrequency) {
                maxFrequency = frequencies[i];
                res = i;
            }
        }

        return res;
    }

    public static void main(String[] args) {
//        int[] left = {1, 2, 5, 15};
//        int[] right = {5, 8, 7, 18};

        int[] left = {1, 2};
        int[] right = {5, 4};

        System.out.println(getMaxAppearingElementUsingNaiveMethod(left, right));
        System.out.println(getMaxAppearingElementUsingHashMap(left, right));
        System.out.println(getMaxAppearingElementUsingPrefixSum(left, right));
    }

}
