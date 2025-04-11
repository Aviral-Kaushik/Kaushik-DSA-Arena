package DataStructures.Arrays.PracticeProblems;

public class MinimumConsecutiveFlips {

    /// In this problem, we have given an binary or boolean array and our task is to determine in how many minimum flips
    /// do we can make that array to make all element same. But we can only flip consecutive 0's oe 1's at a time and
    /// we can only flip either 0's or 1's we cannot flip both. And we need to print the flips

    /// For Example:
    /// 1. {1, 1, 0, 0, 0, 1}:
    ///         From 2 to 4 (2 and 4 are indices)
    /// 2. {1, 0, 0, 0, 1, 0, 0, 1, 1, 1, 1}
    ///         From 1 to 3
    ///         From 5 to 6
    /// 3. {0, 1}
    ///         From 0 to 0 or From 1 to 1

    /**
     * Efficient Method
     * Time Complexity: O(n)
     * */
    private static void printMinimumFlips(int[] arr) {
       for (int i = 1; i < arr.length; i++) {
           if (arr[i] != arr[i - 1]) {
               if (arr[i] != arr[0]) {
                   System.out.print("From " + i + " to ");
               } else {
                   System.out.println(i - 1);
               }
           }

           if (arr[arr.length - 1] != arr[0]) {
               System.out.println(arr.length - 1);
           }
       }
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 0, 0, 0, 1};
//        int[] arr = {1, 0, 0, 0, 1, 0, 0, 1, 1, 1, 1};
//        int[] arr = {1, 1, 1};
//        int[] arr = {0, 1};

        printMinimumFlips(arr);
    }
}
