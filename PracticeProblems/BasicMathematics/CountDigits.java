package PracticeProblems.BasicMathematics;

public class CountDigits {

    /**
     * Time Complexity: O(number) / O(n)
     * */
    private static int countDigits(int number) {
        if (number == 0) {
            return 1;
        }

        int count = 0;

        while (number != 0) {
            number = number / 10;
            count++;
        }

        return count;
    }

    public static void main(String[] args) {
        int count = countDigits(123);
        System.out.println("Count: " + count);
    }

}
