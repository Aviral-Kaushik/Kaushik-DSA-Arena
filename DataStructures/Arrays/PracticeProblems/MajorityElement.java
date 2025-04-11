package DataStructures.Arrays.PracticeProblems;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {

    /// In this problem, we have given an array, and we need to find majority element if it exists.

    /// Majority Element:
    /// An element is known as majority element if it exits more than n / 2 times in an array.


    /**
     * Naive Method
     * Time Complexity: O(n ^ 2)
     * Space Complexity: O(1)
     * */
    private static int getMajorityElementByNaiveMethod(int[] arr) {
        int n = arr.length;
        int occurrenceCount = n / 2;

        for (int i = 0; i < n; i++) {
            int count = 0;

            for (int j = i; j < n; j++) {
                if (arr[i] == arr[j]) {
                    count++;
                }
            }

            if (count > occurrenceCount) {
                return arr[i];
            }
        }

        return -1;
    }

    /**
     * Efficient Method (Hashing)
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * */
    private static int getMajorityElementByHashing(int[] arr) {
        int n = arr.length;
        int occurrenceCount = n / 2;

        final Map<Integer, Integer> frequenciesMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            frequenciesMap.put(arr[i], frequenciesMap.getOrDefault(arr[i], 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry: frequenciesMap.entrySet()) {
            if (entry.getValue() > occurrenceCount) {
                return entry.getKey();
            }
        }

        return -1;
    }


    /**
     * Efficient Method (Boyer-Moore Voting Algorithm)
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * */
    private static int getMajorityElementBoyerMoore(int[] arr) {
        int count = 0, candidate = -1;

        // Phase 1: Find a candidate
        for (int i = 0; i < arr.length; i++) {
            if (count == 0) {
                candidate = arr[i];
            }

            count += (arr[i] == candidate) ? 1 : -1;
        }

        // Phase 2: Validate the candidate (optional)
        count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == candidate) {
                count++;
            }
        }

        return (count > arr.length / 2) ? candidate : -1;
    }

    public static void main(String[] args) {
        int[] arr = {8, 3, 4, 8, 8};
//        int[] arr = {3, 7, 4, 7, 7, 5};
//        int[] arr = {20, 30, 40, 50, 50, 50, 50};
//        int[] arr = {3, 2, 3};
//        int[] arr = {2, 2, 1, 1, 1, 2, 2};

        System.out.println(getMajorityElementByNaiveMethod(arr));
        System.out.println(getMajorityElementByHashing(arr));
        System.out.println(getMajorityElementBoyerMoore(arr));
    }
}
