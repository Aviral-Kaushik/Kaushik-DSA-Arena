package Hashing.PracticeProblem;

import java.util.HashMap;

public class FrequenciesOfArrayElements {

    /// Problem Statement:
    /// In this problem, we have given an array and we need to print the frequencies of array elements. Frequency means
    /// number of times an element appear in the array.

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * */
    private static void printFrequencies(int[] arr) {
        HashMap<Integer, Integer> frequencies = new HashMap<>();

        for (int num: arr) {
            frequencies.put(num, frequencies.getOrDefault(num, 0) + 1 );
        }

        System.out.println(frequencies);
    }

    public static void main(String[] args) {
        int[] testCase1 = {10, 12, 10, 15, 10, 20, 12, 12};
        int[] testCase2 = {10, 10, 10, 10};
        int[] testCase3 = {10, 20};
        int[] testCase4 = {10, 20, 20, 30, 10};

        printFrequencies(testCase1);
        printFrequencies(testCase2);
        printFrequencies(testCase3);
        printFrequencies(testCase4);
    }

}
