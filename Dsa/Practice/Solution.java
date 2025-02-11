package Practice;


class Stack {
    int[] data;
    int capacity;
    int size;
    
    Stack(int cap){
        this.capacity = cap;
        this.size = 0;
        this.data = new int[capacity];
    }

    void Push(int val){
        if (size == capacity) {
            System.out.println("Stack error");
        }
        data[size] = val;
        size ++;
    }

    void Pop(){
        if (size == 0) {
            System.out.println("Stack is Empty");
        }
        size --;
    }

    


}
public class Solution {

    
}