package DataStructures.Arrays.BasicProblems;

public class LeadersInArray {

    /// Problem Statement
    /// In this problem, we have given an array (sorted or unsorted) and we print all the leaders of the array.
    /// An element is known as leader, if there is no greater elements than it to the right of it.
    /// If there is same element is on the right side of that element then it is not a leader.

    /**
     * Naive Method
     * Time Complexity: O(n ^ 2)
     * */
    private static void printAllLeadersUsingNaiveMethod(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            boolean flag = true;

            for (int j = i; j < n; j++) {
                if (arr[j] > arr[i]) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                System.out.print(arr[i] + " ");
            }
        }
    }

    /**
     * Efficient Method
     * - Drawback of this method is that it print the leaders in reverse order.
     * Time Complexity: O(n)
     * */
    private static void printAllLeadersUsingEfficientMethod(int[] arr) {
        int n = arr.length;
        int currentLeader = arr[n - 1];

        System.out.print(currentLeader + " ");

        for (int i = n - 2; i >= 0; i--) {
            if (currentLeader < arr[i]) {
                currentLeader = arr[i];
                System.out.print(currentLeader + " ");
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {7, 5, 2, 10, 4, 6, 5, 2};
//        int[] arr = {10, 20, 30};
//        int[] arr = {30, 20, 10};

        printAllLeadersUsingNaiveMethod(arr);

        System.out.println();

        printAllLeadersUsingEfficientMethod(arr);
    }
}
