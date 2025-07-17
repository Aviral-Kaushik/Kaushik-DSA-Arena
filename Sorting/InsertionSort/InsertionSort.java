package Sorting.InsertionSort;

import java.util.Arrays;

public class InsertionSort {

    /**
     * Insertion Sort
     * Time Complexity: O(n ^ 2)
     * Space Complexity: O(1)
     * Stable Algorithm: Yes
     * Used in array of small size.
     * */
    private static int[] insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;
        }

        return arr;
    }

    public static void main(String[] args) {
        int[] testCase1 = {30, 45, 33, 29, 15, 17, 55, 78};
        int[] testCase2 = {7, 17, 35, 89, 45, 33, 109, 111, 89};
        int[] testCase3 = {20, 88, 10, 85, 75, 95, 18, 82, 60};
        int[] testCase4 = {20, 5, 40, 60, 10, 30};
        int[] testCase5 = {10, 5, 30, 15, 7};
        int[] testCase6 = {30, 10, 18, 3, 2, 16, 50, 1};

        System.out.println(Arrays.toString(insertionSort(testCase1)));
        System.out.println(Arrays.toString(insertionSort(testCase2)));
        System.out.println(Arrays.toString(insertionSort(testCase3)));
        System.out.println(Arrays.toString(insertionSort(testCase4)));
        System.out.println(Arrays.toString(insertionSort(testCase5)));
        System.out.println(Arrays.toString(insertionSort(testCase6)));
    }
}
