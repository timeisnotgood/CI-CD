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

    public int[] minAnd2ndMin(int arr[]) {
        // code here
        if(arr.length < 2) return new int[]{-1};
        int fmin = Integer.MAX_VALUE;
        int smin = Integer.MAX_VALUE;
        
        for(int num : arr){
            if(num < fmin){
                smin = fmin;
                fmin = num;
            }else if(num > fmin && num < smin){
                smin = num;
            }
        }
        
        
        if(smin == Integer.MAX_VALUE){
            return new int[]{-1};
        }
        
        return new int[]{fmin, smin};
    }

    public int[] twoSum(int[] numbers, int target) {

        int left = 0, right = numbers.length - 1;

        while (left <= right) {
            int element = numbers[left] + numbers[right];

            if (element == target) {
                return new int[] {numbers[left] , numbers[right]};
            }

            if (element < target) {
                left++;
            }else if (element > target) {
                right--;
            }
        }
        return new int[] {-1, -1};
    }

    public boolean isSorted(int[] nums) {
        int count = 0, n = nums.length;
         for (int i = 0; i < n; i++) 
             if (nums[i] > nums[(i+1) % n] && ++count > 1) return false;
         return count <= 1;
     }

    public int binarySearch(){
        int arr[] = {2, 4, 10, 15, 18, 21, 36};
        int target = 15;

        int left = 0;
        int right = arr.length - 1;

        while (left < right) {

            int mid = left - (right - left) /2;

            if (arr[mid] == target) {
                return arr[mid];
            }

            if (arr[mid] > target) {
                left = mid + 1;
            }else{
                right = mid - 1;
            }
            
        }

        return -1;
    }

    int slidingWindaw(int[] arr, int k){
        int max = 0;
        int win_max = 0;
        int left = 0;
        
        for(int i = 0; i< k;i++){
            win_max += arr[i];
        }
        
        max = Math.max(max, win_max);
        
        
        for(int j = k;j<arr.length;j++){
            win_max = win_max - arr[left] + arr[j];
             max = Math.max(max, win_max);
             left++;
        }
        
        return max;
    }

    public int[] twoSumUnsorted(int[] arr, int target){
        if (arr.length < 2)  return new int[] {-1, -1};
        int i = 0;
        while (i < arr.length) {
            for (int j = i+1; j < arr.length; j++) {
                int sum = arr[i] + arr[j];
                if (sum == target) {
                    System.out.println(arr[i] + " - " + arr[j] +" --> " + sum);
                    return new int[] {i, j};
                }
            }
            i++;
        }

        return new int[] {-1, -1};
    }

    public static void main(String[] args) {

       Basic algo = new Basic();
       int selecarr[] = {3,3};
       int k = 6;

       algo.twoSumUnsorted(selecarr, k);

        // int arr[] = algo.twoSum(selecarr, k);

        // for (int i = 0; i < arr.length; i++) {
        //     System.out.println(" --> " + arr[i]);
        // }

    }
}