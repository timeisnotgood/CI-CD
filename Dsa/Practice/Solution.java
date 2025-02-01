package Practice;

import java.util.Arrays;

public class Solution {

    int heap[];
    int size;
    int capacity;

    Solution(int cap){
        this.capacity = cap;
        this.size = 0;
        this.heap = new int[cap];
    }

    // get Index's

    int getPrentIndex(int index){ return (index - 1) / 2; }
    int getLeftIndex(int index){ return 2 * index + 1;}
    int getRightIndex(int index){ return 2 * index + 2;}

    // Check Element Exist

    Boolean hasParent(int index){ return getPrentIndex(index) >= 0;}
    Boolean hasLeftChild(int index){ return getLeftIndex(index) < size;}
    Boolean hasRightChild(int index){ return getRightIndex(index) < size;}

    // get Element's

    int Parent(int index){return heap[getPrentIndex(index)];}
    int Left(int index){return heap[getLeftIndex(index)];}
    int Right(int index){return heap[getRightIndex(index)];}

    void swap(int left, int right){
        int temp = heap[left];
        heap[left] = heap[right];
        heap[right] = temp; 
    }

    void hasCapacity(){
        this.heap = Arrays.copyOf(heap, capacity * 2);
        this.capacity *= 2;
    }

    void heapfyUp(){
        int index = size - 1;
        while(hasParent(index) && Parent(index) > heap[index]) {
            swap(getPrentIndex(index), index);
            index = getPrentIndex(index);
        }
    }

    void heaphyDown(){
        int index = 0;
        while (hasLeftChild(index)) {
            int smallestChildIndex  = getLeftIndex(index);
            if (hasRightChild(index) && Right(index) < Left(index)) {
                smallestChildIndex = getRightIndex(index);
            }
            if (heap[index] < heap[smallestChildIndex]) {
                break;
            }else {
                swap(index, smallestChildIndex);
                index  = smallestChildIndex;
            }
        }
    }

    void insert(int val){
        hasCapacity();
        this.heap[size] = val;
        this.size += 1;
        heapfyUp();
    }

    int extractMin(){
        if (size == 0) {
            throw new IllegalStateException("Heap is empty");
        }

        int min = heap[0];
        heap[0] = heap[size - 1];
        size --;
        heaphyDown();
        return min;
    }

    // Print the heap
    public void printHeap() {
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + " ");
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

        System.out.println("Heap before insertions:");
        Heap.printHeap();

        System.out.println("Extraction :  " + Heap.extractMin());

        System.out.println("Heap after insertions:");
        Heap.printHeap();
    }
}