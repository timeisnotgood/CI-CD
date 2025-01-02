package Practice;

import java.util.LinkedList;

public class Solution {

    static class HashTable<K, V> {
        class Entry<K, V> {
            K key;
            V value;
            Entry(K key, V value){
                this.key = key;
                this.value = value;
            }

            @Override
            public String toString() {
                return key + "=" + value;
            }
        }

        LinkedList<Entry<K,V>>[] table;
        int cap;

        HashTable(int capacity){
            this.cap = capacity;
            this.table = new LinkedList[cap];

            for (int i = 0; i < cap; i++) {
                table[i] = new LinkedList<>();
            }
        }

        int getHash(K key){
            return Math.abs(key.hashCode()) % cap;
        }

        void push(K key, V value){
            int index = getHash(key);
            for (Entry<K,V> linkedList : table[index]) {
                if (linkedList.key.equals(key)) {
                    linkedList.value = value;
                }
            }
            table[index].add(new Entry(key, value));
        }

        public V get(K key){
            int index = getHash(key);
            for (Entry<K,V> list : table[index]) {
                if (list.key.equals(key)) {
                    return list.value;
                }
            }
            return null;
        }


        public void entireVal(){
            for (int i = 0; i < cap; i++) {
                System.out.println("Bucket " + i + ": " + table[i]);
            }
        }



    }
    public static void main(String[] args) {
        HashTable object = new HashTable<>(5);

        object.push("1", 1);

        object.push("2", 2);

        object.entireVal();

        // System.out.println("--->  " + object.get("2"));

    }   
}