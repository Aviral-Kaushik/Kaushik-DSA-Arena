package Hashing.PracticeProblem;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class CountDistinctElements {


    /// Problem Statement
    /// In this problem, we have given an array and we need to return the number of distinct element in the array.

    /**
     * TIme Complexity: O(n)
     * Space Complexity: O(n)
     * */
    private static int countDistinctElements(int[] arr) {
        HashSet<Integer> distinctElements = new HashSet<>();

        for (int num: arr) {
            distinctElements.add(num);
        }

        return distinctElements.size();
    }

    public static void main(String[] args) {
        int[] testCase1 = {15, 12, 13, 12, 13, 13, 18};
        int[] testCase2 = {10, 10, 10};
        int[] testCase3 = {10, 11, 12};
        int[] testCase4 = {10, 20, 10, 20, 30};

        System.out.println(countDistinctElements(testCase1));
        System.out.println(countDistinctElements(testCase2));
        System.out.println(countDistinctElements(testCase3));
        System.out.println(countDistinctElements(testCase4));
    }

}
