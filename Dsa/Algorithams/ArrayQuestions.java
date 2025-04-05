package Algorithams;

import java.util.HashMap;
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
    public static void main(String[] args) {
        ArrayQuestions questions = new ArrayQuestions();

        int[] arr = {4,1,2,1,2};
        System.out.println("dfgdfsg---->" +
        questions.longestSubarray()
        );

    }
}
