package Practice;
import java.util.ArrayList;

public class Solution {

    ArrayList<ArrayList<Integer>> list;
    int v;

    Solution(int v){
        this.v = v;
        this.list = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            list.add(new ArrayList<>());
        }
    }

    void addEdges(int v, int e){
        list.get(v).add(e);
        list.get(e).add(v);
    }

    void removeEdges(int v, int e){
        list.get(v).add(0);
        list.get(e).add(0);
    }

    void printGraph(){

        for (int i = 0; i < v; i++) {
            System.out.print("Vertex " + i + ":");
            for(int data: this.list.get(i)){
                System.out.println(" -- " + data );
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Solution graph = new Solution(6);

        graph.addEdges(0, 1);
        graph.addEdges(1, 2);
        graph.addEdges(1, 3);
        graph.addEdges(2, 4);
        graph.addEdges(3, 5);

        graph.printGraph();
    }

}