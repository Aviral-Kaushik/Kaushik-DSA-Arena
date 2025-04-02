package DataStructures.Arrays.BasicProblems;

public class IsArraySorted {

    /**
     * Checking only Increasing Order for an array without rotation
     * Time Complexity: O(n)
     * */
    private static boolean isArraySorted(int[] arr) {
        boolean isArraySorted = true;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] > arr[i]) {
                isArraySorted = false;
                break;
            }
        }

        return isArraySorted;
    }


    public static void main(String[] args) {
        int[] arr = {5, 20, 25, 30, 30};

        System.out.println(isArraySorted(arr));
    }
}
