package Dsa.Algorithams;

public class Basic {

    void HashingPrefetching(){
        int arr[] = {3,5,5,3,2,1,4,4};
        int hash[] = new int[6];

        for (int i = 0; i < arr.length; i++) {
            hash[arr[i]] +=1;
        }

        System.out.println("----->"+ hash[5]);
    }

    void SelectionSort(int[] arr, int n){    

        for (int i = 0; i < n - 1; i++) {
            int min = i;
            for (int j = i+1; j < n; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }

            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }

        System.out.println("Bubble sort --->");

        for (int i = 0; i < arr.length; i++) {
            System.out.println("--->" + arr[i]);
        }
    }

    void BubbleSort(int[] arr, int n){
        for(int i = n -1; i >= 0; i++){
            int swap = 0;

            for(int j = 0; j < i -1;j++){
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                    swap = 1;
                }
            }

            if (swap == 0) break;
        }

        System.out.println("Bubble sort --->");

        for (int i = 0; i < arr.length; i++) {
            System.out.println("--->" + arr[i]);
        }
    }


    public static void InsertionSort(int arr[], int n) {
        for (int i = 1; i < n; i++) {  // Start from index 1
            int j = i;
            while (j > 0 && arr[j - 1] > arr[j]) {
                int temp = arr[j - 1];
                arr[j - 1] = arr[j];
                arr[j] = temp;
                j--;
            }
        }

        System.out.println("Insertion sort --->");

        for (int i = 0; i < arr.length; i++) {
            System.out.println("--->" + arr[i]);
        }
    }

    public static void main(String[] args) {
       Basic algo = new Basic();

    //    algo.HashingPrefetching();

       int selecarr[] = {6,7,2,8,1,4,};

    //    algo.SelectionSort(selecarr, selecarr.length);
       algo.InsertionSort(selecarr, selecarr.length);
    }
}