package DataStructures.Deque.PracticeProblem;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class MaximumOfAllSubArrays {

    /// Problem Statement:
    /// In this problem, we have give an array and an integer k & we need to print all the maximum element in the sub
    /// array of size k. Where, k <= size of the array.

    /// Total number of SubArrays   = n - k + 1

    /// Input: [10, 8, 5, 12, 15, 7, 6], k = 3
    /// Output: 10 12 15 15 15

    /// Input: [20, 5, 3, 8, 6, 15], k = 4
    /// Output: 20 8 15

    private static List<Integer> printMaximumOfAllSubArrays(int[] arr, int k) {
        List<Integer> result = new ArrayList<>();
        ArrayDeque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < arr.length; i++) {

            // Remove indices which are out of this window
            if (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }

            // Remove elements smaller than current from the deque
            while (!deque.isEmpty() && arr[deque.peekLast()] < arr[i]) {
                deque.pollLast();
            }

            // Add current element at the back of the deque
            deque.offerLast(i);

            // The first k-1 windows are not complete
            if (i >= k - 1) {
                result.add(arr[deque.peekFirst()]);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] testCase1 = {10, 8, 5, 12, 15, 7, 6};
        int[] testCase2 = {20, 5, 3, 8, 6, 15};

        System.out.println(printMaximumOfAllSubArrays(testCase1, 3));

        System.out.println(printMaximumOfAllSubArrays(testCase2, 4));

    }

}
