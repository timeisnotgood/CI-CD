package Practice;

import java.util.ArrayList;

public class Solution {

    public void divide(int[] arr, int low, int high){
        if(low < high){
            int mid = (low+high) / 2;
            divide(arr, low, mid);
            divide(arr, mid + 1, high);
            merge(arr, low, mid, high);
        }
    }

    void merge(int[] arr, int low, int mid, int high){
        ArrayList<Integer> list = new ArrayList<>();
        int left = low;
        int right = mid + 1;


        while (left <= mid && right <= high) {
            if(arr[left] <= arr[right]) {
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
        int peviot = arr[low];
        int i = low;
        int j = high;

        while (i < j) {
            while (arr[i] <= peviot && i <= high - 1) {
                i++;
            }

            while (arr[j] > peviot && j >= low) {
                j--;
            }

            if(i < j){
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

    public static void main(String[] args) {
        int[] arr = {3,2,4,1,5,8,7,6};

        Solution obj = new Solution();
        obj.quickSort(arr, 0, arr.length - 1);

        for(int num : arr){
            System.out.print(num + " ");
        }
    }
}