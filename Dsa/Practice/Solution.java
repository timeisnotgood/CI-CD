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

    void GetData(){
        for (int i = 0; i < size; i++) {
            System.out.println(data[i]);
        }
    }
}

class Queue{
    int start;
    int end;
    int[] data;
    int current;
    int size = 0;
}
public class Solution {

    public static void main(String[] args) {
        Stack stack = new Stack(10);

        stack.Push(4);
        stack.Push(5);
        stack.Push(6);
        stack.Push(7);

        stack.GetData();
    }

    
}