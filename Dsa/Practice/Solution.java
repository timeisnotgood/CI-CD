package Practice;

import java.util.LinkedList;

public class Solution<k, v> {

    static class Entry<k,v> {
        k key;
        v val;
        Entry(k key, v val){
            this.key = key;
            this.val = val;
        }
    }

    LinkedList<Entry<k,v>>[] bucket;
    int cap;

    Solution(int cap){
        this.cap = cap;
        this.bucket = new LinkedList[cap];
        for (int i = 0; i < bucket.length; i++) {
            this.bucket[i] = new LinkedList<>();
        }
    }

    int index(k key){
        return Math.abs(key.hashCode()) % this.cap;
    }

    void addPairs(k key, v val){
        int i = index(key);

        for(Entry<k, v> entry : bucket[i]){
            if (entry.key.equals(key)) {
                entry.val = val;
                return;
            }
        }
        bucket[i].add(new Entry(key, val));
    }
    
}