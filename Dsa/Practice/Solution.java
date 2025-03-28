package Practice;

public class Solution {

    int[] heap;
    int cap, size;

    Solution(int cap){
        this.cap = cap;
        this.heap = new int[this.cap];
        this.size = 0;
    }

    int getparentIndex(int i) {return (i-1)/2;};
    int getLeftIndex(int i) {return (i*2)+1;};
    int getRightIndex(int i) {return (i*2)+2;};

    Boolean hasParent(int i) {return getparentIndex(i) >= 0;};
    Boolean hasLeft(int i) {return getLeftIndex(i) < size;};
    Boolean hasRight(int i) {return getRightIndex(i) < size;};

    int Parent(int i) {return heap[getparentIndex(i)];};
    int Left(int i) {return heap[getLeftIndex(i)];};
    int right(int i) {return heap[getRightIndex(i)];};

    void insert(int val){
        if (size + 1 == cap) {
            throw new IllegalStateException("Heap is bull");
        }

        heap[size] = val;
        size++;
        heapifyUp();
    }

    void heapifyUp(){
        int index = size - 1;

        while (hasParent(index) && Parent(index) > heap[index]) {
            swap(getparentIndex(index), index);
            index = getparentIndex(index);
        }
    }

    void swap(int i, int j){
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    int extractMin(){
        if (size  == -1) {
            throw new IllegalStateException("No element");
        }

        int deleted = heap[0];
        heap[0] = heap[size - 1];
        size--;
        heapifyDown();
        return deleted;
    }

    void heapifyDown(){
        int index = 0;

        while (hasLeft(index)) {
            int smallest = getLeftIndex(index);
            if (hasRight(index) && right(index) < Left(index)) {
                smallest = getRightIndex(index);
            }

            if (heap[index] < heap[smallest]) {break;}
            else{swap(index, smallest);}
            index = smallest;
        }
    }

    
}