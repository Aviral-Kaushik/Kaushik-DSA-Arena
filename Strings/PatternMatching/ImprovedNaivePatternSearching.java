package Strings.PatternMatching;

public class ImprovedNaivePatternSearching {


    /// This algorithm only works if pattern only contains distinct elements.


    /**
     * Improve Naive Pattern Searching Algorithm for Pattern with Distinct Characters.
     * TIme Complexity: O(n / m)
     * Space Complexity: O(1)
     * */
    private static void improvedNaivePatternSearching(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();
        int i = 0;

        while (i <= n - m) {
            int j;

            for (j = 0; j < m; j++) {
                if (text.charAt(i + j) != pattern.charAt(j)) {
                    break;
                }
            }


            if (j == m) {
                System.out.println("Pattern Found at index: " + i);
                i += m;
            } else if (j == 0) {
                i += 1;
            } else {
                i += j;
            }
        }
    }

    public static void main(String[] args) {
        String testCase1Text = "ABCABCDABCD";
        String textCase1Pattern = "ABCD";

        String testCase2Text = "GEEKSFORGEEKS";
        String textCase2Pattern = "EKS";

        String testCase3Text = "ABCAAAD";
        String textCase3Pattern = "ABD";

        String testCase4Text = "ABCEABCDABCEABCD";
        String textCase4Pattern = "ABCD";

        String testCase5Text = "ABCABCD";
        String textCase5Pattern = "ABCD";

        improvedNaivePatternSearching(testCase1Text, textCase1Pattern);
        improvedNaivePatternSearching(testCase2Text, textCase2Pattern);
        improvedNaivePatternSearching(testCase3Text, textCase3Pattern);
        improvedNaivePatternSearching(testCase4Text, textCase4Pattern);
        improvedNaivePatternSearching(testCase5Text, textCase5Pattern);
    }

}
