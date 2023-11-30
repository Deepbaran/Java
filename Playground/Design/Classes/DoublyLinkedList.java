import java.util.*;

class Node {
    public int val;
    public Node next;
    public Node prev;
}

public class DoublyLinkedList {

    private Node head;
    private Node tail;
    private int size;

    public DoublyLinkedList() {
        this.size = 0;

    }

    public int get(int index) {
        if (index >= this.size) {
            return -1;
        } else if (index == 0) {
            return this.head.val;
        } else if (index == this.size - 1) {
            return this.tail.val;
        }
        Node temp = this.head;
        for (int i = 1; i <= index; i++) {
            temp = temp.next;
        }
        return temp.val;

    }

    public void insertHead(int val) {
        Node newNode = new Node();
        newNode.val = val;
        if (this.size == 0) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            newNode.next = this.head;
            this.head.prev = newNode;
            this.head = newNode;
        }
        this.size++;
    }

    public void insertTail(int val) {
        Node newNode = new Node();
        newNode.val = val;
        if (this.size == 0) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            this.tail.next = newNode;
            newNode.prev = this.tail;
            this.tail = newNode;
        }
        this.size++;
    }

    public boolean remove(int index) {
        if (index >= this.size) {
            return false;
        }
        if (index == 0) {
            this.head = this.head.next;
            this.head.prev = null;
            return true;
        } else if (index == size - 1) {
            this.tail = this.tail.prev;
            this.tail.next = null;
        } else {
            Node temp = this.head;
            for (int i = 1; i < index; i++) {
                temp = temp.next;
            }
            Node node = temp.next.next;
            node.prev = node.prev.prev;
            temp.next = temp.next.next;
        }
        this.size--;
        return true;

    }

    public ArrayList<Integer> getValues() {
        ArrayList<Integer> list = new ArrayList<>();
        Node temp = this.head;
        for (int i = 0; i < this.size; i++) {
            list.add(temp.val);
            temp = temp.next;
        }
        return list;

    }

}
