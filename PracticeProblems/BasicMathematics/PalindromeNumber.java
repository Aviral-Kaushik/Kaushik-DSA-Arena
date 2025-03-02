package PracticeProblems.BasicMathematics;

public class PalindromeNumber {

    /**
     * Time Complexity: O(number) / O(n)
     * */
    private static boolean isPalindrome(int n) {
        int rev = 0;
        int temp = n;

        while (temp != 0) {
            int ld = temp % 10;
            rev = rev * 10 + ld;
            temp = temp / 10;
        }

        return (rev == n);
    }

    public static void main(String[] args) {
        boolean isPal = isPalindrome(123464321);
        System.out.println("isPalindrome: " + isPal);

    }
}
