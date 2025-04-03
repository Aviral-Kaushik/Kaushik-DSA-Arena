package DataStructures.Arrays.BasicProblems;

public class MaximumDifference {

    /// Problem Statement:
    /// In this problem, we need to print maximum value of arr j - arr i such that j > i.

    /**
     * Naive Method
     * Time Complexity: O(n ^ 2)
     * */
    private static int printMaxDifferenceUsingNaiveMethod(int[] arr) {
        int n = arr.length;

        int maxDifference = arr[1] - arr[0];

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int difference = arr[j] - arr[i];

                if (difference > maxDifference) {
                    maxDifference = difference;
                }
            }
        }

        return maxDifference;
    }

    /**
     * Efficient Method
     * Time Complexity: O(n)
     * */
    private static int printMaxDifferenceUsingEfficientMethod(int[] arr) {
        int maxDifference = arr[1] - arr[0];
        int minValue = arr[0];

        for (int i = 1; i < arr.length; i++) {
            maxDifference = Math.max(maxDifference, arr[i] - minValue);
            minValue = Math.min(minValue, arr[i]);
        }

        return maxDifference;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 10, 6, 4, 8, 1};
//        int[] arr = {7, 9, 5, 6, 3, 2};
//        int[] arr = {10, 20, 30};
//        int[] arr = {30, 10, 8, 2};

        int maxDifferenceByNaive = printMaxDifferenceUsingNaiveMethod(arr);
        int maxDifferenceByEfficient = printMaxDifferenceUsingEfficientMethod(arr);

        System.out.println(maxDifferenceByNaive);
        System.out.println(maxDifferenceByEfficient);
    }
}
