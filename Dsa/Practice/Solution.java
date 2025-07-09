package Practice;

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

    public static void main(String[] args) {
        System.out.println("Hello");

        Solution obj = new Solution();
        int[] arr = {2, 1, 5, 1, 3, 2};
        obj.slidingWindow(arr, 3);
    }
}