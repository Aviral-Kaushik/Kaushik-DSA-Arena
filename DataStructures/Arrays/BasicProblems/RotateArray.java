package DataStructures.Arrays.BasicProblems;

public class RotateArray {

    /// Left Rotate -> Rotation in Anti-Clockwise direction.
    /// Right Rotate -> Rotation in Clockwise direction.
    /// In this problem, where we have to rotate an array by d we assume that d is smaller than n. (d < n)

    /**
     * Time Complexity: O(n)
     * */
    private static void leftRotateArrayBy1(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i - 1];
            arr[i - 1] = arr[i];
            arr[i] = temp;
        }
    }

    /**
     * Time Complexity: O(n)
     * */
    private static void secondMethodToLeftRotateArrayBy1(int[] arr) {
        int temp = arr[0];

        for (int i = 1; i < arr.length; i++) {
            arr[i - 1] = arr[i];
        }

        arr[arr.length - 1] = temp;
    }

    /**
     * Method - 1 (Naive)
     * - Less Efficient in compare to Second and Third Method
     * - Video Link: <a href="https://www.udemy.com/share/10cstB3@feGoXkG02Uz1IZ_mtDA-2jgHQIWApNI6E49hOh11Y0WJlBxS2kUHKlVqvKCRx-2aSg==/">...</a>
     * Time Complexity: O(d * n)
     * Space Complexity: O(1)
     * */
    private static void leftRotateArrayByDUsingFirstMethod(int[] arr, int d) {
        int n = arr.length - 1;

        for (int i = 0; i < d; i++) {
            int temp = arr[0];

            for (int j = 1; j <= n; j++) {
                arr[j - 1] = arr[j];
            }

            arr[n] = temp;
        }
    }


    /**
     * Method - 2 (Less Efficient)
     * - More Efficient then First Method and less efficient than Third Method
     * - Video Link: <a href="https://www.udemy.com/share/10cstB3@feGoXkG02Uz1IZ_mtDA-2jgHQIWApNI6E49hOh11Y0WJlBxS2kUHKlVqvKCRx-2aSg==/">...</a>
     * Time Complexity: O(n) -> O(d + n - d + d) = O (n + d) as d is smaller than n so we can negate d so O(n)
     * Space Complexity: O(d)
     */
    private static void leftRotateArrayByDUsingSecondMethod(int[] arr, int d) {
        int[] temp = new int[d];
        int n = arr.length;

        for (int i = 0; i < d; i++) {
            temp[i] = arr[i];
        }

        for (int i = d; i < n; i++) {
            arr[i - d] = arr[i];
        }

        for (int i = 0; i < d; i++) {
            arr[n - d + i] = temp[i];
        }
    }

    /**
     * Method - 3 (Most Efficient)
     * - More Efficient then First and Second Method
     * - Video Link: <a href="https://www.udemy.com/share/10cstB3@feGoXkG02Uz1IZ_mtDA-2jgHQIWApNI6E49hOh11Y0WJlBxS2kUHKlVqvKCRx-2aSg==/">...</a>
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    private static void leftRotateArrayByDUsingThirdMethod(int[] arr, int d) {
        int n = arr.length;

        reverse(arr, 0, d - 1);
        reverse(arr, d, n - 1);
        reverse(arr, 0, n - 1);
    }

    private static void reverse(int[] arr, int low, int high) {
        while (low < high) {
            int temp = arr[low];
            arr[low] = arr[high];
            arr[high] = temp;

            low++;
            high--;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 5, 7, 9, 19};

        leftRotateArrayBy1(arr);
        secondMethodToLeftRotateArrayBy1(arr);

        leftRotateArrayByDUsingFirstMethod(arr, 3);
        leftRotateArrayByDUsingSecondMethod(arr, 7);
        leftRotateArrayByDUsingThirdMethod(arr, 3);

        BasicOperations.printArray(arr);
    }

}
