package Practice;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    int convertZero(int num){
        if(num == 0 ) return 0;

        int digit = num % 10;
        if (digit == 0) {
            digit = 5;
        }

        return convertZero(num / 10) * 10 + digit; 
    }

    int convertion(int num){
        if (num == 0) {
            return 5;
        }

        return convertZero(num);
    }



    int getOddOccurrence(int[] arr, int n) {
        // code here

        if (arr.length == 1) {
            return arr[0];
        }

        HashMap<Integer, Integer> count = new HashMap<>();

        for(int num : arr){
            if (count.containsKey(num)) {
                count.put(num, count.get(num) + 1);
            }else{
                count.put(num, 1);
            }
        }

        for(Map.Entry<Integer, Integer> entry : count.entrySet()){
            if (entry.getValue() % 2 != 0) {
                return entry.getKey();
            }
        }

        return - 1;
       
    }

    public static void main(String[] args) {
        int[] num = {1, 2, 3, 2, 3, 1, 3};
        Solution obj = new Solution();

        System.out.println("-- > " +
            obj.getOddOccurrence(num, num.length - 1)
        );


        // System.out.println(" -->  " + );
    }
}