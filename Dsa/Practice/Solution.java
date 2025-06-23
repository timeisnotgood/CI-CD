package Practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class Pair {
    int distance;
    int node;
    Pair(int distance, int node){
        this.distance = distance;
        this.node = node;
    }
}
public class Solution {

    static int[] dijkstra(int v, ArrayList<ArrayList<ArrayList<Integer>>> adj, int s ){
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> Integer.compare(x.distance, y.distance));
        int[] vis = new int[v];

        for (int i = 0; i < v; i++) {vis[i] = (int)(1e9);}
        vis[s] = 0;
        pq.add(new Pair(s, 0));

        while (pq.size() != 0) {
            int distance = pq.peek().distance;
            int node = pq.poll().node;

            for(int i = 0;i < adj.get(node).size(); i++){
                int adjWeight = adj.get(node).get(i).get(1);
                int adjnode = adj.get(node).get(i).get(0);

                if (distance + adjWeight < vis[adjnode]) {
                    vis[adjnode] = distance + adjWeight ;
                    pq.add(new Pair( vis[adjnode], adjnode));
                }
            }
        }
        return vis;
    }

    public static void main(String[] args) {
        System.out.println("hello There ---->");
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            adj = new ArrayList<>();
        }

         // Edges
        adj.get(0).add(new ArrayList<>(Arrays.asList(1, 2)));
        adj.get(0).add(new ArrayList<>(Arrays.asList(2, 4)));
        adj.get(1).add(new ArrayList<>(Arrays.asList(2, 1)));
        adj.get(1).add(new ArrayList<>(Arrays.asList(3, 7)));
        adj.get(2).add(new ArrayList<>(Arrays.asList(4, 3)));
        adj.get(3).add(new ArrayList<>(Arrays.asList(4, 1)));

        int[] result = dijkstra(5, adj, 0);
    }
}