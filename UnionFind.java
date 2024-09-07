import java.lang.reflect.Array;
import java.util.*;
public class UnionFind {
    public static void main(String[] args) {

        int arr[] = {6,7,4,9,3,1,5,2,8};
        int n = arr.length;

        // accending order sort

        // for(int i=0; i < n - 1; i++){
        //     for(int j=0;j < n - i -1; j++){
        //         if (arr[j] > arr [j +1]) {
        //             int temp = arr[j];
        //             arr[j] = arr[j+1];
        //             arr[j+1] = temp;
        //         }
        //     }
        // }

        for(int i=0; i< n - 1; i++){
            for(int j=0;j < n-i-1; j++){
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }

        for (int i : arr) {
            System.out.println(" acc --> " + i);
        }


    }
}
