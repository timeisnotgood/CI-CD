package Practice;

import java.util.Arrays;

class Heaps{
    int[] heap;
    int capacity, size;

    Heaps(int cap){
        this.capacity = cap;
        this.size = 0;
        this.heap = new int[capacity];
    }

    int getparentIndex(int i) {return (i-1)/2;}
    int getleftIndex(int i) {return 2*i + 1;}
    int getrightIndex(int i) {return 2*i + 2;}

    Boolean hasParent(int i){ return getparentIndex(i) >= 0;}
    Boolean hasLeft(int i){ return getleftIndex(i) < size;}
    Boolean hasRight(int i){ return getrightIndex(i) < size;}

    int parent(int i ){ return heap[getparentIndex(i)];}
    int left(int i ){ return heap[getleftIndex(i)];}
    int right(int i ){ return heap[getrightIndex(i)];}

    void hasCapacity(){
        if (size == capacity) {
            heap = Arrays.copyOf(heap, capacity * 2);
            capacity = capacity * 2;
        }
    }

    void swap(int parent, int child){
        int temp = heap[parent];
        heap[child] = heap[parent];
        heap[parent] = temp;
    }

    void heapifyUp(){
        int index = size - 1;

        while (hasParent(index) && parent(index) > heap[index]) {
            swap(getparentIndex(index), index);
            index = getparentIndex(index);
        }
    }

    void insert(int val){
        hasCapacity();
        heap[size] = val;
        size++;
        heapifyUp();
    }

    // Print the heap
    public void printHeap() {
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }
}
public class Solution {

    public static void main(String[] args) {
        Heap heap = new Heap(5);

        heap.insert(5);
        heap.insert(2);
        heap.insert(4);
        heap.insert(3);
        heap.insert(1);

        heap.printHeap();
    }
    
}