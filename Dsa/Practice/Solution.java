package Practice;


public class Solution {

    int[] onePair(int[] arr, int tar){
        int n = arr.length;

        for(int i = 0;i < n;i++){
            int sum = arr[i];
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] + sum == tar) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{0, 0};
    }

    int[] twoPointer(int[] arr, int tar){
        int n = arr.length;
        int i =0, j = n-1;

        while (i < j) {
            int sum = arr[i] + arr[j];

            if (sum == tar) {
                return new int[] {i, j};
            }

            if(sum < tar){
                i++;
            }else{
                j--;
            }
        }

        return new int[]{-1, -1};
    }

    int prefixsum(int[] arr, int l, int r){
       int[] prefix = new int[arr.length];

       prefix[0] = arr[0];
       for (int i = 1; i < arr.length; i++) {
           prefix[i] = prefix[i-1] + arr[i];
       }

       return prefix[r];
    }

    int kadans(int[] arr){
        int higest = arr[0];
        int current = 0;

        for(int num: arr){
            current += num;
            higest = Integer.max(higest, current);
            if (current < 0) {
                current = 0;
            }
        }

        return higest;
    }
     

    public static void main(String[] args) {
        Solution obj = new Solution();

        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(" -----> " + obj.kadans(arr));

    }
}