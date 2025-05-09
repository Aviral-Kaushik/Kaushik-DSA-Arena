package Hashing.PracticeProblem;

import java.util.HashSet;

public class UnionOf2UnsortedArray {

    /// Problem Statement:
    /// In this problem, we have given an 2 unsorted array and our task is to count the total number of distinct
    /// elements combine in both of the arrays (, i.e., Union of both Arrays).


    /**
     * Time Complexity: O(m + n)
     * Space Complexity: O(m + n)
     * Where, m is size of arr1 and n is size of arr2
     * */
    private static int countDistinctElementsInArrays(int[] arr1, int[] arr2) {
        HashSet<Integer> distinctElements = new HashSet<>();

        for (int num: arr1) {
            distinctElements.add(num);
        }

        for (int num: arr2) {
            distinctElements.add(num);
        }

        return distinctElements.size();
    }


    public static void main(String[] args) {
        int[] testCase1Arr1 = {15, 20, 5, 15};
        int[] testCase1Arr2 = {15, 15, 15, 20, 10};

        int[] testCase2Arr1 = {10, 12, 15};
        int[] testCase2Arr2 = {18, 12};

        int[] testCase3Arr1 = {3, 3, 3};
        int[] testCase3Arr2 = {3, 3};

        int[] testCase4Arr1 = {10, 30, 10};
        int[] testCase4Arr2 = {5, 10, 5};

        System.out.println(countDistinctElementsInArrays(testCase1Arr1, testCase1Arr2));
        System.out.println(countDistinctElementsInArrays(testCase2Arr1, testCase2Arr2));
        System.out.println(countDistinctElementsInArrays(testCase3Arr1, testCase3Arr2));
        System.out.println(countDistinctElementsInArrays(testCase4Arr1, testCase4Arr2));

    }

}
