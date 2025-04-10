package DataStructures.Arrays.PracticeProblems;

public class TrappingRainWaterProblem {

    /// Problem Statement:
    /// In this problem, we have given an array of non-negative number representing height of bars, and we need to
    /// compute how much water we can trap after raining.

    /**
     * Naive Method:
     * Time Complexity: O(n ^ 2)
     * */
    private static int trappedAreaByNaiveMethod(int[] arr) {
        int res = 0;

        for (int i = 1; i < arr.length - 1; i++) {
            int lMax = arr[i];

            for (int j = 0; j < i; j++) {
                lMax = Math.max(lMax, arr[j]);
            }

            int rMax = arr[i];

            for (int j = i + 1; j < arr.length; j++) {
                rMax = Math.max(rMax, arr[j]);
            }

            res = res + (Math.min(lMax, rMax) - arr[i]);
        }

        return res;
    }

    /**
     * Efficient Method:
     * Time Complexity: O(n)
     * Auxiliary Space: O(n)
     * */
    private static int trappedAreaByEfficientMethod(int[] arr) {
        int res = 0;
        int n = arr.length;

        int[] lMax = new int[n];
        int[] rMax = new int[n];

        lMax[0] = arr[0];

        for (int i = 1; i < n; i++) {
            lMax[i] = Math.max(arr[i], lMax[i - 1]);
        }

        rMax[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rMax[i] = Math.max(arr[i], rMax[i + 1]);
        }

        for (int i = 1; i < n - 1; i++) {
            res = res + (Math.min(lMax[i], rMax[i]) - arr[i]);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] bars = {3, 0, 1, 2, 5};
//        int[] bars = {1, 2, 3};
//        int[] bars = {0,1,0,2,1,0,1,3,2,1,2,1};
//        int[] bars = {4,2,0,3,2,5};

        System.out.println(trappedAreaByNaiveMethod(bars));
        System.out.println(trappedAreaByEfficientMethod(bars));
    }
}
