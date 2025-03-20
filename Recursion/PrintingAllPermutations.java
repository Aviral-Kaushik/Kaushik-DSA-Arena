package Recursion;



public class PrintingAllPermutations {

    /// In this problem we have given a string, and we have to print all the permutations of that string.
    /// For a string of length n there are always n! (factorial of n) permutations.

    /// Input: s = ABC
    /// Output: ABC, ACB, BCA, BAC, CAB, CBA

    /**
     * Time Complexity: O(n * n!)
     * Auxiliary Space: O(n!)
     * */
    static void printAllPermutations(StringBuilder str, int index) {
        if (index == str.length()) {
            System.out.println(str);
        }

        for (int j = index; j < str.length(); j++) {
            swap(str, index, j);
            printAllPermutations(str, index + 1);
            swap(str, j, index);
        }
    }

    static void swap(StringBuilder str, int index1, int index2) {
        char temp = str.charAt(index1);
        str.setCharAt(index1, str.charAt(index2));
        str.setCharAt(index2, temp);
    }

    public static void main(String[] args) {
        printAllPermutations(new StringBuilder("ABC"), 0);
    }
}
