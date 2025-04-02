package DataStructures.Arrays.Basic;

public class BasicOperations {

    /**
     * Time Complexity: O(n)
     * */
    private static int linearSearch(int[] arr, int element) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == element) {
                return i;
            }
        }

        return -1;
    }

    /**
     * Best Case Time Complexity: O(1) -> If the element is inserted at the end, no shifting is needed.
     * Worst Case Time Complexity: O(n) -> If inserted at the beginning, all elements must shift.
     * Average Case Time Complexity: O(n) -> On average, half the elements are shifted.
     * */
    private static int[] insertElement(int[] arr, int element, int index) {
        if (index < 0 || index > arr.length) {
            throw new IllegalArgumentException("Invalid index for insertion");
        }

        int[] newArr = new int[arr.length + 1];

        // Copy elements before index
        for (int i = 0; i < index; i++) {
            newArr[i] = arr[i];
        }

        // Insert the new element
        newArr[index] = element;

        for (int i = index; i < arr.length; i++) {
            newArr[i + 1] = arr[i];
        }

        return newArr;
    }

    /**
     * Best Case Time Complexity: O(1) -> If the last element is deleted, no shifting is needed.
     * Worst Case Time Complexity: O(n) -> If the first element is deleted, all elements must shift.
     * Average Case Time Complexity: O(n) -> If the first element is deleted, all elements must shift.
     * */
    private static int[] deleteElement(int[] arr, int index) {
        if (index < 0 || index > arr.length) {
            throw new IllegalArgumentException("Invalid index for deletion");
        }

        int[] newArr = new int[arr.length - 1];

        // Copy elements before index
        for (int i = 0; i < index; i++) {
            newArr[i] = arr[i];
        }

        // Copy elements after index
        for (int i = index; i < arr.length - 1; i++) {
            newArr[i] = arr[i + 1];
        }

        return newArr;
    }

    private static void printArray(int[] arr) {
        for (int i: arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {0, 5, 7, 9};

        System.out.println(linearSearch(arr, 9));
        System.out.println(linearSearch(arr, 5));

        arr = insertElement(arr, 11, 2);

        printArray(arr);

        arr = insertElement(arr, 25, 4);

        printArray(arr);

        arr = deleteElement(arr, 4);

        printArray(arr);

        arr = deleteElement(arr, 2);

        printArray(arr);

    }

}
