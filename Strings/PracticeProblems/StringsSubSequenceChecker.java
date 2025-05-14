package Strings.PracticeProblems;

public class StringsSubSequenceChecker {

    /// Problem Statement:
    /// In this problem, we have given 2 strings & we need to return true if teh string is subsequence of other given that
    /// length of str1 is always bigger than str2.
    /// If it is not given that length of string 1 is greater than string 2 then we can check it at the top of the function and
    /// if it is not true then we can swap the values of string 1 and string 2.

    /**
     * Time Complexity: O(m + n)
     * Space Complexity: O(1)
     * */
    private static boolean checkStringSubSequence(String str1, String str2) {
        int i = 0, j = 0;

        while (i < str1.length() && j < str2.length()) {
            if (str1.charAt(i) == str2.charAt(j)) {
                i++;
                j++;
            } else {
                i++;
            }
        }

        return j == str2.length();
    }

    public static void main(String[] args) {
        String testCase1String1 = "ABCD";
        String testCase1String2 = "AD";

        String testCase2String1 = "ABCDE";
        String testCase2String2 = "AED";

        String testCase3String1 = "ABCDEF";
        String testCase3String2 = "ADE";

        System.out.println(checkStringSubSequence(testCase1String1, testCase1String2));
        System.out.println(checkStringSubSequence(testCase2String1, testCase2String2));
        System.out.println(checkStringSubSequence(testCase3String1, testCase3String2));
    }
}
