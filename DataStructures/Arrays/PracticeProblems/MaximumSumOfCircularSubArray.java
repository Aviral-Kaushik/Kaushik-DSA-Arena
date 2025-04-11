package DataStructures.Arrays.PracticeProblems;

public class MaximumSumOfCircularSubArray {

    /// In this problem, we have given an array, and we need to find the max sum of a sub-array including normal sub-array
    /// and circular sub-array.

    /// Circular sub-arrays means an array formed by connecting the last element to first element of the array.

    /// For Example: For an array : {10, 5, -5}
    /// Normal Sub Arrays are: {10}, {5}, {-5}, {10, 5}, {5, -5}, {10, 5, -5}
    /// Circular Sub Arrays are: {5, -5, 10}, {-5, 10}, {-5, 10, 5}


    /**
     * Naive Method
     * Time Complexity: O(n ^ 2)
     * */
    private static int maxSumOfCircularSubArrayByNaiveMethod(int[] arr) {
        int res = arr[0];
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            int currentMax = arr[i];
            int currentSum = arr[i];

            for (int j = 1; j < n; j++) {
                int index = (i + j) % n;
                currentSum += arr[index];
                currentMax = Math.max(currentMax, currentSum);
            }

            res = Math.max(res, currentMax);
        }

        return res;
    }


    /**
     * Efficient Method
     * Time Complexity: O(n)
     * */
    private static int maxSumOfCircularSubArrayByEfficientMethod(int[] arr) {
        int maxSumOfNormalSubArrays = maxSumOfNormalSubArray(arr);
        if (maxSumOfNormalSubArrays < 0) {
            return maxSumOfNormalSubArrays;
        }

        int arrSum = 0;

        for (int i = 0; i < arr.length; i++) {
            arrSum += arr[i];
            arr[i] = -arr[i]; // Inverting Every Element of the array (for 8 we are changing for -8 and for -3 we are changing ro 3)
        }

        int maxSumOfCircularSubArrays = arrSum + maxSumOfNormalSubArray(arr);

        return Math.max(maxSumOfNormalSubArrays, maxSumOfCircularSubArrays);
    }

    private static int maxSumOfNormalSubArray(int[] arr) {
        int res = arr[0];
        int maxEnding = arr[0];

        for (int i = 1; i < arr.length; i++) {
            maxEnding = Math.max(arr[i], maxEnding + arr[i]);
            res = Math.max(res, maxEnding);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1, -2, 3, -2};
//        int[] arr = {5, -3, 5};
//        int[] arr = {5, -2, 3, 4};
//        int[] arr = {2, 3, -4};
//        int[] arr = {8, -4, 3, -5, 4};
//        int[] arr = {-3, 4, 6, -2};
//        int[] arr = {-8, 7, 6};
//        int[] arr = {3, -4, 5, 6, -8, 7};

        System.out.println(maxSumOfCircularSubArrayByNaiveMethod(arr));
        System.out.println(maxSumOfCircularSubArrayByEfficientMethod(arr));
    }

}
