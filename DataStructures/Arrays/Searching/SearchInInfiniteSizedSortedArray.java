package DataStructures.Arrays.Searching;

public class SearchInInfiniteSizedSortedArray {

    /// Problem Statement:
    /// In this problem, we have given an infinite sized sorted array and a target, and we need to return the index of
    /// target element if it exits in the sorted array otherwise return -1.

    /// Infinite Sized Sorted Array means a very large sized sorted array (like in millions).

    /**
     * Binary Search Method
     * Time Complexity: O(log p), where p is the position of the element in the infinite sorted array.
     * */
    private static int searchInInfiniteSizedArrayUsingBinarySearch(int[] arr, int target) {
        if (arr[0] == target) {
            return 0;
        }

        int start = 0;
        int end = 1;

        // Step 1: Expand the range exponentially
        while (end < arr.length && arr[end] < target) {
            start = end;
            end *= 2;
            // To avoid IndexOutOfBounds if end exceeds array size
            if (end >= arr.length) {
                end = arr.length - 1;
                break;
            }
        }

        // Step 2: Perform binary search in the found range
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] testCase1 = {1, 10, 15, 20, 40, 80, 90, 100, 120, 150, 500, 179, 799, 888, 594}; // ...
        int[] testCase2 = {20, 40, 100, 300, 333, 444, 357, 159, 486, 158}; // ....

        System.out.println(searchInInfiniteSizedArrayUsingBinarySearch(testCase1, 100));
        System.out.println(searchInInfiniteSizedArrayUsingBinarySearch(testCase2, 50));
    }

}
