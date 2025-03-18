package Practice;
import java.util.ArrayList;
class AdjList {

    void addEdjes(ArrayList<ArrayList<Integer>> al, int i, int j){
        al.get(i).add(j);
        al.get(j).add(i);
    }
}

public class Solution {

    private boolean adjMatrix[][];  // Changed Boolean[][] to boolean[][]
    private int numVertices;

    Solution(int numVertices) {
        this.numVertices = numVertices;
        this.adjMatrix = new boolean[this.numVertices][this.numVertices];  // Defaults to false
    }

    void addEdges(int i, int j) {  // Fixed method name
        this.adjMatrix[i][j] = true;
        this.adjMatrix[j][i] = true;
    }

    void removeEdges(int i, int j) {  // Fixed method name
        this.adjMatrix[i][j] = false;
        this.adjMatrix[j][i] = false;
    }

    // Print the matrix
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < this.numVertices; i++) {
            s.append(i + ": ");
            for (int j = 0; j < this.numVertices; j++) {  // Fixed iteration
                s.append((this.adjMatrix[i][j] ? 1 : 0) + " ");
            }
            s.append("\n");
        }
        return s.toString();
    }

    public static void main(String[] args) {
        int v = 4;
        ArrayList<ArrayList<Integer>> am = new ArrayList<ArrayList<Integer>>(v);

        for (int i = 0; i < v; i++)
            am.add(new ArrayList<Integer>());

        AdjList graph = new AdjList();

        graph.addEdjes(am, 0, 1);
        graph.addEdjes(am, 0, 2);
        graph.addEdjes(am, 0, 3);
        graph.addEdjes(am, 1, 2);

        printGraph(am);
    }

      // Print the graph
  static void printGraph(ArrayList<ArrayList<Integer>> am) {
    for (int i = 0; i < am.size(); i++) {
      System.out.println("\nVertex " + i + ":");
      for (int j = 0; j < am.get(i).size(); j++) {
        System.out.print(" -> " + am.get(i).get(j));
      }
      System.out.println();
    }
  }
    
}