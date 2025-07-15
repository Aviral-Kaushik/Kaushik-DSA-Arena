package DataStructures.Deque.PracticeProblem;

import java.util.ArrayDeque;
import java.util.Deque;

public class DataStructureWithMinAndMaxOperations {

    /// Problem Statement:
    /// In this problem, we have to design a data structure which also supports the following operations: insertMax(x),
    /// insertMin(x), getMin(), getMax(), extractMin(), extractMax().

    /// insertMin(x): operation can assume that item to be inserted is smaller than existing items.
    /// insertMax(x): operation can assume that item to be inserted is greater than existing items.
    /// extractMin(): this operation should remove current minimum element.
    /// extractMax(): this operation should remove current maximum element.

    private final Deque<Integer> mDeque = new ArrayDeque<>();

    public void insetMin(int data) {
        mDeque.offerFirst(data);
    }

    private void insertMax(int data) {
        mDeque.offerLast(data);
    }

    private Integer getMin() {
        return mDeque.peekFirst();
    }

    private Integer getMax() {
        return mDeque.peekLast();
    }

    private Integer extractMin() {
        return mDeque.pollFirst();
    }

    private Integer extractMax() {
        return mDeque.pollLast();
    }

}
