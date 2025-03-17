package Recursion;

public class Print1ToN {

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * */
    static void print1ToN(int n) {
        if (n == 0) {
            return;
        }

        print1ToN(n - 1);

        System.out.println(n);
    }

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * */
    static void printNto1(int n) {
        if (n == 0) {
            return;
        }

        System.out.println(n);

        printNto1(n - 1);
    }

    public static void main(String[] args) {
        print1ToN(5);
        printNto1(5);
    }
}
