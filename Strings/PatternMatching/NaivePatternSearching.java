package Strings.PatternMatching;

public class NaivePatternSearching {

    /// Naive Pattern Searching Algorithm

    /// Test Cases:
    /// Input: String: "ABABABCD", Pattern: "ABAB"
    /// Output: 0 2
    /// Input: String: "ABCABCD", Pattern: "ABCD"
    /// Output: 3
    /// Input: String: "AAAAA", Pattern: "AAA"
    /// Output: 0 1 2

    /**
     * Naive Pattern Searching Algorithm
     * Time Complexity: O(n * m)
     * Space Complexity: O(1)
     * */
    private static void naivePatternSearching(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();

        for (int i = 0; i <= n - m; i++) {
            int j;
            for (j = 0; j < m; j++) {
                if (text.charAt(i + j) != pattern.charAt(j)) {
                    break;
                }
            }

            if (j == m) {
                System.out.println("Pattern Found at index: " + i);
            }
        }
    }


    public static void main(String[] args) {
        String testCase1Text = "ABABABCD";
        String testCase1Pattern = "ABAB";

        String testCase2Text = "ABCABCD";
        String testCase2Pattern = "ABCD";

        String testCase3Text = "AAAAA";
        String testCase3Pattern = "AAA";

        String testCase4Text = "AABAACAADAABAABA";
        String testCase4Pattern = "AABA";

        naivePatternSearching(testCase1Text, testCase1Pattern);
        naivePatternSearching(testCase2Text, testCase2Pattern);
        naivePatternSearching(testCase3Text, testCase3Pattern);
        naivePatternSearching(testCase4Text, testCase4Pattern);
    }

}
