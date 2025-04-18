package DataStructures.Arrays.Searching;

public class CountOccurrencesInSorted {

    /// Problem Statement:
    /// In this problem, we have given a sorted array that might contain duplicates and a target number, and we need to
    /// find the occurrences of that target number in the array.

    /**
     * Solution using Binary Search Technique
     * Time Complexity: O(log n)
     * As both first occurrence and last occurrence solution has time complexity O(log n).
     * */
    private static int countOccurrences(int[] arr, int target) {
        int firstOccurrence = IndexOfFirstOccurrenceInSorted.getIndexOfFirstOccurrenceUsingBinarySearch(arr, target);

        if (firstOccurrence == -1)
            return 0;

        int lastOccurrence = IndexOfLastOccurrenceInSorted.getIndexOfLastOccurrenceUsingBinaryElement(arr, target);

        return lastOccurrence - firstOccurrence + 1;
    }

    public static void main(String[] args) {
        int[] testCase1 = {10, 20, 20, 20, 30, 30};
        int[] testCase2 = {10, 10, 10, 10, 10, 10};
        int[] testCase3 = {5, 8, 10};

        System.out.println(countOccurrences(testCase1, 20));
        System.out.println(countOccurrences(testCase2, 10));
        System.out.println(countOccurrences(testCase3, 7));
    }

}
