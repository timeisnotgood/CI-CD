package Practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    void swap(int[] arr, int low, int high){
        int temp = arr[low];
        arr[low] = arr[high];
        arr[high] = temp;
    }

    

    public void quickSort(int[] arr, int low, int high){
        if(low < high){
            int peviotIdx = partetion(arr, low, high);
            quickSort(arr, low, peviotIdx - 1); 
            quickSort(arr, peviotIdx + 1, high); 
        }
    }

    int partetion(int[] arr, int low, int high){
        int peviot = arr[low];
        int i = low + 1;
        int j = high;
        
        while (i <= j) {
            while (i <= high && arr[i] <= peviot) {
                i++;
            }

            while (j > low && arr[j] > peviot) {
                j--;
            }

            if (i < j) {
                swap(arr, i, j);
            }
        }

        swap(arr, low, j);
        return j;
    }


    void selectionSort(int[] arr){
        int n = arr.length;

        for(int i = 0; i < n;i++){
            int min = i;
            for(int j = i;j < n;j++){
                if(arr[j] < arr[min]){
                    min = j;
                }
            }
            swap(arr, min, i);
        }
    }

    void bubbleSort(int[] arr){
        int n = arr.length;

        for(int i = n - 1;i > 0;i--){
            for(int j = 0;j < i;j++){
                if (arr[j] > arr[i]) {
                    swap(arr, j, i);
                }
            }
        }
    }

    void insertionSort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            int j = i;

            while (j > 0 && arr[j] < arr[j - 1]) {
                swap(arr, j, j-1);
                j--;
            }
        }
    }


    void mergeSort(int[] arr, int low, int high){
        if (low < high) {
            int mid = (low + high) / 2;
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
                list.add(right);
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

        for(int i = low;i <= high;i++){
            arr[i] = list.get(i - low);
        }
    }

    void reverseInplace(int[] arr){
        int n = arr.length;
        int i = 0, j = n - 1;

        while (i < j) {
            swap(arr, j, i);
            i++;
            j--;
        }
    }

    void prefix(int[] arr, int[] qry){
        int[] prex = new int[arr.length];

        prex[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            prex[i] = prex[i-1] + arr[i];
        }

        int sum = prex[qry[1]] - prex[qry[0] - 1];

        System.out.print("Here ->  "+ sum);
    }

    void maxSubarray(int[] arr, int k){
        int winval = 0;
        int max = 0;

        for (int i = 0; i < k; i++) {
            winval += arr[i];
        }

        max = winval;

        for (int i = k; i < arr.length; i++) {
            winval += arr[i] - arr[i-k];
            max = Math.max(max, winval);
        }

        System.out.print("Max value -> " + max);
    }

    void kadanes(int[] arr){
        int currentSum = arr[0], max = 0;

        for (int i = 1; i < arr.length; i++) {
            currentSum = Math.max(arr[i], currentSum + arr[i]);
            max = Math.max(max, currentSum);
        }

        System.out.print("max ->  " + max);
    }


    public static void main(String[] args) {
        Solution obj = new Solution();

        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        obj.kadanes(arr);

    }
}