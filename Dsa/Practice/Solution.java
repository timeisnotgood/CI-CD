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

    public static void main(String[] args) {
        System.out.println("hello");

        int[] arr = {2,3,7,5,4,1,6};

        Solution obj = new Solution();
        obj.quickSort(arr, 0, arr.length - 1);

        for(int num : arr){
            System.out.print(num + " ");
        }
    }
}