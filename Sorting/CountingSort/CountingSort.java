package Sorting.CountingSort;

import java.util.Arrays;

public class CountingSort {

    /**
     * Counting Sort
     * Time Complexity: O(n + m)
     * Space Complexity: O(n + m)
     * Stable Algorithm: Yes
     * In-Place Algorithm: No
     * where n is the size of input array (arr) and m is the size count array.
     * <p>
     * 1. Counting Sort is mainly used where the input elements are in smaller range.
     * 2. Counting Sort is not a comparison based soring algorithm, it never compares elements with each others. Instead,
     * it counts occurrences & frequencies of elements.
     * 3. Used as a subroutine in radix sort.
     * 4. Counting sort generally performs faster than all comparison-based sorting algorithms, such as merge sort and
     * quicksort, if the range of input is of the order of the number of input.
     * 5. Counting sort is inefficient if the range of values to be sorted is very large.
     * </p>
     * */
    private static void countingSort(int[] arr) {
        int n = arr.length;
        
        int maxValue = arr[0];
        for (int i = 1; i < n; i++) {
            maxValue = Math.max(arr[i], maxValue);
        }

        int[] count = new int[maxValue + 1];

        for (int j : arr) {
            count[j]++;
        }

        for (int i = 1; i <= maxValue; i++) {
            count[i] += count[i - 1];
        }

        int[] output = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            output[count[arr[i]] - 1] = arr[i];
            count[arr[i]]--;
        }

        for (int i = 0; i < n; i++) {
            arr[i] = output[i];
        }

    }

    public static void main(String[] args) {
        int[] testCase1 = {2,5,3,0,2,3,0,3};
        int[] testCase2 = { 4, 2, 2, 8, 3, 3, 1 };
        int[] testCase3 = {10, 5, 30, 15, 7};

        countingSort(testCase1);
        countingSort(testCase2);
        countingSort(testCase3);

        System.out.println(Arrays.toString(testCase1));
        System.out.println(Arrays.toString(testCase2));
        System.out.println(Arrays.toString(testCase3));
    }
}
