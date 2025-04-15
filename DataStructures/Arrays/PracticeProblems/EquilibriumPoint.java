package DataStructures.Arrays.PracticeProblems;

public class EquilibriumPoint {

    /// Problem:
    /// In this problem, we have given an integer array, and if an equilibrium point exits we need to return true else false.

    /// Equilibrium Point: A equilibrium point is a point in an array, in which the sum of all the element in the left is
    /// equal to the sum of all the element to the right.

    /// Examples:
    /// arr = [3, 4, 8, -9, 20, 6] => True : 20 is equilibrium point as left & right element's sum is 6.
    /// arr = [4, 2, -2] => True : For starting point we consider left element as 0 so 4 is the equilibrium point.
    /// arr = [4, 2, 2] => False


    /**
     * Naive Method
     * Time Complexity: O(n ^ 2)
     * */
    private static boolean doesEquilibriumPointExitsUsingNaiveMethod(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int leftSum = 0, rightSum = 0;

            for (int j = 0; j < i; j++) {
                leftSum += arr[j];
            }

            for (int j = i + 1; j < arr.length; j++) {
                rightSum += arr[j];
            }

            if (leftSum == rightSum) {
                return true;
            }

        }

        return false;
    }

    /**
     * Time Complexity: O(n) but uses 3 loops each of time complexity O(n):
     * 1. First Loop for Prefix Sum Calculation.
     * 2. Second Loop for Suffix Sum Calculation.
     * 3. Third Loop for checking equilibrium point.
     * */
    private static boolean doesEquilibriumPointExitsUsingPrefixMethod(int[] arr) {
        int[] prefixSum = getPrefixSum(arr);
        int[] suffixSum = getSuffixSum(arr);

        if (suffixSum[1] == 0) {
            return true;
        }

        if (prefixSum[arr.length - 2] == 0) {
            return true;
        }

        for (int i = 1; i < arr.length - 1; i++) {
            if (prefixSum[i - 1] == suffixSum[i + 1]) {
                return true;
            }
        }

        return false;
    }

    private static int[] getPrefixSum(int[] arr) {
        int[] prefixSum = new int[arr.length];

        prefixSum[0] = arr[0];

        for (int i = 1; i < arr.length; i++) {
            prefixSum[i] = arr[i] + prefixSum[i - 1];
        }

        return prefixSum;
    }

    private static int[] getSuffixSum(int[] arr) {
        int[] suffixSum = new int[arr.length];

        suffixSum[arr.length - 1] = arr[arr.length - 1];

        for (int i = arr.length - 2; i >= 0; i--) {
            suffixSum[i] = arr[i] + suffixSum[i + 1];
        }

        return suffixSum;
    }

    /**
     * Efficient Solution (Without Prefix Sum)
     * Time Complexity: O(n)
     * Explanation ChatGPT Chat Link:
     * <a href="https://chatgpt.com/share/67fe4ff5-92d8-8002-844d-d1be0c612394">...</a>
     * */
    public static boolean doesEquilibriumPointExitsWithoutPrefixMethod(int[] arr) {
        int totalSum = 0;
        for (int num : arr) {
            totalSum += num;
        }

        int leftSum = 0;

        for (int i = 0; i < arr.length; i++) {
            int rightSum = totalSum - leftSum - arr[i];

            if (leftSum == rightSum) {
                return true; // 1-based index
            }

            leftSum += arr[i];
        }

        return false; // No equilibrium point found
    }

    public static void main(String[] args) {
        int[] testCase1 = {3, 4, 8, -9, 20, 6};
        int[] testCase2 = {4, -2, 2};
        int[] testCase3 = {4, 2, 2};
        int[] testCase4 = {3, 4, 8, -9, 9, 7};

        System.out.println(doesEquilibriumPointExitsUsingNaiveMethod(testCase1));
        System.out.println(doesEquilibriumPointExitsUsingPrefixMethod(testCase1));
        System.out.println(doesEquilibriumPointExitsWithoutPrefixMethod(testCase1));

        System.out.println();

        System.out.println(doesEquilibriumPointExitsUsingNaiveMethod(testCase2));
        System.out.println(doesEquilibriumPointExitsUsingPrefixMethod(testCase2));
        System.out.println(doesEquilibriumPointExitsWithoutPrefixMethod(testCase2));

        System.out.println();

        System.out.println(doesEquilibriumPointExitsUsingNaiveMethod(testCase3));
        System.out.println(doesEquilibriumPointExitsUsingPrefixMethod(testCase3));
        System.out.println(doesEquilibriumPointExitsWithoutPrefixMethod(testCase3));

        System.out.println();

        System.out.println(doesEquilibriumPointExitsUsingNaiveMethod(testCase4));
        System.out.println(doesEquilibriumPointExitsUsingPrefixMethod(testCase4));
        System.out.println(doesEquilibriumPointExitsWithoutPrefixMethod(testCase4));

    }
}
