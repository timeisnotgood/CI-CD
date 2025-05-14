package Practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

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

    void printAdj(ArrayList<ArrayList<Integer>> list){
        int i = 0;
        for(ArrayList<Integer> node : list ){
            System.out.print(i + " ->  ");
            for(Integer num : node){
               System.out.print(num + " ");
            }
            System.out.println();
            i += 1;
        }
    }

    public ArrayList<Integer> bfsSearch(){
        ArrayList<Integer> bfs = new ArrayList<>();
        boolean[] vis = new boolean[cap];
        Queue<Integer> q = new LinkedList<>();

        q.add(0);
        vis[0] = true;

        while (!q.isEmpty()) {
            Integer node = q.poll();
            bfs.add(node);

            for(Integer it : list.get(node)){
                if (vis[it] == false) {
                    vis[it] = true;
                    q.add(it);
                }
            }
        }

        return bfs;
    }

    public static void main(String[] args) {
        Solution obj = new Solution(7);

        obj.addNode(0, 1);
        obj.addNode(0, 2);
        obj.addNode(1, 3);
        obj.addNode(1, 4);
        obj.addNode(2, 5);
        obj.addNode(2, 6);

        ArrayList<Integer> list = obj.bfsSearch();
        for(Integer num : list){
            System.out.println(" -- > " + num);
        }
    }
}