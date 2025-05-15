package Practice;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public String longest(List<String> arr) {
        int max = Integer.MIN_VALUE;
        int index = 0;
        int i = 0;

        for(String val : arr){
            int winlen = val.toCharArray().length;
            if (winlen > max) {
                max = winlen;
                index = i;
            }
            i++;
        }
        
        return arr.get(index);
    }

    int[] getMoreAndLess(int[] arr, int target) {
        // code here
        
        int less = 0;
        int high = 0;

        for(int i = 0; i < arr.length;i++){
            int sum = arr[i];

            if (sum <= target) {
                less += 1;
            }
            
            if(sum >= target){
                high += 1;
            }
        }

        return new int[]{less, high};
    }

    public static void main(String[] args) {
        
        List<String> list = new ArrayList<>();
        list.add("Geek");
        list.add("Geeks");
        list.add("Geeksfor");
        list.add("GeeksforGeek");
        list.add("GeeksforGeeks");

        int arr[] = {1, 2, 8, 10, 11, 12, 19};
        int target = 10;

        Solution obj = new Solution();

        // String val = obj.longest(list);
        int[] vals = obj.getMoreAndLess(arr, target);

        System.out.println("--> " + "[" + vals[0] + ", " + vals[1] + "]");


    }
}