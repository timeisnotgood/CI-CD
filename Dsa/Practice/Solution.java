package Practice;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Solution {

    int maxSubArray(int[] arr, int k){
        Integer winSum = 0, maxSum = 0;
        for(int i =0;i < k;i++){
            winSum +=arr[i];
        }

        maxSum = winSum;

        for (int i = k; i < arr.length; i++) {
            winSum += arr[i] - arr[i - k];
            maxSum = Integer.max(winSum, maxSum);
        }

        return maxSum;
    }

    boolean rangeSumQue(int[] arr, int k){
        
        int prefix[] = new int[arr.length];
        prefix[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            prefix[i] += prefix[i - 1];
        }

        for(int num : prefix){
            if (num == k) {
                return true;
            }
        }

        return false;
    }

    int binarySearch(int[] arr, int k){
        int left = 0, right = arr.length;

        while (left < right) {
            int mid = (left + right) / 2;

            if (arr[mid] == k) {return mid;}
            if (arr[mid] < k) {left = mid + 1;}
            else {right = mid;}
        }

        return -1;
    }

    int[] twoSum(int[] arr, int k){
        int i = 0, j = arr.length - 1;
        

        while (i<j) {
            int sum = arr[i] + arr[j];
            if (sum == k) {return new int[]{i, j};}
            if (sum < k) {
                i++;
            }else{
                j--;
            }
        }

        return new int[]{-1, -1};
    }

    public int firstUniqChar(String s) {
        HashMap<Character, Integer> freq = new HashMap<>();
        for(char num : s.toCharArray()){
            System.out.println("--->" + num);
            if (freq.containsKey(num)) {
                freq.put(num, freq.get(num) + 1);
            }else{
                freq.put(num, 1);
            }
        }

       for (int i = 0; i < s.toCharArray().length; i++) {
            if (freq.get(s.charAt(i)) == 1) {
                return i;
            }
       }

       return -1;
    }

    public void maxSubArray(int[] arr){
        int maxSum =0, winSum = 0;

        for(int i =0; i < arr.length;i++){
            winSum = Integer.max(arr[i], winSum + arr[i]);
            maxSum = Integer.max(winSum, maxSum);
        }

        System.out.println("------> " + maxSum);
    }

    public int longestSubString(String s){
        Set<Character> seen = new HashSet<>();
        int left = 0, right = 0, maxLength = 0;

        while (right < s.length()) {
            char currentChar = s.charAt(right);

            while (seen.contains(currentChar)) {
                seen.remove(s.charAt(left));
                left++;
            }

            seen.add(currentChar);
            maxLength = Integer.max(maxLength, right - left + 1);
            right++;
        }

        return maxLength;
    }

    public void matrixRotation(int[][] arr, int n){
        int[][] temp = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                temp[j][n-1-i] = arr[i][j];
            }
        }

        for(int i = 0; i < n;i++){
            for (int j = 0; j < n; j++) {
                arr[i][j] = temp[i][j];
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("helo");
        int[][] arr = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        Solution obj = new Solution();


        obj.matrixRotation(arr, arr.length);

        
    }

}