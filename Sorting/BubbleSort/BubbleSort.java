package Sorting.BubbleSort;

import java.util.Arrays;

public class BubbleSort {

    /**
     * Bubble Sort
     * Time Complexity: O(n ^ 2)
     * Space Complexity: O(1)
     * Stable Algorithm: Yes
     * */
    private static int[] bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }

            if (!swapped)
                break;
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

        System.out.println(Arrays.toString(bubbleSort(testCase1)));
        System.out.println(Arrays.toString(bubbleSort(testCase2)));
        System.out.println(Arrays.toString(bubbleSort(testCase3)));
        System.out.println(Arrays.toString(bubbleSort(testCase4)));
        System.out.println(Arrays.toString(bubbleSort(testCase5)));
        System.out.println(Arrays.toString(bubbleSort(testCase6)));
    }

}
