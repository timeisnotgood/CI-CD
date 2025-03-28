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

    public void merge(int[] arr, int low, int mid, int high){
        ArrayList<Integer> list = new ArrayList<>();
        int left = low;
        int right = mid +1;

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

    public void secondLargest(int[] arr){
        int max = arr[0];
        int sec = arr[0];
        for (int i = 0; i < arr.length; i++) {

            if (arr[i] > max) {
                sec = max;
                max = arr[i];
            }

            if (arr[i] > sec && arr[i] < max) {
                sec = arr[i];
            }
        }

        System.out.println("-----> " + max + sec);
    }

    public void quickSort(int[] arr, int low, int high){
        if (low < high) {
            int privI = precetion(arr, low, high);
            quickSort(arr, low, privI - 1);
            quickSort(arr, privI + 1, high);
        }
    }

    int precetion(int[] arr, int low, int high){
        int prev = arr[low];
        int i = low;
        int j = high;

        while (i < j) {
            while (arr[i] <= prev && i <= high - 1) {
                i++;
            }

            while (arr[j] > prev && j >= low +1) {
                j--;
            }

            if (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[low];
        arr[low] = arr[j];
        arr[j] = temp;

        return j;
    }

    public boolean isSorted(int[] nums) {
        int count = 0, n = nums.length;
         for (int i = 0; i < n; i++) 
             if (nums[i] > nums[(i+1) % n] && ++count > 1) return false;
         return count <= 1;
     }

    public static void main(String[] args) {

       Basic algo = new Basic();
       int selecarr[] = {6,7,2,8,1,4};


    //    algo.HashingPrefetching();
    //    algo.secondLargest(selecarr);
    //    algo.InsertionSort(selecarr, selecarr.length);

        System.out.println("Before Sort --> " + Arrays.toString(selecarr));
        System.out.println();
        algo.mergeSort(selecarr, 0, selecarr.length - 1);
        System.out.println();
        System.out.println("After Sort --> " + Arrays.toString(selecarr));


    }
}