package PracticeProblems.BasicMathematics;

public class GCDorHCF {

    /// GCD = Greatest Common Divisor
    /// HCF = Highest Common Factor
    /// In this problem, we will be provided 2 numbers, we need to find the largest number that divides both of the numbers.

    /**
     * Naive Method
     * Time Complexity: O(min(a, b))
     * */
    private static int GCDByNaiveMethod(int a, int b) {
        int res = Math.min(a, b);

        while (res > 0) {
            if (a % res == 0 && b % res == 0) {
                break;
            }
            res--;
        }

        return res;
    }

    /**
     * Euclidean Algorithm (Efficient Method)
     * Let 'b' be smaller than a:
     *      gcd(a, b) = gcb (a - b, b)
     * Why?
     *    Let 'g' be GCD of 'a' and 'b'
     *    a = gx, b = gy and GCD(x, y) = 1
     *    (a - b) = g(x - y)
     * <p>
     * Time Complexity: O(log(min(a, b)))
     * */
    public static int GCDByEuclideanAlgo(int a, int b) {
        if (b == 0) {
            return a;
        }

        return GCDByEuclideanAlgo(b, a % b);
    }

    public static void main(String[] args) {
        System.out.println("GCD or HCF By Naive Method: " + GCDByNaiveMethod(100, 200));
        System.out.println("GCD or HCF By Naive Method: " + GCDByEuclideanAlgo(100, 200));
    }

}
