package DataStructures.Deque.PracticeProblem;

import java.util.ArrayDeque;
import java.util.Deque;

public class FirstCircularTour {

    /// Problem Statement:
    /// In this problem, we have n petrol pumps arranges in a circular manner, and we have given 2 arrays in which first
    /// array represents the petrol available at each petrol pump and other array represents distance between each
    /// petrol pump.
    /// Imagine that you have a truck (with infinite capacity of petrol) and this truck will take 1 unit of petrol to
    /// travel 1 unit of distance.
    /// And our task to find out a petrol pump in which we can start and come back to the same petrol pump without running
    /// out of the petrol. And we can refuel the units of petrol by the petrol pump that comes in the between of route.
    /// Otherwise, return -1.

    /// Input: petrol[] = {4, 8, 7, 4}, dist[] = {6, 5, 3, 5}
    /// So, petrol pump 1 has 4 liters of petrol.
    ///     petrol pump 2 has 8 liters of petrol.
    ///     petrol pump 3 has 7 liters of petrol.
    ///     petrol pump 4 has 4 liters of petrol.
    /// And, Distance between petrol pump 1 and 2 is 6.
    ///      Distance between petrol pump 2 and 3 is 5.
    ///      Distance between petrol pump 3 and 4 is 3.
    ///      Distance between petrol pump 4 and 1 is 5. (Circular Array)

    /// Output: 2 (Second Petrol Pump)

    /**
     * Naive Method
     * Time Complexity: O(n ^ 2)
     * Space Complexity: O(1)
     * */
    private static int firstPetrolPumpUsingNaiveMethod(int[] petrol, int[] distance) {
        for (int start = 0; start < petrol.length; start++) {
            int currentPetrol = 0;
            int end = start;

            while (true) {
                currentPetrol += (petrol[end] - distance[end]);

                if (currentPetrol < 0)
                    break;

                end = (end + 1) % petrol.length;

                if (end == start)
                    return start + 1;
            }
        }

        return -1;
    }

    /**
     * Better Method (Using Deque)
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * */
    private static int firstPetrolPumpUsingDeque(int[] petrol, int[] dist) {
        int n = petrol.length;
        Deque<Integer> deque = new ArrayDeque<>();

        int start = 0, end = 0, currPetrol = 0;

        while (deque.size() < n) {
            currPetrol += petrol[end] - dist[end];
            deque.addLast(end);

            // If currPetrol is negative, move start forward
            while (currPetrol < 0 && !deque.isEmpty()) {
                int removeIdx = deque.pollFirst();
                currPetrol -= petrol[removeIdx] - dist[removeIdx];
                start = removeIdx + 1;

                if (start >= n) return -1;  // Can't complete the circle
            }

            end = (end + 1) % n;
            if (start == 0 && deque.size() == n) break;
        }

        return deque.size() == n ? start + 1 : -1;
    }

    /**
     * Efficient Method
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * */
    private static int firstPetrolPumpUsingEfficientMethod(int[] petrol, int[] dist) {
        int start = 0, currentPetrol = 0;
        int prevPetrol = 0;

        for (int i = 0; i < petrol.length; i++) {
            currentPetrol += petrol[i] - dist[i];

            if (currentPetrol < 0) {
                start = i + 1;
                prevPetrol += currentPetrol;
                currentPetrol = 0;
            }
        }

        return (currentPetrol + prevPetrol) > 0 ? start + 1 : -1;
    }

    public static void main(String[] args) {
        int[] testCase1Petrol = {4, 8, 7, 4};
        int[] testCase1Dist = {6, 5, 3, 5};

        int[] testCase2Petrol = {4, 8};
        int[] testCase2Dist = {5, 6};

        int[] testCase3Petrol = {8, 9, 4};
        int[] testCase3Dist = {5, 10, 12};

        int[] testCase4Petrol = {50, 10, 60, 100};
        int[] testCase4Dist = {30, 20, 100, 10};

        System.out.println(firstPetrolPumpUsingNaiveMethod(testCase1Petrol, testCase1Dist));
        System.out.println(firstPetrolPumpUsingDeque(testCase1Petrol, testCase1Dist));
        System.out.println(firstPetrolPumpUsingEfficientMethod(testCase1Petrol, testCase1Dist));

        System.out.println(firstPetrolPumpUsingNaiveMethod(testCase2Petrol, testCase2Dist));
        System.out.println(firstPetrolPumpUsingDeque(testCase2Petrol, testCase2Dist));
        System.out.println(firstPetrolPumpUsingEfficientMethod(testCase2Petrol, testCase2Dist));

        System.out.println(firstPetrolPumpUsingNaiveMethod(testCase3Petrol, testCase3Dist));
        System.out.println(firstPetrolPumpUsingDeque(testCase3Petrol, testCase3Dist));
        System.out.println(firstPetrolPumpUsingEfficientMethod(testCase3Petrol, testCase3Dist));

        System.out.println(firstPetrolPumpUsingNaiveMethod(testCase4Petrol, testCase4Dist));
        System.out.println(firstPetrolPumpUsingDeque(testCase4Petrol, testCase4Dist));
        System.out.println(firstPetrolPumpUsingEfficientMethod(testCase4Petrol, testCase4Dist));
    }

}
