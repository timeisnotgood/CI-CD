package Practice;

import java.security.KeyStore.Entry;
import java.util.LinkedList;

public class Solution <K, V> {

    static class Entry<K, V> {
        K key;
        V val;

        Entry(K key, V val){
            this.key = key;
            this.val = val;
        }

        @Override
        public String toString() {
            return "(" + key + "--" + val + ")";
        }
    }

    LinkedList<Entry<K, V>>[] bucket;
    int capacity;

    Solution(int cap){
        this.capacity = cap;
        this.bucket = new LinkedList[capacity];

        for (int i = 0; i < bucket.length; i++) {
            this.bucket[i] = new LinkedList<>();
        }
    }

    int getindex(K key){
        return Math.abs(key.hashCode()) % capacity;
    }

    void put(K key, V val){
        int index = getindex(key);

        for(Entry<K, V> list : bucket[index]){
            if (list.key == key) {
                list.val = val;
                return;
            }
        }

        bucket[index].add(new Entry<K,V>(key, val));
    }

    V getValue(K key){
        int index = getindex(key);

        for(Entry<K, V> list : bucket[index]){
            if (list.key.equals(key)) {
                System.out.println(list.val);
            }
        }

        return null;
    }

    void printAll(){
        for (int i = 0; i < capacity; i++) {
            System.out.println("Bucket ---> " + i);
            if (bucket[i].isEmpty()) {
                System.out.println("Table is Empty !");
            }else{
                for(Entry<K, V> list : bucket[i]){
                    System.out.println(list);
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        Solution table = new Solution<>(5);

        table.put("one", "lissan");
        table.put("two", "kishore");
        table.put("three", "akshay");
        table.put("four", "gokul");

        table.getValue("three");

        System.out.println("-------------->");

        table.printAll();
        
    }
}