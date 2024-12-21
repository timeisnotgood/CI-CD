package Practice;

import java.security.KeyStore.Entry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

// class InnerHashTables<K, V> {

//     private class Entry<K,V> {
//         K key;
//         V value;

//         Entry(K key, V value){
//             this.key = key;
//             this.value = value;
//         }
//     }

//     private LinkedList<Entry<K, V>>[] buckets;
//     private int capacity;

//     public InnerHashTables(int capacity){
//         this.capacity = capacity;
//         buckets = new LinkedList[capacity];
//         for (int i = 0; i < capacity; i++) {
//             buckets[i] = new LinkedList<>();
//         }
//     }

//     public int getHash(K key){  // Function to generate HashCode to key
//         return Math.abs(key.hashCode()) % capacity ;
//     }

//     public void put(K key, V value){

//         int index  = getHash(key);  // Get the converted key

//         for (Entry<K,V> linkedList : buckets[index]) { // find's the key in table
//             if (linkedList.key.equals(key)) {
//                 linkedList.value = value;
//                 return;
//             }
//         }

//         buckets[index].add(new Entry(key, value));
//     }

//     public V get(K key){

//         int index  = getHash(key);

//         for (Entry<K,V> linkedList : buckets[index]) {
//             if (linkedList.key.equals(key)) {
//                 return linkedList.value;
//             }
//         }
//         return null;
//     }
// }


class Tables<K, V>{

    private class Entry<K,V>{
        K key; V value;

        Entry(K key, V value){
            this.key = key;
            this.value = value;
        }
    }

    private LinkedList<Entry<K, V>>[] Bucket;
    private int Capacity;

    Tables(int capacity){
        this.Capacity = capacity;
        Bucket = new LinkedList[capacity];

        for (int i = 0; i < capacity; i++) {
            Bucket[i] = new LinkedList<>();
        }
    }

    public int getHash(K key){
        return Math.abs(key.hashCode()) % Capacity;
    }

    public void put(K key, V value){
        int index = getHash(key);
        for (Entry<K,V> list : Bucket[index]) {
            if (list.key.equals(key)) {
                list.value = value;
                return;
            }
        }

        Bucket[index].add(new Entry(key, value));
    }

    public V get(K key){
        int index = getHash(key);
        for (Entry<K,V> list : Bucket[index]) {
            if (list.key.equals(key)) {
                return list.value;
            }
        }
        return null;
    }
    
}
public class HashTables<T> {

    T vals;
    public static void main(String[] args) {
        Tables Users = new Tables(10);
        HashTables ownClass = new HashTables<>();

        Users.put("One", "Bhoopathi");
        Users.put("Two", "Lissan");
        Users.put("Three", "Gokul");
        Users.put("Four", "Achu");
        Users.put("Five", "Sajar");

        Scanner UserValue = new Scanner(System.in);
        System.out.println("Entre Id : ");
        ownClass.vals = UserValue.nextLine();

        if (Users.get(ownClass.vals) != null) {
            System.out.println("--->  " + Users.get(ownClass.vals));
        }else{
            System.out.println("No element Found");
        }
        
    }
}