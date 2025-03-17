package Recursion;

public class SumOfNaturalNumbers {

    /**
     * Time Complexity: O(1)
     * */
    static int sumOfNaturalNumberByFormula(int n) {
        return (n * (n + 1)) / 2;
    }

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * */
    static int sumOfNaturalNumberByRecursion(int n) {
        if (n == 0) {
            return n;
        }
        return n + sumOfNaturalNumberByRecursion(n - 1);
    }

    public static void main(String[] args) {
        int sumByFormula = sumOfNaturalNumberByFormula(100);
        int sumByRecursion = sumOfNaturalNumberByRecursion(100);

        System.out.println(sumByFormula);
        System.out.println(sumByRecursion);
    }

}
