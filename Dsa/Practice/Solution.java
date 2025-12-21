package Practice;


public class Solution {

    int maxSubarray(int[] arr, int k){
        int max = 0;
        int winmax = 0;

        for(int i = 0; i< k;i++){
            winmax += arr[i];
        }

        max = winmax;
        for (int i = k; i < arr.length; i++) {
            winmax = arr[i-k] - winmax + arr[i];
            max = Integer.max(winmax, max);
        }

        return max;
    }

    int prefixSum(int[] arr, int l, int r){
        int[] pre = new int[arr.length];
        pre[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            pre[i] = pre[i - 1] + arr[i];
        }

        return pre[r] - pre[l  -1];
    }

    int kadanas(int[] arr){
        int maxSum = arr[0];
        int currentSum = arr[0];

        for (int i = 1; i < arr.length; i++) {
            currentSum = Math.max(arr[i], currentSum + arr[i]);
            maxSum = Math.max(currentSum, maxSum);
        }

        return maxSum;
    }

    int binarySearch(int[] arr, int tar){
        int low = 0, high = arr.length - 1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == tar) {
                return mid;
            }

            if (arr[mid] < tar) {
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }

        return -1;
    } 

    public static void main(String[] args) {
        Solution obj = new Solution();

        int[] arr = {1, 2, 3, 4, 5};

        int max = obj.binarySearch(arr, 4);

        System.out.println("print --> " + max);
        // for(int val : arr){
        //     System.out.print(val + " ");
        // }
    }
}