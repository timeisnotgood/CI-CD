package Practice;

import java.util.ArrayList;

public class StackLinkedList {

    static class LinkedList {
        int data;
        LinkedList next;
    
        LinkedList(int x) {
            this.data = x;
            this.next = null;
        }
    
    
    }

    LinkedList top;
    int size ;

    StackLinkedList() {
        top = null;
        size = 0;
    }

    void Push(int x){
        LinkedList newNode = new LinkedList(x);
        newNode.next = top;
        top = newNode;
        size += 1;
    }

    void Pop(){
        if (top == null) {
            System.out.println("No element to Delete");
            return;
        }
        top = top.next;
        size -=1;
    }

    int SizeOfStack(){
        if (size == -1) {
            System.out.println("No element in Stack");
            return 0;
        }

        return size;
    }

    void GetStackElements(){
        LinkedList temp = top;

        while (temp != null) {
            System.out.println("--->"+ temp.data);
            temp = temp.next;
        }
    }

    int TopElement(){
        if (top == null) {
            System.out.println("No element to Display");
        }

        return top.data;
    }

        void mergeSort(int[] arr, int low, int high){
        if (low < high) {
            int mid = (high + low) / 2;
            mergeSort(arr, low, mid);
            mergeSort(arr, mid + 1, high);
            merge(arr, low, mid, high);
        }
    }

    void merge(int[] arr, int low, int mid, int high){
        ArrayList<Integer> list = new ArrayList<>();
        int left = low;
        int right = mid + 1;

        while (left <= mid && right <= high) {
            if (arr[left] < arr[right]) {
                list.add(arr[left]);
                left++;
            }else{
                list.add(arr[right]);
                right++;
            }
        }

        while (left <= mid) {
            list.add(arr[left]);
                left++;
        }

        while (right <= high) {
                            list.add(arr[right]);
                right++;
        }

        for (int i = low; i <= high; i++) {
            arr[i] = list.get(i - low);
        }
    }

    void swap(int[] arr, int low, int high){
        int temp = arr[low];
        arr[low] = arr[high];
        arr[high] = temp;
    }

    void quickS(int[] arr, int low, int high){
        if(low < high){
            int peviotIdx = partetio(arr, low, high);
            quickS(arr, low, peviotIdx - 1);
            quickS(arr, peviotIdx + 1, high);
        }
    }

    int partetio(int[] arr, int low, int high){
        int peviot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] < peviot) {
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i+1, high);
        return i + 1;
    }

    public static void main(String[] args) {
        StackLinkedList stk = new StackLinkedList();

        stk.Push(3);
        stk.Push(4);
        stk.Push(5);

        stk.GetStackElements();

        System.out.println(
            "-----> Top  " +
            stk.TopElement()
        );
    }
}
