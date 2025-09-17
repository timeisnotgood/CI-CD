package Practice;

import java.util.ArrayList;

public class Solution {

    void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    void mergeSort(int[] arr, int low, int high){
        if(low < high){
            int mid = (low+high)/2;
            mergeSort(arr, low, mid);
            mergeSort(arr, mid+1, high);
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

        for(int i = low;i <= high;i++){
            arr[i] = list.get(i - low);
        }
    }

    void ses(int[] arr){
        int n = arr.length;

        for (int i = 0; i <= n - 2; i++) {
            int min = i;
            for (int j = i; j <= n - 1; j++) {
                if(arr[j] < arr[min]) min = j;
            }
            swap(arr, i, min);
        }
    }


    void bubble_s(int[] arr){
        int n = arr.length;

        for (int i = n - 1; i >= 1; i--) {
            for (int j = 0; j <= i - 1; j++) {
                if(arr[j] > arr[j + 1])
                swap(arr, j + 1, j);
            }
        }
    }

    void insertion_sort(int[] arr){
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            int j = i;

            while (j > 0 && arr[j - 1] > arr[j]) {
                swap(arr, j - 1, j);
                j--;
            }
        }
    }


    public static void main(String[] args) {
        Solution obj = new Solution();

        int[] arr = {6,2,8,99,3,1};
        obj.insertion_sort(arr);
        
        for(int i : arr){
            System.out.print(i + " ");
        }
    }
}