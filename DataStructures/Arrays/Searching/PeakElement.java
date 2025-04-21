package DataStructures.Arrays.Searching;

public class PeakElement {

    /// Problem Statement:
    /// In this problem, we have given an unsorted array, and we need to find out the peak element in it.

    /// An element is known as peak element if it is not smaller than its neighbour elements, i.e, either greater or
    /// equal to neighbour elements. For the stating element we only need to consider the next element (second element)
    /// to it and for last element we only need to consider the element that is behind it (second last element).

    /// Input: [5, 10, 20, 15, 7]
    /// Output: 20

    /// Input: [10, 20, 15, 5, 23, 90, 67]
    /// Output: 20 or 90

    /// Input: [80, 70, 60]
    /// Output: 80

    /**
     * Naive Method
     * Time Complexity: O(n)
     * */
    private static int getPeakElementUsingNaiveMethod(int[] arr) {
        int size = arr.length;
        if (size == 1) {
            return arr[0];
        }
        if (arr[0] >= arr[1]) {
            return arr[0];
        }

        if (arr[size - 1] >= arr[size - 2]) {
            return arr[size - 1];
        }

        for (int i = 1; i < size - 1; i++) {
            if (arr[i] >= arr[i - 1] && arr[i] >= arr[i + 1]) {
                return arr[i];
            }
        }

        return -1;
    }


    /**
     * Binary Search Method
     * Time Complexity: O(log n)
     * */
    private static int getPeakElementUsingBinarySearch(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if ((mid == 0 || arr[mid - 1] <= arr[mid])
                    && (mid == arr.length - 1 || arr[mid + 1] <= arr[mid])) {
                return arr[mid];
            }

            if (mid > 0 && arr[mid - 1] >= arr[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] testCase1 = {5, 10, 20, 15, 7};
        int[] testCase2 = {10, 20, 15, 5, 23, 90, 67};
        int[] testCase3 = {80, 70, 60};
        int[] testCase4 = {6, 7, 8, 20, 12};
        int[] testCase5 = {5, 20, 40, 30, 20, 50, 60};

        System.out.println(getPeakElementUsingNaiveMethod(testCase1));
        System.out.println(getPeakElementUsingBinarySearch(testCase1));

        System.out.println(getPeakElementUsingNaiveMethod(testCase2));
        System.out.println(getPeakElementUsingBinarySearch(testCase2));

        System.out.println(getPeakElementUsingNaiveMethod(testCase3));
        System.out.println(getPeakElementUsingBinarySearch(testCase3));

        System.out.println(getPeakElementUsingNaiveMethod(testCase4));
        System.out.println(getPeakElementUsingBinarySearch(testCase4));

        System.out.println(getPeakElementUsingNaiveMethod(testCase5));
        System.out.println(getPeakElementUsingBinarySearch(testCase5));
    }

}
