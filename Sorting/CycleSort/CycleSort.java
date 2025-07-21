package Sorting.CycleSort;

import java.util.Arrays;

public class CycleSort {

    /**
     * Cycle Sort
     * Best Case Time Complexity: O(n ^ 2)
     * Worst Case Time Complexity: O(n ^ 2)
     * Average Case Time Complexity: O(n ^ 2)
     * Space Complexity: O(1)
     * Stable Algorithm: No
     * In-Place Algorithm: Yes
     * <p>
     * 1. Does minimum write operation and can be helpful for cases where memory writes are costly.
     * 2. Useful to solve questions like find minimum swaps to sort an array.
     * </p>
     * */
    private static void cycleSort(int[] arr) {
        // count number of memory writes, in case of question where we have to return minimum number of swaps to sort
        // an array we can return this write.
        int writes = 0;

        int n = arr.length;

        for (int cycleStart = 0; cycleStart <= n - 2; cycleStart++) {
            int item = arr[cycleStart];

            int pos = cycleStart;

            // Find position where we put the item. We basically
            // count all smaller elements on right side of item.
            for (int i = cycleStart + 1; i < n; i++) {
                if (arr[i] < item)
                    pos++;
            }

            // If item is already in correct position
            if (pos == cycleStart)
                continue;

            // ignore all duplicate elements
            while (item == arr[pos])
                pos += 1;

            // put the item to it's right position
            if (pos != cycleStart) {
                int temp = item;
                item = arr[pos];
                arr[pos] = temp;

                writes++;
            }

            // Rotate rest of the cycle
            while (pos != cycleStart) {
                pos = cycleStart;

                // Find position where we put the element
                for (int i = cycleStart + 1; i < n; i++) {
                    if (arr[i] < item)
                        pos += 1;
                }

                // ignore all duplicate elements
                while (arr[pos] == item)
                    pos += 1;

                // put the item to it's right position
                if (item != arr[pos]) {
                    int temp = item;
                    item = arr[pos];
                    arr[pos] = temp;

                    writes++;
                }
            }
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

        cycleSort(testCase1);
        cycleSort(testCase2);
        cycleSort(testCase3);
        cycleSort(testCase4);
        cycleSort(testCase5);
        cycleSort(testCase6);
        cycleSort(testCase7);

        System.out.println(Arrays.toString(testCase1));
        System.out.println(Arrays.toString(testCase2));
        System.out.println(Arrays.toString(testCase3));
        System.out.println(Arrays.toString(testCase4));
        System.out.println(Arrays.toString(testCase5));
        System.out.println(Arrays.toString(testCase6));
        System.out.println(Arrays.toString(testCase7));
    }

}
