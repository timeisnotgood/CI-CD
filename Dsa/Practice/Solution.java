package Practice;

public class Solution {

    int[] heap;
    int size;
    int cap;

    Solution(int cap){
        this.cap = cap;
        this.size = 0;
        this.heap = new int[cap];
    }

    int getParentIndex(int i){return (i - 1) / 2;}
    int getLeftIndex(int i){return (i + 1) * 2;}
    int getRightIndex(int i){return (i + 2) * 2;}

    int parent(int i){return heap[getParentIndex(i)];}
    int left(int i){return heap[getLeftIndex(i)];}
    int right(int i){return heap[getRightIndex(i)];}

    boolean hasParent(int i){return getParentIndex(i) >= 0;}
    boolean hasLeft(int i){return getLeftIndex(i) < size;}
    boolean hasRight(int i){return getRightIndex(i) < size;}

    void swap(int i, int j){
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    void heapfyUp(){
        int index = size - 1;
        while (hasParent(index) && parent(index) > heap[index]) {
            swap(getParentIndex(index), index);
            index = getParentIndex(index);
        }
    }

    void heapDown(){
        int index = 0;
        while (hasLeft(index)) {
            int smallest = getLeftIndex(index);
            if (hasRight(index) && right(index) < left(index)) {
                smallest = getRightIndex(index);
            }
            if (heap[index] > heap[smallest]) {break;}
            else{swap(index, smallest);}
            index = smallest;
        }
    }

    void insert(int val){
        if (size == cap) {
            System.out.println("heap is Bull");
            return;
        }

        heap[size] = val;
        size++;
        heapfyUp();
    }

    void extractMin(){
        if (size == 0) {
            System.out.println(" Heap is Empty !!");
            return;
        }

        int deleted = heap[0];
        heap[0] = heap[size - 1];
        size--;
        heapDown();
    }

    void findKsmallestElement(int[] arr, int k){
        Solution heap = new Solution(k);

       for(int num : arr){
            heap.insert(num);
            if (heap.size > k) {
                extractMin();
            }
       }
        for(int i = 0; i < heap.size; i++){
            System.out.println("- >  " + heap.heap[i]);
        }
    }

    // Print the heap
    public void printHeap() {
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Solution obj = new Solution(10);
        int[] arr = {10, 3, 5, 7, 6, 2, 8, 1, 9};
        obj.findKsmallestElement(arr, 3);
    }
}