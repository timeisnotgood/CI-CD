package Practice;

public class Solution {

    void selectionSort(int arr[], int n){
        for(int i = 0; i <= n-1; i++){
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }

            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
    }

    void bubbleSort( int arr[], int n){
        for(int i = n-1; i >= 0; i--){
            int swap = 0;
            for(int j = 0; j <= i -1; j++){
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                    swap = 1;
                }
            }

            if (swap == 0) break;
        }
    }

    void insertionSort(int arr[], int n){
        for(int i = 0; i <= n - 1; i++){
            int j = i;
            while (j > 0 && arr[j-1] > arr[j]) {
                int temp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = temp;
                j--;
            }
        }
    }

    int deleteDuplicate(int[] arr){
        int i = 0;
        for (int j = 1; j < arr.length; j++) {
            if (arr[i] != arr[j]) {
                i++;
                arr[i] = arr[j];
            }
        }
        return i + 1;
    }

    void reverse(){
        int[]arr = {-1,-100,3,99};
        int temp = arr[arr.length - 1];
        int k = 3;

        for(int j = 0; j <= k - 1; j++){
            for (int i = arr.length - 1; i >= 0; i--) {
                if (i == 0) {
                    arr[i] = temp;
                    temp = arr[arr.length - 1];
                    break;
                }
                arr[i] = arr[i-1];
            }
        }


        for (int i = 0; i < arr.length; i++) {
            System.out.print(" " + arr[i]);
        }

        System.out.println("------->" + k);
    }


    public static void main(String[] args) {

        Solution algo = new Solution();

        int[] arr = {13,46,24,52,20,9};
        // System.out.println("Before ---> " + arr.toString());
        // algo.insertionSort(arr, arr.length );

        // int[] arr2 = {0,0,1,1,1,2,2,3,3,4};
        algo.reverse();
        
    }

    
}