package DataStructures.Arrays.Techniques.TwoPointer;

public class PairExitsWithGivenSumInSorted {

    /// Problem Statement:
    /// In this problem, we have given a sorted array & a target number, and we have to find out that if there is pair
    /// with that sum exists or not.

    /// Input: [2, 5, 8, 12, 30] & 17
    /// Output: True (Pair of 12 & 5)

    /// Input: [3, 8, 13, 18] & 14
    /// Output: False

    /**
     * Naive Method (Brute Force Approach)
     * Time Complexity: O(n ^ 2)
     * */
    private static boolean doesPairExitsUsingNaiveMethod(int[] arr, int target) {

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == target) {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * Two-Pointer Technique/Approach
     * Time Complexity: O(n)
     * */
    private static boolean doesPairExitsUsingTwoPointer(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int sum = arr[left] + arr[right];

            if (sum == target)
                return true;
            else if (sum < target)
                left++;
            else
                right--;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] testCase1 = {2, 5, 8, 12, 30};
        int[] testCase2 = {3, 8, 13, 18};
        int[] testCase3 = {2, 3, 8, 11};
        int[] testCase4 = {2, 4, 8, 9, 11, 12, 20, 30};

        System.out.println(doesPairExitsUsingNaiveMethod(testCase1, 17));
        System.out.println(doesPairExitsUsingTwoPointer(testCase1, 17));

        System.out.println(doesPairExitsUsingNaiveMethod(testCase2, 14));
        System.out.println(doesPairExitsUsingTwoPointer(testCase2, 14));

        System.out.println(doesPairExitsUsingNaiveMethod(testCase3, 14));
        System.out.println(doesPairExitsUsingTwoPointer(testCase3, 14));

        System.out.println(doesPairExitsUsingNaiveMethod(testCase4, 23));
        System.out.println(doesPairExitsUsingTwoPointer(testCase4, 23));
    }

}
