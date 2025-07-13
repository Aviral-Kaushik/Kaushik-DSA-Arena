package DataStructures.Queue.Utils;

import java.util.Queue;

public class PrintQueue {

    public static void printQueue(Queue<Integer> queue) {
        while (!queue.isEmpty()) {
            System.out.print(queue.poll() + " ");
        }
    }
}
