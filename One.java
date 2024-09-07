import java.util.*;
/**
 * One
 */
/**
 * One
 */
public class One {

    public static void main(String[] args) {
        System.out.println("1");
        int num[] = {10,5,10,15,10,5};
        hash(num);
    }

    static void hash(int arr[]){
        Map<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            if (hashMap.containsKey(arr[i])) {
                hashMap.put(arr[i], hashMap.get(arr[i])+1);
            }else{
                hashMap.put(arr[i], 1);
            }
        }
        int minele = 0;
        int mincount = arr.length;
        int maxele = 0;
        int maxcount = 0;

        for(Map.Entry<Integer, Integer> entry : hashMap.entrySet()){
            int count = entry.getValue();
            int element = entry.getKey();

            if (count > maxcount) {
                maxcount = count;
                maxele = element;
            }

            if(count < mincount){
                mincount = count;
                minele = element;
            }

        }

        System.out.println("max element " + maxele +" : " + maxcount);
        System.out.println("min element " + minele +" : " + mincount);
    }
}