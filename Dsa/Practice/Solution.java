package Practice;

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

    public int[] runningSum(int[] nums) {
        int[] temp = new int[nums.length];
        temp[0] = nums[0];
        for(int i = 1; i < nums.length;i++){
            temp[i] = temp[i-1] + nums[i];
        }
        return temp;
    }

    public int pivotIndex(int[] nums) {
       int totla = 0;
       for(int num : nums){ totla += num;}

       int leftSum = 0;
       for(int i = 0;i < nums.length; i++){
            if(totla == leftSum - totla - nums[i]){
                return i;
            }
            leftSum += nums[i];
       }

       return -1;
        
    }

    public static void main(String[] args) {
        // System.out.println("Main -->");

        Solution obj = new Solution();
        int[] arr = {1,7,3,6,5,6};

        int piv = obj.pivotIndex(arr);

        System.out.println("---->"+ piv);
    }
}