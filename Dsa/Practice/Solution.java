package Practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {

    public void prefixSum(int[] arr, int k){
        int[] prefix = new int[arr.length];

        prefix[0] = arr[0];

        for(int i = 1;i < arr.length;i++){
            prefix[i] = prefix[i - 1] + arr[i];
        }

        for(int num : prefix){
            System.out.println("--->" + num);
        }
    }

    public void slidingWindow(int[] arr, int k){
        int winSum = 0;
        int maxSum = 0;

        for (int i = 0; i < k; i++) {
            winSum += arr[i];
        }

        maxSum = winSum;

        for (int i = k; i < arr.length; i++) {
            winSum = winSum - arr[i- k] + arr[i];
            maxSum = Integer.max(maxSum, winSum);
        }

        System.out.println(maxSum);
    }

    public void kadane(int[] arr){
        int currentmax = arr[0];
        int max = arr[0];

        for (int i = 1; i < arr.length; i++) {
            currentmax = Integer.max(arr[i], currentmax + arr[i]);
            max = Integer.max(max, currentmax);
        }

        System.out.println(max);
    }

    public int[] twoPointer(int[] arr, int t){
        int i = 0;
        int j = arr.length - 1;

        while (i < j) {
            int sum = arr[i] + arr[j];

            if (sum == t) {
                return new int[]{i, j};
            }

            if (sum < t) {
                i++;
            }else if(sum > t){
                j--;
            }
        }

         return new int[]{i, j};
    }




    static public int[] removeElement(int[] arr, int val){

        int[] temp = new int[arr.length - 1];


        int j = 0;

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] != val) {
                temp[j] = arr[i];
                j++; 
            }
        }


        return temp;
    }
    public static void printNGE(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[arr.length];


        for (int i = arr.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }

            result[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(arr[i]);
        }




        // Print result
        for (int val : result) {
            System.out.print(val + " ");
        }
    }

    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        String str = "";

        for (int i = 0; i < nums.length; i++) {
            if(nums.length == 1){
                String val = Integer.toString(nums[i]);
                str = str + val;
                list.add(str);
                return list;
            }
            if (i == nums.length - 1) {
                char charNumber = (char) (nums[i] + '0');
                str = nums[i - 1] + 1 == nums[i] ? str + '-' + '>' + charNumber : str + charNumber;
                list.add(str);
                str = "";
                return list;
            }
            if(str.isEmpty() && nums[i+1] != nums[i] + 1){
                char charNumber = (char) (nums[i] + '0');
                str = str + charNumber;
                list.add(str);
                str = "";
                continue;
            }
            if (str.isEmpty() && nums[i+1] == nums[i] + 1) {
                 char charNumber = (char) (nums[i] + '0');
                str = str + charNumber;
            }

            if (nums[i+1] != nums[i] + 1) {
                char charNumber = (char) (nums[i] + '0');
                str = str + '-' + '>' + charNumber;
                list.add(str);
                str = "";
            }
        }

        return list;
    }
    public static void main(String[] args) {
        System.out.println("Hello");
        Solution obj = new Solution();


        // int[] arr =  {1,2,3,4,5};
        // int[] newarr = removeElement(arr, 3); // {1,2,4,5}






        // System.err.print("[ ");
        // for(int num : newarr){
        //     System.out.print(num + ", ");
        // }
        // System.out.print("]");


        // {1,2,4,5}


        List<String> list = obj.summaryRanges(new int[]{-1});

        for(String num : list){
            System.out.println("--> " + num);
        }

        

    }
}