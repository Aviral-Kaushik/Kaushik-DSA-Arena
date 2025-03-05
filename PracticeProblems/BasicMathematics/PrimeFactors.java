package PracticeProblems.BasicMathematics;

public class PrimeFactors {

    /**
     * Naive Method
     * Time Complexity: O(n * √n * log n) => O(n√nlog n)
     * */
    private static void primeFactorsByNaiveMethod(int n) {
        for (int i = 2; i <= n; i++) { /// O(n)
            if (PrimeNumber.isPrime(n)) { /// O(√n)
                int x = i;
                while (n % x == 0) { /// O(log n)
                    System.out.println(i);
                    x = x * i;
                }
            }
        }
    }

    /**
     * First Efficient Method (Same as Prime Number 2nd Method)
     * Idea -
     *      1. All Divisors appear in pairs as (x * y = n).
     *          30: (1, 30), (2, 15), (3, 10) and (5, 6)
     *          65: (1, 65) and (13, 5).
     *          If (x, y) is a pair
     *               x * y = n
     *          And if x <= y
     *               x * x <= n
     *               x <= √n.
     *       2.  A number n can be written as multiplications of power of prime factors
     *            12 = (2 ^ 2) * 3
     *            450 = (2 ^ 1) * (3 ^ 2) * (5 ^ 2)
     *            13 = 13 ^ 1
     * Time Complexity: O(√nlog n)
     * */
    private static void primeFactorsByFirstEfficientMethod(int n) {
        if (n <= 1) {
            return;
        }

        for (int i = 2; i * i < n; i++) { ///  O(√n)
            while (n % i == 0) { /// O(log n)
                System.out.println(i);
                n = n / i;
            }
        }

        if (n > 1) { // Corner Case
            System.out.println(n);
        }
    }

    /**
     * Second Efficient Method (Same as Prime Number 3rd Method)
     * Idea -
     * 1. Check only till √n.
     * 2. By checking n % 2 == 0 and n % 3 == 0 we can save many iteration for large value of n.
     * Time Complexity: O(√n) Worst Case
     * */
    private static void primeFactorsBySecondEfficientMethod(int n) {
        if (n <= 1) {
            return;
        }

        while (n % 2 == 0) {
            System.out.println(n);
            n = n / 2;
        }

        while (n % 3 == 0) {
            System.out.println(n);
            n = n / 3;
        }

        for (int i = 5; i * i <= n; i += 5) { /// O(√n)
            while (n % i == 0) {
                System.out.println(i);
                n = n / i;
            }

            while (n % (i + 2) == 0) {
                System.out.println(i + 2);
                n = n / (i + 2);
            }
        }

        if (n > 3) { // Corner Case
            System.out.println(n);
        }
    }
}
