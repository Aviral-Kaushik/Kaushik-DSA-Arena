package DataStructures.Arrays.Searching;

public class IndexOfFirstOccurrenceInSorted {

    /// Problem Statement:
    /// In this problem, we have given a sorted array & input target, we need to return the index of first occurrence of
    /// the element in the sorted array if the target is present in the array otherwise return -1.


    /**
     * Naive Method
     * Time Complexity: O(n)
     * */
    private static int getIndexOfFirstOccurrenceUsingNaiveMethod(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }

        return -1;
    }

    /**
     * Binary Search
     * Time Complexity; O(log n)
     * */
    public static int getIndexOfFirstOccurrenceUsingBinarySearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (arr[mid] == target) {
                if (mid == 0 || arr[mid - 1] != target) {
                    return mid;
                } else {
                    end = mid - 1;
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
        int[] testCase1 = {1, 10, 10, 10, 20, 20, 40};
        int[] testCase2 = {10, 20, 30};
        int[] testCase3 = {15, 15, 15};
        int[] testCase4 = {5, 10, 10, 15, 15, 20, 20, 20};

        System.out.println(getIndexOfFirstOccurrenceUsingNaiveMethod(testCase1, 20));
        System.out.println(getIndexOfFirstOccurrenceUsingBinarySearch(testCase1, 20));

        System.out.println(getIndexOfFirstOccurrenceUsingNaiveMethod(testCase2, 15));
        System.out.println(getIndexOfFirstOccurrenceUsingBinarySearch(testCase2, 15));

        System.out.println(getIndexOfFirstOccurrenceUsingNaiveMethod(testCase3, 15));
        System.out.println(getIndexOfFirstOccurrenceUsingBinarySearch(testCase3, 15));

        System.out.println(getIndexOfFirstOccurrenceUsingNaiveMethod(testCase4, 20));
        System.out.println(getIndexOfFirstOccurrenceUsingBinarySearch(testCase4, 20));
    }


}
