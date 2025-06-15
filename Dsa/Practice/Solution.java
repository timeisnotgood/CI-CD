package Practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public void mergeSort(int[] arr, int low, int high){
        if (low < high) {
            int mid = (low + high) / 2; 
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

            if(arr[left] <= arr[right]){
                list.add(arr[left]);
                left++;
            }else{
                list.add(arr[right]);
                right++;
            }
        }

        while (left <= mid) {
            list.add(arr[left]);
            left++;
        }

        while (right <= high) {
            list.add(arr[right]);
            right++;
        }

        for(int i = low; i <= high; i++){
            arr[i] = list.get(i - low);
        }
    }

    void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    void quickSort(int[] arr, int low, int high){
        if(low < high){
            int peviotIndex = partetion(arr, low, high);
            quickSort(arr, low, peviotIndex - 1);
            quickSort(arr, peviotIndex + 1, high);
        }
    }

    int partetion(int[] arr, int low, int high){
        int peviot = arr[high];
        int i = low -1;
        

        for (int j = low; j < high; j++) {
            if (arr[j] < peviot) {
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i + 1, high);
        return i+ 1;
    }

    void bfs(ArrayList<ArrayList<Integer>> adj, int v){
        ArrayList<Integer> bfs = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[v];

        vis[0] = true;
        q.add(0);

        while (!q.isEmpty()) {
            int node = q.poll();
            bfs.add(node);

            for(int it : adj.get(node)){
                if (vis[it] != true) {
                    vis[it] = true;
                    q.add(it);
                }
            }
        }
    }

    void dfsMain(ArrayList<ArrayList<Integer>> adj, int v){
        ArrayList<Integer> dfs = new ArrayList<>();
        boolean[] vis = new boolean[v];
        dfs(0, adj, dfs, vis);
    }

    void dfs(int node, ArrayList<ArrayList<Integer>> adj,  ArrayList<Integer> dfs,  boolean[] vis){
        vis[node] = true;
        dfs.add(node);

        for(int it : adj.get(node)){
            if(vis[it] != true){
                dfs(it, adj, dfs, vis);
            }
        }
    }


    public static void main(String[] args) {

        Solution obj = new Solution();

        int[] arr = {3,2,1,4,7,6,8,9};
        obj.quickSort(arr, 0, arr.length - 1);

        for(int num : arr){
            System.out.print(num + " ");
        }
        
    }
}