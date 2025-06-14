package Algorithams;

import java.util.ArrayList;
import java.util.PriorityQueue;

class Pair {
    int distance;
    int node;

    Pair(int distance, int node) {
        this.distance = distance;
        this.node = node;
    }
}


public class Dijkstra {
    //Function to find the shortest distance of all the vertices 
    //from the source vertex S. 
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) { 
        // min-heap 
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> Integer.compare(x.distance, y.distance));
        int[]dist = new int[V]; 

        for(int i = 0; i<V;i++) dist[i] = (int)(1e9); 

        dist[S] = 0; 
        pq.add(new Pair(0,S)); 

        while(pq.size() != 0) { 
            int dis =  pq.peek().distance; 
            int node =  pq.peek().node; 
            pq.remove(); 
            for(int i = 0; i<adj.get(node).size();i++) { 
                int edgeWeight = adj.get(node).get(i).get(1); 
                int adjNode =  adj.get(node).get(i).get(0); 
                if(dis + edgeWeight < dist[adjNode]) { 
                    dist[adjNode] = dis + edgeWeight; 
                    pq.add(new Pair(dist[adjNode], adjNode)); 
                } 
            } 
        } 
        return dist; 

    }
}
