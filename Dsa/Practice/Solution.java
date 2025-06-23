package Practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    ArrayList<Integer> Bfs(ArrayList<ArrayList<Integer>> adj, int v){
        ArrayList<Integer> bfs = new ArrayList<>();
        boolean[] vis = new boolean[v];
        Queue<Integer> q = new LinkedList<>();

        vis[0] = true;
        q.add(0);

        while (!q.isEmpty()) {
            Integer node = q.peek();
            bfs.add(node);
            for(int it : adj.get(node)){
                if(vis[it] != true){
                    vis[it] = true;
                    q.add(it);
                }
            }
        }

        return bfs;
    }

    ArrayList<Integer> Dfs(ArrayList<ArrayList<Integer>> adj, int v ){
        ArrayList<Integer> dfs = new ArrayList<>();
        boolean[] vis = new boolean[v];
        dfsSearch(0, adj, dfs, vis);
        return dfs;
    }

    void dfsSearch(int node, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> dfs, boolean[] vis){
        vis[node] = true;
        dfs.add(node);

        for(int it : adj.get(node)){
            if (vis[it] != true) {
                dfsSearch(it, adj, dfs, vis);
            }
        }
    }
    public static void main(String[] args) {
        System.out.println(("Helo"));
    }
}