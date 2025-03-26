package Algorithams;

import java.util.ArrayList;
import java.util.Arrays;

public class Basic {

    void HashingPrefetching(){
        int arr[] = {3,5,5,3,2,1,4,4};
        int hash[] = new int[6];

        for (int i = 0; i < arr.length; i++) {
            hash[arr[i]] +=1;
        }

        System.out.println("----->"+ hash[5]);
    }

    void SelectionSort(int[] arr, int n){    

        for (int i = 0; i < n - 1; i++) {
            int min = i;
            for (int j = i+1; j < n; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }

            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }

        System.out.println("Bubble sort --->");

        for (int i = 0; i < arr.length; i++) {
            System.out.println("--->" + arr[i]);
        }
    }

    void BubbleSort(int[] arr, int n){
        for(int i = n -1; i >= 0; i++){
            int swap = 0;

            for(int j = 0; j < i -1;j++){
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                    swap = 1;
                }
            }

            if (swap == 0) break;
        }

        System.out.println("Bubble sort --->");

        for (int i = 0; i < arr.length; i++) {
            System.out.println("--->" + arr[i]);
        }
    }


    public static void InsertionSort(int arr[], int n) {
        for (int i = 1; i < n; i++) {
            int j = i;
            while (j > 0 && arr[j - 1] > arr[j]) {
                int temp = arr[j - 1];
                arr[j - 1] = arr[j];
                arr[j] = temp;
                j--;
            }
        }

        System.out.println("Insertion sort --->");

        for (int i = 0; i < arr.length; i++) {
            System.out.println("--->" + arr[i]);
        }
    }

    public void mergeSort(int[] arr, int low, int high){
        if (low >= high) return;

        int mid = (low + high) / 2;
        mergeSort(arr, low, mid);
        mergeSort(arr, mid+1, high);
        merge(arr,low,mid,high);
    }

    public void merge(int arr[], int low, int mid, int high){
        ArrayList<Integer> temp = new ArrayList<>();
        int left = low;
        int right = mid+1;

        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp.add(arr[left]);
                left++;
            }else{
                temp.add(arr[right]);
                right++;
            }
        }

        while (left <= mid) {
            temp.add(arr[left]);
            left++;
        }

        while (right <= high) {
            temp.add(arr[right]);
            right++;
        }

        for (int i = low; i <= high; i++) {
            arr[i] = temp.get(i - low);
        }
    }

    public static void main(String[] args) {

       Basic algo = new Basic();
       int selecarr[] = {6,7,2,8,1,4,};


    //    algo.HashingPrefetching();
    //    algo.SelectionSort(selecarr, selecarr.length);
    //    algo.InsertionSort(selecarr, selecarr.length);

        System.out.println("Before Sort --> " + Arrays.toString(selecarr));
        System.out.println();
        algo.mergeSort(selecarr, 0, selecarr.length - 1);
        System.out.println();
        System.out.println("After Sort --> " + Arrays.toString(selecarr));


    }
}