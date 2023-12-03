import java.util.LinkedList;
import java.util.Queue;

public class SimpleStack {
    /*
     * isEmpty
     * size
     * peek -> top
     * push
     * pop
     */

    public class SimpleStackUsingArray {
        private int[] bucket;
        private int size;
        private int capacity;

        public SimpleStackUsingArray() {
            this.capacity = 10;
            this.size = 0;
            this.bucket = new int[this.capacity];
        }

        public boolean isEmpty() {
            if (this.size == 0) {
                return true;
            }
            return false;
        }

        public int size() {
            return this.size;
        }

        public int peek() {
            if (this.isEmpty()) {
                return -1;
            } else {
                return this.bucket[this.size - 1];
            }
        }

        public int push(int val) {
            if (this.size == this.capacity) {
                doubleBucketCapacity();
            }
            this.bucket[this.size] = val;
            this.size++;
            return val;
        }

        public int pop() {
            if (this.isEmpty()) {
                return -1;
            }
            this.size--;
            return this.bucket[this.size];
        }

        private void doubleBucketCapacity() {
            this.capacity *= 2;
            int[] newBucket = new int[this.capacity];
            for (int i = 0; i < this.size; i++) {
                newBucket[i] = this.bucket[i];
            }
            this.bucket = newBucket;
        }
    }

    public class SimpleStackUsingLL {

        private class Node {
            public int val;
            public Node next;

            public Node(int val) {
                this.val = val;
                this.next = null;
            }
        }

        private Node head;
        private int size;

        public SimpleStackUsingLL() {
            this.size = 0;
        }

        public boolean isEmpty() {
            if (this.size == 0) {
                return true;
            }
            return false;
        }

        public int size() {
            return this.size;
        }

        public int peek() {
            if (this.isEmpty()) {
                return -1;
            }
            return this.head.val;
        }

        public int push(int val) {
            Node newNode = new Node(val);
            newNode.next = this.head;
            this.head = newNode;
            return this.head.val;
        }

        public int pop() {
            if (this.size == 0) {
                return -1;
            }
            int val = this.head.val;
            this.head = this.head.next;
            return val;
        }
    }

    public class SimpleStackUsingQueue {
        private Queue<Integer> queue1;
        private Queue<Integer> queue2;
        private int size;

        public SimpleStackUsingQueue() {
            this.queue1 = new LinkedList<>();
            this.size = 0;
        }

        public boolean isEmpty() {
            return this.size == 0;
        }

        public int size() {
            return this.size;
        }

        public int push(int val) {
            // Fix the orientation of the values at the time of adding
            // With this the other functions become straight forward

            this.queue2 = new LinkedList<>();
            queue2.add(val);
            while (!queue1.isEmpty()) {
                queue2.add(queue1.poll());
            }
            queue1 = queue2;
            this.size++;
            return val;
        }

        public int pop() {
            if (this.isEmpty()) {
                return -1;
            }
            return queue1.poll();
        }

        public int peek() {
            return queue1.peek();
        }
    }
}
