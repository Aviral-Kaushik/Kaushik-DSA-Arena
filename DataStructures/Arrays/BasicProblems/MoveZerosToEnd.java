package DataStructures.Arrays.BasicProblems;

public class MoveZerosToEnd {

    /**
     * Custom Solution implemented by Aviral.
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * */
    private static int[] moveAllZerosToEnd(int[] arr) {
        int[] newArr = new int[arr.length];
        int j = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                newArr[j] = arr[i];
                j++;
            }
        }

        return newArr;
    }

    /**
     * More Efficient Solution as it takes constant space.
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * */
    private static void moveAllZerosToEndEfficiently(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] == 0) {
                swap(arr[i - 1], arr[i]);
//                int temp = arr[i - 1];
//                arr[i - 1] = arr[i];
//                arr[i] = temp;
            }
        }
    }

    private static void swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
    }

    public static void main(String[] args) {
        int[] arr = {10, 0, 20, 5, 0, 32, 47, 59, 0, 0};
//        int[] arr = {0, 0, 0, 0, 10, 0, 0, 0};
//        int[] arr = {10, 22, 35, 37, 49, 55, 97};

        arr = moveAllZerosToEnd(arr);

        BasicOperations.printArray(arr);

        moveAllZerosToEndEfficiently(arr);

        BasicOperations.printArray(arr);
    }
}
