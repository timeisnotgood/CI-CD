package Practice;

import java.util.HashSet;

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
        HashMap<Integer, Integer> hash = new HashMap<>();
        
    }

    public static void main(String[] args) {
        Solution obj = new Solution();

        int[] arr = {4,9,6,7,3,5,1,8,2};

        obj.quickSort(arr,0, arr.length - 1);

        for(int val : arr){
            System.out.print(val + " ");
        }
    }
}