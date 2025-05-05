package Practice;

public class Solution {

    int heap[];
    int size, cap;

    Solution(int cap){
        this.cap = cap;
        this.size = 0;
        this.heap = new int[cap];
    }

    int parentIndex(int i){return (i-1) / 2;}
    int leftIndex(int i){return (i * 2) + 1;}

    public static void main(String[] args) {
        System.out.println("one");
    }
}