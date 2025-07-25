package DataStructure;

import java.util.ArrayList;
import java.util.LinkedList;
import  java.util.Queue;

// AdjacencyMatrix
class Matrix {
    int V;
    int data[][];

    Matrix(int cap){
        this.V = cap;
        this.data = new int[V][V];
    }

    void addEdjes(int v, int e){
        data[v][e] = 1;
        data[e][v] = 1;
    }

    void removeEdjes(int v, int e){
        data[v][e] = 0;
        data[e][v] = 0;
    }

    
}

// AdjacencyList unweighted Graph

class unweighted {

    ArrayList<ArrayList<Integer>> adjlist;
    int V;
    unweighted(int v){
        this.V = v;
        this.adjlist = new ArrayList<>(v);

        for (int i = 0; i < v; i++) {
            adjlist.add(new ArrayList<>());
        }
    }

    void addEdge(int v, int e){
        adjlist.get(v).add(e);
        adjlist.get(e).add(v);
    }

    void printGraph(){

        for (int i = 0; i < V; i++) {
            System.out.print("Vertex " + i + ":");
            for(int data: this.adjlist.get(i)){
                System.out.println(" -- " + data );
            }
            System.out.println();
        }
    }
}

// AdjacencyList weighted Graph

class weighted {
    ArrayList<ArrayList<Pair>> adjList;
    int v;

    static class Pair {
        int e, w;
        Pair(int e, int w){
            this.e = e;
            this.w = w;
        }
    }

    weighted(int v){
        this.v = v;
        this.adjList = new ArrayList<>(v);

        for (int i = 0; i < v; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    void addEdge(int v, int e, int w){
        adjList.get(v).add(new Pair(e, w));
        adjList.get(e).add(new Pair(v, w));
    }

    void printGraph(){
        for (int i = 0; i < v; i++) {
            System.out.println("Vertix - " + i + " : ");
            for (Pair arrayList : adjList.get(i)) {
                System.out.print(" -> (" + arrayList.e + ", " + arrayList.w + ")");
            }
            System.out.println();
        }
    }
    
}


public class Graph {

    ArrayList<Integer> breathFirstSearch(ArrayList<ArrayList<Integer>> adj, int v){
        ArrayList<Integer> bfs = new ArrayList<>();
        boolean[] vis = new boolean[v];
        Queue<Integer> q = new LinkedList<>();

        q.add(0);
        vis[0] =true;

        while (!q.isEmpty()) {
            Integer node = q.poll();
            bfs.add(node);

            for(Integer it : adj.get(node)){
                if (!vis[node]) {
                    q.add(it);
                    vis[it] = true;
                }
            }
        }

        return bfs;
    }

    void search(int node, ArrayList<Integer> dfs, ArrayList<ArrayList<Integer>> adj, boolean[] vis ){
        vis[node] = true;
        dfs.add(node);

        for(Integer it : adj.get(node)){ 
            if(vis[it] == false){
                search(it, dfs, adj, vis);
            }
        }
    }

    ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj, int v){
        ArrayList<Integer> dfs = new ArrayList<>();
        boolean[] vis = new boolean[v];
        search(0, dfs, adj, vis);
        return dfs;
    }
    public static void main(String[] args) {
        weighted g = new weighted(5);

        g.addEdge(0, 1, 15);
        g.addEdge(0, 2, 25);
        g.addEdge(1, 3, 35);
        g.addEdge(2, 4, 45);
        g.printGraph();

    }    
}
