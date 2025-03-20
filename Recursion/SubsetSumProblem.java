package Recursion;

public class SubsetSumProblem {

    /// In this problem, we have given 2 inputs a set and a sum, and we need to return a total number of subsets whose
    /// sum is equal to the given input sum.

    /// Input: set = [10, 5, 2, 3, 6], sum = 8
    /// Output: 2

    /// Input: set = [1, 2, 3], sum = 4
    /// Output: 1

    /**
     * Time Complexity: O(2^n)
     * Space Complexity: O(n)
     * */
    static int countSubset(int[] arr, int n, int sum) {
        if (n == 0) {
            return sum == 0 ? 1 : 0;
        }

        return countSubset(arr, n - 1, sum) + countSubset(arr, n - 1, sum - arr[n - 1]);
    }

    static int countSubSetIteratively(int[] arr, int n, int sum) {
        int count = 0;
        int sumOfAllElements = 0;

        if (sum == 0) {
            count++;
        }

        for (int i = 0; i < n; i++) {
            if (arr[i] == sum) {
                count++;
            }

            for (int j = i; j < n; j++) {
                if (arr[i] + arr[j] == sum) {
                    count++;
                }
            }

            sumOfAllElements++;
        }

        if (sumOfAllElements == sum) {
            count++;
        }

        return count;
    }


    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        int subSetCount = countSubset(arr, 3, 4);
        int subSetCountIteratively = countSubSetIteratively(arr, 3, 4);

        System.out.println(subSetCount);
        System.out.println(subSetCountIteratively);
    }

}
