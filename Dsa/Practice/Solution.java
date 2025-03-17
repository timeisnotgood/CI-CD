package Practice;

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
        Solution graph = new Solution(4);

        graph.addEdges(0, 1);
        graph.addEdges(0, 2);
        graph.addEdges(1, 2);
        graph.addEdges(2, 0);
        graph.addEdges(2, 3);

        System.out.print(graph.toString());
    }
    
}