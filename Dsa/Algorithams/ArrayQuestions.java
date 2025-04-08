package Algorithams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArrayQuestions {

    int findtheMissing(int[] arr){
        int[] newarr = new int[arr.length + 2];

        for (int i = 0; i < arr.length; i++) {
            newarr[arr[i]] = 1;
        }

        for (int i = 0; i < newarr.length; i++) {
            if (newarr[i] == 0) {
                return i;
            }
        }
        return 0;
    }

    public int findMaxConsecutiveOnes(int[] nums) {
        int cnt = 0;
        int max = 0;
        for(int i = 0;i < nums.length;i++){
            if(nums[i] == 1){
                cnt++;
                max = Math.max(max, cnt);
            }else{
                cnt = 0;
            }
        }

        return max;
    }

    public void minandmax(int[] arr){
        int min = arr[0];
        int max = arr[0];

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }else if (arr[i] < min) {
                min = arr[i];
            }
        }


        System.out.println( "Min -- > " + min + "  max -- > " + max );
    }

    public void rotateAnarray(int arr[]){
        int temp = arr[arr.length - 1];

        for (int i = arr.length-1; i >= 0; i--) {
            if (i == 0) {
                arr[i] = temp;
                break;
            }

            arr[i] = arr[i-1];
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(" " + arr[i]);
        }
    }

    public int singleElement(int nums[]){

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        int arr[] = new int[max - min + 1];

        for (int i : nums) {
            arr[i - min]++;
        }

        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == 1) return (i + min);
        }

        return 0;

    }

    public int singleElementMap(int arr[]){
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            }else{
                map.put(i, 1);
            }
        }

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }

        return 0;
    }
    
    public int longestSubarray(int[] arr, int k){
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0, maxLen = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            // If the whole array from 0 to i sums to k
            if (sum == k) {
                maxLen = i + 1;
            }

            // If (sum - k) is found, subarray exists
            if (map.containsKey(sum - k)) {
                maxLen = Math.max(maxLen, i - map.get(sum - k));
            }

            // Store the first occurrence of the sum
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }

        return maxLen;
    }

    public void mostWater(){
        int arr[] = {1,8,6,2,5,4,8,3,7};

        int i = 0;
        int j = arr.length - 1;
        int maxval = 0;
        int maxlength = 0;

        while ( i < j) {
            int m = arr[i] * arr[j];
            int l = i - j;
            if (m > maxlength) {
                maxval = Math.max(maxval, m);
                maxlength = Math.max(maxlength, i-j);
            }
            i++;
            j--;
        }

        System.out.println(maxlength + " ---- " + maxval);
    }

    public void TwoSum(){
        int arr[] = {2, 7, 11, 15};
        int k = 9;

        int i = 0;
        int j = arr.length - 1;

        while (i < j) {
            int sum = arr[i] + arr[j];
            if (sum == k) {
                System.out.println("----> " + arr[i] + " - " + arr[j] );
                break;
            }

            if (sum < k) {
                i++;
            }

            if (sum > k ) {
                j--;
            }
        }
    }

    public void moveZeros(){
        int arr[] = {0, 1, 0, 3, 12};
        int i = 0;

        for (int j = 1; j < arr.length; j++) {
            if (arr[i] == 0 && arr[j] != 0) {
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
                i++;
            }
        }
    }

    public void imidateSmallest(){
        int arr[] = {4, 2, 1, 5, 3};
        for (int i = 0; i < arr.length - 1; i++) {
           if (arr[i+1] < arr[i]) {
            int temp = arr[i];
            arr[i] = arr[i+1];
            arr[i+1] = temp;
           }else{
            arr[i] = -1;
           }
            
        }

        arr[arr.length - 1] = -1;

        for (int j = 0; j < arr.length; j++) {
            System.out.print(" " + arr[j]);
        }
    }

    public void maxSubArray(){
        int arr[] = {2, 1, 5, 1, 3, 2};
        int k = 3;

        int left = 0;
        int max = 0;
        int win_max = 0;
        
        for (int i = 0; i < k; i++) {
            win_max += arr[i];
        }

        max = win_max;


        for (int i = k; i < arr.length; i++) {
            win_max = win_max - arr[left] + arr[i];
            max = Math.max(win_max, max);
            left++;
        }

        System.out.println(" - --> "+ max);
        
    }


    public int binarySearch(){
        int arr[] = {2, 4, 10, 15, 18, 21, 36};
        int target = 15;

        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {

            int mid = left + (right - left) /2;

            if (arr[mid] == target) {
                return mid;
            }

            if (arr[mid] < target) {
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }

        return -1;
    }

    public void mergeSort(int[] arr, int low, int high){
        if (low < high) {
            int mid = low + high /2;

            mergeSort(arr, low, mid);
            mergeSort(arr, mid + 1, high);
            merge(arr, low, mid, high);
        }
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
            arr[i] = list.get(i);
        }
    }




    public static void main(String[] args) {
        ArrayQuestions questions = new ArrayQuestions();

        int[] arr = {4,1,2,1,2};
        System.out.println("dfgdfsg---->" +
        questions.binarySearch()
        ); 

    }
}
