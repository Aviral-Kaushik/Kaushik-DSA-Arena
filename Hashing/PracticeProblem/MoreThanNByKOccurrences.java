package Hashing.PracticeProblem;

import java.util.HashMap;

public class MoreThanNByKOccurrences {

    /// Problem Statement:
    /// In this problem, we have given an array & a number k, and we need print the numbers which appears more than
    /// n / k times.

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * */
    private static void printElementsWithMoreThenNByKOccurrences(int[] arr, int k) {
        HashMap<Integer, Integer> frequencies = new HashMap<>();
        int occurrenceCount = arr.length / k;

        for (int num: arr) {
            frequencies.put(num, frequencies.getOrDefault(num, 0) + 1);

            int frequency = frequencies.get(num);

            if (frequency > occurrenceCount) {
                System.out.print(num + " ");
            }
        }

//        for (Map.Entry<Integer, Integer> entry: frequencies.entrySet()) {
//            if (entry.getValue() > occurrenceCount) {
//                System.out.print(entry.getKey() + " ");
//            }
//        }
    }

    public static void main(String[] args) {
        int[] testCase1 = {30, 10, 20, 20, 10, 20, 30, 30};
        int[] testCase2 = {30, 10, 20, 30, 30, 40, 30, 40, 30};
        int[] testCase3 = {10, 10, 20, 30, 20, 10, 10};
        int[] testCase4 = {10, 20, 30, 10, 10, 20};
        int[] testCase5 = {30, 10, 20, 20, 20, 10, 40, 30, 30};

        printElementsWithMoreThenNByKOccurrences(testCase1, 4);

        System.out.println();

        printElementsWithMoreThenNByKOccurrences(testCase2, 2);

        System.out.println();

        printElementsWithMoreThenNByKOccurrences(testCase3, 2);

        System.out.println();

        printElementsWithMoreThenNByKOccurrences(testCase4, 3);

        System.out.println();

        printElementsWithMoreThenNByKOccurrences(testCase5, 4);
    }

}
