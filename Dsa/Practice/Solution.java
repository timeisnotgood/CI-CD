package Practice;

import java.util.ArrayList;

public class Solution {

    void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // void mergeSort(int[] arr, int low, int high){
    //     if(low < high){
    //         int mid = (low+high)/2;
    //         mergeSort(arr, low, mid);
    //         mergeSort(arr, mid+1, high);
    //         merge(arr, low, mid, high);
    //     }
    // }

    // void merge(int[] arr, int low, int mid, int high){
    //     ArrayList<Integer> list = new ArrayList<>();
    //     int left = low;
    //     int right = mid + 1;

    //     while (left <= mid && right <= high) {
    //         if (arr[left] < arr[right]) {
    //             list.add(arr[left]);
    //             left++;
    //         }else{
    //             list.add(arr[right]);
    //             right++;
    //         }
    //     }

    //     while (left <= mid) {
    //         list.add(arr[left]);
    //         left++;
    //     }

    //     while (right <= high) {
    //         list.add(arr[right]);
    //         right++;
    //     }

    //     for(int i = low;i <= high;i++){
    //         arr[i] = list.get(i - low);
    //     }
    // }

    // void ses(int[] arr){
    //     int n = arr.length;

    //     for (int i = 0; i <= n - 2; i++) {
    //         int min = i;
    //         for (int j = i; j <= n - 1; j++) {
    //             if(arr[j] < arr[min]) min = j;
    //         }
    //         swap(arr, i, min);
    //     }
    // }


    // void bubble_s(int[] arr){
    //     int n = arr.length;

    //     for (int i = n - 1; i >= 1; i--) {
    //         for (int j = 0; j <= i - 1; j++) {
    //             if(arr[j] > arr[j + 1])
    //             swap(arr, j + 1, j);
    //         }
    //     }
    // }

    // void insertion_sort(int[] arr){
    //     int n = arr.length;

    //     for (int i = 0; i < n; i++) {
    //         int j = i;

    //         while (j > 0 && arr[j - 1] > arr[j]) {
    //             swap(arr, j - 1, j);
    //             j--;
    //         }
    //     }
    // }

    // void quickSort(int[] arr, int low, int high){
    //     if (low < high) {
    //         int partetionIndex = partetion(arr, low, high);
    //         partetion(arr, low, partetionIndex - 1);
    //         partetion(arr, partetionIndex + 1, high);
    //     }
    // }

    // int partetion(int[] arr, int low, int high){
    //     int peviot = arr[low];
    //     int i = low;
    //     int j = high;

    //     while (i < j) {
    //         while (arr[i] <= peviot && i<= high - 1) {
    //             i++;
    //         }
    //         while (arr[j] > peviot && j >= low + 1) {
    //             j--;
    //         }
    //         if(i < j){
    //             swap(arr, i, j);
    //         }
    //     }
    //     swap(arr, low, j);
    //     return j;
    // }

    void selectionSort(int[] arr, int n){
        for(int i = 0;i < n - 1;i++){
            int min = i;
            for(int j = i;j <= n -1;j++){
                if(arr[j] < arr[min]){
                    min = j;
                }
            }
            swap(arr, i, min);
        }
    }

    void bubbleSort(int[] arr, int n){
        for(int i = n - 1;i >= 0; i--){
            for(int j = 0;j < i;j++){
                if(arr[j] > arr[j+1]){
                    swap(arr, j+1, j);
                }
            }
        }
    }


    void insertionSort(int[] arr, int n){
        for(int i = 0; i <= n - 1;i++){
            int j = i;
            while (j > 0 && arr[j - 1] > arr [j]) {
                swap(arr, j - 1, j);
                j--;
            }
        }
    }



    void mergeSort(int[] arr, int low, int high){
        if (low < high) {
            int mid = (low+high) / 2;
            mergeSort(arr, low, mid);
            mergeSort(arr, mid + 1, high);
            merge(arr, low, mid, high);
        }
    }


    void merge(int arr[], int low, int mid, int high){
        ArrayList<Integer> list = new ArrayList<>();
        int left = low;
        int right = mid + 1;

        while (left <= mid && right <= high) {
            if(arr[left] < arr[right]){
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

        for(int i= low;i <= high; i++){
            arr[i] = list.get(i - low);
        }
    }

    void quickSort(int[] arr, int low, int high){
        if(low < high){
            int pevIdx = partetion(arr, low, high);
            quickSort(arr, low, pevIdx - 1);
            quickSort(arr, pevIdx + 1, high);
        }
    }

    int partetion(int[] arr, int low, int high){

        int pev = arr[low];
        int i = low , j = high;

        while (i < j) {
            while (arr[i] <= pev && i < high) {
                i++;
            }
            while (arr[j] > pev && j > low) {
                j--;
            }

            if(i < j){
                swap(arr, i, j);
            }
        }

        swap(arr, low, j);
        return j;
    }


    public static void main(String[] args) {
        Solution obj = new Solution();

        int[] arr = {6,2,8,99,3,1};
        obj.quickSort(arr,0, arr.length - 1);
        
        for(int i : arr){
            System.out.print(i + " ");
        }
    }
}