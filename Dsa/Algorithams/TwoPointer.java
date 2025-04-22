package Algorithams;

import java.util.ArrayList;

public class TwoPointer {

    public void subArray(){
        int arr[] = {1, 2, 3, 4, 5, 6};
        int k = 3;

        int max = 0;
        int win_max = 0;

        for (int i = 0; i <= k - 1 ; i++) {
            win_max += arr[i];
        }

        max = Math.max(max, win_max);

        for (int j = k; j < arr.length; j++) {
            win_max += arr[j] - arr[j - k];
            max = Math.max(max, win_max);
        }

        System.out.println("-----> " + max);
    }

    public void findNegative(){
        int arr[] = {12, -1, -7, 8, -15, 30, 16, 28};
        int k = 3;

        ArrayList<Integer> list = new ArrayList<>();

        int i = 0;
        int j = k;

        while (i < j) {
            System.out.println(" -- " + i);
            i++;
        }

    }

    public int[] Twopointer(){
        int arr[] = {1, 2, 3, 4, 6};
        int k = 6;

        int left = 0, right = arr.length - 1;

        while (left < right) {
            int sum = arr[left] + arr[right];
            if (sum == k) return new int[]{arr[left] , arr[right]};
            if (sum < k) left++;
            else right--;

        }

        return new int[0];

    }

    public void mergeSort(int[] arr, int low, int high){
        if(low >= high) return;
            int mid = (low + high)/2;
            mergeSort(arr, low, mid);
            mergeSort(arr, mid+1, high);
            merge(arr, low, mid, high);
        
    }

    void merge(int[] arr, int low, int mid, int high){
        int left = low;
        int right = mid + 1;
        ArrayList<Integer> list = new ArrayList<>();

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


    void quickSort(int[] arr, int low, int high){
        if (low < high) {
            int prev = precestion(arr, low, high);
            quickSort(arr, low, prev - 1);
            quickSort(arr, prev + 1, high);
        }
    }

    int precestion(int[] arr, int low, int high){
        int prev = arr[low];
        int i = low;
        int j = high;

        while ( i < j) {
            while (arr[i] <= prev && i <= high-1) {
                i++;
            }

            while (arr[j] > prev && j >= low + 1) {
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

    void binarySearch(){
        int arr[] = {1,2,3,4,6};
        int tar = 6;

        int left=0;
        int right = arr.length  -1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            System.out.println(mid);

            if (arr[mid] == tar) {
                System.out.println(" -- " +arr[mid]);
                break;
            }

            if (arr[mid] < tar) {
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
    }

    int missingNum(int arr[]) {
        // code here    
        int[] hash = new int[arr.length + 2];

        for (int i = 0; i < arr.length; i++) {
           hash[arr[i]] = 1;
        }

        for (int i = 1;i < hash.length;i++) {

            if (hash[i] == 0) {
                return i;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
       int[] arr = {1,2,3,5}; 
       TwoPointer pointer = new TwoPointer();
    //    pointer.quickSort(arr, 0, arr.length -1);
        pointer.missingNum(arr);

    //    for (int i = 0; i < arr.length; i++) {
    //     System.out.println(" - " + arr[i]);
    //    }
    }
}