package DataStructures.Stack.PracticeProblems;

public class ImplementKStacksInAnArray {

    /// Problem Statement:
    /// Implement K stacks in a single array of size n, such that all stacks can grow dynamically and efficiently
    /// utilize the space.
    ///
    /// Time and Space Complexity
    /// Time: O(1) for both push and pop.
    /// Space: O(n + k) for all arrays (arr, top, next).

    public static void main(String[] args) {
        KStack ks = new KStack(3, 10);  // 3 stacks in an array of size 10

        ks.push(15, 2);
        ks.push(45, 2);

        ks.push(17, 1);
        ks.push(49, 1);
        ks.push(39, 1);

        ks.push(11, 0);
        ks.push(9, 0);
        ks.push(7, 0);

        System.out.println("Popped element from stack 2 is " + ks.pop(2));
        System.out.println("Popped element from stack 1 is " + ks.pop(1));
        System.out.println("Popped element from stack 0 is " + ks.pop(0));
    }

    static class KStack {
        int[] arr; // Stores actual content
        int[] top; // Stores indexes of top elements of stacks
        int[] next; // Helps in maintaining next entry for stack and free list
        int k, n;
        int free; // Beginning index of free list


        public KStack(int n, int k) {
            this.n = n;
            this.k = k;
            arr = new int[n];
            top = new int[k];
            next = new int[n];

            // Initialize all stacks as empty
            for (int i = 0; i < k; i++)
                top[i] = -1;

            // Initialize all spaces free
            free = 0;
            for (int i = 0; i < n - 1; i++)
                next[i] = i + 1;
            next[n - 1] = -1; // Last element points to -1
        }

        // Check if there is a free space
        public boolean isFull() {
            return free == -1;
        }

        // Push item onto stack number sn (0-based index)
        public void push(int item, int sn) {
            if (isFull()) {
                System.out.println("Stack Overflow");
                return;
            }

            int i = free; // Get the first free index
            free = next[i]; // Update free to next free slot

            arr[i] = item; // Put the item at free slot
            next[i] = top[sn]; // Link the new element to the previous top
            top[sn] = i; // Update top to new element index
        }

        // Pop from stack number sn
        public int pop(int sn) {
            if (isEmpty(sn)) {
                System.out.println("Stack Underflow");
                return -1;
            }

            int i = top[sn]; // Index of top element in stack 'sn'
            top[sn] = next[i]; // Update top to next of previous top

            next[i] = free; // Add this index to free list
            free = i;

            return arr[i];
        }

        // Check if specific stack is empty
        public boolean isEmpty(int sn) {
            return top[sn] == -1;
        }
    }

}
