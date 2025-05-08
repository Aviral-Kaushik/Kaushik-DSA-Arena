package Hashing.PracticeProblem;

import java.util.HashMap;
import java.util.HashSet;

public class IntersectionOf2UnsortedArray {

    /// Problem Statement:
    /// In this problem, we have given two unsorted array with distinct elements and print the intersection of the array.
    /// Intersection means the common elements in both of the array and we need to print the common elements in both
    /// of the array like the first element that appear must be printed firstly.

    /**
     * Time Complexity: O(m +n)
     * Space Complexity: O(n)
     * Where m is the size of arr1 and n is the size of arr2
     * */
    private static void printIntersectionElements(int[] arr1, int[] arr2) {
        HashSet<Integer> set = new HashSet<>();

        for (int num: arr2) {
            set.add(num);
        }

        for (int num: arr1) {
            if (set.contains(num)) {
                System.out.print(num + " ");
            }
        }
    }

    public static void main(String[] args) {
        int[] testCase1Arr1 = {10, 15, 20, 25, 30, 50};
        int[] testCase1Arr2 = {30, 5, 15, 80};

        int[] testCase2Arr1 = {10, 20};
        int[] testCase2Arr2 = {20, 30};

        int[] testCase3Arr1 = {10, 20, 30};
        int[] testCase3Arr2 = {30, 20, 10};

        int[] testCase4Arr1 = {10, 20, 30};
        int[] testCase4Arr2 = {10, 30};

        printIntersectionElements(testCase1Arr1, testCase1Arr2);

        System.out.println();

        printIntersectionElements(testCase2Arr1, testCase2Arr2);

        System.out.println();

        printIntersectionElements(testCase3Arr1, testCase3Arr2);

        System.out.println();

        printIntersectionElements(testCase4Arr1, testCase4Arr2);
    }
}
