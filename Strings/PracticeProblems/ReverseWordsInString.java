package Strings.PracticeProblems;

public class ReverseWordsInString {

    /// Problem Statement:
    /// In this problem, we have given a string that might contains multiple words and out task is to reverse
    /// the order of the words in the given string.

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * */
    private static String reverseOrderOfWords(String str) {
        String[] strings = str.split(" ");
        StringBuilder builder = new StringBuilder();

        for (int i = strings.length - 1; i >= 0; i--) {
            builder.append(strings[i])
                    .append(" ");
        }

        return builder.toString();
    }

    public static void main(String[] args) {
        String testCase1 = "Welcome to GFG";
        String testCase2 = "I Love Coding";
        String testCase3 = "abc";

        System.out.println(reverseOrderOfWords(testCase1));
        System.out.println(reverseOrderOfWords(testCase2));
        System.out.println(reverseOrderOfWords(testCase3));
    }
}
