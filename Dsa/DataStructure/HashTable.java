package DataStructure;

import java.util.LinkedList;

public class HashTable<K, V> {
    
    static class Entry<K, V> {
        K key;
        V value;
        Entry(K key, V value){
            this.key = key;
            this.value = value;
        }
    }

    LinkedList<Entry<K, V>>[] table;
    int capacity;

    HashTable(int capacity){
        this.capacity = capacity;
        this.table = new LinkedList[capacity];

        for (int i = 0; i < capacity; i++) {
            table[i] = new LinkedList<>();
        }
    }

    int getIndex(K key){
        return Math.abs(key.hashCode()) % capacity;
    }

    void push(K key, V value){
        int index = getIndex(key);

        for (Entry<K,V> linkedList : table[index]) {
            if (linkedList.key.equals(key)) {
                linkedList.value = value;
                return;
            }
        }

        table[index].add(new Entry(key, value));
    }

    

    void getValue(K key){
        int index = getIndex(key);
        for (Entry<K,V> linkedList : table[index]) {
            if (linkedList.key.equals(key)) {
                System.out.println("--->" + linkedList.value);
            }
        }
    }

        // Method to print the entire HashTable
        // void printTable() {
        //     for (int i = 0; i < capacity; i++) {
        //         System.out.print("Index " + i + ": ");
        //         for (Entry<K, V> entry : table[i]) {
        //             System.out.print("{" + entry.key + "=" + entry.value + "} ");
        //         }
        //         System.out.println();
        //     }
        // }

    public static void main(String[] args) {
        HashTable users = new HashTable<>(5);

        users.push(1, "Bhoopathi");
        users.push(2, "lissan");
        users.push(3, "Gokul");
        users.push(4, "Kishore");

        users.getValue(2);

                // Print the entire HashTable
                users.printTable();
    }
}
