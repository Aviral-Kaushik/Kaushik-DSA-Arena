package PracticeProblems.BasicMathematics;

public class LCM {

    /// LCM: Lowest Common Multiple
    /// It this problem we will be given 2 number, and we need to find the lowest number which is divisible by both of the numbers.

    /**
     * Naive Method
     * Time Complexity: O(man(a, b)
     * */
    private static int calculateLCMByNaiveMethod(int a, int b) {
        int res = Math.max(a, b);

        while (true) {
            if (res % a == 0 && res % b == 0) {
                break;
            }
            res++;
        }

        return res;
    }

    /**
     * Efficient Method
     * Relation Between GCD/HCF and LCM is:
     *      a * b = gcb(a, b) * lcm(a, b)
     * Time Complexity: O(log(min(a, b)) (Time Complexity of Euclidean Algo used for calculating GCD of 2 number).
     * */
    private static int calculateLCMByEfficientMethod(int a, int b) {
        return (a * b) / GCDorHCF.GCDByEuclideanAlgo(a, b);
    }

    public static void main(String[] args) {
        System.out.println("LCM: " + calculateLCMByNaiveMethod(12, 15));
        System.out.println("LCM: " + calculateLCMByEfficientMethod(12, 15));
    }

}
