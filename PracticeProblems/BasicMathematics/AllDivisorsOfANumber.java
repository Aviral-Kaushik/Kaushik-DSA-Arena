package PracticeProblems.BasicMathematics;

public class AllDivisorsOfANumber {

    /**
     * Naive Method
     * Time Complexity: O(n)
     * */
    private void printAllDivisorOfANumberByNaiveMethod(int n) {
        for(int i = 1; i <= n; i++) {
            if (n % i == 0) {
                System.out.println(i);
            }
        }
    }

    /**
     * Efficient Method
     * Idea -
     *      Same as Prime Number 2 Method
     * Time Complexity: O(√n)
     * The method print all the divisors of the number but not in sorted order
     * */
    private void printAllDivisorOfANumberByEfficientMethod(int n) {
        for(int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                System.out.println(i);
                if (i != n / i) {
                    System.out.println(n / i);
                }
            }
        }
    }

}
