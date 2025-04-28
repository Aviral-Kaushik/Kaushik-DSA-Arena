package DataStructures.Arrays.PracticeProblems;

public class AllocateMinimumPages {

    /// Problem Statement:
    /// In this problem, we have given an array and an integer k, the elements of the array represents the number of pages
    /// in every book and k represent the number of students that has to read all the books and our task is to figure
    /// out maximum number of pages read by a student in a way that a student should read minimum number of pages.
    /// So, in this problem we have to minimize the number of pages that students can read and every student can read
    /// continuous books only student cannot leave any book in between.

    /// Test Cases:
    /// Input: [10, 20, 30, 40] & k = 2
    /// Output: 60
    /// As a student read first 3 books (10 + 20 + 30 = 60 Pages) & other student read last book with 40 pages.

    /// Input: [10, 20, 30] & k = 1
    /// Output: 60
    /// As there is only 1 student so he has to read all the pages (10 + 20 + 30 = 60 Pages)

    /// Input: [10, 5, 30, 1, 2, 5, 10, 10] & k = 3
    /// Output: 30
    /// First Student read first 2 books (10 + 5 = 15 Pages), second student read third book (30 Pages) and third & last
    /// student read all the remaining books (1 + 2 + 5 + 10 + 10 = 28 Pages).


    /**
     * Recursive Method (Naive Method)
     * Time Complexity: O(n ^ n)
     * Space Complexity: O(k)
     * */
    private static int maxPagesReadByStudentUsingRecursion(int[] arr, int n, int k) {
        if (k == 1) {
            return sum(arr, 0, n - 1);
        }

        if (n == 1) {
            return arr[0];
        }

        int res = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            res = Math.min(res, Math.max(maxPagesReadByStudentUsingRecursion(arr, i, k -1),
                    sum(arr, i, n - 1)));
        }

        return res;
    }

    private static int sum(int[] arr, int start, int end) {
        int sum = 0;

        for (int i = start; i <= end; i++) {
            sum += arr[i];
        }

        return sum;
    }

    /**
     * Binary Search Method
     * Time Complexity: O(n * log(sum))
     * Space = O(1)
     * Where:
     * n = number of books (arr.length)
     * sum = total pages in all books
     * So, this is very efficient even for large inputs.
     * */
    private static int maxPagesReadByStudentUsingBinarySearch(int[] arr, int k) {
        int sum = 0, max = 0;

        for (int num: arr) {
            sum += num;
            max = Math.max(max, num);
        }

        int low = max, high = sum, res = 0;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (isFeasible(arr, k, mid)) {
                res = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return res;
    }

    private static boolean isFeasible(int[] arr, int k, int ans) {
        int req = 1, sum = 0;

        for (int j : arr) {
            if (sum + j > ans) {
                req++;
                sum = j;
            } else {
                sum += j;
            }
        }

        return req <= k;
    }

    public static void main(String[] args) {
        int[] testCase1 = {10, 20, 30, 40};
        int[] testCase2 = {10, 20, 30};
        int[] testCase3 = {10, 5, 30, 1, 2, 5, 10, 10};
        int[] testCase4 = {10, 5, 20};

        System.out.println(maxPagesReadByStudentUsingRecursion(testCase1, 4, 2));
        System.out.println(maxPagesReadByStudentUsingBinarySearch(testCase1, 2));

        System.out.println(maxPagesReadByStudentUsingRecursion(testCase2, 3, 1));
        System.out.println(maxPagesReadByStudentUsingBinarySearch(testCase2, 1));

        System.out.println(maxPagesReadByStudentUsingRecursion(testCase3, 8, 3));
        System.out.println(maxPagesReadByStudentUsingBinarySearch(testCase3, 3));

        System.out.println(maxPagesReadByStudentUsingRecursion(testCase4, 3, 2));
        System.out.println(maxPagesReadByStudentUsingBinarySearch(testCase4, 2));
    }

}
