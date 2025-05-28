package Practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    void mergeSort(int[] arr, int low, int high){
        if (low < high) {
            int mid = (low + high) /2;
            mergeSort(arr, low, mid);
            mergeSort(arr, mid + 1, high);
            merge(arr, low, mid, high);
        }
    }

    void merge(int[] arr, int low, int mid, int high){
        ArrayList<Integer> list = new ArrayList<>();
        int left = low;
        int right = mid + 1;

        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                list.add(arr[left]);
                left++;
            }else{
                list.add(arr[right]);
                right++;
            }
        }
    }

    ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj, int cap){
        ArrayList<Integer> bfs = new ArrayList<>();
        boolean[] vis = new boolean[cap - 1];
        Queue<Integer> q = new LinkedList<>();

        vis[0] = true;
        q.add(0);

        while (!q.isEmpty()) {
            Integer node = q.poll();
            bfs.add(node);
            for(int it : adj.get(node)){
                if (vis[it] != true) {
                    vis[it] = true;
                    q.add(it);
                }
            }
        }
        return bfs;
    } 

    ArrayList<Integer> dfsmethod(ArrayList<ArrayList<Integer>> adj, int cap){
        ArrayList<Integer> dfs = new ArrayList<>();
        boolean[] vis = new boolean[cap - 1];
        dfs(0, adj, dfs, vis);
        return dfs;
    }

    void dfs(int node, ArrayList<ArrayList<Integer>> adj,  ArrayList<Integer> dfs, boolean[] vis){
        vis[node] = true;
        dfs.add(node);
        for(int it : adj.get(node)){
            if (vis[it] != true) {
                dfs(it, adj, dfs, vis);
            }
        }
    }

    public static void main(String[] args) {
        Solution obj = new Solution();
    }
}