package Strings.PatternMatching;

public class KMPAlgorithm {

    private static void computeLPSArray(String pattern, int[] lps) {
        int length = 0; // length of the previous longest prefix suffix
        int i = 1;
        lps[0] = 0; // lps[0] is always 0

        while (i < pattern.length()) {
            if (pattern.charAt(i) == pattern.charAt(length)) {
                length++;
                lps[i] = length;
                i++;
            } else {
                if (length != 0) {
                    length = lps[length - 1];
                    // Do not increment i here
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
    }

    /**
     * KMP Pattern Searching Algorithm
     * Time Complexity: O(n + m)
     * O(n) for KMP Search and O(m) for computing LPS Array. So total time complexity for KMP Algorithm: O(n + m)
     * Space Complexity: O(m)
     * As we create a lps array os size m.
     * Where n is the length of the text and m is the length of pattern.
     * */
    private static void KMPSearch(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();

        // Create lps[] that will hold the longest prefix suffix values for pattern
        int[] lps = new int[m];
        computeLPSArray(pattern, lps);

        int i = 0; // index for text
        int j = 0; // index for pattern

        while (i < n) {
            if (pattern.charAt(j) == text.charAt(i)) {
                i++;
                j++;
            }

            if (j == m) {
                System.out.println("Pattern found at index " + (i - j));
                j = lps[j - 1]; // look for next match
            } else if (i < n && pattern.charAt(j) != text.charAt(i)) {
                // mismatch after j matches
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++; // move to the next character in text
                }
            }
        }
    }

    public static void main(String[] args) {
        String testCase1Text = "abcdefg";
        String testCase1Pattern = "bcd";

        String testCase2Text = "aaaaab";
        String testCase2Pattern = "aaaa";

        String testCase3Text = "abcd";
        String testCase3Pattern = "ba";

        String testCase4Text = "ABABDABACDABABCABAB";
        String testCase4Pattern = "ABABCABAB";

        KMPSearch(testCase1Text, testCase1Pattern);
        KMPSearch(testCase2Text, testCase2Pattern);
        KMPSearch(testCase3Text, testCase3Pattern);
        KMPSearch(testCase4Text, testCase4Pattern);
    }

}
