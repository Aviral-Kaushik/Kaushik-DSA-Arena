package Strings.PatternMatching;

public class RabinKarpAlgorithm {

    /**
     * Rabin Karp Algorithm
     * Average Case Time Complexity: O(n + m)
     * Worst Case Time Complexity: O(n * m) (dur to hash collision)
     * Space Complexity: O(1)
     * Where n is the length of text and m is the length of the pattern.
     * */
    private static void rabinKarpAlgorithmPatternSearching(String text, String pattern, int q) {
        int n = text.length();
        int m = pattern.length();
        int i, j;
        int p = 0; // hash value for pattern
        int t = 0; // hash value for text
        int h = 1;
        final int d = 256;

        // The value of h would be "pow(d, m-1)%q"
        for (i = 0; i < m - 1; i++) {
            h = (h * d) % q;
        }

        // Calculate the hash value of pattern and first window of text
        for (i = 0; i < m; i++) {
            p = (d * p + pattern.charAt(i)) % q;
            t = (d * t + text.charAt(i)) % q;
        }

        // Slide the pattern over text one by one
        for (i = 0; i <= n - m; i++) {
            // If hash values match, then only check characters one by one
            if (p == t) {
                for (j = 0; j < m; j++) {
                    if (text.charAt(i + j) !=  pattern.charAt(j)) {
                        break;
                    }
                }

                if (j == m) {
                    System.out.println("Pattern Found at Index: " + i);
                }
            }

            // Calculate hash value for next window of text:
            // Remove leading digit, add trailing digit
            if (i < n - m) {
                t = (d * (t - text.charAt(i) * h) + text.charAt(i + m)) % q;
                if (t < 0) {
                    t = t + q;
                }
            }
        }

    }

    public static void main(String[] args) {
        String testCase1Text = "abdabcbabc";
        String testCase1Pattern = "abc";

        String testCase2Text = "aaaaa";
        String testCase2Pattern = "aaa";

        String testCase3Text = "abcd";
        String testCase3Pattern = "xyz";

        String testCase4Text = "ABCCDDAEFG";
        String testCase4Pattern = "CDD";

        int q = 101; // A prime number

        rabinKarpAlgorithmPatternSearching(testCase1Text, testCase1Pattern, q);
        rabinKarpAlgorithmPatternSearching(testCase2Text, testCase2Pattern, q);
        rabinKarpAlgorithmPatternSearching(testCase3Text, testCase3Pattern, q);
        rabinKarpAlgorithmPatternSearching(testCase4Text, testCase4Pattern, q);
    }

}
