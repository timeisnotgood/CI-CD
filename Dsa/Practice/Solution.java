package Practice;

public class Solution {

    public void quickSort(int[] arr, int low, int high){
        if(low < high){
            int peviotIndex = partetion(arr, low, high);
            quickSort(arr, low, peviotIndex - 1);
            quickSort(arr, peviotIndex + 1, high);
        }
    }

    public int partetion(int[] arr, int low, int high){
        int peviot = arr[low];
        int i = low;
        int j = high;

        while (i < j) {
            while (i <= high && arr[i] <= peviot) {
                i++;
            }

            while (j >= low && arr[j] > peviot) {
                j--;
            }

            if (i < j) {
                swap(arr, i, j);
            }
        }

        swap(arr, low, j);

        return j;
    }

    void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    void SelectionSort(int[] arr){
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) min = j;
            }
            swap(arr, i, min);
        }
    }

    void bubbleSort(int[] arr){
        for (int i = arr.length - 1; i >= 0; i--) {
            for(int j = 0; j <= i - 1; j ++){
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
            
        }
    }

    void insertionSort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            int j = i;

            while (j > 0 && arr[j - 1] > arr[j]) {
                swap(arr, j - 1, j);
                j--;
            }
        }
    }



    public static void main(String[] args) {
        System.out.println("hello");

        int[] arr = {2,3,7,5,4,1,6};

        Solution obj = new Solution();
        obj.insertionSort(arr);

        for(int num : arr){
            System.out.print(num + " ");
        }
    }
}