package Practice;

public class Solution {

    void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    void selectSort(int[] arr, int n){
        for(int i = 0;i <= n - 2;i++){
            int min = i;
            for(int j = i;j <= n -1;j++){
                if(arr[j] < arr[min]) min = j;
            }
            swap(arr, i, min);
        }
    }

    void bubbleSort(int[] arr, int n){
        for(int i = n - 1;i >= 1;i--){
            for(int j = 0;j <= i - 1;j++){
                if(arr[j] > arr[j + 1]) swap(arr, j, j+1);
            }
        }
    }

    void insertionSort(int[] arr, int n){
        for(int i = 0; i <= n - 1;i++){
            int j = i;
            while (j > 0 && arr[j] < arr[j - 1]) {
                swap(arr, j, j - 1);
                j--;
            }
        }
    }

    public static void main(String[] args) {
        Solution obj = new Solution();

        int[] arr = {6,2,8,99,3,1};
        obj.insertionSort(arr, arr.length);
        
        for(int i : arr){
            System.out.print(i + " ");
        }
    }
}