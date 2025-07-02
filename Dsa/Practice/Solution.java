package Practice;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Solution {

    public int[] plusOne(int[] digits) {
       for (int i = digits.length - 1; i >= 0 ; i--) {
            if(digits[i] < 9){
                digits[i]++;
                return digits;
            }

            digits[i] = 0;
       }

       int[] temp = new int[digits.length + 1];
       temp[0] = 1;
       return temp;
    }

    // public void merge(int[] nums1, int m, int[] nums2, int n) {
    //     int[] temp = new int[m + n];
    //     int i = 0, j = 0, a = 0;

    //     while (i < m && j < n) {
    //         System.out.println(i + " " + j);
    //         if (nums1[i] < nums2[j]) {
    //             temp[a] = nums1[i];
    //             i++;
    //             a++;
    //         }else{
    //             temp[a] = nums2[j];
    //             j++;
    //             a++;
    //         }
    //     }

    //     while (i < m) {
    //         temp[a] = nums1[i];
    //             i++;
    //             a++;
    //     }

    //     while (j < n) {
    //         temp[a] = nums2[j];
    //             j++;
    //             a++;
    //     }

    //     for(int k = 0 ;k < nums1.length;k++){
    //         nums1[k] = temp[k];
    //     }
    // }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
       int i = m - 1;
       int j = n - 1;
       int k = m + n -1;

       while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            }else{
                nums1[k--] = nums2[j--];
            }
       }

       while (j > 0) {
         nums1[k--] = nums2[j--];
       }
    }

     public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>(numRows);

        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            for(int j = 0; j<=i; j++){
                if (i == 0 || j == i || j == 0) {
                    row.add(1);
                }else{
                    row.add(list.get(i - 1).get(j - 1) + list.get(i - 1).get(j));
                }
            }
            list.add(row);
        }

        return list;
    }

    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i < rowIndex + 1; i++) {
            List<Integer> rowlist = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    rowlist.add(1);
                }else{
                    rowlist.add(list.get(i - 1).get(j - 1) + list.get(i - 1).get(j) );
                }
            }
            list.add(rowlist);

            if (i == rowIndex) {
                return rowlist;
            }
        }

        return new ArrayList<>();
    }

    public int[] prefixSum(int[] arr){
        int[] prefix = new int[arr.length];
        prefix[0] = arr[0];
        for (int i = 1; i < prefix.length; i++) {
            prefix[i] = prefix[i - 1] + arr[i];
        }

        return prefix;
    }

    public int slidingWindow(int[] arr, int k){
        int winVal = 0, max = 0;

        for (int i = 0; i < k; i++) {
            winVal += arr[i];
            max = Integer.max(max, winVal);
        }

        for (int i = k; i < arr.length; i++) {
            winVal = winVal - arr[i-k] + arr[i];
            max = Integer.max(max, winVal);
        }
        return max;
    }

    public void kadanesAlgo(int[] arr){
        int currentMax = arr[0];
        int max = arr[0];

        for (int i = 0; i < arr.length; i++) {
            currentMax = Integer.max(arr[i], currentMax + arr[i]);
            max = Integer.max(currentMax, max);
        }

        System.out.println("-->" + max);
    }

    public int[] twoPointer(int[] nums, int k){
        int i = 0, j = nums.length - 1;

        while (i < j) {
            int added = nums[i] + nums[j];
            if (added == k) {
                return new int[]{i, j};
            }

            if (added < k) {
                i++;
            }else{
                j--;
            }
        }

        return new int[]{0, 0};
    }


    public static void main(String[] args) {

        Solution obj = new Solution();
        int[] arr = {2, 7, 11, 15};
        int[] val = obj.twoPointer(arr, 9);

        for(int num : val){
            System.out.print(num + " ");
        }

        // for(int num : prev){
        //     System.out.print(num + " ");
        // }

    }
}