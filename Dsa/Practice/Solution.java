package Practice;

import java.util.ArrayList;

public class Solution {

    void mergeSort(int[] arr, int low, int high){
        if(low < high){
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
            if(arr[left] <= arr[right]){
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


    void quickSort(int[] arr, int low, int high){
        if(low < high){
            int peviotIndex = partetion(arr, low, high);
            quickSort(arr, low, peviotIndex - 1);
            quickSort(arr, peviotIndex + 1, high);
        }
    }

    int partetion(int[] arr, int low, int high){
        int peviot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] < peviot) {
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i + 1, high);
        return i + 1;
    }

    void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        Solution obj = new Solution();
        int[] arr= {3,1,5,2,4};

        obj.quickSort(arr, 0, arr.length - 1);

        for(int num : arr){
            System.out.print(num + " ");
        }
    }
}