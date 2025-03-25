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

    public static void main(String[] args) {
       Basic algo = new Basic();

       algo.HashingPrefetching();
    }
}