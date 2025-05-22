package Strings.PracticeProblems;

public class CheckIfStringsAreRotations {

    /// Problem Statement:
    /// In this problem, we have given 2 strings & we have to check weather these strings are rotations of each other or not.
    /// That means, that string s2 can be obtained by rotating s1 any number of times or not.

    /**
     * Time Complexity: O(1)
     * Space Complexity: O)1)
     * */
    private static boolean areRotations(String str1, String str2) {
        if (str1.length() !=  str2.length()) {
            return false;
        }

        return (str1 + str1).contains(str2);
    }

    public static void main(String[] args) {
        String testCase1String1 = "ABCD";
        String testCase1String2 = "CDAB";

        String testCase2String1 = "ABAAA";
        String testCase2String2 = "BAAAA";

        String testCase3String1 = "ABAB";
        String testCase3String2 = "ABBA";

        System.out.println(areRotations(testCase1String1, testCase1String2));
        System.out.println(areRotations(testCase2String1, testCase2String2));
        System.out.println(areRotations(testCase3String1, testCase3String2));
    }
}
