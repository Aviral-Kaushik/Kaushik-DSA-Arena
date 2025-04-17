package DataStructures.Arrays.Techniques.BruteForce;

public class FindLargestElement {

    private static int getLargestElement(int[] arr) {
        int largestElement = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > largestElement) {
                largestElement = arr[i];
            }
        }

        return largestElement;
    }

    public static void main(String[] args) {
        int[] testCase1 = {888, 1, 57, 333, 456, -2, 789, 33, 22};
        int[] testCase2 = {-2, -5, -7, -18, -27, -7, -9};

        System.out.println(getLargestElement(testCase1));
        System.out.println(getLargestElement(testCase2));
    }

}
