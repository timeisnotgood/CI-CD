package Algorithams;

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

    public static void main(String[] args) {
       TwoPointer pointer = new TwoPointer();
       pointer.subArray();
    }
}
