package Recursion;

public class SumOfDigits {

    /**
     * Time Complexity: O(d)
     * Where d is number of digits of the number n.
     * */
    static int sumOfDigits(int n) {
        int res = 0;

        while (n != 0) {
            res = res + n % 10;

            n = n / 10;
        }

        return res;
    }

    /**
     * Time Complexity: O(d)
     * Space Complexity: O(d)
     * Where d is number of digits of the number n.
     * */
    static int sumOfDigitsByRecursion(int n) {
        if (n == 0) {
            return 0;
        }

        return n % 10 + sumOfDigitsByRecursion(n / 10);
    }

    public static void main(String[] args) {
        int num = 557;

        int sum = sumOfDigits(num);
        int sumByRecursion = sumOfDigitsByRecursion(num);

        System.out.println(sum);
        System.out.println(sumByRecursion);
    }
}
