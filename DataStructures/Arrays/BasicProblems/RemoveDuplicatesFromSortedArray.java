package DataStructures.Arrays.BasicProblems;

public class RemoveDuplicatesFromSortedArray {

    /// Note, this code has been written to remove duplicates from sorted array only.

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * */
    private static int[] removeDuplicatesByNaiveMethod(int[] arr) {
        int[] newArr = new int[arr.length];
        int j = 0;

        newArr[0] = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] != arr[i]) {
                j++;
                newArr[j] = arr[i];
            }
        }

        return newArr;
    }


    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * <p>
     * More Efficient method as it has constant space complexity and naive method has linear space complexity.
     * Doing same work as in naive method but doing operations in the same array.
     * </p>
     * */
    private static void removeDuplicatesByEfficientMethod(int[] arr) {
        int res = 1;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i - 1]) {
                arr[res] = arr[i];
                res++;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {10, 10, 20, 20, 30, 30, 30, 55, 55, 70, 75, 75, 80, 97};

        arr = removeDuplicatesByNaiveMethod(arr);

        BasicOperations.printArray(arr);

        removeDuplicatesByEfficientMethod(arr);

        BasicOperations.printArray(arr);
    }

}
