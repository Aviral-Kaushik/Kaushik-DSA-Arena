package Sorting.RadixSort;

import java.util.Arrays;

public class RadixSort {

    /**
     * Radix Sort
     * Best Case Time Complexity: O(n * d)
     * Average Case Time Complexity: O(n * d)
     * Worst Case Time Complexity: O(n * d)
     * Space Complexity: O(n)
     * Stable Algorithm: Yes
     * In-Place Algorithm: No
     * Where, n is the number of elements in the input array.
     *      d = Number of digits in the maximum element like
     *      - for max element 321 it will be 3,
     *      - for 1014 it will be 4 &
     *      - for 11514 it will be 5.
     * <p>
     * 1. Radix Sort is capable of sorting array with elements with larger values, alike counting sort.
     * 2. Radix Sort uses counting sort as a subroutine.
     * 3. Radix Sort is not a comparison based sorting algorithm like counting sort. It does not compare the elements
     * with each other.
     * </p>
     * */
    private static void radixSort(int[] arr) {
        int n = arr.length;
        int max = arr[0];

        for (int i = 1; i < n; i++) {
            max = Math.max(arr[i], max);
        }

        for (int exp = 1; max / exp > 0; exp = exp * 10) {
            countingSort(arr, exp);
        }
    }

    private static void countingSort(int[] arr, int exp) {
        int n = arr.length;

        int[] count = new int[10];
        int[] output = new int[n];

        Arrays.fill(count, 0);

        for (int j : arr) {
            count[(j / exp) % 10]++;
        }

        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) {
            output[(count[(arr[i] / exp) % 10]) - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }

        for (int i = 0; i < n; i++) {
            arr[i] = output[i];
        }
    }

    public static void main(String[] args) {
        int[] testCase1 = {30, 45, 33, 29, 15, 17, 55, 78};
        int[] testCase2 = {7, 17, 35, 89, 45, 33, 109, 111, 89};
        int[] testCase3 = {20, 88, 10, 85, 75, 95, 18, 82, 60};
        int[] testCase4 = {20, 5, 40, 60, 10, 30};
        int[] testCase5 = {10, 5, 30, 15, 7};
        int[] testCase6 = {30, 10, 18, 3, 2, 16, 50, 1};
        int[] testCase7 = {34, 7, 23, 32, 5, 62, 3, 9, 12, 45, 1};

        radixSort(testCase1);
        radixSort(testCase2);
        radixSort(testCase3);
        radixSort(testCase4);
        radixSort(testCase5);
        radixSort(testCase6);
        radixSort(testCase7);

        System.out.println(Arrays.toString(testCase1));
        System.out.println(Arrays.toString(testCase2));
        System.out.println(Arrays.toString(testCase3));
        System.out.println(Arrays.toString(testCase4));
        System.out.println(Arrays.toString(testCase5));
        System.out.println(Arrays.toString(testCase6));
        System.out.println(Arrays.toString(testCase7));
    }
}
