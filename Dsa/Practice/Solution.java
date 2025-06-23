package Practice;

import java.util.NoSuchElementException;

public class Solution {

    int[] heap;
    int size, cap;

    Solution(int cap){
        this.cap = cap;
        this.size = 0;
        this.heap = new int[cap];
    }

    int getParentIndex(int i){ return (i - 1)/2; }
    int getLeftIndex(int i){return 2 * (i + 1);}
    int getRightIndex(int i){return 2 * (i + 2);}

    boolean hasParent(int i){return size > 0;}
    boolean hasLeft(int i){ return getLeftIndex(i) < size;}
    boolean hasRight(int i){return getRightIndex(i) < size;}

    int Parent(int i){return heap[getParentIndex(i)];}
    int Right(int i){return heap[getRightIndex(i)];}
    int Left(int i){return heap[getLeftIndex(i)];}

    void heapfyUp(){
        int index = size - 1;

        while (hasParent(index) && Parent(index) < heap[index]) {
            swap(getParentIndex(index), index);
            index = getParentIndex(index);
        }
    }

    void swap(int i, int j){
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    void heapfyDown(){
        int index = 0;
        while (hasLeft(index)) {
            int largest = getLeftIndex(index);

            if (hasRight(index) && Right(index) > Left(index)) {
                largest = getRightIndex(largest);
            }

            if(heap[index] > heap[largest]){break;}
            else{swap(index, largest);}
            largest = index;
        }
    }

    void insert(int val){
        if (size == cap) {
            System.out.println("Heap is Full");
        }

        heap[size] = val;
        size++;
        heapfyUp();
    }

    int extractMin(){
        if (size == 0) {
            System.out.println("Heap is empty");
        }
        int min = heap[0];
        heap[0] = heap[size - 1];
        size--;
        heapfyDown();
        return min;
    }

     public int peek() {
        if (size == 0) {System.out.println("Heap is empty");}
        return heap[0];
    }

    public static void main(String[] args) {

        Solution obj = new Solution(5);
        int[] arr = {1,4,3,5,2};

       for (int num : arr) {
            obj.insert(num);
            if (obj.size > 3) {
                obj.extractMin();
            }
        }

        for (int i = 0; i < obj.size; i++) {
            System.out.println("Heap --> " + obj.heap[i]);
        }

    }
}