package DataStructures.Arrays.Techniques.BruteForce;

public class GenerateAllSubArrays {

    private static void printAllSubArrays(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {

                System.out.print("[");

                for (int k = i; k <= j; k++) {
                    System.out.print(arr[k]);
                    if (k < j) {
                        System.out.print(", ");
                    }
                }

                System.out.println("]");
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 11, 7, 9, 15, 18};

        printAllSubArrays(arr);
    }

}
