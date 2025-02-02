package Practice;

import java.util.Arrays;

public class Solution {

    int heap[];
    int size, capacity;

    Solution(int cap){
        this.capacity = cap;
        this.size = 0;
        this.heap = new int[capacity];
    }

    int getParentIndex(int index){ return (index - 1) / 2;};
    int getLeftIndex(int index){ return 2 * index + 1;};
    int getRightIndex(int index){ return 2* index + 2;};

    int Parent(int index) { return heap[getParentIndex(index)];}
    int Right(int index) { return heap[getLeftIndex(index)];}
    int Left(int index) { return heap[getRightIndex(index)];}

    Boolean hasParent(int index) { return getParentIndex(index) >= 0;}
    Boolean hasRight(int index) { return getLeftIndex(index) < size;}
    Boolean hasLeft(int index) { return getRightIndex(index) < size;}

    void Swap(int parent, int child){
        int temp = heap[parent];
        heap[parent] = heap[child];
        heap[child] = temp;
    }

    void heapifyUp(){
        int index = size - 1;
        while (hasParent(index) && Parent(index) > heap[index]) {
            Swap(getParentIndex(index), index);
            index = getParentIndex(index);
        }
    }

    void heapifyDown(){
        int index = 0;
        while (hasLeft(index)) {
            int smallestValue = getLeftIndex(index);
            if (hasRight(index) && Right(index) < Left(index)) {
                smallestValue = getRightIndex(index);
            }
            if (heap[index] > heap[smallestValue]) {
                break;
            }
            else{
                Swap(index, smallestValue);
            }
            index = smallestValue;
        }
    }

    void hasSpace(){
        if (size == capacity) {
            heap = Arrays.copyOf(heap, capacity * 2);
            capacity *= 2;
        }
    }

    void insert(int val){
        hasSpace();
        heap[size] = val;
        size ++;
        heapifyUp();
    }

    int extractMin(){
        if (size == 0) {
            System.out.println("Heap is Empty");
        }
        int index = 0;
        int min = heap[index];
        heap[index] = heap[size-1];
        size --;
        heapifyDown();
        return min;
    }

    void printHeap(){
        for (int i = 0; i < size; i++) {
            System.out.println(heap[i]+ " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Solution Heap = new Solution(10);

        // Insert elements into the heap
        Heap.insert(15);
        Heap.insert(10);
        Heap.insert(20);
        Heap.insert(8);

        System.out.println("Befor Extraction : ");
        Heap.printHeap();
        Heap.extractMin();
        System.out.println("After Extraction : ");
        Heap.printHeap();
    }
}