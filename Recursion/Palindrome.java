package Recursion;

public class Palindrome {

    /**
     * Time Complexity: O(n)
     * Where n is length of string.
     * */
    static boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;

        while (left <= right) {

            if(str.charAt(left) != str.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * Where n is length of string.
     * */
    static boolean isPalindromeByRecursion(String str, int start, int end) {
        if (start >= end) {
            return true;
        }

        return (str.charAt(start) == str.charAt(end))
                && isPalindromeByRecursion(str, start + 1, end - 1);
    }

    public static void main(String[] args) {
        String str = "abbcba";

        boolean res = isPalindrome(str);
        boolean resByRecursion = isPalindromeByRecursion(str, 0, str.length() - 1);

        System.out.println(res);
        System.out.println(resByRecursion);
    }

}
