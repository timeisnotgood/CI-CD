package Algorithams;

import java.util.ArrayList;

public class SortingSearching {

    public void mergeSort(int[] arr, int low, int high){
        if (low < high) {
            int mid = (low + high ) / 2;
            mergeSort(arr, low, mid);
            mergeSort(arr, mid + 1, high);
            merge(arr, low, mid, high);
        }
    }

    protected void merge(int[] arr, int low, int mid, int high){
        ArrayList<Integer> list = new ArrayList<>();
        int left = low;
        int right = mid + 1;

        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
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

    public void QuickSort(int[] arr, int low, int high){
        if(low < high){
            int peviot = partetion(arr, low, high);
            QuickSort(arr, low, peviot - 1);
            QuickSort(arr, peviot + 1, high);
        }
    }

    public int partetion(int[] arr, int low, int high){
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i + 1, high);
        return i + 1;
    }

    void swap(int[] arr,int i , int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    int BinarySearch(int[] arr, int k){
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) /2;

            if (arr[mid] == k) {
                return mid;
            }
             if (arr[mid] < k) {
                low = mid + 1;
            }
            
            if(arr[mid] > k){
                high = mid - 1;
            }
        }

        return -1;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        SortingSearching obj = new SortingSearching();

        System.out.println(

            obj.BinarySearch(arr, 3)
        );


        // for(int num : arr){
        //     System.out.print( num + " ");
        // }
    }
}
