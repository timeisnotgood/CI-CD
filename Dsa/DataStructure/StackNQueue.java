package DataStructure;

// /**
//  * Stack
//  */
// class Stack {

//     int top = -1;
//     int[] val = new int[10];

//     void push(int x){
//         if (top >= 10) return;

//         top = top+1;
//         val[top] = x; 
//     }

//     int top(){
//         if (top == -1) return 0;

//         return val[top];
//     }

//     void pop(){
//         if (top == -1) return ;

//         top = top-1;
//     }
// }

/**
 * Queue
 */
class Queue {
    int current = -1;
    int[] arr = new int[10];
    int start = -1;
    int end = -1;

    void push(int x){
        this.current = this.current+1;
        if (this.start == -1) {
            this.start = this.start+1;
        }
        this.end = this.end+1;
        this.arr[this.current] = x;
    }

    int top(){
        return this.arr[this.start];
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
