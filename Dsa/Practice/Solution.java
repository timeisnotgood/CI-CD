package Practice;

public class Solution {

    int[] heap;
    int size, cap;

    Solution(int cap){
        this.cap = cap;
        this.size = 0;
        this.heap = new int[cap];
    }

    int parentIndex(int i){return (i - 1) /2;}
    int leftIndex(int i){return (i*2) + 1;}
    int rightIndex(int i){return (i*2) + 2;}

    Boolean hasParent(int i){return parentIndex(i) >= 0;}
    Boolean hasLeft(int i){return leftIndex(i) < size;}
    Boolean hasRight(int i){return rightIndex(i) < size;}

    int parent(int i){return heap[parentIndex(i)];}
    int left(int i){return heap[leftIndex(i)];}
    int right(int i){return heap[rightIndex(i)];}

    void swap(int i, int j){
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    void heapfyUp(){
        int index = size - 1;

        while (hasParent(index) && parent(index) > heap[index]) {
            swap(parentIndex(index), index);
            index = parentIndex(index);
        }
    }

    void heapfyDown(){
        int index = 0;

        while (hasLeft(index)) {
            int smallestValue = leftIndex(index);

            if (hasRight(index) && right(index) < left(index)) {
                smallestValue = rightIndex(index);
            }

            if (heap[index] <= heap[smallestValue]) {
                break;
            }else{
                swap(index, smallestValue);
            }
            index = smallestValue;
        }
    }

    void insert(int val){
        if (size == cap) {
            System.out.println("Heap is Full !! ");
            return;
        }

        heap[size] = val;
        size++;
        heapfyUp();
    }

    int extractMin(){
        if (size == 0) {
            System.out.println("Heap is empty !!");
            return -1;
        }

        int deleted = heap[0];
        heap[0] = heap[size - 1];
        size--;
        heapfyDown();
        return deleted;
    }
}