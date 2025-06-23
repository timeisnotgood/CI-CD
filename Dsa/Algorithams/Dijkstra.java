package Algorithams;

import java.util.ArrayList;
import java.util.Arrays;
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

            System.out.println("------->"+adj.get(node).size());

            for(int i = 0; i < adj.get(node).size();i++) { 
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


    public static void main(String[] args) {
        int V = 5;
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Edges
        adj.get(0).add(new ArrayList<>(Arrays.asList(1, 2)));
        adj.get(0).add(new ArrayList<>(Arrays.asList(2, 4)));
        adj.get(1).add(new ArrayList<>(Arrays.asList(2, 1)));
        adj.get(1).add(new ArrayList<>(Arrays.asList(3, 7)));
        adj.get(2).add(new ArrayList<>(Arrays.asList(4, 3)));
        adj.get(3).add(new ArrayList<>(Arrays.asList(4, 1)));

        int[] result = dijkstra(V, adj, 0);

        // System.out.println("Shortest distances from node 0:");
        // System.out.println(Arrays.toString(result));
    }

}
