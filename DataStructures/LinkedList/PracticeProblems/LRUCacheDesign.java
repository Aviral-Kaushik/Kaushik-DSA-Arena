package DataStructures.LinkedList.PracticeProblems;

import java.util.HashMap;
import java.util.Map;

public class LRUCacheDesign {

    /// LRU Cache Design -> Least Recently Used Cache Design
    /// This memory design system works on the basis that element once access can be accessed in near future again.
    /// So, once the element is accessed we put that in cache so on the next time it is accessed and if it is present
    /// in cache memory that item is returned from the cache otherwise it is searched in the memory.
    /// So, cache has a limited size so when the cache memory becomes full we need to make cache empty. So, when the
    /// cache becomes full & we need to insert the element in it, so we have to remove the element which is least accessed.
    /// (Least Recent Used Element).

    /// And our task is to design such a cache system using linked lists.

    /// Input: Cache Size: 4, Reference Sequence: 10, 20, 10, 30, 40, 50, 30, 40, 60, 30
    /// So, for that we will keep the most recent element at the head so when we have to remove an element we just have
    /// to remove last element.

    /// Case Definitions:
    /// Hit: Element is found in the cache.
    /// Miss: Element not found in the cache.

    /// If we use an array to design LRU Cache Design:
    /// Hit Case: O(n)
    /// Miss Case: O(n)

    /// If we use a doubly linked list + hashing (for better complexities) to design LRU Cache Design:
    /// Hit Case: O(1)
    /// Miss Case: O(1)

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);

        cache.put(1, 1);
        cache.put(2, 2);

        cache.get(1); // returns 1
        System.out.println(cache.get(1));     // returns 1

        cache.put(3, 3);  // evicts key 2

        cache.get(2);     // returns -1 (not found)
        System.out.println(cache.get(2));     // returns -1 (not found)

        cache.put(4, 4);  // evicts key 1

        cache.get(1);     // returns -1 (not found)
        System.out.println(cache.get(1));     // returns -1 (not found)

        cache.get(3);     // returns 3
        System.out.println(cache.get(3));     // returns 3
        
        cache.get(4);     // returns 4
        System.out.println(cache.get(4));     // returns 4
    }

}

class LRUCache {

    static class Node {
        int key, value;
        Node prev, next;
        Node(int k, int v) {
            key = k;
            value = v;
        }
    }

    private final int capacity;
    private final Map<Integer, Node> map;
    private final Node head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node(0, 0); // Dummy Head
        tail = new Node(0, 0); // Dummy Tail
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        Node node = map.get(key);
        remove(node);
        insertToFront(node);

        return node.value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            remove(map.get(key));
        }

        if (map.size() == capacity) {
            remove(tail.prev);
        }

        insertToFront(new Node(key, value));
    }

    private void insertToFront(Node node) {
        map.put(node.key, node);
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    private void remove(Node node) {
        map.remove(node.key);

        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}
