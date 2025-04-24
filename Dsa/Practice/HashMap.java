package Practice;

import java.security.KeyStore.Entry;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

public class HashMap<K, V> {
   
    static class Entry<K, V> {
        K key;
        V val;

        Entry(K key, V val){
            this.key = key;
            this.val = val;
        }
    }

    LinkedList<Entry<K, V>>[] bucket;
    int size;

    HashMap(int size){
        this.size = size;

        bucket = new LinkedList[size];

        for (int i = 0; i < size; i++) {
            bucket[i] = new LinkedList<>();
        }
    }

    public int getIndex(K key){
        return Math.abs(key.hashCode()) % size;
    }

    // Insertion 

    public void put(K key, V val){
        int index = getIndex(key);

        for(Entry<K, V> entry : bucket[index]){
            if (entry.key == key) {
                entry.val = val;
            }
        }

        bucket[index].add(new Entry(key, val));
    }

    // delection

    public V lookUp(K key){
        int index = getIndex(key);

        for(Entry<K, V> list : bucket[index]){
            if (list.key == key) {
                return list.val;
            }
        }

        return null;
    }

    public void delete(K key){
        int index = getIndex(key);

        LinkedList<Entry<K, V>> list = bucket[index];
        list.removeIf(entry -> entry.key.equals(key));
    }

    public void listing(){
        int[] arr = {1, 2, 5, 3, 1, 2};
        ArrayList<Integer> list = new ArrayList<>();
        
        int max = arr[arr.length - 1];
        list.add(max);

        for (int i = arr.length - 1; i >=0 ; i--) {
            if (arr[i] > max) {
                max = arr[i];
                list.add(max);
            }
        }

        Collections.reverse(list);
        System.out.println(list);  // Output: [5, 3, 2]
    }




    public static void main(String[] args) {
        HashMap map = new HashMap<>(10);
        // map.put("one", "Bhoop");
        // map.put("two", "liss");
        // map.put("three", "gook");

        // System.out.println(" ----- > " + 
        // map.lookUp("three")
        // );

        // map.delete("two");

        // System.out.println(" ----- > " + 
        // map.lookUp("two")
        // );

        map.listing();
    }


}
