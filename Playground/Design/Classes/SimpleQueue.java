public class SimpleQueue {
    /*
     * isEmpty
     * size
     * peek -> front
     * add -> enQueue
     * poll -> deQueue
     */

    public class SimpleQueueUsingArray {
        private int[] queue;
        private int size;
        private int capacity;
        private int front;
        private int rear;

        public SimpleQueueUsingArray() {
            this.capacity = 10;
            this.queue = new int[this.capacity];
            this.size = 0;
            this.front = 0;
            this.rear = 0;
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
            return this.queue[0];
        }

        public int add(int val) {
            if (this.size == this.capacity) {
                return -1;
            }
            if (this.rear == this.capacity) {
                if (this.front != 0) {
                    this.rear = 0;
                } else {
                    return -1;
                }
            }
            this.queue[this.rear] = val;
            this.size++;
            this.rear++;
            return val;
        }

        public int poll() {
            if (this.isEmpty()) {
                return -1;
            }
            if (this.front == this.capacity) {
                this.front = 0;
            }
            int val = this.queue[this.front];
            this.front++;
            this.size--;
            return val;
        }
    }

    public class SimpleQueueUsingLL {

        private class Node {
            public int val;
            public Node next;

            public Node(int val) {
                this.val = val;
                this.next = null;
            }
        }

        private Node head;
        private Node tail;
        private int size;

        public SimpleQueueUsingLL() {
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

        public int add(int val) {
            Node newNode = new Node(val);
            if (this.head == null) {
                this.head = newNode;
                this.tail = newNode;
            } else {
                this.tail.next = newNode;
                this.tail = newNode;
            }
            this.size++;
            return val;
        }

        public int poll() {
            if (this.head == null) {
                return -1;
            }
            int val = this.head.val;
            this.head = this.head.next;
            this.size--;
            return val;
        }
    }
}
