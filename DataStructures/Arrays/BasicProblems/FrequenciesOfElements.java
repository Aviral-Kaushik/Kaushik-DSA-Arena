package DataStructures.Arrays.BasicProblems;

import java.util.HashMap;
import java.util.Map;

public class FrequenciesOfElements {

    /// Problem Statement
    /// In this problem, we have given an array (sorted or unsorted), and we have to print the number of time an
    /// elements occur, i.e., frequency of element.


    /**
     * Most Used Method
     * - I have seen coders and teachers use this method very often.
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * */
    private static void printFrequenciesUsingHashmap(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

    /**
     * This method only works if the array is sorted, we can sort this array first in this function using Arrays.sort()
     * but that will make time complexity of this function as O(n log n).
     * <p>
     * Time Complexity: O(n) (If Array is Sorted)
     * Space Complexity: O(1)
     * */
    private static void printFrequenciesIfArrayIsSorted(int[] arr) {
        int n = arr.length;
        int count = 1;

        for (int i = 1; i < n; i++) {
            if (arr[i - 1] == arr[i]) {
                count++;
            } else {
                System.out.println(arr[i - 1] + " : " + count);
                count = 1;
            }
        }

        // Print last element frequency
        System.out.println(arr[n - 1] + " : " + count);
    }

    public static void main(String[] args) {
        int[] arr = {10, 10, 10, 25, 30, 30};
//        int[] arr = {10, 10, 10};
//        int[] arr = {10, 20, 30};

        printFrequenciesIfArrayIsSorted(arr);

        System.out.println();

        printFrequenciesUsingHashmap(arr);
    }

}
