package Practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    ArrayList<ArrayList<Integer>> adj;
    int cap;

    Solution(int cap){
        this.cap = cap;
        this.adj = new ArrayList<>(cap);

        for (int i = 0; i < cap; i++) {
            adj.add(new ArrayList<>());
        }
    }

    void addedges(int v, int e){
        adj.get(v).add(e);
        adj.get(e).add(v);
    }

    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj, int cap){

        ArrayList<Integer> bfss = new ArrayList<>();
        boolean[] vis = new boolean[cap];
        Queue<Integer> q = new LinkedList<>();

        q.add(0);
        vis[0] = true;

        while (!q.isEmpty()) {
            Integer node = q.poll();
            bfss.add(node);

            for(Integer it : adj.get(node)){
                if (vis[it] == false) {
                    vis[it] = true;
                    q.add(it);
                }
            }
        }

        return bfss;

    }

    public ArrayList<Integer> dfsGraph(ArrayList<ArrayList<Integer>> adj, int v){
        ArrayList<Integer> list = new ArrayList<>();
        boolean[] vis = new boolean[v - 1];
        dfs(0, list, adj, vis);
        return list;
    }

    public void dfs(int node, ArrayList<Integer> list, ArrayList<ArrayList<Integer>> adj,  boolean[] vis){
        vis[node] = true;
        list.add(node);

        for(Integer it: adj.get(node)){
            if (vis[it] == false) {
                dfs(it, list, adj, vis);
            }
        }
    }

    public static void main(String[] args) {

        Solution obj = new Solution(7);
        obj.addedges(0, 1);
        obj.addedges(0, 2);
        obj.addedges(1, 3);
        obj.addedges(1, 4);
        obj.addedges(2, 5);
        obj.addedges(2, 6);

        ArrayList<Integer> list = obj.dfsGraph(obj.adj, obj.cap);

        for(int val : list){
            System.out.println("--> " + val);
        }

    }
}