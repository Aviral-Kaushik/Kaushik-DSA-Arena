package Strings.PracticeProblems;

public class Anagrams {

    /// Problem Statement:
    /// In this problem, we have given 2 strings and we need to check weather these strings are anagrams or not.
    /// Anagram: It means that the every character that is present in first string then it must be present in the second string
    /// and frequency of every character must be same in both of the strings. However, the order of the characters may differ.

    /**
     * Time Complexity: O(n + CHAR)
     * Space Complexity: O(CHAR)
     * */
    private static boolean areAnagrams(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }

        int CHAR = 256;
        int[] count = new int[CHAR];

        for (int i = 0; i < str1.length(); i++) {
            count[str1.charAt(i)]++;
            count[str2.charAt(i)]--;
        }

        for (int i = 0; i < CHAR; i++) {
            if (count[i] != 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String testCase1String1 = "listen";
        String testCase1String2 = "silent";

        String testCase2String1 = "aaacb";
        String testCase2String2 = "cabaa";

        String testCase3String1 = "aab";
        String testCase3String2 = "bab";

        System.out.println(areAnagrams(testCase1String1, testCase1String2));
        System.out.println(areAnagrams(testCase2String1, testCase2String2));
        System.out.println(areAnagrams(testCase3String1, testCase3String2));
    }

}
