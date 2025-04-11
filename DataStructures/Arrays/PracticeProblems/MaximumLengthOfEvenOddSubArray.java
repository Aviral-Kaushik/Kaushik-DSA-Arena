package DataStructures.Arrays.PracticeProblems;

public class MaximumLengthOfEvenOddSubArray {

    /// In this problem, we have given an array, and we need to find the length of longest sub array that contains
    /// alternating even and odd element.

    /**
     * Naive Method
     * Time Complexity: O(n ^ 2)
     * */
    private static int maximumLengthAlternatingSubArrayByNaiveMethod(int[] arr) {
        int res = 0;

        for (int i = 0; i < arr.length; i++) {
            int count = 1;

            for (int j = i + 1; j < arr.length; j++) {
                if ((isEven(arr[j]) && !isEven(arr[j - 1]))
                        || (!isEven(arr[j]) && isEven(arr[j - 1]))) {
                    count++;
                } else {
                    break;
                }
            }

            res = Math.max(res, count);
        }

        return res;
    }

    /**
     * Efficient Method
     * Time Complexity: O(n)
     * */
    private static int maximumLengthAlternatingSubArrayByEfficientMethod(int[] arr) {
        int res = 1;
        int count = 1;

        for (int i = 1; i < arr.length; i++) {
            if ((isEven(arr[i]) && !isEven(arr[i - 1]))
                    || (!isEven(arr[i]) && isEven(arr[i - 1]))) {
                count++;
                res = Math.max(res, count);
            } else {
                count = 1;
            }
        }

        return res;
    }

    private static boolean isEven(int n) {
        return (n % 2 == 0);
    }

    public static void main(String[] args) {
//        int[] arr = {10, 12, 14, 7, 8};
//        int[] arr = {7, 10, 13, 14};
//        int[] arr = {10, 12, 8, 4};
        int[] arr = {5, 10, 20, 6, 3, 8};

        System.out.println(maximumLengthAlternatingSubArrayByNaiveMethod(arr));
        System.out.println(maximumLengthAlternatingSubArrayByEfficientMethod(arr));
    }

}
