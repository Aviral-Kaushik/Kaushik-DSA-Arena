package DataStructures.Arrays.Techniques.BruteForce;

public class FindAllPairsWithSum {

    private static void findAllPairsWithGivenSum(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == target) {
                    System.out.println("Pair: [" + arr[i] + ", " + arr[j] + "]");
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 6, 2, 5, 9, 0, 8, 1, 7, 2, 5, 4, 2, 7};

        findAllPairsWithGivenSum(arr, 9);
        findAllPairsWithGivenSum(arr, 11);
    }

}
