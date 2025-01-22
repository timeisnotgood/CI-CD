package Practice;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Heap {
    
    int capacity, size, heap[];

    Heap(int cap){
        this.capacity = cap;
        this.size = 0;
        this.heap = new int[capacity];
    }

    // getindex of Node

    int getparentIndex(int index){return (index -1) / 2;}
    int leftChildIndex(int index){return 2 * index + 1;}
    int rightChildIndex(int index){return 2 * index + 2;}


    //check if the node is present

    boolean hasParent(int index){return getparentIndex(index) >= 0;}
    boolean hasLeft(int index){return leftChildIndex(index) < size;}
    boolean hasright(int index){return rightChildIndex(index) < size;}

    //value of the Node

    int parent(int index){return heap[getparentIndex(index)];}
    int right(int index){return heap[rightChildIndex(index)];}
    int left(int index){return heap[leftChildIndex(index)];}

    void hasCapacity() {
        if (size == capacity) {
            heap = Arrays.copyOf(heap, capacity * 2);
            capacity *= 2;
        }
    }

    void swap(int parent, int child){
        int temp = heap[parent];
        heap[parent] = heap[child];
        heap[child] = temp;
    }

    void heapifyUp(){
        int index = size -1;
        while (hasParent(index) && parent(index) > heap[index]) {
            swap(getparentIndex(index), index);
            index = getparentIndex(index);
        }
    }

    void heapifyDown(){
        int index = 0;
        while (hasLeft(index)) {
            int smallestValue = leftChildIndex(index);
            if (hasright(index) && right(index) < left(index)) {
                smallestValue = rightChildIndex(index);
            }
            if (heap[index] < heap[smallestValue]) {break;}
            else{swap(index, smallestValue);}
            index = smallestValue;
        }
    }

    int extractMin(){
        if (size == 0) throw new IllegalStateException("Heap is Empty");
        int min = heap[0];
        heap[0] = heap[size -1];
        size--;
        heapifyDown();
        return min;
    }

    void insert(int value){
        hasCapacity();
        heap[size] = value;
        size ++;
        heapifyUp();
    }

    // // Print the heap
    // public void printHeap() {
    //     for (int i = 0; i < size; i++) {
    //         System.out.print(heap[i] + " ");
    //     }
    //     System.out.println();
    // }


    public static void main(String[] args) {
        Heap minHeap = new Heap(10);

        // Insert elements into the heap
        minHeap.insert(15);
        minHeap.insert(10);
        minHeap.insert(20);
        minHeap.insert(8);

        // Extract the minimum element
        System.out.println("Extracted Min: " + minHeap.extractMin());
        System.out.println("Heap after ---->");
        minHeap.printHeap();
    }
}
