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

    int maxSubarray(int[] arr, int k){
        int max = 0;
        int winmax = 0;

        for(int i = 0; i< k;i++){
            winmax += arr[i];
        }

        max = winmax;
        for (int i = k; i < arr.length; i++) {
            winmax = arr[i-k] - winmax + arr[i];
            max = Integer.max(winmax, max);
        }

        return max;
    }

    int prefixSum(int[] arr, int l, int r){
        int[] pre = new int[arr.length];
        pre[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            pre[i] = pre[i - 1] + arr[i];
        }

        return pre[r] - pre[l  -1];
    }

    int kadanas(int[] arr){
        int maxSum = arr[0];
        int currentSum = arr[0];

        for (int i = 1; i < arr.length; i++) {
            currentSum = Math.max(arr[i], currentSum + arr[i]);
            maxSum = Math.max(currentSum, maxSum);
        }

        return maxSum;
    }

    int binarySearch(int[] arr, int tar){
        int low = 0, high = arr.length - 1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == tar) {
                return mid;
            }

            if (arr[mid] < tar) {
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }

        return -1;
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

    void hashing(int[] arr){
        HashMap<Integer, Integer> list = new HashMap<>();

        for (int i : arr) {
            list.put(i, list.getOrDefault(i, 0) + 1);
        }
        
        for(Map.Entry<Integer, Integer> e : list.entrySet()){
            System.out.println(e + " - > ");
        }
    }

    void selectionSort(int[] arr){
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i; j < arr.length; j++) {
                if(arr[j] < arr[min]){
                    min = j;
                }
            }
            swap(arr, min, i);
        }
    }

    void bubbleSort(int[] arr){
        for(int i = arr.length - 1; i >= 0;i--){
            for (int j = 0; j < arr.length; j++) if(arr[j] > arr[j + 1]) swap(arr, j, i);
        }
    }

    void insertionSort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            int j = i;
            while (j > 0 && arr[j] < arr[j-1]) {
                swap(arr, j, j-1);
                j--;
            }
        }
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

    void quickS(int[] arr, int low, int high){
        if(low < high){
            int peviotIdx = partetio(arr, low, high);
            quickSort(arr, low, peviotIdx - 1);
            quickSort(arr, peviotIdx + 1, high);
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
        Solution obj = new Solution();

        int[] arr = {3,2,5,1,4,7,6};

        obj.quickS(arr, 0, arr.length - 1);

        for(int val : arr){
            System.out.print(val + " ");
        }
    }
}