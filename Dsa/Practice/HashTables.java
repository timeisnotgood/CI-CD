// package Practice;

// import java.util.LinkedList;
// import java.util.Scanner;

// class Tables<K, V> {

//     private class Entry<K, V> {
//         K key;
//         V value;

//         Entry(K key, V value) {
//             this.key = key;
//             this.value = value;
//         }

//         @Override
//         public String toString() {
//             return "(" + key + " : " + value + ")";
//         }
//     }

//     private LinkedList<Entry<K, V>>[] Bucket;
//     private int Capacity;

//     Tables(int capacity) {
//         this.Capacity = capacity;
//         Bucket = new LinkedList[capacity];

//         for (int i = 0; i < capacity; i++) {
//             Bucket[i] = new LinkedList<>();
//         }
//     }

//     public int getHash(K key) {
//         return Math.abs(key.hashCode()) % Capacity;
//     }

//     public void put(K key, V value) {
//         int index = getHash(key);
//         for (Entry<K, V> list : Bucket[index]) {
//             if (list.key.equals(key)) {
//                 list.value = value;
//                 return;
//             }
//         }
//         Bucket[index].add(new Entry<>(key, value));
//     }

//     public V get(K key) {
//         int index = getHash(key);
//         for (Entry<K, V> list : Bucket[index]) {
//             if (list.key.equals(key)) {
//                 return list.value;
//             }
//         }
//         return null;
//     }

//     // **Method to print the entire hash table**
//     public void printTable() {
//         System.out.println("\nHash Table Structure:");
//         for (int i = 0; i < Capacity; i++) {
//             System.out.print("Bucket " + i + " -> ");
//             if (Bucket[i].isEmpty()) {
//                 System.out.println("Empty");
//             } else {
//                 for (Entry<K, V> entry : Bucket[i]) {
//                     System.out.print(entry + "  ");
//                 }
//                 System.out.println();
//             }
//         }
//     }
// }


// public class HashTables<T> {

//     T vals;

//     public static void main(String[] args) {
//         Tables<String, String> Users = new Tables<>(10);
//         HashTables<String> ownClass = new HashTables<>();

//         Users.put("One", "Bhoopathi");
//         Users.put("Two", "Lissan");
//         Users.put("Three", "Gokul");
//         Users.put("Four", "Achu");
//         Users.put("Five", "Sajar");

//         // **Print the entire table**
//         Users.printTable();

//         Scanner UserValue = new Scanner(System.in);
//         System.out.println("\nEnter Id: ");
//         ownClass.vals = UserValue.nextLine();

//         if (Users.get(ownClass.vals) != null) {
//             System.out.println("--->  " + Users.get(ownClass.vals));
//         } else {
//             System.out.println("No element Found");
//         }

//         UserValue.close();
//     }
// }



package Practice;

import java.util.LinkedList;


class Table<K, V> {

    
    public class Entry<K, V> {

        K key;
        V val;

        Entry(K key,V val){
            this.key = key;
            this.val = val;
        }

        @Override
        public String toString(){
            return "(" + key + " - " + val + ")";
        }
    }

    private LinkedList<Entry<K, V>>[] Bucket;
    private int capacity;

    Table(int cap){
        this.capacity = cap;
        this.Bucket = new LinkedList[capacity];

        for (int i = 0; i < capacity; i++) {
            this.Bucket[i] = new LinkedList<>();
        }
    }

    int getIndex(K key){
        return Math.abs(key.hashCode()) % capacity;
    }

    void put(K key, V val){
        int index = getIndex(key);

        for (Entry<K,V> list : Bucket[index]) {
            if (list.key == key) {
                list.val = val;
                return;
            }
        }

        Bucket[index].add(new Entry(key, val));
    }


    V getValue(K key){
        int index = getIndex(key);

        for (Entry<K,V> list : Bucket[index]) {
            if (list.key == key) {
                return list.val;
            }
        }

        return null;
    }

    public void printTable() {
        System.out.println("\nHash Table Structure:");
        for (int i = 0; i < capacity; i++) {
            System.out.print("Bucket " + i + " -> ");
            if (Bucket[i].isEmpty()) {
                System.out.println("Empty");
            } else {
                for (Entry<K, V> entry : Bucket[i]) {
                    System.out.print(entry + "  ");
                }
                System.out.println();
            }
        }
    }

    public void printAll(){
        for (int i  = 0; i < capacity; i++) {
            if (Bucket[i].isEmpty()) {
                System.out.println("Tabe is empty");
            }else{
                for(Entry<K, V> entry : Bucket[i]){
                    System.out.println(entry + "");
                }
                System.out.println();
            }
        }
    }
}

public class HashTables<K, V> {
    public static void main(String[] args) {
        Table<String, String> hashTable = new Table<>(10);
        hashTable.put("One", "Bhoopathi");
        hashTable.put("Two", "Hari");
        hashTable.put("Three", "Lissan");
        hashTable.put("Four", "Achu");
        hashTable.put("Five", "Kishore");

        hashTable.printAll();
    }

}