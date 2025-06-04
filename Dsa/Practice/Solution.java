package Practice;

public class Solution {

    int[] heap;
    int cap, size;

    Solution(int cap){
        this.cap = cap;
        this.size = 0;
        this.heap = new int[cap];
    }

    int getParentIndex(int i) {return (i - 1) /2;}
    int getLeftIndex(int i) {return 2 * i + 1;}
    int getRightIndex(int i) {return 2 * i + 2;}

    boolean hasParent(int i){return getParentIndex(i) >= 0;}
    boolean hasLeft(int i){return getLeftIndex(i) < size;}
    boolean hasRight(int i){return getRightIndex(i) < size;}

    int Parent(int i){return heap[getParentIndex(i)];}
    int Left(int i){return heap[getLeftIndex(i)];}
    int Right(int i){return heap[getRightIndex(i)];}

    void swap(int i, int j){
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    void heapfyUp(){
        int index = size - 1;

        while (hasParent(index) && Parent(index) > heap[index]) {
            swap(getParentIndex(index), index);
            index =getParentIndex(index);
        }
    }

    void heapfyDown(){
        int index= 0;

        while (hasLeft(index)) {
            int smallest = getLeftIndex(index);

            if (hasRight(index) && Right(index) < Left(index)) {
                smallest = getRightIndex(index);
            }

            if (heap[index] < heap[smallest]) {
                break;
            }else{
                swap(index, smallest);
            }
            index = smallest;
        }
    }


    void insert(int val){
        if (size == cap) {
            System.out.println("Heap is Bull");
            return;
        }

        heap[size] = val;
        size++;
        heapfyUp();
    }

    void findFsmallest(int[] arr, int k){
        Solution heap = new Solution(10);

        for (int num : arr) {
            heap.insert(num);
            if (heap.size > k) {
                // heap.extractMin();
            }
        }

        for (int i = 0; i < heap.size; i++) {
            System.out.println("Heap --> " + heap.heap[i]);
        }
    }

    void leftRotate(int arr[], int k) {
        for (int j = 0; j <= k; j++) {
           int num = arr[0];
           for (int i = 0; i < arr.length; i++) {
               if(i == arr.length - 1){
                   arr[i] = num;

                   break;
               }
               arr[i] = arr[i + 1];
           }
       }
    }


    void leftRotates(int arr[], int k) {
        int n = arr.length;
        k %= n;
        if (k == 0) return;
        rev(arr, 0, k - 1);
        rev(arr, k, n - 1);
        rev(arr, 0, n - 1);
    }

    private void rev(int a[], int low, int high) {
        while (low < high) {
            swap(a, low++, high--);
        }
    }

    private void swap(int a[], int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        Solution obj = new Solution(10);
        int[] arr = {1,2,3,4,5,6};
        obj.leftRotate(arr, 2);
    }


}