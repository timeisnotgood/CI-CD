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

    boolean findDuplicate(int[] arr){

        int[] dup = new int[arr.length + 1];

        for (int i : arr) {
            if (dup[i] == 1) {
                dup[i] = dup[i] + 1;
            }else{
                dup[i] = 1;
            }
        }

        for (int i : dup) {
            if (i == 2) {
                return true;
            }
        }
        return false;
    }

    int[] rotate(int[] arr){
        int n = arr.length;
        int pickval = arr[0];

        for(int i = 1; i < n; i++){
            arr[i - 1] = arr[i];
        }
        arr[n - 1] = pickval;
        return arr;
    }

    int[] insertIntoArray(int[] arr, int val, int idx){
        int existArrayLength = arr.length;
        int[] newArray = new int[existArrayLength + 1];
        int i = 0, j = 0;

        while (i < existArrayLength) {
            if(j == idx - 1){
                newArray[j] = val;
                j++;
            }else{
                newArray[j] = arr[i];
                j++; i++;
            }
        }

        return newArray;
    }

    int[] deleteFromArray(int[] arr, int idx){

        for(int i = idx; i < arr.length - 1;i++){
            arr[i - 1] = arr[i];
        }

        return arr;
    }

    int bineSearch(int[] arr, int tar){
        int low = 0, high = arr.length - 1;

        while (low < high) {
            int mid = low + (high - low) /2;

            if (arr[mid] == tar) {
                return mid;
            }else if(arr[mid] < tar){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return -1;
    }

    void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    void reverse(int[] arr){
     int i = 0, j = arr.length - 1;
     
     while (i < j) {
        swap(arr, i, j);
        i++;
        j--;
     }
    }
     

    int lowerBound(int[] arr, int target) {
        int low = 0, high = arr.length;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] < target)
                low = mid + 1;
            else
                high = mid;
        }
        return low;
    }


    public static void main(String[] args) {
        Solution obj = new Solution();

        int[] arr = {4,3,2,1};

        obj.reverse(arr);
        for(int val : arr){
            System.out.print(val + " ");
        }
    }
}