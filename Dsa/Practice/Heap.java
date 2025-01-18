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

    int getparentIndex(int index){
        return (index -1) / 2;
    }

    boolean hasParent(int index){
        return getparentIndex(index) >= 0;
    }

    int parent(int index){
        return heap[getparentIndex(index)];
    }

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
        if (hasParent(index) && parent(index) > heap[index]) {
            swap(getparentIndex(index), index);
            index = getparentIndex(index);
        }
    }

    void insert(int value){
        hasCapacity();
        heap[size] = value;
        size ++;
        heapifyUp();
    }

    // Print the heap
    public void printHeap() {
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        Heap hh = new Heap(10);


        hh.insert(2);
        hh.insert(3);
        hh.insert(4);
        hh.insert(5);
        hh.insert(1);

        hh.printHeap();
    }
}
