package DataStructure;

import java.util.Arrays;

public class MyArray {
    private int size;      // Number of elements in the array
    private int capacity;  // Maximum size before resizing
    private int[] data;    // Internal array to store elements

    // Constructor
    public MyArray() {
        this.size = 0;
        this.capacity = 10; // Initial capacity
        this.data = new int[capacity];
    }

    // Get element at a specific index
    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        return data[index];
    }

    // Add an element to the end of the array
    public void push(int item) {
        ensureCapacity();
        data[size] = item;
        size++;
    }

    // Remove the last element
    public int pop() {
        if (size == 0) {
            throw new IllegalStateException("Array is empty");
        }
        int lastItem = data[size - 1];
        size--;
        return lastItem;
    }

    // Remove an element at a specific index
    public void delete(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        shiftItems(index);
    }

    // Ensure the array has enough capacity
    private void ensureCapacity() {
        if (size == capacity) {
            capacity *= 2; // Double the capacity
            data = Arrays.copyOf(data, capacity);
        }
    }

    // Shift elements to fill the gap after deletion
    private void shiftItems(int index) {
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
    }

    // Return the current size of the array
    public int getSize() {
        return size;
    }

    // Convert the array to a string for printing
    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(data, size));
    }

    // Main method for testing
    public static void main(String[] args) {
        MyArray myArray = new MyArray();
        myArray.push(10);
        myArray.push(20);
        myArray.push(30);
        System.out.println(myArray); // Output: [10, 20, 30]
        System.out.println(myArray.get(1)); // Output: 20
        myArray.pop();
        System.out.println(myArray); // Output: [10, 20]
        myArray.delete(0);
        System.out.println(myArray); // Output: [20]
    }
}

