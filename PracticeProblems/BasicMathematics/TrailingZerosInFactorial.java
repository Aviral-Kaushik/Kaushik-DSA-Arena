package PracticeProblems.BasicMathematics;

public class TrailingZerosInFactorial {

    /**
     * Naive Method
     * Time Complexity: O(n)
     * */
    private static int getCountOfTrailingZerosInFactorialByNaiveMethod(int n) {
        int countOfTrialingZeros = 0;
        int factorial = Factorial.factorial(n);

        while (factorial % 10 == 0) {
            countOfTrialingZeros++;
            factorial = factorial / 10;
        }

        return countOfTrialingZeros;
    }

    /**
     * Efficient Method
     * Time Complexity: O(log n)
     * */
    private static int getCountOfTrailingZerosInFactorialByEfficientMethod(int n) {
        int res = 0;
        for (int i = 5; i <= n; i = i * 5) {
            res = res + n/i;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println("Count of Trailing Zeros in Factorial: " + getCountOfTrailingZerosInFactorialByNaiveMethod(10));
        System.out.println("Count of Trailing Zeros in Factorial: " + getCountOfTrailingZerosInFactorialByEfficientMethod(100));
    }

}
