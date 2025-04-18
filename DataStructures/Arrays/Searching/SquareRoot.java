package DataStructures.Arrays.Searching;

public class SquareRoot {

    /**
     * Time Complexity: O(1)
     * Internally, it uses hardware-level operations (like the IEEE 754 floating point square root instruction),
     * or efficient algorithms like Newton-Raphson.
     * */
    private static int floorSquareRootUsingSqrt(int num) {
        return (int) Math.sqrt(num);
    }

    /**
     * Time Complexity: O(1)
     * Computing logarithms and exponential are still fast, constant-time operations on primitive types.
     * Slightly slower than Math.sqrt() due to extra function calls internally (log, exp, etc.)
     * */
    private static int floorSquareRootUsingPower(int num) {
        return (int) Math.pow(num, 0.5);
    }

    /**
     * Time Complexity: O(√n)
     * */
    private static int floorSquareRootUsingLinearSolution(int num) {
        int i = 1;

        while (i * i <= num) {
            i++;
        }

        return i - 1;
    }

    /**
     * Time Complexity: O(log n)
     * Better than O(√n)
     * */
    private static int floorSquareRootUsingBinarySearch(int num) {
        int start = 0;
        int end = num;
        int ans = -1;

        while (start <= end) {
            int mid = (start + end) / 2;
            int midSquare = mid * mid;

            if (midSquare == num) {
                return mid;
            } else if (midSquare > num) {
                end = mid - 1;
            } else {
                start = mid + 1;
                ans = mid;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int testCase1 = 4;
        int testCase2 = 14;
        int testCase3 = 25;

        System.out.println(floorSquareRootUsingSqrt(testCase1));
        System.out.println(floorSquareRootUsingPower(testCase1));
        System.out.println(floorSquareRootUsingLinearSolution(testCase1));
        System.out.println(floorSquareRootUsingBinarySearch(testCase1));

        System.out.println(floorSquareRootUsingSqrt(testCase2));
        System.out.println(floorSquareRootUsingPower(testCase2));
        System.out.println(floorSquareRootUsingLinearSolution(testCase2));
        System.out.println(floorSquareRootUsingBinarySearch(testCase2));

        System.out.println(floorSquareRootUsingSqrt(testCase3));
        System.out.println(floorSquareRootUsingPower(testCase3));
        System.out.println(floorSquareRootUsingLinearSolution(testCase3));
        System.out.println(floorSquareRootUsingBinarySearch(testCase3));
    }
}
