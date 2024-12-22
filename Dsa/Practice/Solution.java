package Practice;

class Stak {
    int top = -1;
    int arr[];

    Stak(int capacit){
        this.arr = new int[capacit];
    }

    void Push(int val){
        if (top == 10) {
            System.out.println("stack is Bull");
        }

        top = top + 1;
        arr[top] = val;
    }

    void Pop(){
        if (top == -1) {
            System.out.println("No data in Stack");
            return;
        }

        top = top - 1;
    }

    void getDatas(){
        for (int i = 0; i <= top; i++) {
            System.out.println("---> " + arr[i]);
        }
    }
    
}

class Queue {

    int currentsiz = -1;
    int start = -1;
    int top = -1;
    int capacity;
    int arr[];

    Queue(int capacity){
        this.capacity = capacity;
        arr = new int[capacity];
    }

    void push(int value){
        if (currentsiz == capacity) {
            System.out.println("Queue is Full");
            return;
        }else if (start == -1) {
            start = top = 0;
        }else{
            top = (top +1) % capacity;
        }

        arr[top] = value;
    }

    void Pop(){
        if (top == -1) {
            System.out.println("Queue is empty");
            return;
        }

        start = start+1;
    }

    int Top(){
        if (top == -1) {
            System.out.println("Queue is empty");
        }

        return arr[start];
    }

    void getallDatas(){
        for (int i = 0; i <= top; i++) {
            System.out.println("---> " + arr[i]);
        }
    }
}


public class Solution {

    public static void main(String[] args) {
        // Stak users = new Stak(10);
        int ids[] = {4,7,2,8,2,23,74};

        // for (int i = 0; i < ids.length; i++) {
        //     users.Push(ids[i]);
        // }

        // users.getDatas();

        Queue qq = new Queue(10);

        for (int i = 0; i < ids.length; i++) {
            qq.push(ids[i]);
        }

        qq.getallDatas();
        System.out.println(
            "dfdfg" + 
            qq.Top()

        );


    }
    
}