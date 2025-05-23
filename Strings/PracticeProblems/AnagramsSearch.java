package Strings.PracticeProblems;

public class AnagramsSearch {

    /// Problem Statement:
    /// In this problem, we have given 2 strings & we have to check weather second string or its any permutations is
    /// present continuously in the first strings or not.

    /**
     * My Own Programmed Solution
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * */
    private static boolean checkAnagrams(String str1, String str2) {
        int startIndex = str1.indexOf(str2.charAt(0));

        if (startIndex < 0) {
            return false;
        }

        str1 = str1.substring(startIndex, startIndex + str2.length());

        for (int i = 0; i < str2.length(); i++) {
            String character = String.valueOf(str2.charAt(i));

            if (!str1.contains(character)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String testCase1String1 = "geeksforgeeks";
        String testCase1String2 = "frog"; // True

        String testCase2String1 = "geeksforgeeks";
        String testCase2String2 = "rseek"; // False

        System.out.println(checkAnagrams(testCase1String1, testCase1String2));
        System.out.println(checkAnagrams(testCase2String1, testCase2String2));
    }
}
