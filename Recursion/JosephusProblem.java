package Recursion;

public class JosephusProblem {

    /// A total of n people are standing in a circle, and you are one of them playing a game. Starting from a person,
    /// k persons will be counted in order along the circle, and the kth person will be killed. Then the next k persons
    /// will be counted along the circle, and again the kth person will be killed. This cycle will continue until only
    /// a single person is left in the circle.

    /// If there are 5 people in the circle in the order A, B, C, D, and E, you will choose k=3. Starting from A, you
    /// will count A, B and C. C will be the 3rd person and will be killed. Then you will continue counting from D, E
    /// and then A. A will be third person and will be killed.

    /// Input: n = 7, k = 3 (There are 7 persons and every 3rd person has to be killed)
    /// Output: 3

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * */
    static int getSavedPerson(int n, int k) {
        if (n == 1) {
            return 0;
        }

        return (getSavedPerson(n - 1, k) + k) % n;
    }

    public static void main(String[] args) {
        int savedPerson = getSavedPerson(7, 3);

        System.out.println(savedPerson);
    }
}
