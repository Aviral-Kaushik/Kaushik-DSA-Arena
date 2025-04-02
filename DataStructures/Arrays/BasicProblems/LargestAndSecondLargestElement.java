package DataStructures.Arrays.BasicProblems;

import java.util.Arrays;

public class LargestAndSecondLargestElement {

    /**
     * Time Complexity: O(n)
     * */
    private static int getLargestElement(int[] arr) {
        int largestElement = arr[0];

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > largestElement) {
                largestElement = arr[i];
            }
        }

        return largestElement;
    }

    /**
     * Time Complexity: O(n)
     * */
    private static int getSecondLargestElement(int[] arr) {
//        Arrays.sort(arr);
//        return arr[arr.length - 2];
        int res = -1, largest = arr[0];

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > largest) {
                res = largest;
                largest = arr[i];
            } else if (arr[i] != largest) {
                if (res == -1 || arr[i] > res) {
                    res = arr[i];
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 9, 15, 20, 55, 91, 97, 151, 295, 555};

        System.out.println(getLargestElement(arr));
        System.out.println(getSecondLargestElement(arr));
    }

}
