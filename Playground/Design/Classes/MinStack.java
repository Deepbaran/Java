import java.util.Stack;

class Node {
    public int val;
    public Node next;
    public Node prev;

    public Node(int val) {
        this.val = val;
    }
}

public class MinStack {
    /*
     * void push
     * void pop
     * int top
     * int getMin -> Retrieve minimum element in the stack
     * 
     * Implement all with O(1)
     */

    private Stack<Integer> s = new Stack<>();
    private Node mh;
    private Node mt;

    public MinStack() {

    }

    public void push(int val) {
        s.push(val);
        Node newNode = new Node(val);
        if (mh == null) {
            mh = newNode;
            mt = newNode;
        } else {
            if (val <= mh.val) {
                newNode.next = mh;
                mh.prev = newNode;
                mh = newNode;
            } else {
                mt.next = newNode;
                newNode.prev = mt;
                mt = newNode;
            }
        }
    }

    public void pop() {
        int val = s.peek();
        s.pop();
        if (mh.val == val) {
            mh = mh.next;
        } else {
            mt = mt.prev;
        }
    }

    public int top() {
        return s.peek();
    }

    public int getMin() {
        return mh.val;
    }
}
