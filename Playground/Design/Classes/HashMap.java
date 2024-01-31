import java.util.*;

class MapNode {
    String key;
    int val;
    MapNode next;
    MapNode prev;

    public MapNode(String key, int val) {
        this.key = key;
        this.val = val;
    }
}

public class HashMap {
    // Implement the inbuilt HashFunction too

    private List<MapNode> bucket;
    private int bucketSize;

    public HashMap() {
        this.bucket = new ArrayList<>();
        this.bucketSize = 16;
        // This is the default bucket size of the internal implementation of HashMap in
        // Java

        for (int i = 0; i < this.bucketSize; i++) {
            this.bucket.add(null);
        }
    }

    public void put(String key, int value) {
        int index = this.getBucketIndex(key);
        MapNode node = new MapNode(key, value);
        if (this.bucket.get(index) == null) {
            this.bucket.add(index, node);
        } else {
            MapNode head = this.bucket.get(index);
            while (head.next != null && !head.key.equals(key)) {
                head = head.next;
            }
            if (head.key.equals(key)) {
                head.val = value;
            } else {
                head.next = node;
                node.prev = head;
            }
        }
    }

    public int get(String key) {
        int index = this.getBucketIndex(key);
        int val;
        if (this.bucket.get(index) == null) {
            return -1;
        } else {
            MapNode head = this.bucket.get(index);
            while (head != null && !head.key.equals(key)) {
                head = head.next;
            }
            if (head == null) {
                return -1;
            } else {
                val = head.val;
            }
        }
        return val;
    }

    public void remove(String key) {
        int index = this.getBucketIndex(key);
        if (this.bucket.get(index) != null) {
            MapNode head = this.bucket.get(index);
            while (head != null && !head.key.equals(key)) {
                head = head.next;
            }
            if (head != null) {
                if (head.prev == null && head.next == null) {
                    bucket.add(index, null);
                } else if (head.prev == null) {
                    bucket.add(index, head.next);
                } else if (head.next == null) {
                    MapNode prevNode = head.prev;
                    prevNode.next = null;
                    head = null;
                } else {
                    MapNode prevNode = head.prev;
                    MapNode nextNode = head.next;
                    prevNode.next = nextNode;
                    nextNode.prev = prevNode;
                    head = null;
                }
            }
        }
    }

    private int getBucketIndex(String key) {
        int index = key.hashCode();
        // Compression of the index
        return index % this.bucketSize; // Keep the index within the range.
    }
}
