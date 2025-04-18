package DataStructures.Arrays.Searching;

public class IndexOfLastOccurrenceInSorted {

    /// Problem Statement:
    /// In this problem, we have given a sorted array & input target, we need to return the index of last occurrence of
    /// the element in the sorted array if the target is present in the array otherwise return -1.


    /**
     * Naive Method
     * Time Complexity: O(n)
     * */
    private static int getIndexOfLastOccurrenceUsingNaiveMethod(int[] arr, int target) {

        for (int i = arr.length - 1; i >= 0; i--) {
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
    public static int getIndexOfLastOccurrenceUsingBinaryElement(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (arr[mid] == target) {
                if (mid == arr.length - 1 || arr[mid + 1] != target) {
                    return mid;
                } else {
                    start = mid + 1;
                }
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] testCase1 = {10, 15, 20, 20, 40, 40};
        int[] testCase2 = {5, 8, 8, 10, 10};
        int[] testCase3 = {8, 10, 10, 12};
        int[] testCase4 = {5, 10, 10, 10, 15, 15, 20, 20};

        System.out.println(getIndexOfLastOccurrenceUsingNaiveMethod(testCase1, 20));
        System.out.println(getIndexOfLastOccurrenceUsingBinaryElement(testCase1, 20));

        System.out.println(getIndexOfLastOccurrenceUsingNaiveMethod(testCase2, 10));
        System.out.println(getIndexOfLastOccurrenceUsingBinaryElement(testCase2, 10));

        System.out.println(getIndexOfLastOccurrenceUsingNaiveMethod(testCase3, 7));
        System.out.println(getIndexOfLastOccurrenceUsingBinaryElement(testCase3, 7));

        System.out.println(getIndexOfLastOccurrenceUsingNaiveMethod(testCase4, 20));
        System.out.println(getIndexOfLastOccurrenceUsingBinaryElement(testCase4, 20));
    }

}
