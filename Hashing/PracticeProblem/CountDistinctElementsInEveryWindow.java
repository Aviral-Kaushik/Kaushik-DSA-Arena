package Hashing.PracticeProblem;

import java.util.HashMap;

public class CountDistinctElementsInEveryWindow {

    /// Problem Statement:
    /// In this problem, we have given an array and an element k (k <= n) and we need to find distinct element count
    /// in every window of size k.

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(k)
     * */
    private static void printDistinctElementInEveryWindow(int[] arr, int k) {
        HashMap<Integer, Integer> frequencies = new HashMap<>();

        for (int i = 0; i < k; i++) {
            frequencies.put(arr[i], frequencies.getOrDefault(arr[i], 0) + 1);
        }

        System.out.print(frequencies.size() + " ");

        for (int i = k; i < arr.length; i++) {
            int frequency = frequencies.get(arr[i - k]);

            if (frequency == 1) {
                frequencies.remove(arr[i - k]);
            } else {
                frequencies.put(arr[i - k], frequency - 1);
            }

            if (frequencies.containsKey(arr[i])) {
                frequencies.put(arr[i], frequencies.getOrDefault(arr[i], 0) + 1);
            } else {
                frequencies.put(arr[i], 1);
            }

            System.out.print(frequencies.size() + " ");
        }
    }

    public static void main(String[] args) {
        int[] testCase1 = {10, 20, 20, 10, 30, 40, 10};
        int[] testCase2 = {10, 10, 10, 10};
        int[] testCase3 = {10, 20, 30, 40};
        int[] testCase4 = {10, 20, 10, 10, 30, 40};
        int[] testCase5 = {1, 2, 1, 3, 4, 2, 3};

        printDistinctElementInEveryWindow(testCase1, 4);

        System.out.println();

        printDistinctElementInEveryWindow(testCase2, 3);

        System.out.println();

        printDistinctElementInEveryWindow(testCase3, 3);

        System.out.println();

        printDistinctElementInEveryWindow(testCase4, 4);

        System.out.println();

        printDistinctElementInEveryWindow(testCase5, 4);
    }

}
