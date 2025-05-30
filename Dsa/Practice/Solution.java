package Practice;

import java.util.ArrayList;

public class Solution {

    public void mergeSort(int[] arr, int low, int high){
        if ((low < high)) {
            int mid = (low + high) / 2;

            mergeSort(arr, low, mid);
            mergeSort(arr, mid + 1, high);
            merge(arr, low, mid, high);
        }
    }

    public void merge(int[] arr, int low, int mid, int high){
        ArrayList<Integer> list = new ArrayList<>();
        int left = low;
        int right = mid + 1;

        while (left <= mid && right <= high) {
            if(arr[left] <= arr[right]) {
                list.add(arr[left]);
                left++;
            }else{
                list.add(arr[right]);
                right++;
            }
        }

        while (left <= mid) {
             list.add(arr[left]);
            left++;
        }

        while (right <= high) {
            list.add(arr[right]);
                right++;
        }

        for(int i = low; i <= high;i++){
            arr[i] = list.get(i - low);
        }
    }

public void quickSort(int[] arr, int low, int high){
    if (low < high) {
        int prevIndex = partition(arr, low, high);
        quickSort(arr, low, prevIndex - 1);
        quickSort(arr, prevIndex + 1, high);
    }
}

public int partition(int[] arr, int low, int high){
    int peviot = arr[low];
    int i = low;
    int j = high;

    while (i < j) {
        while (arr[i] <= peviot && i <= high - 1) {
            i++;
        }

        while (arr[j] > peviot && j >= low + 1) {
            j--;
        }

        if (i < j) {
            swap(arr, i, j);
        }
    }

    swap(arr, low, j);
    return j;

}

public void swap(int[] arr, int i, int j){
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
}

    public static void main(String[] args) {
        System.out.println("Hello");

        int[] arr = {2, 5, 8, 1, 3, 7};

        Solution obj = new Solution();

        obj.quickSort(arr, 0, arr.length - 1);

        for(int num : arr){
            System.out.print(num + " ");
        }
    }
}