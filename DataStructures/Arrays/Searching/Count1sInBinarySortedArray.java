package DataStructures.Arrays.Searching;

public class Count1sInBinarySortedArray {

    /// Problem Statement:
    /// In this problem, we have given a binary sorted array (contains only 0s and 1s in sorted manner),
    /// we need to return the number of ones the array has.

    /**
     * Solution using Binary Search Technique.
     * Time Complexity: O(log n)
     * As Time Complexity of code for getting first occurrence in sorted array using binary search.
     * */
    private static int getCountOf1sInSortedBinaryArray(int[] arr) {
        int firstOccurrenceOf1 = IndexOfFirstOccurrenceInSorted.getIndexOfFirstOccurrenceUsingBinarySearch(arr, 1);

        if (firstOccurrenceOf1 == -1)
            return 0;

        return arr.length - firstOccurrenceOf1;
    }

    public static void main(String[] args) {
        int[] testCase1 = {0, 0, 0, 1, 1, 1, 1};
        int[] testCase2 = {1, 1, 1, 1, 1};
        int[] testCase3 = {0, 0, 0, 0};

        System.out.println(getCountOf1sInSortedBinaryArray(testCase1));
        System.out.println(getCountOf1sInSortedBinaryArray(testCase2));
        System.out.println(getCountOf1sInSortedBinaryArray(testCase3));
    }

}
