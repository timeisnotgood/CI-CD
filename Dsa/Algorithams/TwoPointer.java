package Algorithams;

import java.util.ArrayList;

public class TwoPointer {

    public void subArray(){
        int arr[] = {1, 2, 3, 4, 5, 6};
        int k = 3;

        int max = 0;
        int win_max = 0;

        for (int i = 0; i <= k - 1 ; i++) {
            win_max += arr[i];
        }

        max = Math.max(max, win_max);

        for (int j = k; j < arr.length; j++) {
            win_max += arr[j] - arr[j - k];
            max = Math.max(max, win_max);
        }

        System.out.println("-----> " + max);
    }

    public void findNegative(){
        int arr[] = {12, -1, -7, 8, -15, 30, 16, 28};
        int k = 3;

        ArrayList<Integer> list = new ArrayList<>();

        int i = 0;
        int j = k;

        while (i < j) {
            System.out.println(" -- " + i);
            i++;
        }

    }

    public int[] Twopointer(){
        int arr[] = {1, 2, 3, 4, 6};
        int k = 6;

        int left = 0, right = arr.length - 1;

        while (left < right) {
            int sum = arr[left] + arr[right];
            if (sum == k) return new int[]{arr[left] , arr[right]};
            if (sum < k) left++;
            else right--;

        }

        return new int[0];

    }

    public static void main(String[] args) {
       TwoPointer pointer = new TwoPointer();
       pointer.Twopointer();
    }
}
