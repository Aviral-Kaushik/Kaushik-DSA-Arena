package PracticeProblems.BasicMathematics;

import java.util.Arrays;

public class SieveOfEratosthenes {

    /// In this problem we need to print to all prime numbers till a number m.

    /// Sieve Of Eratosthenes Algorithm -
    /// The Sieve of Eratosthenes is an efficient algorithm to find all prime numbers up to a given number
    /// n in O(n log log n) time.
    ///
    /// Steps:
    /// 1. Create a boolean array isPrime[] of size n + 1 and mark all numbers as true (assuming all are prime initially).
    /// 2. Set isPrime[0] and isPrime[1] to false since 0 and 1 are not prime.
    /// 3. Start from the first prime 2 and mark all its multiples as false.
    /// 4. Repeat this for the next unmarked number (which is prime) and mark its multiples.
    /// 5. Continue until you reach √n, since larger factors would have been marked already.
    /// 6. The numbers that remain true in isPrime[] are the prime numbers up to n.

    /**
     * Time Complexity: O(n log log n)
     * Auxiliary Space: O(n)
     * */
    private void printAllPrimeNumberBySieveOfEratosthenes(int n) {
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true); // Assume all numbers are prime initially

        isPrime[0] = isPrime[1] = false; // 0 and 1 are not prime

        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) { // If i is a prime
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false; // Mark all multiples of i as non-prime
                }
            }
        }

        System.out.println("Prime numbers up to " + n + ":");
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                System.out.print(i + " ");
            }
        }
    }

}
