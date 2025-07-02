package Practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public void mergeSort(int[] arr, int low, int high){
        if(low < high){
            int mid = (low + high) / 2;

            mergeSort(arr, low, mid);
            mergeSort(arr, mid + 1, high);
            merge(arr, low, mid, high);
        }
    }

    public void merge(int[] arr, int low, int mid, int high){
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

        while (left <= mid) {
            list.add(arr[left]);
                left++;
        }

        while (right <= high) {
             list.add(arr[right]);
                right++;
        }

        for(int i = low; i <= high;i++){
            arr[i] = list.get(i - low);
        }
    }

    public void quickSort(int[] arr, int low, int high){
        if(low < high){
            int peviotIndex = precession(arr, low, high);
            quickSort(arr, low, peviotIndex - 1);
            quickSort(arr, peviotIndex + 1, high);
        }
    }

    public int precession(int[] arr, int low, int high){
        int peviot = arr[high];
        int i = low;
        int j = high;

        while (i < j) {
            if (arr[i] <= peviot && i <= high - 1) {
                i++;
            }else if (arr[j] > peviot && j >= low + 1) {
                j++;
            }

            while (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[low];
        arr[low] = arr[j];
        arr[j] = temp;
        return j;
    }


    public ArrayList<Integer> Bfs(ArrayList<ArrayList<Integer>> adj, int v){
        ArrayList<Integer> list = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[v];

        q.add(0);
        vis[0] = true;

        while (!q.isEmpty()) {
            int node = q.poll();
            list.add(node);

            for(int iq : adj.get(node)){
                if (vis[iq] != true) {
                    q.add(iq);
                    vis[iq] = true;
                }
            }
        }
        return list;
    }

    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj, int v){
        ArrayList<Integer> dfs = new ArrayList<>();
        boolean[] vis = new boolean[v];
        sortestPath(0, adj, dfs, vis);
        return dfs;
    }

    public void sortestPath(int node, ArrayList<ArrayList<Integer>> adj,  ArrayList<Integer> dfs, boolean[] vis){
        vis[node] = true;
        dfs.add(node);

        for(int iq : adj.get(node)){
            if (vis[iq] != true) {
                sortestPath(iq, adj, dfs, vis);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {2,4,6,1,3,5};

        Solution obj = new Solution();
        obj.mergeSort(arr, 0, arr.length - 1);

        for (int num : arr) {
            System.out.println(num);
        }
    }
}