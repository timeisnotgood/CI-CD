package DataStructure;

/**
 * LinkedList
 */
class LinkedLst {
    int data;
    LinkedLst next;

    LinkedLst(int dat){
        this.data = dat;
        this.next = null;
    }

    LinkedLst(int dat, LinkedLst nxt){
        this.data = dat;
        this.next = nxt;
    }
}


/**
 * Stack
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

/**
 * StackInLL
**/
class StackInLL {
    LinkedLst top;
    int size = 0;

    void push(int x){
        LinkedLst newnode = new LinkedLst(x);
        newnode.next = top;
        top = newnode;
        size = size +1;
    }

    int top(){
        return top.data;
    }

    void pop(){
        if (top == null) {
            System.out.println("No element found");
            return;
        }
        LinkedLst temp = this.top;
        this.top = this.top.next;
        this.size = this.size -1;
    }

    int size(){
        return size;
    }
    
}


/**
 * QueueInLL
 */
class QueueInLL {

    LinkedLst start, end;
    int size = 0;

    void push(int x){
        LinkedLst newnOde = new LinkedLst(x);
        if (this.start == null) {
            start = end = newnOde;
        }
        end.next = newnOde;
        end = newnOde;
        this.size = this.size+1;
    }

    int top(){
        return start.data;
    }

    void pop(){
        start = start.next;
        this.size = this.size -1;
    }
    int size(){
        return size;
    }
}

class St{
    Queue q;

    void push(int x){
        int s = q.size;
        q.push(x);

        for (int i = 1; i < s; i++) {
            q.push(q.top());
            q.pop();
        }
    }

    void pop(){
        q.pop();
    }

    int top(){
        return q.top();
    }

    int size(){
        return q.size();
    }
}

// class qu{
//     Stack st;

//     push(x){
        
//     }
// }


public class StackNQueue {
    public static void main(String[] args) {
        // QueueInLL arr = new QueueInLL();

        // arr.push(5);
        // arr.push(4);
        // arr.push(3);
        // arr.push(2);
        // arr.push(1);

        // // arr.pop();

        // System.out.println("sdf -->  "+ arr.size());

        Stack st = new Stack();
        int arr[] = {4,7,2,9,1,0,4};

        for (int i = 0; i < arr.length; i++) {
            st.push(arr[i]);
        }

        System.out.println("here" + st.top());
    }
}
