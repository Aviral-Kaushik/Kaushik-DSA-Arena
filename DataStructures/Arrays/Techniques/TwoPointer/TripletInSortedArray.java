package DataStructures.Arrays.Techniques.TwoPointer;

public class TripletInSortedArray {

    /// Problem Statement:
    /// In this array, we have given a sorted array & a target number, and we need to find if there is a triplet exits
    /// in the array with sum target.

    /// Note: If in this problem, we have given an unsorted array then we can use this solution also firstly we can
    /// sort that array in O(n log n) time, and we can apply out logic to find triplet, then the total time complexity
    ///  will be O(n log n) + O (n ^ 2) which O (n ^ 2) which is same as of now.

    /// Input: [2, 3, 4, 8, 9, 20, 40] & 32
    /// Output: True (4, 8, 20)

    /// Input: [1, 2, 5, 6] & 14
    /// Output: False

    /**
     * Naive Method (Brute Force Approach)
     * Time Complexity: O(n ^ 3)
     * */
    private static boolean doesTripletExitsUsingNaiveMethod(int[] arr, int target) {
        int n = arr.length;

        for (int i = 0; i < n - 2; i++) {
           for (int j = i + 1; j < n - 1; j++) {
               for (int k = j + 1; k < n; k++) {
                   if (arr[i] + arr[j] + arr[k] == target) {
                       return true;
                   }
               }
           }
        }

        return false;
    }

    /**
     * Two Pointer Technique
     * Time Complexity: O(n ^ 2)
     * Note: If in this problem, we have given an unsorted array then we can use this solution also firstly we can
     * sort that array in O(n log n) time, and we can apply out logic to find triplet, then the total time complexity
     * will be O(n log n) + O (n ^ 2) which O (n ^ 2) which is same as of now.
     * */
    private static boolean doesTripletExitsUsingTwoPointer(int[] arr, int target) {

        for (int i = 0; i < arr.length - 2; i++) {
            if (isPair(arr, target - arr[i], i + 1)) {
                return true;
            }
        }

        return false;
    }

    private static boolean isPair(int[] arr, int target, int startIndex) {
        int left = startIndex;
        int right = arr.length - 1;

        while (left < right) {
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
        int[] testCase1 = {2, 3, 4, 8, 9, 20, 40};
        int[] testCase2 = {1, 2, 5, 6};
        int[] testCase3 = {2, 3, 5, 6, 15};
        int[] testCase4 = {2, 5, 10, 15, 18};

        System.out.println(doesTripletExitsUsingNaiveMethod(testCase1, 32));
        System.out.println(doesTripletExitsUsingTwoPointer(testCase1, 32));

        System.out.println(doesTripletExitsUsingNaiveMethod(testCase2, 14));
        System.out.println(doesTripletExitsUsingTwoPointer(testCase2, 14));

        System.out.println(doesTripletExitsUsingNaiveMethod(testCase3, 20));
        System.out.println(doesTripletExitsUsingTwoPointer(testCase3, 20));

        System.out.println(doesTripletExitsUsingNaiveMethod(testCase4, 33));
        System.out.println(doesTripletExitsUsingTwoPointer(testCase4, 33));
    }

}
