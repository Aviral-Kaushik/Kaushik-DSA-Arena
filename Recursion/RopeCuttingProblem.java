package Recursion;

public class RopeCuttingProblem {

    /// In this problem, we have been given 4 inputs n, a, b, c where
    ///     n is length of the rope
    ///     a, b, c are the number in which the rope can be cut.
    /// And we need to return the number for which maximum number of pieces that can be made from the rope
    /// if possible else return -1.


    /**
     * Time Complexity: O(3 ^ n)
     * */
    static int maxPieces(int n, int a, int b, int c) {
        if (n == 0) {
            return 0;
        }

        if (n < 0) {
            return -1;
        }

        int res = Math.max(maxPieces(n - a, a, b, c), Math.max(maxPieces(n - b, a, b, c), maxPieces(n - c, a, b, c)));

        if (res < 0) {
            return -1;
        }

        return res + 1;
    }

    public static void main(String[] args) {
        int maxPieces = maxPieces(5, 5, 2, 1);

        System.out.println(maxPieces);
    }


}
