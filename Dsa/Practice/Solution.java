package Practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    static void swap(int[] arr, int low, int high){
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

    int binarySearch(int[] arr, int low, int high, int tar){
        int left = low, right = high;
        while (left <= high) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == tar) {
                return mid;
            }else if(arr[mid] < tar){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }

        return 0;
    }

    void hash(int[] arr){
        int[] hash = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            if (hash[arr[i]] == 0) {
                hash[arr[i]] = 1;
            }else{
                hash[arr[i]]++;
            }
        }

        for (int i : hash) {
            System.out.println("has -> " + i);
        }
    }


    void hashingMap(int[] arr){
        Map<Integer, Integer> hash = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            
            if (hash.containsKey(arr[i])) {
                hash.put(arr[i], hash.get(arr[i]) + 1);
            }else{
                hash.put(arr[i], 1);
            }
        }


        for(Integer vals : hash.keySet()){
            System.out.println(vals + " ->  " + hash.get(vals));
        }
    }


    void qsort(int[] arr, int low, int high){
        if (low < high) {
            int pivotidx = partetions(arr, low, high);
            qsort(arr, low, pivotidx );
            qsort(arr, pivotidx + 1, high);
        }
    }

    static int partetions(int[] arr, int low, int high){
        int pivet = medianIdx(arr, low, high);
        int i = low - 1;
        int j = high + 1;

        while (true) {
            
            do{
                i++;
            }while(arr[i] < pivet);

            do{
                j--;
            }while (arr[j] > pivet);

            if (i >= j) {
                return j;
            }

            swap(arr, i, j);
        }
    }

    static int medianIdx(int[] arr, int low, int high){

        int mid = low + (high - low) /2;

        if (arr[low] > arr[mid]) 
            swap(arr, low, mid);

        if (arr[low] > arr[high]) 
            swap(arr, low, high);

        if (arr[mid] > arr[high]) 
            swap(arr, mid, high);

        swap(arr, low, mid);
        return arr[low];
    }

    void greedy(int[] arr, int remainder){
        int count = 0;

        for (int i : arr) {
            remainder -= i;
            count++;
        }

        System.out.println("Coins used = " + count);
    }



    void oneTwoarray(){
        int arr[] = {1,2,3,4,5};

        for (int i = 0; i < arr.length; i++) System.out.print(" " + arr[i]);

        System.out.println();
        int matrix[][] = {
            {1,2,3},
            {4,5,6},
            {7,8,9}
        };

        for (int row = 0; row < matrix.length; row ++) {
            for(int col = 0; col < matrix[row].length; col ++)
                System.out.print(matrix[row][col] + " ");
            System.out.println();
        }
        
    }

    void updatearray(){

        int[] arr = new int[6];

        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 4;
        arr[3] = 5;
        arr[4] = 6;

        int size = 5;
        int position = 2;

        for (int i = size; i > position; i--) {
            arr[i] = arr[i - 1];
        }

        arr[position] = 3;
        size++;

        for (int i : arr) System.out.print(i + " ");
    }

    void deletelement(){
        int[] arr = {1,2,3,4,5};

        int position = 2;

        for (int i = position; i < arr.length; i++) {
            if(i == arr.length - 1) {
                arr[i] = 0; 
                break;
            }
            arr[i] = arr[i + 1];
        }

        for (int i : arr) {
            System.out.println(i);
        }
    }



    public static void main(String[] args) {
        Solution obj = new Solution();

        obj.deletelement();

    }
}