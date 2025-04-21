package DataStructures.Arrays.Searching;

public class SearchInSortedRotatedArray {

    /// Problem Statement:
    /// In this problem, we have given a sorted rotated array and a target number, and we need to return the index of that
    /// target element in that sorted rotated array if it exits otherwise return -1.

    /// Input: [10, 20, 30, 40, 50, 8, 9] & 30
    /// Output: 2
    /// Input: [100, 200, 300, 10, 20] & 40
    /// Output: -1

    /**
     * Linear Search
     * Time Complexity: O(n)
     * */
    private static int searchInSortedRotatedArrayUsingLinearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }

        return -1;
    }


    /**
     * Binary Search
     * Time Complexity: O(log n)
     * */
    private static int searchInSortedRotatedArrayUsingBinarySearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (arr[mid] == target) {
                return mid;
            }

            if (arr[start] <= arr[mid]) {
                if (target >= arr[start] && target < arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (target > arr[mid] && target <= arr[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }

        return -1;
    }


    public static void main(String[] args) {
        int[] testCase1 = {10, 20, 30, 40, 50, 8, 9};
        int[] testCase2 = {100, 200, 10, 20};
        int[] testCase3 = {100, 200, 400, 1000, 10, 20};
        int[] testCase4 = {10, 20, 40, 60, 5, 8};

        System.out.println(searchInSortedRotatedArrayUsingLinearSearch(testCase1, 30));
        System.out.println(searchInSortedRotatedArrayUsingBinarySearch(testCase1, 30));

        System.out.println(searchInSortedRotatedArrayUsingLinearSearch(testCase2, 40));
        System.out.println(searchInSortedRotatedArrayUsingBinarySearch(testCase2, 40));

        System.out.println(searchInSortedRotatedArrayUsingLinearSearch(testCase3, 10));
        System.out.println(searchInSortedRotatedArrayUsingBinarySearch(testCase3, 10));

        System.out.println(searchInSortedRotatedArrayUsingLinearSearch(testCase4, 5));
        System.out.println(searchInSortedRotatedArrayUsingBinarySearch(testCase4, 5));

        System.out.println(searchInSortedRotatedArrayUsingLinearSearch(testCase4, 6));
        System.out.println(searchInSortedRotatedArrayUsingBinarySearch(testCase4, 6));
    }

}
