package Sorting.HeapSort;

import java.util.Arrays;

public class HeapSort {

    /**
     * Heap Sort
     * Time Complexity: O(n log n)
     * Space Complexity: O(log n), due to recursive call stack.
     * Stable Algorithm: No
     * In-Place Algorithm: Yes
     * <p>
     * 1. Typically, 2-3 times slower than well-implemented QuickSort. The reason for slowness is a lack of locality
     * of reference.
     * 2. Heap Sort can be mainly seen as improvement of selection sort just a change that we use max heap data structure
     * to sort the array.
     * 3. In practice, merge sort and heap sort takes lesser time then heap sort and hence merge sort and quick sort
     * are used more in practice.
     * 4. Heap sort is not used as a standalone sorting algorithm in libraries but it used as a helper sorting algorithm
     * in hybrid algorithm like intro sort.
     * </p>
     * */
    private static void heapSort(int[] arr) {
        int n = arr.length;

        buildHeap(arr);

        // One by one extract an element from heap
        for (int i = n - 1; i > 0; i--) {

            // Move current root to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Call max heapify on the reduced heap
            heapify(arr, i, 0);
        }
    }

    private static void buildHeap(int[] arr) {
        int n = arr.length;

        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }
    }

    // To heapify a subtree rooted with node i
    // which is an index in arr[].
    private static void heapify(int[] arr, int n, int i) {
        // Initialize largest as root
        int largest = i;

        int left = 2 * i + 1;
        int right = 2 * i + 2;

        // If left child is larger than root
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        // If right child is larger than largest so far
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        // If largest is not root
        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest);
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

        heapSort(testCase1);
        heapSort(testCase2);
        heapSort(testCase3);
        heapSort(testCase4);
        heapSort(testCase5);
        heapSort(testCase6);
        heapSort(testCase7);

        System.out.println(Arrays.toString(testCase1));
        System.out.println(Arrays.toString(testCase2));
        System.out.println(Arrays.toString(testCase3));
        System.out.println(Arrays.toString(testCase4));
        System.out.println(Arrays.toString(testCase5));
        System.out.println(Arrays.toString(testCase6));
        System.out.println(Arrays.toString(testCase7));
    }
}
