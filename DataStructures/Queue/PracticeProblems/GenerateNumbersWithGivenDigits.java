package DataStructures.Queue.PracticeProblems;

import java.util.LinkedList;
import java.util.Queue;

public class GenerateNumbersWithGivenDigits {

    /// Problem Statement:
    /// In this problem, we have given a number n & we need to print first n numbers in increasing order (sorted order)
    /// such that all these numbers contains only 5 or 6.

    /// Input: 10
    /// Output: 5 6 55 56 65 66 555 556 566

    /// Input: 4
    /// Output: 5 6 55 56

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * */
    private static void printFirstNNumbersWithDigits5And6(int n) {
        Queue<String> queue = new LinkedList<>();

        queue.add("5");
        queue.add("6");

        for (int i = 0; i < n; i++) {
            String current = queue.remove();

            System.out.print(current + " ");

            queue.add(current + "5");
            queue.add(current + "6");
        }
    }


    public static void main(String[] args) {
        printFirstNNumbersWithDigits5And6(10);

        System.out.println();

        printFirstNNumbersWithDigits5And6(4);
    }

}
