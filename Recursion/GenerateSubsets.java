package Recursion;

public class GenerateSubsets {

    /// Input: "AB" => Output: "", "A", "B", "AB"
    /// Input: "ABC" => Output: "", "A", "B", "C", "AB", "AC", "BC", "ABC"
    /// For string of length there are 2^n subsets.
    /// Assumptions: All characters in the input strings are distinct.

    /**
     * Time Complexity: O(n^2)
     * */
    static void generateSubsetIteratively(String str) {
        System.out.print(" , ");

        for (int i = 0; i < str.length(); i++) {
            System.out.print(str.charAt(i) + ", ");

            for (int j = i + 1; j < str.length(); j++) {
                String s1 = String.valueOf(str.charAt(i));
                String s2 = String.valueOf(str.charAt(j));

                System.out.print(s1 + s2 + ", ");
            }
        }

        System.out.println(str);
    }

    /**
     * Time Complexity: O(2^n)
     * Space Complexity: O(2^n)
     * */
    static void generateSubsets(String str, String current, int index) {
        if (index == str.length()) {
            System.out.print(current + " ");
            return;
        }

        generateSubsets(str, current, index + 1);
        generateSubsets(str, current + str.charAt(index), index + 1);
    }

    public static void main(String[] args) {
        generateSubsetIteratively("ABC");
        generateSubsets("ABC", "", 0);
    }

}
