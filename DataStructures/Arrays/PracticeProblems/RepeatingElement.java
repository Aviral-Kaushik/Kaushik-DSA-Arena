package DataStructures.Arrays.PracticeProblems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class RepeatingElement {

    /// Problem Statement:
    /// 1. In this problem, we have given an array in which all the elements appear only once except one element which can
    /// repeat any number times, and we have to find this element.
    /// 2. In the array 0 is always present.
    /// 3. And this array contains all the elements from 0 to max element in the array, .e.g, an array has max element 4
    /// so it will contain all the elements form 0 to 4.
    /// 4. And there is one more thing that the max element will be always less than equal to n - 2, where n is
    /// length of array. So, therefore we can conclude that 0 <= max(arr) <= n - 2.
    /// 5. Array size is n >= 2.

    /// Test Cases
    /// Input: [0, 2, 1, 3, 2, 2]
    /// Output: 2

    /// Input: [1, 2, 3, 0, 3, 4, 5]
    /// Output: 3

    /// Input: [0, 0]
    /// Output: 0

    /**
     * HashMap Method (My Solution)
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * */
    private static int getRepeatingElementUsingHashmap(int[] arr) {
        HashMap<Integer, Integer> frequencies = new HashMap<>();

        for (int num: arr) {
            int count = frequencies.getOrDefault(num, 1);

            if (count > 1) {
                return num;
            }

            frequencies.put(num, count + 1);
        }

        return -1;
    }

    /**
     * Boolean Flag Method
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * */
    private static int getRepeatingElementUsingBooleanFlagMethod(int[] arr) {
        boolean[] visited = new boolean[arr.length];

        for (int j : arr) {
            if (visited[j]) {
                return j;
            }

            visited[j] = true;
        }

        return -1;
    }

    /**
     * HashSet
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * */
    private static int getRepeatingElementUsingHashSet(int[] arr) {
        Set<Integer> seen = new HashSet<>();

        for (int num: arr) {
            if (seen.contains(num)) {
                return num;
            }

            seen.add(num);
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] testCase1 = {0, 2, 1, 3, 2, 2};
        int[] testCase2 = {1, 2, 3, 0, 3, 4, 5};
        int[] testCase3 = {0, 0};

        System.out.println(getRepeatingElementUsingHashmap(testCase1));
        System.out.println(getRepeatingElementUsingBooleanFlagMethod(testCase1));
        System.out.println(getRepeatingElementUsingHashSet(testCase1));

        System.out.println(getRepeatingElementUsingHashmap(testCase2));
        System.out.println(getRepeatingElementUsingBooleanFlagMethod(testCase2));
        System.out.println(getRepeatingElementUsingHashSet(testCase2));

        System.out.println(getRepeatingElementUsingHashmap(testCase3));
        System.out.println(getRepeatingElementUsingBooleanFlagMethod(testCase3));
        System.out.println(getRepeatingElementUsingHashSet(testCase3));
    }

}
