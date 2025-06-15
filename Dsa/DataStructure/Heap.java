package DataStructure;

class Heap {

    int heap[];
    int cap, size;

    Heap(int cap){
        this.cap = cap;
        this.size = 0;
        this.heap = new int[cap];
    }

    int getParentIndex(int i){return (i - 1) / 2;}
    int getLeftIndex(int i){return 2 * i + 1;}
    int getRightIndex(int i){return 2 * i + 2;}

    boolean hasParent(int i){return getParentIndex(i) >= 0;}
    boolean hasLeft(int i){return getLeftIndex(i) < size;}
    boolean hasRight(int i){return getRightIndex(i) < size;}

    int Parent(int i){return heap[getParentIndex(i)];}
    int RightChild(int i){return heap[getRightIndex(i)];}
    int LeftChild(int i){return heap[getLeftIndex(i)];}

    void swap(int i, int j){
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    void heapfyUp(){
        int index = size - 1;
        while (hasParent(index) && Parent(index) > heap[index]) {
            swap(getParentIndex(index), index);
            index = getParentIndex(index);
        }
    }

    void heapDown(){
        int index = 0;
        while (hasLeft(index)) {

            int smallest = getLeftIndex(index);
            if(hasRight(index) && RightChild(index) < LeftChild(index)){
                smallest = getRightIndex(index);
            }

            if(heap[index] < heap[smallest]){break;}
            else{swap(index, smallest);}
            index = smallest;
        }
    }

    void insert(int val){
        if(size == cap){
            System.out.println("Heap is Full!!");
            return;
        }
        heap[size] = val;
        size++;
        heapfyUp();
    }

    void extractMin(){
        if (size == 0) {
            System.out.println("Heap is Empty !!");
            return;
        }

        heap[0] = heap[size - 1];
        size--;
        heapDown();
    }


    public static void main(String[] args) {
        System.out.println("sdsdffsd ---->");

        Heap priorityQueue = new Heap(10);
        priorityQueue.insert(3);
        priorityQueue.insert(1);
        priorityQueue.insert(2);
        priorityQueue.insert(5);
        priorityQueue.insert(4);
        priorityQueue.insert(8);

        for(int num : priorityQueue.heap){
            System.out.println("-------> "+ num);
        }
    }    
}
