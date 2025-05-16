package Strings.PracticeProblems;

public class LeftmostNonRepeatingCharacter {

    ///  Problem Statement:
    /// In this problem, we have given a string and we need to return the index of left most non-repeating character.
    /// For explanation of problem & test cases, please visit LeftmostRepeatingCharacter.java file inside
    /// Strings.PracticeProblems

    /**
     * Efficient Method
     * Time Complexity: O(n)
     * Space Complexity: O(CHAR)
     * */
    private static int getIndexOfLeftmostNonRepeatingCharacter(String str) {
        final int CHAR = 256;
        int[] count = new int[CHAR];

        for (int i = 0; i < str.length(); i++) {
            count[str.charAt(i)]++;
        }

        for (int i = 0; i < str.length(); i++) {
            if (count[str.charAt(i)] == 1) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        String testCase1 = "geeksforgeeks"; // Output: 5
        String testCase2 = "abcabc"; // Output: -1
        String testCase3 = "apple"; // Output: 0
        String testCase4 = "abbcda"; // Output: 3

        System.out.println(getIndexOfLeftmostNonRepeatingCharacter(testCase1));
        System.out.println(getIndexOfLeftmostNonRepeatingCharacter(testCase2));
        System.out.println(getIndexOfLeftmostNonRepeatingCharacter(testCase3));
        System.out.println(getIndexOfLeftmostNonRepeatingCharacter(testCase4));
    }

}
