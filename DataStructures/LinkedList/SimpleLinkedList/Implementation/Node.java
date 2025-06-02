package DataStructures.LinkedList.SimpleLinkedList.Implementation;

public class Node {
    int data;
    public Node next; // Null By default

    public Node(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }
}
