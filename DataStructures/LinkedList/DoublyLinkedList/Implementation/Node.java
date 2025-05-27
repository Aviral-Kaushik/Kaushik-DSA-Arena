package DataStructures.LinkedList.DoublyLinkedList.Implementation;

public class Node {
    int data;
    public Node prev; // Null by Default
    public Node next; // Null by Default

    public Node(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }
}
