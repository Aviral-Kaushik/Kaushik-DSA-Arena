package Sorting.SelectionSort;

import java.util.Arrays;

public class SelectionSort {

    /**
     * Selection Sort
     * Time Complexity: O(n ^ 2)
     * Space Complexity: O(1)
     * Stable Algorithm: No
     * */
    private static int[] selectionSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
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

        System.out.println(Arrays.toString(selectionSort(testCase1)));
        System.out.println(Arrays.toString(selectionSort(testCase2)));
        System.out.println(Arrays.toString(selectionSort(testCase3)));
        System.out.println(Arrays.toString(selectionSort(testCase4)));
        System.out.println(Arrays.toString(selectionSort(testCase5)));
        System.out.println(Arrays.toString(selectionSort(testCase6)));
    }

}
