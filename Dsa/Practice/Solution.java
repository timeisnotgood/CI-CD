package Practice;

import java.security.KeyStore.Entry;
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

    void selectionsrt(int[] arr){
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min= j;
                }
            }
            swap(arr, min, i);
        }
    }

    void bubblesrt(int[] arr){
        for (int i = arr.length - 1; i > 0; i--) {
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
                swap(arr, j, j - 1);
                j--;
            }
        }
    }

    void mergeSrt(int[] arr, int low, int high){
        if (low < high) {
            int mid = low + (high - low) / 2;
            mergeSrt(arr, low, mid);
            mergeSrt(arr, mid + 1, high);
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

        for(int i = low; i <= high;i++){
            arr[i] = list.get(i - low);
        }
    }

    void quicksrt(int[] arr, int low, int high){
        if(low < high){
            int pixIdx = partetion(arr, low, high);
            quicksrt(arr, low, pixIdx);
            quicksrt(arr, pixIdx + 1, high);
        }
    }

    int partetion(int[] arr, int low, int high){
        int piveot = arr[low];
        int i = low - 1;
        int j = high + 1;

        while(true){
            do{
                i++;
            }while(arr[i] < piveot);

            do{
                j--;
            }while (arr[j] > piveot);

            if (i >= j) {
                return j;
            }

            swap(arr, i, j);
        }
    }


    void twopointer(int[] arr){
        int i = 0;
        int j = arr.length - 1;

        while (i < j) {
            swap(arr, j, i);
            i++;
            j--;
        }
    }

    void slidingwin(int[] arr, int k){
        int winmax = 0;
        int max = 0;

        for (int i = 0; i < k; i++) {
            winmax += arr[i];
        }

        max = winmax;

        for (int i = k; i < arr.length; i++) {
            winmax = arr[i] + winmax - arr[i-k];
            max = Math.max(max, winmax);
        }

        System.out.println("---> " + max);
    }

    void prefix(int[] arr, int x, int y){
        int[] prx = new int[arr.length];
        prx[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            prx[i] = prx[i - 1] + arr[i];
        }

        int ans = prx[y - 1] - prx[x - 2];
        System.out.println("prx ---> " + ans);
    }

    void kadanealgo(int[] arr){
        int winmax = 0;
        int max = 0;

        for (int i = 0; i < arr.length; i++) {
            winmax = Math.max(arr[i] + winmax, arr[i]);
            max = Math.max(max, winmax);
        }

        System.out.println("--> " + max);
    }

    void hashing(int[] arr){
        HashMap<Integer, Integer> list = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            if (list.containsKey(arr[i])) {
                list.put(arr[i], list.get(arr[i]) + 1);
            }else{
                list.put(arr[i], 1);
            }
        }

        for(Map.Entry<Integer, Integer> val : list.entrySet()){
            if (val.getKey() == 2) {
                System.out.println("---> " + val.getValue());
            }
        }
    }

    int bineSearch(int[] arr, int k){
        int low = 0;int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == k) {
                return mid;
            }

            if (arr[mid] < k) {
                low = mid +1;
            }else{
                high = low - 1;
            }
        }

        return - 1;
    }

    public static void main(String[] args) {
        Solution obj = new Solution();

        int[] arr = {1,2,3,4,5,6,7};
        int val = obj.bineSearch(arr, 7);

        System.out.println("--> " + val);
    }
}