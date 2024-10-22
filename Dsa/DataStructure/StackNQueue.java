package DataStructure;

/**
 * InnerSolution
 */
class Stack {
    int top = -1;
    int[] arr = new int[10];

    // Insert in Stach

    void push(int x){
        if (top == 10) System.out.println("memory is full");

        top = top+1;
        arr[top] = x;
    }

    int top(){
        return arr[top];
    }

    void pop(){
        if (top == -1){
            System.out.println("no value in stack");
            return;
        }
        top = top-1;
    }

    int size(){
        if (top == -1) return 0;

        return top + 1;
    }
}

/**
 * Queue
 */
class Queue {

    int currentsiz = -1;
    int arr[] = new int[10];
    int start = -1;
    int end = -1;
    int size = 10;

    void push(int x){
        currentsiz = currentsiz +1;
        if (currentsiz == size) {
            System.out.println("Memory out of size");
            return;
        }else if (currentsiz == 0) {
            start = 0; end = 0;

        }else{
            end = (end+1)% size;
        }

        arr[end] = x;
    }

    void pop(){
        if (currentsiz == -1) {
            System.out.println("no elements in memory to delete");
            return;
        }

        int element = arr[start];

        if (currentsiz == 0) {
            currentsiz = -1; start = -1; end =-1;
        }

        start = start+1;
        currentsiz = currentsiz-1;
    }

    int top(){
        return arr[start];
    }

    int size(){
        return currentsiz +1;
    }
    
}

public class StackNQueue {
    public static void main(String[] args) {
        Queue arr = new Queue();

        arr.push(5);
        arr.push(4);
        arr.push(3);
        arr.push(2);
        arr.push(1);

        System.out.println("sdf -->  "+ arr.top());
    }
}
