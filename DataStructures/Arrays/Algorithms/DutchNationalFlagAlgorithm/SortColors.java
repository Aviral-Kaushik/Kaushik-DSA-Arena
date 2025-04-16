package DataStructures.Arrays.Algorithms.DutchNationalFlagAlgorithm;

import java.util.Arrays;

public class SortColors {

    /// Problem:
    /// In this problem, we have given an arrays of colors that contains 3 types of elements 0s, 1s & 2s and we need to
    /// sort them where, 0 represents Red Color, 1 represents White Color and 2 represents Blue Color.

    /// Input: [2, 0, 2, 1, 1, 0]
    /// Output: [0, 0, 1, 1, 2, 2]

    /**
     * Dutch National Flag Algorithm
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * */
    private static void sortColors(int[] nums) {
        int low = 0, high = nums.length - 1, mid = 0;

        while (mid <= high) {
            if (nums[mid] == 0) {
                swap(nums, low++, mid++);
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                swap(nums, mid, high--);
            }
        }

    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 1, 2, 1, 0, 2, 0, 1};

        sortColors(arr);
        System.out.println(Arrays.toString(arr));
    }
}
