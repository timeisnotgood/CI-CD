package Practice;

import java.util.ArrayList;

public class Solution {

    void mergeSort(int arr[], int low, int high){
        if(low < high){
            int mid = (low+high) /2;
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
            arr[i] = list.get(i-low);
        }
    }

    void quickSort(int arr[], int low, int high){
        if (low < high) {
            int peviot = partition(arr, low, high);
            quickSort(arr, low, peviot - 1);
            quickSort(arr, peviot + 1, high);
        }
    }

    int partition(int[] arr, int low, int high){
        int peviot = arr[high];
        int i = low;
        int j = high - 1;

        while (i <= j) {
            while (arr[i] <= peviot && i <= high - 1) {
                i++;
            }

            while (arr[j] > peviot && j >= low + 1) {
                j--;
            }

            if (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i];
        arr[i] = arr[high];
        arr[high] = temp;
        return i;
    }

    void binarySearch(){
        int arr[] = {2, 5, 8, 12, 16, 23, 38, 56, 72, 91};
        int k = 12;

        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == k) {
                System.out.println("mid -> " + mid);
                break;
            }

            if (arr[mid] < k) {
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
    }

    public static void main(String[] args) {
        Solution obj = new Solution();
        int[] arr= {2, 5, 8, 12, 16, 23, 38, 56, 72, 91};
        // obj.mergeSort(arr, 0, arr.length - 1);

        obj.binarySearch();

        
        // for(int num : arr){
        //     System.out.print(" " + num);
        // }

    }
}