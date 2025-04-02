package DataStructures.Arrays.BasicProblems;

public class ReverseArray {

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * <p>
     * We are not returning as we are modifying the same array of main method and java works on call by reference.
     * So the data is updated everytime in the memory so not need ot return anything from this method.
     * */
    private static void reverseArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        int temp;
        while (start < end) {
            temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] arr = {50, 30, 17, 12};

        reverseArray(arr);

        BasicOperations.printArray(arr);
    }

}
