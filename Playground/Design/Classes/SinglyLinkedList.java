import java.util.*;

class Node {
    public int val;
    public Node next;
}

public class SinglyLinkedList {

    private Node head;
    private int size;

    public SinglyLinkedList() {
        this.size = 0;

    }

    public int get(int index) {
        if (index >= this.size) {
            return -1;
        } else if (index == 0) {
            return this.head.val;
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
        } else {
            newNode.next = this.head;
            this.head = newNode;
        }
        this.size++;
    }

    public void insertTail(int val) {
        Node newNode = new Node();
        newNode.val = val;
        if (this.size == 0) {
            this.head = newNode;
        }
        Node temp = this.head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        this.size++;
    }

    public boolean remove(int index) {
        if (index >= this.size) {
            return false;
        }
        if (index == 0) {
            this.head = this.head.next;
            this.size--;
            return true;
        }
        Node temp = this.head;
        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
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
