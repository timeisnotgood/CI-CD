package Practice;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {

    static ArrayList<ArrayList<Integer>> matrixRow(ArrayList<ArrayList<Integer>> matrix, int m, int n, int i){
        for (int j = 0; j < n; j++) {
            if (matrix.get(i).get(j) != 0) {
                matrix.get(i).set(j, -1);
            }
        }
        return matrix;
    }

    static ArrayList<ArrayList<Integer>> matrixCol(ArrayList<ArrayList<Integer>> matrix, int m, int n, int i){
        for (int j = 0; j < m; j++) {
            if (matrix.get(j).get(i) != 0) {
                matrix.get(j).set(i, -1);
            }
        }
        return matrix;
    }

    static ArrayList<ArrayList<Integer>> zeroMatrix( ArrayList<ArrayList<Integer>> matrix, int m, int n){
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix.get(i).get(j) == 0) {
                    matrixRow(matrix, m, n, i);
                    matrixCol(matrix, m, n, j);
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix.get(i).get(j) == -1) {
                    matrix.get(i).set(j, 0);
                }
            }
        }

        return matrix;
    }

    public void setZeroes(int[][] matrix) {
        
        int m = matrix.length;
        int n = matrix[0].length;
        boolean row[] = new boolean[m];
        boolean col[] = new boolean[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                   row[i] = true;
                   col[j] = true;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            if (row[i] == true) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (col[i] == true) {
                for (int j = 0; j < m; j++) {
                    matrix[j][j] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> Matrix = new ArrayList<>();

        Matrix.add(new ArrayList<>(Arrays.asList(1,1,1)));
        Matrix.add(new ArrayList<>(Arrays.asList(1,0,1)));
        Matrix.add(new ArrayList<>(Arrays.asList(1,1,1)));

        int m = Matrix.size();
        int n = Matrix.get(0).size();

        ArrayList<ArrayList<Integer>> ans = zeroMatrix(Matrix, m, n);

        System.out.println("The Final matrix is: ");
        System.out.println(" ");

        for (ArrayList<Integer> row : ans) {
            for (Integer ele : row) {
                System.out.print(ele + " ");
            }
            System.out.println();
        }
    }
}