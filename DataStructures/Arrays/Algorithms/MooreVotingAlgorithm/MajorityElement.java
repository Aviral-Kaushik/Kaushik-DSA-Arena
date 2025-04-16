package DataStructures.Arrays.Algorithms.MooreVotingAlgorithm;

public class MajorityElement {

    /// In this problem, we have given an array, and we need to find majority element if it exists.

    /// Majority Element:
    /// An element is known as majority element if it exits more than n / 2 times in an array.

    /**
     * Moore's Voting Algorithm
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * */
    private static int getMajorityElement(int[] arr) {
        int count = 0;
        int candidate = 0;

        for (int j : arr) {
            if (count == 0) {
                candidate = j;
            }

            count += (j == candidate) ? 1 : -1;
        }

        return candidate;
    }

    public static void main(String[] args) {
        int[] testCase1 = {8, 3, 4, 8, 8};
        int[] testCase2 = {3, 7, 4, 7, 7, 5};
        int[] testCase3 = {20, 30, 40, 50, 50, 50, 50};
        int[] testCase4 = {3, 2, 3};
        int[] testCase5 = {2, 2, 1, 1, 1, 2, 2};

        System.out.println(getMajorityElement(testCase1));
        System.out.println(getMajorityElement(testCase2));
        System.out.println(getMajorityElement(testCase3));
        System.out.println(getMajorityElement(testCase4));
        System.out.println(getMajorityElement(testCase5));
    }
}
