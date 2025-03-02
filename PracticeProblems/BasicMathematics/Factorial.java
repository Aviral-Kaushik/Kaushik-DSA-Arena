package PracticeProblems.BasicMathematics;

public class Factorial {

    /**
     * Recursive Approach
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * Auxiliary Space: O(n)
     * */
    public static int factorial(int n) {
        if (n == 0) {
            return 1;
        }

        return n * factorial(n - 1);
    }

    /**
     * Iterative Approach
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * Auxiliary Space: O(1)
     * */
    private static int factorialByLoop(int n) {
        int factorial = 1;

        for (int i = 2; i <= n; i++) {
            factorial *= i;
        }

        return factorial;
    }

    public static void main(String[] args) {
        System.out.println("Factorial: " + factorial(5));
        System.out.println("Factorial: " + factorialByLoop(5));
    }

}
