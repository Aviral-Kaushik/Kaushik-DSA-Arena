package DataStructures.Arrays.Techniques.PrefixSum;

public class GetSum {

    static int[] prefixSum;

    /**
     * Time Complexity: O(n)
     * */
    private static int[] getPrefixSum(int[] arr) {
        int[] prefixSum = new int[arr.length];

        prefixSum[0] = arr[0];

        for (int i = 1; i < arr.length; i++) {
            prefixSum[i] = arr[i] + prefixSum[i - 1];
        }

        return prefixSum;
    }

    /**
     * Time Complexity: O(1)
     * */
    private static int getSum(int left, int right) {
        if (left == 0) {
            return prefixSum[right];
        }

        return prefixSum[right] - prefixSum[left - 1];
    }

    public static void main(String[] args) {
        int[] arr = {2, 8, 3, 9, 6, 5, 4};
        prefixSum = getPrefixSum(arr);

        System.out.println(getSum(0, 2));
        System.out.println(getSum(1, 3));
        System.out.println(getSum(2, 6));
    }

}
