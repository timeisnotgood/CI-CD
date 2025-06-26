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

    public static void main(String[] args) {
        System.out.println("Main -->");

        Solution obj = new Solution();
        int[] arr = {1, 9, 9};
        // obj.plusOne(arr);
        int[] added = obj.plusOne(arr);

        for(int num : added){
            System.out.println("--> "+ num);
        }
    }
}