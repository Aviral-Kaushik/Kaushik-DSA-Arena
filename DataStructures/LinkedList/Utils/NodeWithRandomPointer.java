package DataStructures.LinkedList.Utils;

public class NodeWithRandomPointer {

    private int data;
    public NodeWithRandomPointer next;
    public NodeWithRandomPointer random;

    public NodeWithRandomPointer(int data) {
        this.data = data;
    }

    public NodeWithRandomPointer getNext() {
        return next;
    }

    public void setNext(NodeWithRandomPointer next) {
        this.next = next;
    }

    public NodeWithRandomPointer getRandom() {
        return random;
    }

    public void setRandom(NodeWithRandomPointer random) {
        this.random = random;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }
}
