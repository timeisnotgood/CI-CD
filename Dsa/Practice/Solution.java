package Practice;

public class Solution {

    public static void main(String[] args) {
        
        int arr[] = {9,8,5,3,2,1,9,5};

        int max = arr[0];
        int count = 0;


        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == max) {
                count ++;
            }

            
        }

        System.out.println("dsgfdfg---" + max +  " " + count);
    }
    
}