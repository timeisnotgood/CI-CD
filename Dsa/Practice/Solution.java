package Practice;

import java.util.ArrayList;

public class Solution {

    void mergeSort(int arr[], int low, int high){
        if(low < high){
            int mid = (low + high) /2;

            mergeSort(arr, low, mid);
            mergeSort(arr, mid+1, high);
            merge(arr, low, mid, high);
        }
    }

    void merge(int arr[], int low, int mid, int high){
        ArrayList<Integer> list = new ArrayList<>();
        int left = 0;
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

    public static void main(String[] args) {

        Solution obj = new Solution();
        int arr[] = {38, 27, 43, 3, 9, 82, 10};
        obj.mergeSort(arr, 0, arr.length - 1);

        for(int num : arr){
            System.out.print("--> " + num);
        }
    }
}