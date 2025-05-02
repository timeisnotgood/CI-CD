package Algorithams;

public class HeapPrac {
    
    int heap[];
    int size;
    int maxsize;

    HeapPrac(int maxsize){
        this.maxsize = maxsize;
        this.size = 0;
        this.heap = new int[maxsize];
    }

    int parentIndex(int i) { return (i-1 / 2); };
    int leftIndex(int i) { return (i * 2) +1; };
    int rightIndex(int i) { return (i * 2) +2; };

    Boolean hasParent(int i){ return parentIndex(i) > 0;};
    Boolean hasLeft(int i){ return leftIndex(i) < size;};
    Boolean hasRight(int i){ return rightIndex(i) < size;};

    int parent(int i) {return heap[parentIndex(i)];};
    int left(int i) {return heap[leftIndex(i)];};
    int right(int i) {return heap[rightIndex(i)];};

    void swap(int i, int j){
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    void heapfyUp(){
        int i = maxsize - 1;

        while (hasParent(i) && parent(i) > heap[i]) {
            swap(parentIndex(i), i);
            i = parentIndex(i);
        }
    }

    void insert(int val){
        if (size == maxsize - 1) {
            System.out.println("Heap is Full");
        }

        heap[size] = val;
        size++;
        heapfyUp();
    }

    public static void main(String[] args) {
        HeapPrac heap = new HeapPrac(10);

        heap.insert(2);
        heap.insert(1);
        heap.insert(4);
        heap.insert(3);

    }

}
