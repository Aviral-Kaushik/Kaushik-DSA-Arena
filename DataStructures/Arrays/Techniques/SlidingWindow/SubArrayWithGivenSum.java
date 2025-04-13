package DataStructures.Arrays.Techniques.SlidingWindow;

public class SubArrayWithGivenSum {

    /// In this problem, we have given an array of non-negative integer and a sum, our task is to find that is there a
    /// sub-array with given sum or not.

    /**
     * Naive Method
     * Time Complexity: O(n ^ 2)
     * */
    private static boolean doesSubArrayWithGivenSumExistsUsingNaiveMethod(int[] arr, int sum) {

        for (int i = 0; i < arr.length; i++) {
            int currentSum = arr[i];

            for (int j = i + 1; j < arr.length; j++) {
                currentSum += arr[j];

                if (currentSum == sum) {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * Sliding Window Technique
     * Time Complexity: O(n)
     * */
    private static boolean doesSumArrayWithGivenSumExistsUsingSlidingWindow(int[] arr, int sum) {
        int left = 0;
        int currentSum = 0;

        for (int right = 0; right < arr.length; right++) {
            currentSum += arr[right];

            while (currentSum > sum) {
                currentSum -= arr[left];

                left++;
            }

            if (currentSum == sum) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
//        int[] arr = {1, 4, 20, 3, 10, 5};
//        int[] arr = {1, 4, 0, 0, 3, 10, 5};
//        int[] arr = {2, 4};
        int[] arr = {4, 8, 12, 5};

        System.out.println(doesSubArrayWithGivenSumExistsUsingNaiveMethod(arr, 17));
        System.out.println(doesSumArrayWithGivenSumExistsUsingSlidingWindow(arr, 17));
    }

}
