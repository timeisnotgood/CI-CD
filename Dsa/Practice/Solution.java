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

    

    void selectsrt(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            swap(arr, min, i);
        }
    }

    void bubblesrt(int[] arr){
        for(int i = arr.length - 1; i > 0;i--){
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j+1);
                }
            }
        }
    }

    void insertionsrt(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            int j = i;

            while (j > 0 && arr[j - 1] > arr[j]) {
                swap(arr, j, j-1);
                j--;
            }
        }
    }

    void mergesrt(int[] arr, int low, int high){
        if (low < high) {
            int mid = (low + high) / 2;
            mergesrt(arr, low, mid);
            mergesrt(arr, mid + 1, high);
            merge(arr, low, mid, high);
        }
    }

    void merge(int[] arr, int low, int mid, int high){
        ArrayList<Integer> list = new ArrayList<>();
        int left = low;
        int right = mid + 1;

        while(left <= mid && right <= high){
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

    void quicksrt(int[] arr, int low, int high){
        if (low < high) {
            int pividex = partetion(arr, low, high);
            quicksrt(arr, low, pividex);
            quicksrt(arr, pividex + 1, high);
        }
    }

    int partetion(int[] arr, int low, int high){
        int peviot = arr[low];
        int i = low - 1;
        int j = high + 1;

        while (true) {
            do{
                i++;
            }while(arr[i] < peviot);

            do{
                j--;
            }while (arr[j] > peviot);

            if (i >= j) {
                return j ;
            }

            swap(arr, i, j);
        }
    }

    void twoprt(int[] arr){
        int i = 0;
        int j = arr.length - 1;

        while (i < j) {
            swap(arr, j, i);
            i++;
            j--;
        }

    }

    int[] exist(int[] arr, int tar){
        int i = 0;
        int j = arr.length - 1;

        while (i < j) {
            int sum = arr[i] + arr[j];

            if (sum == tar) {
                return new int[]{i, j};
            }

            if (sum < tar) {
                i++;
            }else if (sum > tar) {
                j--;
            }
        }
        return new int[]{};
    }

    void maxsubarr(int[] arr, int k){
        int winmax = 0;
        int max = 0;

        for (int i = 0; i < k; i++) {
            winmax += arr[i];
        }

        max = winmax;

        for (int i = k; i < arr.length; i++) {
            winmax = winmax + arr[i] - arr[i - k];
            max = Math.max(max, winmax);
        }

        System.out.println("--> " + max);
    }


    void prepix(int[] arr, int x, int y){
        int[] pix = new int[arr.length];

        pix[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            pix[i] = pix[i-1] + arr[i];
        }

        int ans = pix[y] - pix[x - 1];

        System.out.println(pix[y]+ "---. "+pix[x - 1]);

        System.out.println("---> " + ans);
    }

    void kandane(int[] arr){
        int winmax = 0;
        int max = 0;

        for (int i = 0; i < arr.length; i++) {
            winmax = Math.max(winmax + arr[i], arr[i]);
            max = Math.max(max, winmax);
        }

        System.out.println("---- > "+ max);
    }


    int binarysrch(int[] arr,int k){

        int low = 0, high = arr.length -1;

        // System.out.println("--> " + high);

        while (low <= high) {
            int mid = low + (high - low) / 2;

            // System.out.println("--> " + mid);

            if (arr[mid] == k) {
                return mid;
            }

            if (arr[mid] < k) {
                low = mid + 1;
            }else if(arr[mid] > k){
                high = mid -1;
            }
        }

        return 0;
    }


    void hashing(int[] arr, int query){
        HashMap<Integer, Integer> prex =
            new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            if (prex.containsKey(arr[i])) {
                prex.put(arr[i], prex.get(arr[i]) + 1);
            }else{
                prex.put(arr[i], 1);
            }
        }

        for(Map.Entry<Integer, Integer> val : prex.entrySet()){
            if (val.getKey() == query) {
                System.out.println("---> " + val.getValue());
            }
        }
    }

    public static void main(String[] args) {
        Solution obj = new Solution();

        int[] arr = {1,2,3,2,1,2};
        obj.hashing(arr, 2);
    }
}