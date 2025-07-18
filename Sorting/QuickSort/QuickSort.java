package Sorting.QuickSort;

import java.util.Arrays;

public class QuickSort {

    /**
     * Quick Sort
     * Average Case Time Complexity: O(n log n)
     * Worst Case Time Complexity: O(n ^ 2)
     * Space Complexity: O(n)
     * Stable Algorithm: No
     * In Place Algorithm: Yes
     * <p>
     * 1. Divide & Conquer Algorithm.
     * 2. Quick Sort Algorithm is not a stable algorithm by default, but we can convert it to a stable algorithm by
     * using Naive Partition Method instead of Lomuto Partition, but naive partition method will have more time complexity
     * in compare of Lomuto Partition so the time complexity of our quick sort function will also increase.
     * */
    private static int[] quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivot = partition(arr, low, high);

            quickSort(arr, low, pivot - 1);
            quickSort(arr, pivot + 1, high);
        }

        return arr;
    }

    /**
     * Partition Function: Lomuto Partition
     * This partition is also known as Lomuto Partition.
     * We use this partition algo in quick sort algo.
     * <p>
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * */
    private static int partition(int[] arr, int low, int high) {
        // Choose the pivot
        int pivot = arr[high];

        // Index of smaller element and indicates
        // the right position of pivot found so far
        int i = low - 1;

        // Traverse arr[low...high] and move all smaller
        // elements to the left side. Elements from low to
        // i are smaller after every iteration
        for (int j = low; j <= high - 1; j++) {
            if (arr[j] < pivot) {
                i++;

                swap(arr, i, j);
            }
        }

        // Move pivot after smaller elements and
        // return its position
        swap(arr, i + 1, high);

        return i + 1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static void main(String[] args) {
        int[] testCase1 = {30, 45, 33, 29, 15, 17, 55, 78};
        int[] testCase2 = {7, 17, 35, 89, 45, 33, 109, 111, 89};
        int[] testCase3 = {20, 88, 10, 85, 75, 95, 18, 82, 60};
        int[] testCase4 = {20, 5, 40, 60, 10, 30};
        int[] testCase5 = {10, 5, 30, 15, 7};
        int[] testCase6 = {30, 10, 18, 3, 2, 16, 50, 1};

        System.out.println(Arrays.toString(quickSort(testCase1, 0, testCase1.length - 1)));
        System.out.println(Arrays.toString(quickSort(testCase2, 0, testCase2.length - 1)));
        System.out.println(Arrays.toString(quickSort(testCase3, 0, testCase3.length - 1)));
        System.out.println(Arrays.toString(quickSort(testCase4, 0, testCase4.length - 1)));
        System.out.println(Arrays.toString(quickSort(testCase5, 0, testCase5.length - 1)));
        System.out.println(Arrays.toString(quickSort(testCase6, 0, testCase6.length - 1)));
    }

}
