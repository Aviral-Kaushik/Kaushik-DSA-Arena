package Strings.PracticeProblems;

public class PalindromeCheck {

    /// Problem Statement:
    /// In this problem, we have given a string and we need to return true if the string is palindrome.

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * */
    private static boolean isPalindrome1(String str) {
        StringBuilder stringBuilder = new StringBuilder(str);
        String reversedString = String.valueOf(stringBuilder.reverse());

        return str.equals(reversedString);
    }

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * */
    private static boolean isPalindrome2(String str) {
        int start = 0;
        int end = str.length() - 1;

        while (start <= end) {
            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }

    public static void main(String[] args) {
        String testCase1 = "ABCDCBA";
        String testCase2 = "ABBA";
        String testCase3 = "geeks";

        System.out.println(isPalindrome1(testCase1));
        System.out.println(isPalindrome2(testCase1));

        System.out.println(isPalindrome1(testCase2));
        System.out.println(isPalindrome2(testCase2));

        System.out.println(isPalindrome1(testCase3));
        System.out.println(isPalindrome2(testCase3));
    }
}
