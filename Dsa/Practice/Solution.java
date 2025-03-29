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


    public static void main(String[] args) {

        Solution algo = new Solution();

        int[] arr = {13,46,24,52,20,9};
        // System.out.println("Before ---> " + arr.toString());
        // algo.insertionSort(arr, arr.length );

        int[] arr2 = {0,0,1,1,1,2,2,3,3,4};
        algo.deleteDuplicate(arr2);
        
    }

    
}