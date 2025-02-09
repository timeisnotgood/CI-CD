package Practice;

public class Solution {

    int data[];
    int capacity = 10;
    int size ;

    Solution(int cap){
        this.capacity = cap;
        this.data = new int[capacity];
    }

    void push(int val){
        if (size == capacity) {
            System.out.println("Array is BUll --->");
        }

        data[size] = val;
        size ++;
    }

    void Pop(){
        if (size == 0) {
            System.out.println("Arrau is Empty");
        }
        size --;
    }

    

    public static void main(String[] args) {
        

        Solution Array = new Solution(10);

        Array.push(1);
        Array.push(2);
        Array.push(5);
        Array.push(6);

        Array.Pop();


    }
}