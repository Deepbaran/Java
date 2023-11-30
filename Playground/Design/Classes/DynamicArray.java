public class DynamicArray {

    // For ease of implementation, we assume that arr is a positive integer array.
    // This means it contains values >= 0
    private int[] arr;
    private int capacity;
    private int size;

    public DynamicArray(int capacity) {
        this.capacity = capacity;
        this.arr = new int[capacity];
    }

    public int get(int i) {
        // Return the element at index i
        // If nothing exists, return -1

        if (i < this.capacity) {
            return this.arr[i];
        }
        return -1;
    }

    public void set(int i, int n) {
        // Set the value n, at index i of the array

        if (i < this.capacity) {
            this.arr[i] = n;
        }
    }

    public void pushback(int n) {
        // Add the element at the end of the array

        if (this.size == this.capacity) {
            this.resize();
        }
        this.arr[this.size] = n;
        this.size++;
    }

    public int popback() {
        // Remove the last element of the array

        this.size--;
        return arr[this.size];
    }

    public int getSize() {
        // Return the size / number of elements in the array

        return this.size;
    }

    public int getCapacity() {
        // Return the total capacity of the array

        return this.capacity;
    }

    private void resize() {
        // If the current size of the array is filled, then double the size of it.
        this.capacity *= 2;
        int[] arr = new int[this.capacity];
        for (int i = 0; i < this.arr.length; i++) {
            arr[i] = this.arr[i];
        }
        this.arr = arr;
    }
}