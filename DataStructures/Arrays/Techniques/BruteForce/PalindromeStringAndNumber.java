package DataStructures.Arrays.Techniques.BruteForce;

public class PalindromeStringAndNumber {

    private static boolean isPalindrome(int input) {
        String str = String.valueOf(input);
        String reversed = new StringBuilder(str)
                .reverse()
                .toString();

        return reversed.equalsIgnoreCase(str);
    }

    private static boolean isPalindrome(String input) {
        String reversed = new StringBuilder(input)
                .reverse()
                .toString();

        return reversed.equalsIgnoreCase(input);
    }

    public static void main(String[] args) {
        int intInput = 112211;
        String strInput = "ababa";

        System.out.println(isPalindrome(intInput));
        System.out.println(isPalindrome(strInput));
    }

}
