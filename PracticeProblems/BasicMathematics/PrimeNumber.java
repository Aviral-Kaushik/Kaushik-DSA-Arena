package PracticeProblems.BasicMathematics;

public class PrimeNumber {

    /**
     * Naive Method
     * Time Complexity: O(n)
     * */
    private static boolean checkForPrime(int n) {
        if (n == 1) {
            return false;
        }

        for (int i = 2; i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }

    /**
     * Less Efficient Method
     * Idea:
     * All Divisors appears in pairs as (x * y = n).
     * 30: (1, 30), (2, 15), (3, 10) and (5, 6)
     * 65: (1, 65) and (13, 5).
     * If (x, y) is a pair
     *      x * y = n
     * And if x <= y
     *      x * x <= n
     *      x <= √n
     * Time Complexity: O(√n) (Square Root of n)
     * <p>
     * Note: For large value of n => √n can also be large and can be time-consuming.
     * */

    private static boolean checkForPrimeByLessEfficientMethod(int n) {
        if (n == 1) {
            return false;
        }

        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }

    /**
     * More Efficient Method
     * Idea:
     * 1. Check only till √n.
     * 2. By checking n % 2 == 0 and n % 3 == 0 we can save many iteration for large value of n.
     * <p>
     * Time Complexity: O(√n) (But 3 times faster than last approach)
     * */
    private static boolean checkForPrimeMoreEfficiently(int n) {
        if (n == 1) {
            return false;
        }

        if (n == 2 || n == 3) {
            return true;
        }

        if (n % 2 == 0 || n % 3 == 0) {
            return false;
        }

        for (int i = 5; i * i <= n; i = i + 6) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
        }

        return true;
    }

    public static boolean isPrime(int n) {
        return checkForPrimeMoreEfficiently(n);
    }
}
