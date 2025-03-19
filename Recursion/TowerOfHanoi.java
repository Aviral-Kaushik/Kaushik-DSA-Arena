package Recursion;

public class TowerOfHanoi {

    /// Input: n = 3 (Where n is number of disks)
    /// Output: Move Disk 1 from A to C
    ///         Move Disk 2 from A to B
    ///         Move Disk 1 from C to B
    ///         Move Disk 3 from A to C
    ///         Move Disk 1 from B to A
    ///         Move Disk 2 from B to C
    ///         Move Disk 1 from A to C

    /// Rules: 1. Only move disk at a time.
    ///        2. No Bigger disk should be placed on smaller disk
    ///        3. Only the top disc of the tower can be moved.

    /**
     * Time Complexity: O(2^n)
     * Space Complexity: O(n)
     * */
    static void towerOfHanoi(int n, String fromTower, String auxTower, String toTower) {
        if (n == 0) {
            return;
        }

        towerOfHanoi(n - 1, fromTower, toTower, auxTower);

        System.out.println("Move Disk " + n + " from " + fromTower + " to " + toTower);

        towerOfHanoi(n - 1, auxTower, fromTower, toTower);
    }

    public static void main(String[] args) {
        towerOfHanoi(3, "A", "B", "C");
    }
}
