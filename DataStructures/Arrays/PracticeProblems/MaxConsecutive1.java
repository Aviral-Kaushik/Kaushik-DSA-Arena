package DataStructures.Arrays.PracticeProblems;

public class MaxConsecutive1 {

    /// In this problem we have given a binary array, and we have to return the max number consecutive 1's appears in
    /// the array.

    /**
     * Efficient Method
     * Time Complexity: O(n)
     * */
    private static int maxConsecutive1(int[] arr) {
        int max1Count = 0;
        int tempCount = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                tempCount++;
            } else {
                // Can Use Math.max too for better code
                if (max1Count < tempCount) {
                    max1Count = tempCount;
                }
                tempCount = 0;
            }
        }

        // Can Use Math.max too for better code
        if (max1Count < tempCount) {
            max1Count = tempCount;
        }

        return max1Count;
    }


    public static void main(String[] args) {
//        int[] binaryArray = {0, 1, 1, 0, 1, 0};
        int[] binaryArray = {1, 1, 1, 1};
//        int[] binaryArray = {0, 0, 0};
//        int[] binaryArray = {1, 0, 1, 1, 1, 1, 0, 1, 1};

        System.out.println(maxConsecutive1(binaryArray));
    }
}
