package DataStructures.Arrays.Searching;

public class BinarySearch {

    /// There are 2 types of searching in an array:

    /// 1. Linear Search: We iterate to a whole array and check weather the current element is equal to the target or
    /// not and return the index of element if it found. So, worst case time complexity is O(n).

    /// 2. Binary Search: If the array is sorted, we can quickly find an element in O(log n) time using binary search.
    /// In Binary Search, we check the element in the middle if the element is smaller than the mid-element we neglect
    /// the array after mid-element and if the element is greater than mid-element then we neglect the array before
    /// element and repeat this until the element is found or the array gets completed. So, it gives us time
    /// complexity of O(log n).

    /// Problem Statement:
    /// In this problem we have given a sorted array. and we need to find a target and if found return the index of the
    /// element and if not found return -1.

    /**
     * Binary Search
     * Time Complexity: O(log n)
     * Space Complexity: O(n)
     * */
    private static int binarySearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

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
        int[] testCase1 = {10, 20, 30, 40, 50, 60};
        int[] testCase2 = {5, 15, 25};
        int[] testCase3 = {5, 10, 15, 25, 35};
        int[] testCase4 = {10, 15};
        int[] testCase5 = {10, 10};

        System.out.println(binarySearch(testCase1, 60));
        System.out.println(binarySearch(testCase2, 25));
        System.out.println(binarySearch(testCase3, 20));
        System.out.println(binarySearch(testCase4, 20));
        System.out.println(binarySearch(testCase5, 10));
    }

}
