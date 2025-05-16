package Strings.PracticeProblems;

public class LeftmostRepeatingCharacter {

    /// Problem Statement:
    /// In this problem, we have given a string with possible repeating character and we need return the index of left most
    /// repeating character.

    /// Test Cases"
    /// Input: "abbcc"
    /// Output: 1 (Input of the first occurrence of b)

    /// Input: "geeksforgeeks"
    /// Output: 0 (Index of first occurrence of g)

    /// Input: "abcd"
    /// output: -1 (No Repeating Characters)

    /**
     * Naive Method
     * Time Complexity: O(n ^ 2)
     * Space Complexity: O(1)
     * */
    private static int getIndexOfLeftmostRepeatingCharacterByNaiveMethod(String str) {
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j < str.length(); j++) {
                if (str.charAt(i) == str.charAt(j)) {
                    return i;
                }
            }
        }

        return -1;
    }

    /**
     * Efficient Method
     * Time Complexity: O(n)
     * Space Complexity: O(CHAR)
     * */
    private static int getIndexOfLeftmostRepeatingCharacterByEfficientMethod(String str) {
        final int CHAR = 256;
        int[] count = new int[CHAR];

        for (int i = 0; i < str.length(); i++) {
            count[str.charAt(i)]++;
        }

        for (int i = 0; i < str.length(); i++) {
            if (count[str.charAt(i)] > 1) {
                return i;
            }
        }

        return -1;
    }

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(CHAR_
     * */
    private static int getIndexOfLeftmostRepeatingCharacterByEfficientMethod2(String str) {
        final int CHAR = 256;
        boolean[] visited = new boolean[CHAR];
        int res = -1;

        for (int i = str.length() - 1; i >= 0; i--) {
            if (visited[str.charAt(i)]) {
                res = i;
            } else {
                visited[str.charAt(i)] = true;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        String testCase1 = "abbcc";
        String testCase2 = "geeksforgeeks";
        String testCase3 = "abcd";
        String testCase4 = "cabbad";

        System.out.println(getIndexOfLeftmostRepeatingCharacterByNaiveMethod(testCase1));
        System.out.println(getIndexOfLeftmostRepeatingCharacterByEfficientMethod(testCase1));
        System.out.println(getIndexOfLeftmostRepeatingCharacterByEfficientMethod2(testCase1));

        System.out.println(getIndexOfLeftmostRepeatingCharacterByNaiveMethod(testCase2));
        System.out.println(getIndexOfLeftmostRepeatingCharacterByEfficientMethod(testCase2));
        System.out.println(getIndexOfLeftmostRepeatingCharacterByEfficientMethod2(testCase2));

        System.out.println(getIndexOfLeftmostRepeatingCharacterByNaiveMethod(testCase3));
        System.out.println(getIndexOfLeftmostRepeatingCharacterByEfficientMethod(testCase3));
        System.out.println(getIndexOfLeftmostRepeatingCharacterByEfficientMethod2(testCase3));

        System.out.println(getIndexOfLeftmostRepeatingCharacterByNaiveMethod(testCase4));
        System.out.println(getIndexOfLeftmostRepeatingCharacterByEfficientMethod(testCase4));
        System.out.println(getIndexOfLeftmostRepeatingCharacterByEfficientMethod2(testCase4));
    }

}
