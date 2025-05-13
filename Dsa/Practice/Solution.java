package Practice;

import java.util.ArrayList;

public class Solution {

    ArrayList<ArrayList<Integer>> list;
    int cap;

    Solution(int cap){
        this.cap = cap;
        this.list = new ArrayList<>(cap);

        for (int i = 0; i < cap; i++) {
            list.add(new ArrayList<>());
        }
    }

    void addNode(int v, int e){
        list.get(v).add(e);
        list.get(e).add(v);
    }

    void printAll(){
        for (int i = 0; i < cap; i++) {
            System.out.println(list.get(i));
        }
    }

    public static void main(String[] args) {
        Solution obj = new Solution(10);

        obj.addNode(1, 2);
        obj.addNode(1, 3);
        obj.addNode(2, 4);
        obj.addNode(2, 5);
        obj.addNode(3, 6);
        obj.addNode(3, 7);

        obj.printAll();
    }
}