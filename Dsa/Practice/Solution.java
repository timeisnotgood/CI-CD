package Practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
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

    public void bfss(ArrayList<ArrayList<Integer>> adj, int cap){
        ArrayList<Integer> bfs = new ArrayList<>();
        boolean[] vis = new boolean[cap - 1];
        Queue<Integer> q = new LinkedList<>();

        q.add(0);
        vis[0] = true;

        while (!q.isEmpty()) {
            Integer node = q.poll();
            bfs.add(node);
            for(int it : adj.get(node) ){
                if (vis[it] != true) {
                    vis[it] = true;
                    q.add(it);
                }
            }
        }
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

    void Degree(){
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] rotateMatrix = new int[m][n];

        for (int i = 0; i < n; i++) {
            int[] Column = new int[n];
            for (int j = m -1; j >= 0; j--) {
                Column[(m - 1) - j] = matrix[j][i];
            }
            rotateMatrix[i] = Column;
        }
        for (int i = 0; i < m; i++) {
            matrix[i] = rotateMatrix[i];
        }

        for (int i = 0; i < m; i++) {
            System.out.print("[ ");
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j]);
                if (j != n - 1) {
                    System.out.print(" ");
                }
            }
            System.out.print(" ]");
            System.out.println();
        }
    }

    void swapKthEle(){
        List<Integer> arr = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8));
        int k = 3;
        int i = 0, j = arr.size() - 1;


        while (i < j) {
            if (i + 1 == k) {
                int temp = arr.get(i);
                System.out.println("--> " + arr.get(j));
                arr.set(i, arr.get(j));
                arr.set(j, temp);
                break;
            }
            i++;
            j--;
        }

        for(int num : arr){
            System.out.print( num + " ");
        }
    }

    public static void main(String[] args) {

       Solution obj = new Solution(10);
       obj.swapKthEle();
    }
}