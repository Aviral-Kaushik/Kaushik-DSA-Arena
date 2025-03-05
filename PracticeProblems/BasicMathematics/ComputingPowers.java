package PracticeProblems.BasicMathematics;

public class ComputingPowers {

    /// It this problem we will be given 2 variables as input x amd n, and we need to return x ^ n.

    /** Naive Method
     * Time Complexity: O(n)
     * */
    private int powerByNaiveMethod(int x, int n) {
        int res = 1;

        for (int i = 0; i < n; i++) {
            res = res * x;
        }

        return res;
    }

    /** Less Efficient Method (Recursive Method)
     * - This method is less efficient as it takes space complexity of O(log n) as it is recursive method,
     *      and it takes some space.
     * Idea:
     *      power (x, n) =
     *          - if (n % 2 == 0)
     *              power (x, n / 2) * power (x, n / 2)
     *          - else
     *              power(x, n -1)
     * Time Complexity: O(log n)
     * Auxiliary Space: O(log n)
     * */
    private int powerByRecursiveMethod(int x, int n) {
        if (n == 0) {
            return 1;
        }
        int temp = powerByRecursiveMethod(x, n / 2);
        temp = temp * temp;

        if (n % 2 == 0) {
            return temp;
        } else {
            return temp * x;
        }
    }

    /**  More Efficient Method (Iterative Method)
     * - This Method is More Efficient as it takes space complexity is 0(1) as it is iterative method,
     *      and it takes constant space.
     * Time Complexity: O(log n)
     * Auxiliary Space: O(1)
     * */
    private int powerByIterativeMethod(int x, int n) {
        int res = 1;

        while (n > 0) {
            if (n % 2 == 0) {
                res = res * x;
            }

            x = x * x;
            n = n / 2;
        }

        return res;
    }
}
