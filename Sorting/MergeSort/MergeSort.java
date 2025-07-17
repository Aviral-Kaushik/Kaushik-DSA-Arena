package Sorting.MergeSort;

import java.util.Arrays;

public class MergeSort {

    /**
     * Merge Sort
     * Time Complexity: O(n log n)
     * Space Complexity: O(n)
     * Stable Algorithm: Yes
     * In-Place Algorithm: Not, an in-place sorting algorithm.
     * <p>
     * 1. Divide & Conquer Algorithm (Divide, Conquer & Merge).
     * 2. Well suited for Linked List. Works in O(1) Auxiliary Space.
     * 3. In general for array, Quick Sort Outperforms.
     * */
    private static int[] mergeSort(int[] arr, int low, int high) {
        if (high > low) {
            int mid = low + (high - low) / 2;

            mergeSort(arr, low, mid);
            mergeSort(arr, mid + 1, high);

            merge(arr, low, mid, high);
        }

        return arr;
    }

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * Where n is the number of elements from low to high.
     * */
    private static void merge(int[] arr, int low, int mid, int high) {
        int n1 = mid - low + 1;
        int n2 = high - mid;

        int[] left = new int[n1];
        int[] right = new int[n2];

        for (int i = 0; i < n1; i++) {
            left[i] = arr[low + i];
        }

        for (int i = 0; i < n2; i++) {
            right[i] = arr[mid + 1 + i];
        }

        int i = 0, j = 0;
        int k = low;

        while (i < n1 && j < n2) {
            if (left[i] <= right[j]) {
                arr[k] = left[i];
                i++;
            } else {
                arr[k] = right[j];
                j++;
            }

            k++;
        }

        while (i < n1) {
            arr[k] = left[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = right[j];
            j++;
            k++;
        }
    }

    /**
     * Time Complexity: O(m + n)
     * Where m is the length of array 1 and n is the length of array2.
     * */
    private static void mergeTwoSortedArrays(int[] a, int[] b) {
        int m = a.length, n = b.length;

        int i = 0, j = 0;

        while (i < m && j < n) {
            if (a[i] <= b[j]) {
                System.out.print(a[i] + " ");
                i++;
            } else {
                System.out.print(b[j] + " ");
                j++;
            }
        }

        while (i < m) {
            System.out.print(a[i] + " ");
            i++;
        }

        while (j < n) {
            System.out.print(b[j] + " ");
            j++;
        }

    }

    public static void main(String[] args) {
        int[] testCase1 = {30, 45, 33, 29, 15, 17, 55, 78};
        int[] testCase2 = {7, 17, 35, 89, 45, 33, 109, 111, 89};
        int[] testCase3 = {20, 88, 10, 85, 75, 95, 18, 82, 60};
        int[] testCase4 = {20, 5, 40, 60, 10, 30};
        int[] testCase5 = {10, 5, 30, 15, 7};
        int[] testCase6 = {30, 10, 18, 3, 2, 16, 50, 1};

        System.out.println(Arrays.toString(mergeSort(testCase1, 0, testCase1.length - 1)));
        System.out.println(Arrays.toString(mergeSort(testCase2, 0, testCase2.length - 1)));
        System.out.println(Arrays.toString(mergeSort(testCase3, 0, testCase3.length - 1)));
        System.out.println(Arrays.toString(mergeSort(testCase4, 0, testCase4.length - 1)));
        System.out.println(Arrays.toString(mergeSort(testCase5, 0, testCase5.length - 1)));
        System.out.println(Arrays.toString(mergeSort(testCase6, 0, testCase6.length - 1)));
    }

}
