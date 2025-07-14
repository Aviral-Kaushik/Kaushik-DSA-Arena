package DataStructures.Deque.Implementation;

import java.util.ArrayDeque;
import java.util.Deque;

public class DequeUsingArrayDeque {

    public static void main(String[] args) {
        Deque<Integer> deque = new ArrayDeque<>();

        deque.addFirst(10);  // insert at front
        deque.addLast(20);   // insert at rear
        deque.offerFirst(5); // safe add at front
        deque.offerLast(25); // safe add at rear

        System.out.println(deque.peekFirst()); // 5
        System.out.println(deque.peekLast()); // 25

        deque.removeFirst(); // removes 5
        deque.removeLast(); // removes 25

        System.out.println(deque); // [10, 20]
    }

}
