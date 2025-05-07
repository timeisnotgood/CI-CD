package Practice;

public class Solution {

    int[] heap;
    int size, capacity;

    // Constructor
    public Solution(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.heap = new int[capacity];
    }

    // Helper methods for index calculation
    int parent(int i) { return (i - 1) / 2; }
    int left(int i) { return 2 * i + 1; }
    int right(int i) { return 2 * i + 2; }

    // Swap elements
    void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    // Heapify up after insert
    void heapifyUp() {
        int index = size - 1;
        while (index > 0 && heap[parent(index)] > heap[index]) {
            swap(index, parent(index));
            index = parent(index);
        }
    }

    // Heapify down after remove
    void heapifyDown() {
        int index = 0;

        while (left(index) < size) {
            int smallerChild = left(index);

            if (right(index) < size && heap[right(index)] < heap[left(index)]) {
                smallerChild = right(index);
            }

            if (heap[index] <= heap[smallerChild]) break;

            swap(index, smallerChild);
            index = smallerChild;
        }
    }

    // Insert a new value into the heap
    public void insert(int value) {
        if (size == capacity) {
            System.out.println("Heap is full!");
            return;
        }

        heap[size] = value;
        size++;
        heapifyUp();
    }

    // Remove and return the minimum value (root)
    public int poll() {
        if (size == 0) {
            System.out.println("Heap is empty!");
            return -1;
        }

        int min = heap[0];
        heap[0] = heap[size - 1];
        size--;
        heapifyDown();

        return min;
    }

    // Peek the minimum value without removing it
    public int peek() {
        if (size == 0) {
            System.out.println("Heap is empty!");
            return -1;
        }
        return heap[0];
    }

    // Check if the heap is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Print the heap
    public void printHeap() {
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }


    public static void main(String[] args) {

        Solution pq = new Solution(10);

       int[] arr = {10, 5, 20, 100, 70, 30};

       int k = 3;


       for(int num : arr){
            pq.insert(num);
            if (pq.size > k) {
                pq.poll();
            }
       }

       int[] result = new int[k];
       int i = 0;
       for(int num : pq.heap){
        result[i] = num;
       }
        
    }
}
