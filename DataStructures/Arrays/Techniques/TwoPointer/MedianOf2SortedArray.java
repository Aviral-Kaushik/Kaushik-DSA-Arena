package DataStructures.Arrays.Techniques.TwoPointer;

public class MedianOf2SortedArray {

    /// Problem Statement:
    /// In this problem, we have given 2 sorted arrays, and we need to find median of the array that is formed by
    /// merging both sorted array.

    /// Calculation of Median:
    /// 1. If the dataset has an odd number of values, the median is the middle value.
    /// 2. If the dataset has an even number of values, the median is the average of the two middle values.

    /// Test Cases:
    /// Input: [10, 20, 30, 40, 50] & [5, 15, 25, 35, 45]
    /// Output: 27.5
    /// as [5, 10, 15, 20, 25, 30, 35, 40, 45, 50] has Even elements count so average of 25 & 30. ((25 + 30 ) / 2).

    /// Input: [1, 2, 3, 4, 5, 6] & [10, 20, 30, 40, 50]
    /// Output: 6.0
    /// as [1, 2, 3, 4, 5, 6, 10, 20, 30, 40, 50] Odd elements count so middle element 6.

    /// Input: [10, 20, 30, 40, 50, 60] & [1, 2, 3, 4, 5]
    /// Output: 10.0
    /// as [1, 2, 3, 4, 5, 10, 20, 30, 40, 50, 60] has Odd elements count so middle element 10.


    /**
     * Merging Method
     * Time Complexity: O(n1 + n2)
     * Space Complexity: O(n1 + n2)
     * where n1 is arr1 length and n2 is arr2 length
     * */
    private static double calculateMedianUsingMergingMethod(int[] arr1, int[] arr2) {
        int size = arr1.length + arr2.length;

        int[] mergedArray = new int[size];
        int i = 0, j = 0, k = 0;

        // Merge both arrays until one is exhausted
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                mergedArray[k++] = arr1[i++];
            } else {
                mergedArray[k++] = arr2[j++];
            }
        }

        // Copy remaining elements from arr1 (if any)
        while (i < arr1.length) {
            mergedArray[k++] = arr1[i++];
        }

        // Copy remaining elements from arr2 (if any)
        while (j < arr2.length) {
            mergedArray[k++] = arr2[j++];
        }

        if (size % 2 == 0) {
            return (double) (mergedArray[size / 2] + mergedArray[(size / 2) - 1]) / 2;
        } else {
            return mergedArray[size / 2];
        }
    }

    /**
     * Binary Search Solution
     * This solution consider an assumption that length of first array is always less than length of second array.
     * So, we have put that first if case with swap of the input arrays.
     *
     * <p>
     * Time Complexity: O(log(min(m, n)))
     * where m is size of first array and 1 is the size of second array.
     * Space Complexity: O(1)
     * </p>
     * */
    public static double calculateMedianUsingBinarySearch(int[] arr1, int[] arr2) {
        // Ensure arr1 is the smaller array
        if (arr1.length > arr2.length) {
            return calculateMedianUsingBinarySearch(arr2, arr1);
        }

        int x = arr1.length;
        int y = arr2.length;
        int low = 0, high = x;

        while (low <= high) {
            int partitionX = (low + high) / 2;
            int partitionY = (x + y + 1) / 2 - partitionX;

            int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : arr1[partitionX - 1];
            int minRightX = (partitionX == x) ? Integer.MAX_VALUE : arr1[partitionX];

            int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : arr2[partitionY - 1];
            int minRightY = (partitionY == y) ? Integer.MAX_VALUE : arr2[partitionY];

            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                if ((x + y) % 2 == 0) {
                    return ((double) Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2;
                } else {
                    return Math.max(maxLeftX, maxLeftY);
                }
            } else if (maxLeftX > minRightY) {
                high = partitionX - 1;
            } else {
                low = partitionX + 1;
            }
        }

        return 0.0;
    }

    public static void main(String[] args) {
        int[] testCase1Input1 = {10, 20, 30, 40, 50};
        int[] testCase1Input2 = {5, 15, 25, 35, 45};

        int[] testCase2Input1 = {1, 2, 3, 4, 5, 6};
        int[] testCase2Input2 = {10, 20, 30, 40, 50};

        int[] testCase3Input1 = {10, 20, 30, 40, 50, 60};
        int[] testCase3Input2 = {1, 2, 3, 4, 5};

        int[] testCase4Input1 = {10, 20, 30};
        int[] testCase4Input2 = {5, 15, 25, 35, 45};

        System.out.println(calculateMedianUsingMergingMethod(testCase1Input1, testCase1Input2));
        System.out.println(calculateMedianUsingBinarySearch(testCase1Input1, testCase1Input2));

        System.out.println(calculateMedianUsingMergingMethod(testCase2Input1, testCase2Input2));
        System.out.println(calculateMedianUsingBinarySearch(testCase2Input1, testCase2Input2));

        System.out.println(calculateMedianUsingMergingMethod(testCase3Input1, testCase3Input2));
        System.out.println(calculateMedianUsingBinarySearch(testCase3Input1, testCase3Input2));

        System.out.println(calculateMedianUsingMergingMethod(testCase4Input1, testCase4Input2));
        System.out.println(calculateMedianUsingBinarySearch(testCase4Input1, testCase4Input2));
    }

}
