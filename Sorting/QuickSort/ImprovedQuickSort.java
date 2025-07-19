package Sorting.QuickSort;

import java.util.Arrays;

public class ImprovedQuickSort {


    private static final int INSERTION_SORT_THRESHOLD = 10;

    /**
     * Improved Quick Sort
     * Time Complexity: O(n log n)
     * Best Case Time Complexity: O(n log n)
     * Average Case Time Complexity: O(n log n)
     * Worst Case Time Complexity: O(n ^ 2)
     * Space Complexity: O(n)
     * Stable Algorithm: No
     * In Place Algorithm: Yes
     * <p>
     * 1. This algo reduces that chances of hitting worst case so there are fewer chances of getting worst case time
     * complexity of O(n ^ 2). But we cannot guarantee that we will not get worst case in every case but most of the
     * time it will fall into average case and runs with average case time complexity O(n log n).
     * 2. All the libraries that provides and uses quick sort uses this version of improved quick sort as it provides
     * better overall time complexity.
     * 3. This algo works on an idea that the pivot element shall not be last element or first element so the worst case
     * of time complexity never happens.
     * 4. So, it is better than default quick sort algorithm.
     * */
    private static void quickSort(int[] arr, int low, int high) {
        while (low < high) {

            if (high - low + 1 < INSERTION_SORT_THRESHOLD) {
                insertionSort(arr);
                return;
            }


            // Median-of-three pivot selection
            int pivotIndex = medianOfThree(arr, low, high);
            int pivotNewIndex = partition(arr, low, high, pivotIndex);

            // Tail call optimization: recurse on smaller part first
            if (pivotNewIndex - low < high - pivotNewIndex) {
                quickSort(arr, low, pivotNewIndex - 1);
                low = pivotNewIndex + 1;
            } else {
                quickSort(arr, pivotNewIndex + 1, high);
                high = pivotNewIndex - 1;
            }
        }
    }

    private static int medianOfThree(int[] arr, int low, int high) {
        if (high - low < 2) {
            return low; // fallback to simple pivot
        }

        int mid = low + (high - low) / 2;

        if (arr[mid] < arr[low])
            swap(arr, low, mid);
        else if (arr[high] < arr[low])
            swap(arr, low, high);
        else if (arr[high] < arr[mid])
            swap(arr, mid, high);

        // Place the pivot at high - 1
        swap(arr, mid, high - 1);

        return high - 1;
    }

    private static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;
        }
    }

    private static int partition(int[] arr, int low, int high, int pivotIndex) {
        int pivotValue = arr[pivotIndex];
        swap(arr, pivotIndex, high);  // Move pivot to end
        int storeIndex = low;

        for (int i = low; i < high; i++) {
            if (arr[i] < pivotValue) {
                swap(arr, i, storeIndex++);
            }
        }

        swap(arr, storeIndex, high);  // Move pivot to final place
        return storeIndex;
    }

    private static void swap(int[] arr, int i, int j) {
        if (i != j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
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

        quickSort(testCase1, 0, testCase1.length - 1);
        quickSort(testCase2, 0, testCase1.length - 1);
        quickSort(testCase3, 0, testCase1.length - 1);
        quickSort(testCase4, 0, testCase1.length - 1);
        quickSort(testCase5, 0, testCase1.length - 1);
        quickSort(testCase6, 0, testCase1.length - 1);
        quickSort(testCase7, 0, testCase1.length - 1);

        System.out.println(Arrays.toString(testCase1));
        System.out.println(Arrays.toString(testCase2));
        System.out.println(Arrays.toString(testCase3));
        System.out.println(Arrays.toString(testCase4));
        System.out.println(Arrays.toString(testCase5));
        System.out.println(Arrays.toString(testCase6));
        System.out.println(Arrays.toString(testCase7));
    }
}
