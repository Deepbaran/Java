public class SimpleStack {
    /*
     * isEmpty
     * size
     * peek -> top
     * push
     * pop
     */

    public static class SimpleStackUsingArray {
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

    public static class SimpleStackUsingLL {

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
}
